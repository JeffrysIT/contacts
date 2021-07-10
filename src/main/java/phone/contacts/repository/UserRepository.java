package phone.contacts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phone.contacts.model.User;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}
