package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserJoined extends AbstractEvent {

    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private Boolean isKt;
    private Boolean isSubscribed;
    private Date subscribedAt;
    private Date subscriptionEndAt;

    public UserJoined(User aggregate) {
        super(aggregate);
    }

    public UserJoined() {
        super();
    }
}
//>>> DDD / Domain Event
