package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CarReserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Long carId;
    private Integer qty;

    public CarReserved(Reserve aggregate) {
        super(aggregate);
    }

    public CarReserved() {
        super();
    }
}
//>>> DDD / Domain Event
