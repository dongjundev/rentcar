package rentcar.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import rentcar.infra.AbstractEvent;

@Data
public class CarReserved extends AbstractEvent {

    private Long id;
    private String userId;
    private Long carId;
    private Integer qty;
}
