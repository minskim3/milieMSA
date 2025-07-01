package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.UserApplication;
import untitled.domain.BookBought;
import untitled.domain.BookSubscribed;

@Entity
@Table(name = "Subscription_table")
@Data
//<<< DDD / Aggregate Root
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subscriptionId;

    @Embedded
    private UserId userId;

    private Long bookId;

    private Date startedAt;

    private String accessType;

    private Integer bookPrice;

    @PostPersist
    public void onPostPersist() {
        BookSubscribed bookSubscribed = new BookSubscribed(this);
        bookSubscribed.publishAfterCommit();

        BookBought bookBought = new BookBought(this);
        bookBought.publishAfterCommit();
    }

    public static SubscriptionRepository repository() {
        SubscriptionRepository subscriptionRepository = UserApplication.applicationContext.getBean(
            SubscriptionRepository.class
        );
        return subscriptionRepository;
    }

    //<<< Clean Arch / Port Method
    public void requestBuyBook() {
        //implement business logic here:

        BookBuyRequested bookBuyRequested = new BookBuyRequested(this);
        bookBuyRequested.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void buyBook(PointDecreased pointDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Subscription subscription = new Subscription();
        repository().save(subscription);

        */

        /** Example 2:  finding and process
        

        repository().findById(pointDecreased.get???()).ifPresent(subscription->{
            
            subscription // do something
            repository().save(subscription);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
