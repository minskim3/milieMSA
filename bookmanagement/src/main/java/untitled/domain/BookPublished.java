package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookPublished extends AbstractEvent {

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

    public BookPublished(Book aggregate) {
        super(aggregate);
    }

    public BookPublished() {
        super();
    }
}
//>>> DDD / Domain Event
