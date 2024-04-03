package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OutofStock extends AbstractEvent {

    private Long id;
    private String carName;
    private Integer stock;
    private Long reserveId;

    public OutofStock(Car aggregate) {
        super(aggregate);
    }

    public OutofStock() {
        super();
    }
}
//>>> DDD / Domain Event
