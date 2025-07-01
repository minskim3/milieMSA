package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class CoverGenerated extends AbstractEvent {

    private Long writingId;
    private Long authorId;
    private String imageUrl;

    public CoverGenerated(CoverDesign aggregate) {
        super(aggregate);
    }

    public CoverGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
