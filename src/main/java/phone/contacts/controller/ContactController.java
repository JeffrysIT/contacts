package phone.contacts.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@RestController
public class ContactController {

    @GetMapping(value = "/contacts")
    public String ss() {
        return null;
    }

}
