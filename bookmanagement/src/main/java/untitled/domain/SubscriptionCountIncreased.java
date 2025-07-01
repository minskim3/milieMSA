package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionCountIncreased extends AbstractEvent {

    private Long bookId;
    private Integer subscriptionCount;
    private Integer totalReadCount;

    public SubscriptionCountIncreased(Book aggregate) {
        super(aggregate);
    }

    public SubscriptionCountIncreased() {
        super();
    }
}
//>>> DDD / Domain Event
