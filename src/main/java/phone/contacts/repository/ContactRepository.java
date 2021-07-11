package phone.contacts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import phone.contacts.model.Contact;


/**
 * @author Yuriy Ivanischev
 * @version 1.0
 */

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
    Contact findById(long id);

}
