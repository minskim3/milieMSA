package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class BookBuyRequested extends AbstractEvent {

    private Object userId;
    private Long bookId;
    private Integer bookPrice;
}
