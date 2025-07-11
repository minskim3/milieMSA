package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverRequested extends AbstractEvent {

    private Long writingId;
    private Long authorId;
    private String content;

    public CoverRequested(Writing aggregate) {
        super(aggregate);
    }

    public CoverRequested() {
        super();
    }
}
//>>> DDD / Domain Event
