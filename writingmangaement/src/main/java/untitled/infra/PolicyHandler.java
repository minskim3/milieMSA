package untitled.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    WritingRepository writingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CoverGenerated'"
    )
    public void wheneverCoverGenerated_SaveCover(
        @Payload CoverGenerated coverGenerated
    ) {
        CoverGenerated event = coverGenerated;
        System.out.println(
            "\n\n##### listener SaveCover : " + coverGenerated + "\n\n"
        );

        // Sample Logic //
        Writing.saveCover(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SummaryAndGenreGenerated'"
    )
    public void wheneverSummaryAndGenreGenerated_SaveSummaryAndGenre(
        @Payload SummaryAndGenreGenerated summaryAndGenreGenerated
    ) {
        SummaryAndGenreGenerated event = summaryAndGenreGenerated;
        System.out.println(
            "\n\n##### listener SaveSummaryAndGenre : " +
            summaryAndGenreGenerated +
            "\n\n"
        );

        // Sample Logic //
        Writing.saveSummaryAndGenre(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
