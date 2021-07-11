package phone.contacts.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import phone.contacts.model.User;
import phone.contacts.security.JwtProvider;
import phone.contacts.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping(value = "/auth/register")
    public ResponseEntity<?> register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (userService.isExistBy(username)) {
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userService.add(user);
        return ResponseEntity.ok("User registered successfully!");
    }

}
