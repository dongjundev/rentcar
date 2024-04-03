package rentcar.domain;

import java.util.*;
import lombok.*;
import rentcar.domain.*;
import rentcar.infra.AbstractEvent;

@Data
@ToString
public class OutofStock extends AbstractEvent {

    private Long id;
    private String carName;
    private Integer stock;
    private Long reserveId;
}
