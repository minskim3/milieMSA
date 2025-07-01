package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookBuyRequested extends AbstractEvent {

    private UserId userId;
    private Long bookId;
    private Integer bookPrice;

    public BookBuyRequested(Subscription aggregate) {
        super(aggregate);
    }

    public BookBuyRequested() {
        super();
    }
}
//>>> DDD / Domain Event
