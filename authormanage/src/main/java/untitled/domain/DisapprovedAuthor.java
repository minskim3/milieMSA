package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DisapprovedAuthor extends AbstractEvent {

    private Long id;
    private String isApproved;

    public DisapprovedAuthor(Author aggregate) {
        super(aggregate);
    }

    public DisapprovedAuthor() {
        super();
    }
}
//>>> DDD / Domain Event
