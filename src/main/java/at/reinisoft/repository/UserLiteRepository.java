package at.reinisoft.repository;

import at.reinisoft.domain.User;
import at.reinisoft.domain.UserLite;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by stocki on 04.01.15.
 */
@RepositoryRestResource(collectionResourceRel = "userLite", path = "userLite")
public interface UserLiteRepository extends PagingAndSortingRepository<UserLite,Long>{

    List<UserLite> findByLastName(@Param("name") String name);
}
