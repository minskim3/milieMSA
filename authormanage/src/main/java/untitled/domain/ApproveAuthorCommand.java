package untitled.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ApproveAuthorCommand {

    private Long authorId;
    private String isApproved;
}
