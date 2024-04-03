package rentcar.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import rentcar.config.kafka.KafkaProcessor;
import rentcar.domain.*;

@Service
public class MypageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarReserved_then_CREATE_1(
        @Payload CarReserved carReserved
    ) {
        try {
            if (!carReserved.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setReserveId(String.valueOf(carReserved.getId()));
            mypage.setUserId(carReserved.getUserId());
            mypage.setCarId(carReserved.getCarId());
            mypage.setQty(carReserved.getQty());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCarReservationCanceled_then_DELETE_1(
        @Payload CarReservationCanceled carReservationCanceled
    ) {
        try {
            if (!carReservationCanceled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            mypageRepository.deleteByReserveId(
                String.valueOf(carReservationCanceled.getId())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
