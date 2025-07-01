package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookSubscriptionCancelled extends AbstractEvent {

    private Long userId;
    private Boolean isSubscribed;
    private Date subscriptionEndAt;

    public BookSubscriptionCancelled(User aggregate) {
        super(aggregate);
    }

    public BookSubscriptionCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
