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
import untitled.domain.SummaryAndGenreGenerated;

@Entity
@Table(name = "ContentAnalyzer_table")
@Data
//<<< DDD / Aggregate Root
public class ContentAnalyzer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contentAnalyzerId;

    private Long writingId;

    private Long authorId;

    private String aiSummary;

    private String aiGenre;

    private GerationStatus status;

    public static ContentAnalyzerRepository repository() {
        ContentAnalyzerRepository contentAnalyzerRepository = AimanagementApplication.applicationContext.getBean(
            ContentAnalyzerRepository.class
        );
        return contentAnalyzerRepository;
    }

    //<<< Clean Arch / Port Method
    public static void generateSummaryAndGenre(
        SummaryAndGenreRequested summaryAndGenreRequested
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        ContentAnalyzer contentAnalyzer = new ContentAnalyzer();
        repository().save(contentAnalyzer);

        SummaryAndGenreGenerated summaryAndGenreGenerated = new SummaryAndGenreGenerated(contentAnalyzer);
        summaryAndGenreGenerated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(summaryAndGenreRequested.get???()).ifPresent(contentAnalyzer->{
            
            contentAnalyzer // do something
            repository().save(contentAnalyzer);

            SummaryAndGenreGenerated summaryAndGenreGenerated = new SummaryAndGenreGenerated(contentAnalyzer);
            summaryAndGenreGenerated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
