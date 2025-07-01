package untitled.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import untitled.AuthormanageApplication;
import untitled.domain.RegistedAuthor;

@Entity
@Table(name = "Author_table")
@Data
//<<< DDD / Aggregate Root
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;

    private String email;

    private String authorName;

    private String portfolioUrl;

    private String masterpiece;

    private String isApproved;

    private Date createdAt;

    private Date updatedAt;

    @PostPersist
    public void onPostPersist() {
        RegistedAuthor registedAuthor = new RegistedAuthor(this);
        registedAuthor.publishAfterCommit();
    }

    public static AuthorRepository repository() {
        AuthorRepository authorRepository = AuthormanageApplication.applicationContext.getBean(
            AuthorRepository.class
        );
        return authorRepository;
    }

    //<<< Clean Arch / Port Method
    public void approveAuthor(ApproveAuthorCommand approveAuthorCommand) {
        //implement business logic here:

        ApprovedAuthor approvedAuthor = new ApprovedAuthor(this);
        approvedAuthor.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void disapproveAuthor(
        DisapproveAuthorCommand disapproveAuthorCommand
    ) {
        //implement business logic here:

        DisapprovedAuthor disapprovedAuthor = new DisapprovedAuthor(this);
        disapprovedAuthor.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
