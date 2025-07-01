package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AimanagementApplication;
import untitled.domain.CoverGenerated;

@Entity
@Table(name = "CoverDesign_table")
@Data
//<<< DDD / Aggregate Root
public class CoverDesign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long coverId;

    private Long writingId;

    private Long authorId;

    private String penName;

    private String content;

    private String imageUrl;

    private Date generatedAt;

    private GenerationStatus status;

    public static CoverDesignRepository repository() {
        CoverDesignRepository coverDesignRepository = AimanagementApplication.applicationContext.getBean(
            CoverDesignRepository.class
        );
        return coverDesignRepository;
    }

    //<<< Clean Arch / Port Method
    public static void generateCover(CoverRequested coverRequested) {
        //implement business logic here:

        /** Example 1:  new item 
        CoverDesign coverDesign = new CoverDesign();
        repository().save(coverDesign);

        CoverGenerated coverGenerated = new CoverGenerated(coverDesign);
        coverGenerated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(coverRequested.get???()).ifPresent(coverDesign->{
            
            coverDesign // do something
            repository().save(coverDesign);

            CoverGenerated coverGenerated = new CoverGenerated(coverDesign);
            coverGenerated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
