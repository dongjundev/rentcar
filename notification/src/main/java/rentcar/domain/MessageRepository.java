package rentcar.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rentcar.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageRepository
    extends PagingAndSortingRepository<Message, Long> {}
