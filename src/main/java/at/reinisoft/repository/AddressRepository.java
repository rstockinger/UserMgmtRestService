package at.reinisoft.repository;

import at.reinisoft.domain.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by stocki on 04.01.15.
 */
@RepositoryRestResource(collectionResourceRel = "address" , path = "address")
public interface AddressRepository extends PagingAndSortingRepository <Address, Long> {

    List<Address> findByStreet(@Param("street") String street);

}
