package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ApprovedAuthor extends AbstractEvent {

    private Long id;
    private String isApproved;

    public ApprovedAuthor(Author aggregate) {
        super(aggregate);
    }

    public ApprovedAuthor() {
        super();
    }
}
//>>> DDD / Domain Event
