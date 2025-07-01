package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookBought extends AbstractEvent {

    private Long subscriptionId;
    private UserId userId;
    private Long bookId;
    private Date startedAt;
    private String accessType;

    public BookBought(Subscription aggregate) {
        super(aggregate);
    }

    public BookBought() {
        super();
    }
}
//>>> DDD / Domain Event
