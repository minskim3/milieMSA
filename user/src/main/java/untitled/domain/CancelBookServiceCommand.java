package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CancelBookServiceCommand {

    private Long userId;
    private Boolean isSubscribed;
    private Date subscriptionEndAt;
}
