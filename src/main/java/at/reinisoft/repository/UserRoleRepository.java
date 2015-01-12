package at.reinisoft.repository;

import at.reinisoft.domain.User;
import at.reinisoft.domain.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by stocki on 04.01.15.
 */
@RepositoryRestResource(collectionResourceRel = "userRole", path = "userRole")
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole,Long>{

    List<User> findByName(@Param("name") String name);
}
