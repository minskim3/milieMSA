package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class UserJoined extends AbstractEvent {

    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private Boolean isKt;
    private Boolean isSubscribed;
    private Date subscribedAt;
    private Date subscriptionEndAt;
}
