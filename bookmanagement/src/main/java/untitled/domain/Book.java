package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.BookmanagementApplication;
import untitled.domain.BookPublished;
import untitled.domain.PurchaseCountIncreased;
import untitled.domain.SubscriptionCountIncreased;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String authorName;

    private Long authorId;

    private String genre;

    private String summary;

    private String coverUrl;

    private Integer price;

    private String content;

    private Date publishedDate;

    private Integer purchaseCount;

    private Integer subscriptionCount;

    private Integer totalReadCount;

    private Boolean isBestSeller;

    public static BookRepository repository() {
        BookRepository bookRepository = BookmanagementApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public void selectBestSeller(
        SelectBestSellerCommand selectBestSellerCommand
    ) {
        //implement business logic here:

        BookSelectedBestSeller bookSelectedBestSeller = new BookSelectedBestSeller(
            this
        );
        bookSelectedBestSeller.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void publishBook(PublicationRequested publicationRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookPublished bookPublished = new BookPublished(book);
        bookPublished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(publicationRequested.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookPublished bookPublished = new BookPublished(book);
            bookPublished.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increasePurchaseCount(PointDecreased pointDecreased) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        PurchaseCountIncreased purchaseCountIncreased = new PurchaseCountIncreased(book);
        purchaseCountIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(pointDecreased.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            PurchaseCountIncreased purchaseCountIncreased = new PurchaseCountIncreased(book);
            purchaseCountIncreased.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseSubscription(BookSubscribed bookSubscribed) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        SubscriptionCountIncreased subscriptionCountIncreased = new SubscriptionCountIncreased(book);
        subscriptionCountIncreased.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if bookSubscribed.userId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> subscriptionMap = mapper.convertValue(bookSubscribed.getUserId(), Map.class);

        repository().findById(bookSubscribed.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            SubscriptionCountIncreased subscriptionCountIncreased = new SubscriptionCountIncreased(book);
            subscriptionCountIncreased.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
