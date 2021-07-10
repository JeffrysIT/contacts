package phone.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import phone.contacts.model.User;
import phone.contacts.security.JwtProvider;
import phone.contacts.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping(value = "/auth/registration")
    public void register(WebRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userService.add(newUser);
    }

    @PostMapping(value = "/auth")
    public ResponseEntity auth(HttpServletRequest request) {
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findBy(login, password);
        String token = jwtProvider.generateToken(user.getUsername());
        Map<Object, Object> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

}
