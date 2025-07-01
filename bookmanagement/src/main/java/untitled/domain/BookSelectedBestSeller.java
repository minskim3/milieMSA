package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookSelectedBestSeller extends AbstractEvent {

    private Long bookId;
    private Boolean isBestSeller;

    public BookSelectedBestSeller(Book aggregate) {
        super(aggregate);
    }

    public BookSelectedBestSeller() {
        super();
    }
}
//>>> DDD / Domain Event
