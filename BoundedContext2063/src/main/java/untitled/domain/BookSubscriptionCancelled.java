package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class BookSubscriptionCancelled extends AbstractEvent {

    private Long userId;
    private Boolean isSubscribed;
    private Date subscriptionEndAt;
}
