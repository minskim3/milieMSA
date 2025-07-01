package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class SummaryAndGenreRequested extends AbstractEvent {

    private Long writingId;
    private Long authorId;
    private String content;
}
