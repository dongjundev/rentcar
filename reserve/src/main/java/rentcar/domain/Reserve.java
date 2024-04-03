package rentcar.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentcar.ReserveApplication;
import rentcar.domain.CarReservationCanceled;
import rentcar.domain.CarReserved;

@Entity
@Table(name = "Reserve_table")
@Data
//<<< DDD / Aggregate Root
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long carId;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        CarReserved carReserved = new CarReserved(this);
        carReserved.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        CarReservationCanceled carReservationCanceled = new CarReservationCanceled(
            this
        );
        carReservationCanceled.publishAfterCommit();
    }

    public static ReserveRepository repository() {
        ReserveRepository reserveRepository = ReserveApplication.applicationContext.getBean(
            ReserveRepository.class
        );
        return reserveRepository;
    }

    //<<< Clean Arch / Port Method
    public static void outOfStockCancel(OutofStock outofStock) {
        //implement business logic here:

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        CarReservationCanceled carReservationCanceled = new CarReservationCanceled(reserve);
        carReservationCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(outofStock.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);

            CarReservationCanceled carReservationCanceled = new CarReservationCanceled(reserve);
            carReservationCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
