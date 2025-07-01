package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestPublicationCommand {

    private Long writingId;
    private Long authorId;
    private String authorName;
    private String title;
    private String content;
    private String aiGenre;
    private String aiCoverUrl;
    private String aiSummary;
    private String status;
}
