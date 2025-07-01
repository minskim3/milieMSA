package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class PointDecreased extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Integer balance;
    private Integer totalUsed;
    private Date lastUpdatedAt;
}
