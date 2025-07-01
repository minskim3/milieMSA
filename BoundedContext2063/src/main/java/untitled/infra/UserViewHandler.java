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
public class UserViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private UserRepository userRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUserJoined_then_CREATE_1(@Payload UserJoined userJoined) {
        try {
            if (!userJoined.validate()) return;

            // view 객체 생성
            User user = new User();
            // view 객체에 이벤트의 Value 를 set 함
            user.setUserId(userJoined.getUserId());
            user.setLoginId(userJoined.getLoginId());
            user.setPassword(userJoined.getPassword());
            user.setName(userJoined.getName());
            user.setIsKt(userJoined.getIsKt());
            // view 레파지 토리에 save
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenWelcomePointGiven_then_UPDATE_1(
        @Payload WelcomePointGiven welcomePointGiven
    ) {
        try {
            if (!welcomePointGiven.validate()) return;
            // view 객체 조회
            Optional<User> userOptional = userRepository.findByUserId(
                welcomePointGiven.getUserId()
            );

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                user.setPointUpdatedAt(welcomePointGiven.getLastUpdatedAt());
                user.setPointBalance(welcomePointGiven.getBalance());
                // view 레파지 토리에 save
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookServiceSubscribed_then_UPDATE_2(
        @Payload BookServiceSubscribed bookServiceSubscribed
    ) {
        try {
            if (!bookServiceSubscribed.validate()) return;
            // view 객체 조회
            Optional<User> userOptional = userRepository.findByUserId(
                bookServiceSubscribed.getUserId()
            );

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                user.setIsSubscribed(bookServiceSubscribed.getIsSubscribed());
                user.setSubscribedAt(bookServiceSubscribed.getSubscribedAt());
                // view 레파지 토리에 save
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookSubscriptionCancelled_then_UPDATE_3(
        @Payload BookSubscriptionCancelled bookSubscriptionCancelled
    ) {
        try {
            if (!bookSubscriptionCancelled.validate()) return;
            // view 객체 조회
            Optional<User> userOptional = userRepository.findByUserId(
                bookSubscriptionCancelled.getUserId()
            );

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                user.setIsSubscribed(
                    bookSubscriptionCancelled.getIsSubscribed()
                );
                user.setEndSubscribedAt(
                    bookSubscriptionCancelled.getSubscriptionEndAt()
                );
                // view 레파지 토리에 save
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointRecharged_then_UPDATE_4(
        @Payload PointRecharged pointRecharged
    ) {
        try {
            if (!pointRecharged.validate()) return;
            // view 객체 조회
            Optional<User> userOptional = userRepository.findByUserId(
                pointRecharged.getUserId()
            );

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                user.setPointBalance(pointRecharged.getBalance());
                user.setTotalCharged(pointRecharged.getTotalCharged());
                // view 레파지 토리에 save
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPointDecreased_then_UPDATE_5(
        @Payload PointDecreased pointDecreased
    ) {
        try {
            if (!pointDecreased.validate()) return;
            // view 객체 조회
            Optional<User> userOptional = userRepository.findByUserId(
                pointDecreased.getUserId()
            );

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                user.setTotalUsed(
                    String.valueOf(pointDecreased.getTotalUsed())
                );
                user.setPointBalance(pointDecreased.getBalance());
                // view 레파지 토리에 save
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
