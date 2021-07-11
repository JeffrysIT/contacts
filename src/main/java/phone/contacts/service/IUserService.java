package phone.contacts.service;

import phone.contacts.model.User;

import java.util.Optional;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */
public interface IUserService {

    User findBy(String username, String password);

    void add(User user);

    boolean isExistBy(String username);

    Optional<Object> findByUsername(String username);
}
