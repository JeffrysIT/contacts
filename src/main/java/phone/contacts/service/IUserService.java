package phone.contacts.service;

import phone.contacts.model.User;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */
public interface IUserService {

    User findBy(String username, String password);

    void add(User user);
}
