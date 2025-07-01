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
// @RequestMapping(value="/subscriptions")
@Transactional
public class SubscriptionController {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @RequestMapping(
        value = "/subscriptions/{id}/requestbuybook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Subscription requestBuyBook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /subscription/requestBuyBook  called #####");
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(
            id
        );

        optionalSubscription.orElseThrow(() -> new Exception("No Entity Found")
        );
        Subscription subscription = optionalSubscription.get();
        subscription.requestBuyBook();

        subscriptionRepository.save(subscription);
        return subscription;
    }
}
//>>> Clean Arch / Inbound Adaptor
