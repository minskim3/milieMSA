package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class SubscribeBookServiceCommand {

    private Long userId;
    private Boolean isSubscribed;
    private Date subscribedAt;
    private Date subscriptionEndAt;
}
