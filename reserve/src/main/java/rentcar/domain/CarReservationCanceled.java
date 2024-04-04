package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CarReservationCanceled extends AbstractEvent {

    private Long id;
    private String userId;
    private Long carId;
    private Integer qty;

    private boolean outOfStock;

    public CarReservationCanceled(Reserve aggregate) {
        super(aggregate);
    }

    public CarReservationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
