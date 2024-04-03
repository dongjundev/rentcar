package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CarDecreased extends AbstractEvent {

    private Long id;
    private String carName;
    private Integer stock;

    public CarDecreased(Car aggregate) {
        super(aggregate);
    }

    public CarDecreased() {
        super();
    }
}
//>>> DDD / Domain Event
