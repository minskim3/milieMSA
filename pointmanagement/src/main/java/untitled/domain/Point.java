package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.PointmanagementApplication;
import untitled.domain.PointDecreased;
import untitled.domain.WelcomePointGiven;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pointId;

    private Long userId;

    private Integer balance;

    private Date lastUpdatedAt;

    private Integer totalCharged;

    private Integer totalUsed;

    private accountStatus status;

    public static PointRepository repository() {
        PointRepository pointRepository = PointmanagementApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public void rechargePoint(RechargePointCommand rechargePointCommand) {
        //implement business logic here:

        PointRecharged pointRecharged = new PointRecharged(this);
        pointRecharged.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void giveWelcomPoint(UserJoined userJoined) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        WelcomePointGiven welcomePointGiven = new WelcomePointGiven(point);
        welcomePointGiven.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(userJoined.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            WelcomePointGiven welcomePointGiven = new WelcomePointGiven(point);
            welcomePointGiven.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreasePoint(BookBuyRequested bookBuyRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointDecreased pointDecreased = new PointDecreased(point);
        pointDecreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if bookBuyRequested.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> subscriptionMap = mapper.convertValue(bookBuyRequested.getUserId(), Map.class);

        repository().findById(bookBuyRequested.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointDecreased pointDecreased = new PointDecreased(point);
            pointDecreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
