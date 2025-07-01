package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import untitled.infra.AbstractEvent;

@Data
public class PointDecreased extends AbstractEvent {

    private Long pointId;
    private Long userId;
    private Integer balance;
    private Integer totalUsed;
    private Date lastUpdatedAt;
}
