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
    CarRepository carRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarReserved'"
    )
    public void wheneverCarReserved_DecreaseCar(@Payload CarReserved carReserved) {
        CarReserved event = carReserved;
        System.out.println(
            "\n\n##### listener DecreaseCar : " + carReserved + "\n\n"
        );

        // Sample Logic //
        Car.decreaseCar(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CarReservationCanceled'"
    )
    public void wheneverCarReservationCanceled_IncreaseCar(@Payload CarReservationCanceled carReservationCanceled) {
        CarReservationCanceled event = carReservationCanceled;
        System.out.println(
            "\n\n##### listener IncreaseCar : " +
            carReservationCanceled +
            "\n\n"
        );

        // Sample Logic //
        Car.increaseCar(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
