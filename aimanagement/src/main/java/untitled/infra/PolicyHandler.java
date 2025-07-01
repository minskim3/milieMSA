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
    CoverDesignRepository coverDesignRepository;

    @Autowired
    ContentAnalyzerRepository contentAnalyzerRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CoverRequested'"
    )
    public void wheneverCoverRequested_GenerateCover(
        @Payload CoverRequested coverRequested
    ) {
        CoverRequested event = coverRequested;
        System.out.println(
            "\n\n##### listener GenerateCover : " + coverRequested + "\n\n"
        );

        // Sample Logic //
        CoverDesign.generateCover(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SummaryAndGenreRequested'"
    )
    public void wheneverSummaryAndGenreRequested_GenerateSummaryAndGenre(
        @Payload SummaryAndGenreRequested summaryAndGenreRequested
    ) {
        SummaryAndGenreRequested event = summaryAndGenreRequested;
        System.out.println(
            "\n\n##### listener GenerateSummaryAndGenre : " +
            summaryAndGenreRequested +
            "\n\n"
        );

        // Sample Logic //
        ContentAnalyzer.generateSummaryAndGenre(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
