package untitled.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import untitled.domain.*;

@Component
public class WritingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Writing>> {

    @Override
    public EntityModel<Writing> process(EntityModel<Writing> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/requestpublication"
                )
                .withRel("requestpublication")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/requestcover")
                .withRel("requestcover")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/requestsummaryandgenre"
                )
                .withRel("requestsummaryandgenre")
        );

        return model;
    }
}
