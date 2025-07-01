package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointRecharged extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Integer balance;
    private Date lastUpdatedAt;
    private Integer totalCharged;

    public PointRecharged(Point aggregate) {
        super(aggregate);
    }

    public PointRecharged() {
        super();
    }
}
//>>> DDD / Domain Event
