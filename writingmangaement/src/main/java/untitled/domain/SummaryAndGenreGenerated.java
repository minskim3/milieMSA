package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class SummaryAndGenreGenerated extends AbstractEvent {

    private Long contentAnalyzerId;
    private Long writingId;
    private Long authorId;
    private String aiSummary;
    private String aiGenre;
}
