package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RechargePointCommand {

    private Long pointId;
    private Integer balance;
    private Date lastUpdatedAt;
    private Integer totalCharged;
    private accountStatus status;
}
