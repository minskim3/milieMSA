package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/writings")
@Transactional
public class WritingController {

    @Autowired
    WritingRepository writingRepository;

    @RequestMapping(
        value = "/writings/{id}/requestpublication",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Writing requestPublication(
        @PathVariable(value = "id") Long id,
        @RequestBody RequestPublicationCommand requestPublicationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /writing/requestPublication  called #####");
        Optional<Writing> optionalWriting = writingRepository.findById(id);

        optionalWriting.orElseThrow(() -> new Exception("No Entity Found"));
        Writing writing = optionalWriting.get();
        writing.requestPublication(requestPublicationCommand);

        writingRepository.save(writing);
        return writing;
    }

    @RequestMapping(
        value = "/writings/{id}/requestcover",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Writing requestCover(
        @PathVariable(value = "id") Long id,
        @RequestBody RequestCoverCommand requestCoverCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /writing/requestCover  called #####");
        Optional<Writing> optionalWriting = writingRepository.findById(id);

        optionalWriting.orElseThrow(() -> new Exception("No Entity Found"));
        Writing writing = optionalWriting.get();
        writing.requestCover(requestCoverCommand);

        writingRepository.save(writing);
        return writing;
    }

    @RequestMapping(
        value = "/writings/{id}/requestsummaryandgenre",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Writing requestSummaryAndGenre(
        @PathVariable(value = "id") Long id,
        @RequestBody RequestSummaryAndGenreCommand requestSummaryAndGenreCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /writing/requestSummaryAndGenre  called #####"
        );
        Optional<Writing> optionalWriting = writingRepository.findById(id);

        optionalWriting.orElseThrow(() -> new Exception("No Entity Found"));
        Writing writing = optionalWriting.get();
        writing.requestSummaryAndGenre(requestSummaryAndGenreCommand);

        writingRepository.save(writing);
        return writing;
    }
}
//>>> Clean Arch / Inbound Adaptor
