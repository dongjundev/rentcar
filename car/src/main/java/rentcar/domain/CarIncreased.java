package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CarIncreased extends AbstractEvent {

    private Long id;
    private String carName;
    private Integer stock;

    public CarIncreased(Car aggregate) {
        super(aggregate);
    }

    public CarIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
