package phone.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.contacts.model.User;
import phone.contacts.repository.UserRepository;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User findBy(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
