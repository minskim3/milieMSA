package untitled.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import untitled.config.kafka.KafkaProcessor;
import untitled.domain.*;

@Service
public class BookPriceViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private BookPriceRepository bookPriceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookPublished_then_CREATE_1(
        @Payload BookPublished bookPublished
    ) {
        try {
            if (!bookPublished.validate()) return;

            // view 객체 생성
            BookPrice bookPrice = new BookPrice();
            // view 객체에 이벤트의 Value 를 set 함
            bookPrice.setBookId(bookPublished.getBookId());
            bookPrice.setPrice(bookPublished.getPrice());
            // view 레파지 토리에 save
            bookPriceRepository.save(bookPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
