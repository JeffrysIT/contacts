package phone.contacts.service;

import phone.contacts.model.Contact;

import java.util.List;

/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */
public interface IContactService {

    void add(Contact contact);

    void delete(long id);

    void update(long id, String name);

    Contact get(long id);

    List<Contact> getAll();

}
