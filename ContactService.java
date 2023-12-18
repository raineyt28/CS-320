package contact_package;

import java.util.ArrayList;
import java.util.List;


public class ContactService {
    private List<Contact> contactList = new ArrayList<>();

    public void newContact(Contact contact) {
        contactList.add(contact);
    }
    
    public void deleteContact(String id) throws Exception {
        Contact contactToRemove = searchForContact(id);
        if (contactToRemove != null) {
            contactList.remove(contactToRemove);
        } else {
            throw new Exception("The Contact does not exist!");
        }
    }

    public void updateFirstName(String id, String firstName) throws Exception {
        Contact contact = searchForContact(id);
        if (contact != null) {
            contact.updateFirstName(firstName);
        } else {
            throw new Exception("The Contact does not exist!");
        }
    }

    public void updateLastName(String id, String lastName) throws Exception {
        Contact contact = searchForContact(id);
        if (contact != null) {
            contact.updateLastName(lastName);
        } else {
            throw new Exception("The Contact does not exist!");
        }
    }

    public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
        Contact contact = searchForContact(id);
        if (contact != null) {
            contact.updatePhoneNumber(phoneNumber);
        } else {
            throw new Exception("The Contact does not exist!");
        }
    }

    public void updateAddress(String id, String address) throws Exception {
        Contact contact = searchForContact(id);
        if (contact != null) {
            contact.updateAddress(address);
        } else {
            throw new Exception("The Contact does not exist!");
        }
    }

    protected List<Contact> getContactList() {
        return contactList;
    }

   

    private Contact searchForContact(String id) {
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(id)) {
                return contact;
            }
        }
        return null;
    } 
}

    
    
    




