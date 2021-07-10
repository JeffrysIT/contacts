package phone.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.contacts.model.Contact;
import phone.contacts.repository.ContactRepository;

import java.util.List;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void add(Contact contact) {
        contactRepository.save(contact);
    }

    public void delete(long id) {
        contactRepository.deleteById(id);
    }

    public Contact get(long id) {
        return contactRepository.findById(id);
    }

    public List<Contact> getAll() {
        return (List<Contact>) contactRepository.findAll();
    }

}
