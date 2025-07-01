package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RequestCoverCommand {

    private Long writingId;
    private Long authorId;
    private String content;
    private Date modifiedAt;
    private String status;
}
