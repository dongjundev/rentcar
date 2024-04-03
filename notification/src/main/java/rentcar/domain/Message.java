package rentcar.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentcar.NotificationApplication;

@Entity
@Table(name = "Message_table")
@Data
//<<< DDD / Aggregate Root
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String content;

    public static MessageRepository repository() {
        MessageRepository messageRepository = NotificationApplication.applicationContext.getBean(
            MessageRepository.class
        );
        return messageRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifyToUser(
        CarReservationCanceled carReservationCanceled
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        */

        /** Example 2:  finding and process
        
        repository().findById(carReservationCanceled.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyToUser(CarReserved carReserved) {
        //implement business logic here:

        /** Example 1:  new item 
        Message message = new Message();
        repository().save(message);

        */

        /** Example 2:  finding and process
        
        repository().findById(carReserved.get???()).ifPresent(message->{
            
            message // do something
            repository().save(message);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
