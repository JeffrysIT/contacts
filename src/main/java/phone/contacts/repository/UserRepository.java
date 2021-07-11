package phone.contacts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phone.contacts.model.User;

import java.util.Optional;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    Optional<Object> findByUsername(String username);
}
