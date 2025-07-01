package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class BookSubscribed extends AbstractEvent {

    private Long subscriptionId;
    private Object userId;
    private Long bookId;
    private Date startedAt;
    private String accessType;
}
