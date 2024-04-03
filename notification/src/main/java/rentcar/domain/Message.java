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
    public static void notifyToUser(CarReservationCanceled carReservationCanceled) {
        Message message = new Message();
        message.setUserId(carReservationCanceled.getUserId());
        message.setContent("xxx님 xxx x대 예약 취소되었습니다.");
        repository().save(message);
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyToUser(CarReserved carReserved) {
        Message message = new Message();
        message.setUserId(carReserved.getUserId());
        message.setContent("xxx님 xxx x대 예약되었습니다.");
        repository().save(message);
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
