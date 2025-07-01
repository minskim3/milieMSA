package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class RegistedAuthor extends AbstractEvent {

    private Long authorId;
    private String email;
    private String authorName;
    private String portfolioUrl;
    private String masterpiece;
    private String isApproved;

    public RegistedAuthor(Author aggregate) {
        super(aggregate);
    }

    public RegistedAuthor() {
        super();
    }
}
//>>> DDD / Domain Event
