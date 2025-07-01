package untitled.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "User_table")
@Data
public class User {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    private String loginId;
    private String password;
    private String name;
    private Boolean isKt;
    private Boolean isSubscribed;
    private Date subscribedAt;
    private Integer pointBalance;
    private Date pointUpdatedAt;
    private Integer totalCharged;
    private String totalUsed;
    private Date endSubscribedAt;
}
