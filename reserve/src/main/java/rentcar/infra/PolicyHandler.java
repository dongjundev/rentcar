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
    ReserveRepository reserveRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OutofStock'"
    )
    public void wheneverOutofStock_OutOfStockCancel(
        @Payload OutofStock outofStock
    ) {
        OutofStock event = outofStock;
        System.out.println(
            "\n\n##### listener OutOfStockCancel : " + outofStock + "\n\n"
        );

        // Sample Logic //
        Reserve.outOfStockCancel(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
