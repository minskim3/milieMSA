package untitled.domain;

import untitled.domain.UserJoined;
import untitled.UserApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;


@Entity
@Table(name="User_table")
@Data

//<<< DDD / Aggregate Root
public class User  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
private Long userId;    
    
    
private String loginId;    
    
    
private String password;    
    
    
private String name;    
    
    
private Boolean isKt;    
    
    
private Boolean isSubscribed;    
    
    
private Date subscribedAt;    
    
    
private Date subscriptionEndAt;

    @PostPersist
    public void onPostPersist(){


        UserJoined userJoined = new UserJoined(this);
        userJoined.publishAfterCommit();

    
    }

    public static UserRepository repository(){
        UserRepository userRepository = UserApplication.applicationContext.getBean(UserRepository.class);
        return userRepository;
    }



//<<< Clean Arch / Port Method
    public void subscribeBookService(SubscribeBookServiceCommand subscribeBookServiceCommand){
        
        //implement business logic here:
        

        untitled.external.UserQuery userQuery = new untitled.external.UserQuery();
        // userQuery.set??()        
          = UserApplication.applicationContext
            .getBean(untitled.external.Service.class)
            .user(userQuery);

        BookServiceSubscribed bookServiceSubscribed = new BookServiceSubscribed(this);
        bookServiceSubscribed.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void cancelBookService(CancelBookServiceCommand cancelBookServiceCommand){
        
        //implement business logic here:
        


        BookSubscriptionCancelled bookSubscriptionCancelled = new BookSubscriptionCancelled(this);
        bookSubscriptionCancelled.publishAfterCommit();
    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
