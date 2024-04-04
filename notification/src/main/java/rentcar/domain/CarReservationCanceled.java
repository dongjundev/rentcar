package rentcar.domain;

import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

@Data
@ToString
public class CarReservationCanceled extends AbstractEvent {

    private Long id;
    private String userId;
    private Long carId;
    private Integer qty;

    private boolean outOfStock;
}
