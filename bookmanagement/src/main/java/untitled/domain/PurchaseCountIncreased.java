package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PurchaseCountIncreased extends AbstractEvent {

    private Long bookId;
    private Integer purchaseCount;
    private Integer totalReadCount;

    public PurchaseCountIncreased(Book aggregate) {
        super(aggregate);
    }

    public PurchaseCountIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
