package untitled.domain;

import untitled.domain.WritingCreated;
import untitled.WritingmangaementApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;


@Entity
@Table(name="Writing_table")
@Data

//<<< DDD / Aggregate Root
public class Writing  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
private Long writingId;    
    
    
private Long authorId;    
    
    
private String authorName;    
    
    
private String title;    
    
    
private String content;    
    
    
private String aiGenre;    
    
    
private String aiCoverUrl;    
    
    
private String aiSummary;    
    
    
private Date createdAt;    
    
    
private Date modifiedAt;    
    
    
private String status;

    @PostPersist
    public void onPostPersist(){


        WritingCreated writingCreated = new WritingCreated(this);
        writingCreated.publishAfterCommit();

    
    }

    public static WritingRepository repository(){
        WritingRepository writingRepository = WritingmangaementApplication.applicationContext.getBean(WritingRepository.class);
        return writingRepository;
    }



//<<< Clean Arch / Port Method
    public void requestPublication(RequestPublicationCommand requestPublicationCommand){
        
        //implement business logic here:
        

        untitled.external.WritingQuery writingQuery = new untitled.external.WritingQuery();
        // writingQuery.set??()        
          = WritingApplication.applicationContext
            .getBean(untitled.external.Service.class)
            .writing(writingQuery);

        PublicationRequested publicationRequested = new PublicationRequested(this);
        publicationRequested.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void requestCover(RequestCoverCommand requestCoverCommand){
        
        //implement business logic here:
        

        untitled.external.WritingQuery writingQuery = new untitled.external.WritingQuery();
        // writingQuery.set??()        
          = WritingApplication.applicationContext
            .getBean(untitled.external.Service.class)
            .writing(writingQuery);

        CoverRequested coverRequested = new CoverRequested(this);
        coverRequested.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void requestSummaryAndGenre(RequestSummaryAndGenreCommand requestSummaryAndGenreCommand){
        
        //implement business logic here:
        


        SummaryAndGenreRequested summaryAndGenreRequested = new SummaryAndGenreRequested(this);
        summaryAndGenreRequested.publishAfterCommit();
    }
//>>> Clean Arch / Port Method

//<<< Clean Arch / Port Method
    public static void saveCover(CoverGenerated coverGenerated){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Writing writing = new Writing();
        repository().save(writing);

        */

        /** Example 2:  finding and process
        

        repository().findById(coverGenerated.get???()).ifPresent(writing->{
            
            writing // do something
            repository().save(writing);


         });
        */

        
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public static void saveSummaryAndGenre(SummaryAndGenreGenerated summaryAndGenreGenerated){
        
        //implement business logic here:
        
        /** Example 1:  new item 
        Writing writing = new Writing();
        repository().save(writing);

        */

        /** Example 2:  finding and process
        

        repository().findById(summaryAndGenreGenerated.get???()).ifPresent(writing->{
            
            writing // do something
            repository().save(writing);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
