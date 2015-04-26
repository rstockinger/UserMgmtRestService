package at.reinisoft.repository;

import at.reinisoft.domain.LotteryNumbers;
import at.reinisoft.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by stocki on 24.01.15.
 */
@RepositoryRestResource(collectionResourceRel = "lottery", path = "lottery")
public interface LotteryNumberRepository extends PagingAndSortingRepository<LotteryNumbers,Long> {

    List<User> findByDrawDate(@Param("drawDate") String drawDate);
}
