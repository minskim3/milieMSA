package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookServiceSubscribed extends AbstractEvent {

    private Long userId;
    private Boolean isSubscribed;
    private Date subscribedAt;
    private Date subscriptionEndAt;

    public BookServiceSubscribed(User aggregate) {
        super(aggregate);
    }

    public BookServiceSubscribed() {
        super();
    }
}
//>>> DDD / Domain Event
