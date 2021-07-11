package phone.contacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone.contacts.model.Contact;
import phone.contacts.repository.ContactRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void add(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(long id) {
        contactRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(long id, String name) {
        Contact contact = contactRepository.findById(id);
        if (contact != null) {
            contact.setName(name);
            contactRepository.save(contact);
        }
    }

    @Override
    public Contact get(long id) {
        return contactRepository.findById(id);
    }

    @Override
    public List<Contact> getAll() {
        return (List<Contact>) contactRepository.findAll();
    }


}
