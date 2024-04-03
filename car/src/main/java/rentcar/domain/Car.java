package rentcar.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import rentcar.CarApplication;
import rentcar.domain.CarDecreased;
import rentcar.domain.CarIncreased;
import rentcar.domain.OutofStock;

@Entity
@Table(name = "Car_table")
@Data
//<<< DDD / Aggregate Root
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String carName;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {
//        CarDecreased carDecreased = new CarDecreased(this);
//        carDecreased.publishAfterCommit();
//
//        OutofStock outofStock = new OutofStock(this);
//        outofStock.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
//        CarIncreased carIncreased = new CarIncreased(this);
//        carIncreased.publishAfterCommit();
    }

    public static CarRepository repository() {
        CarRepository carRepository = CarApplication.applicationContext.getBean(
            CarRepository.class
        );
        return carRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseCar(CarReserved carReserved) {
        repository().findById(carReserved.getCarId()).ifPresent(car->{
            Integer stock = car.getStock();
            Integer qty = carReserved.getQty();

            if (stock >= qty) {
                car.setStock(stock - qty);
                repository().save(car);

//                CarDecreased carDecreased = new CarDecreased();
//                carDecreased.publishAfterCommit();
            } else {
                OutofStock outofStock = new OutofStock(car);
                outofStock.publishAfterCommit();
            }
         });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseCar(CarReservationCanceled carReservationCanceled) {
        repository().findById(carReservationCanceled.getCarId()).ifPresent(car->{
            Integer stock = car.getStock();
            car.setStock(stock + carReservationCanceled.getQty());
            repository().save(car);

//            CarIncreased carIncreased = new CarIncreased(car);
//            carIncreased.publishAfterCommit();
         });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
