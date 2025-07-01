package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SummaryAndGenreGenerated extends AbstractEvent {

    private Long contentAnalyzerId;
    private Long writingId;
    private Long authorId;
    private String aiSummary;
    private String aiGenre;

    public SummaryAndGenreGenerated(ContentAnalyzer aggregate) {
        super(aggregate);
    }

    public SummaryAndGenreGenerated() {
        super();
    }
}
//>>> DDD / Domain Event
