package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WelcomePointGiven extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Integer balance;
    private Date lastUpdatedAt;

    public WelcomePointGiven(Point aggregate) {
        super(aggregate);
    }

    public WelcomePointGiven() {
        super();
    }
}
//>>> DDD / Domain Event
