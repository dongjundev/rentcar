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

    @Transient
    private boolean outOfStock = false;

    @PostPersist
    public void onPostPersist() {
        if (!this.isOutOfStock()) {
            CarReserved carReserved = new CarReserved(this);
            carReserved.publishAfterCommit();
        }
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
        repository().findById(outofStock.getReserveId()).ifPresent(reserve -> {
            reserve.setOutOfStock(true);
            repository().save(reserve);
        });
        repository().deleteById(outofStock.getReserveId());
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
