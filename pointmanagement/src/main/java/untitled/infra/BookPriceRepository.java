package untitled.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "bookPrices",
    path = "bookPrices"
)
public interface BookPriceRepository
    extends PagingAndSortingRepository<BookPrice, Long> {}
