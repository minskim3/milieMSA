package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class PublicationRequested extends AbstractEvent {

    private Long authorId;
    private Long penName;
    private String title;
    private String content;
    private String aiGenre;
    private String aiCoverUrl;
    private String aiSummary;
}
