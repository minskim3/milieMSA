package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WritingCreated extends AbstractEvent {

    private Long id;

    public WritingCreated(Writing aggregate) {
        super(aggregate);
    }

    public WritingCreated() {
        super();
    }
}
//>>> DDD / Domain Event
