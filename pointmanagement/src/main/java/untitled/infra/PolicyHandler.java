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
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UserJoined'"
    )
    public void wheneverUserJoined_GiveWelcomPoint(
        @Payload UserJoined userJoined
    ) {
        UserJoined event = userJoined;
        System.out.println(
            "\n\n##### listener GiveWelcomPoint : " + userJoined + "\n\n"
        );

        // Sample Logic //
        Point.giveWelcomPoint(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookBuyRequested'"
    )
    public void wheneverBookBuyRequested_DecreasePoint(
        @Payload BookBuyRequested bookBuyRequested
    ) {
        BookBuyRequested event = bookBuyRequested;
        System.out.println(
            "\n\n##### listener DecreasePoint : " + bookBuyRequested + "\n\n"
        );

        // Sample Logic //
        Point.decreasePoint(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
