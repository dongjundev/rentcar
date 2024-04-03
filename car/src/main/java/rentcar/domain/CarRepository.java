package rentcar.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import rentcar.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {}
