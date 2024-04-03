package rentcar.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import rentcar.config.kafka.KafkaProcessor;
import rentcar.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    MessageRepository messageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarReservationCanceled'"
    )
    public void wheneverCarReservationCanceled_NotifyToUser(
        @Payload CarReservationCanceled carReservationCanceled
    ) {
        CarReservationCanceled event = carReservationCanceled;
        System.out.println(
            "\n\n##### listener NotifyToUser : " +
            carReservationCanceled +
            "\n\n"
        );

        // Sample Logic //
        Message.notifyToUser(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarReserved'"
    )
    public void wheneverCarReserved_NotifyToUser(
        @Payload CarReserved carReserved
    ) {
        CarReserved event = carReserved;
        System.out.println(
            "\n\n##### listener NotifyToUser : " + carReserved + "\n\n"
        );

        // Sample Logic //
        Message.notifyToUser(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
