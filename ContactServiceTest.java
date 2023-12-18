package contact_package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    protected String contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest;
    protected String tooLongContactId, tooLongFirstName, tooLongLastName, tooLongPhoneNumber, tooShortPhoneNumber,
            tooLongAddress;

    @BeforeEach
    void setUp() {
        contactId = "10293A475F";
        firstNameTest = "Alice";
        lastNameTest = "Johnson";
        phoneNumberTest = "7776665551";
        addressTest = "5 Maple Street, Boston MA 02101";
        tooLongContactId = "1122334455AA";
        tooLongFirstName = "Jennifer Anne";
        tooLongLastName = "von Somethingelse";
        tooLongPhoneNumber = "5559871234";
        tooShortPhoneNumber = "7654321";
        tooLongAddress = "15 Oakwood Drive, San Francisco, CA 94101";
    }
    @Test
    void testCreateContactContactIdFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Tom", "Sawyer", "2801 91ST");
        });
    }

    @Test
    void testCreateContactFirstNameFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Omarrrrrrrrrrr", "Toledo", "1111 E Road Street");
        });
    }

    @Test
    void testCreateContactLastNameFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Omar", "Toolonglastnameeeeeeeeeee", "1111 E Road Street");
        });
    }

    @Test
    void testCreateContactAddressFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Omar", "Toledo", "This is a very long address that exceeds the limit");
        });
    }

    @Test
    void testCreateContactNumberToLongFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Omar", "Toledo", "1111 E Road Street");
        });
    }

    @Test
    void testCreateContactNumberToShortFails() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456", "Omar", "Toledo", "1111 E Road Street");
        });
    }

    @Test
    void testCreateContactSuccess() {
        Contact contact = new Contact("123456", "Omar", "Toledo", "5645 Pacific blvd");

        assertNotNull(contact);
        assertEquals("123456", contact.getContactId());
        assertEquals("Omar", contact.getFirstName());
        assertEquals("Toledo", contact.getLastName());
        assertEquals("5645 Pacific blvd", contact.getAddress());
        assertEquals("5616998563", contact.getPhoneNumber());
    }

    
    @Test
    void newContactTest() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(contactId, "INITIAL", "INITIAL", "5559871234");
        Contact contact2 = new Contact(contactId, firstNameTest, "INITIAL", "5559871234");
        Contact contact3 = new Contact(contactId, firstNameTest, lastNameTest, "5559871234");
        Contact contact4 = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, "INITIAL");
        Contact contact5 = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest, addressTest);

        service.newContact(contact1);
        service.newContact(contact2);
        service.newContact(contact3);
        service.newContact(contact4);
        service.newContact(contact5);

        assertEquals("INITIAL", service.getContactList().get(0).getFirstName());
        assertEquals(firstNameTest, service.getContactList().get(1).getFirstName());
        assertEquals(lastNameTest, service.getContactList().get(2).getLastName());
        assertEquals(phoneNumberTest, service.getContactList().get(3).getPhoneNumber());
        assertEquals(addressTest, service.getContactList().get(4).getAddress());
    }

    @Test
    void deleteContactTest() throws Exception {
        ContactService service = new ContactService();

        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        service.newContact(contact);

        assertEquals(1, service.getContactList().size());

        service.deleteContact(contactId);

        assertEquals(0, service.getContactList().size());
    }

    @Test
    void updateFirstNameTest() throws Exception {
        ContactService service = new ContactService();

        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        service.newContact(contact);

        service.updateFirstName(contactId, "NewFirstName");

        assertEquals("NewFirstName", service.getContactList().get(0).getFirstName());
    }

    @Test
    void updateLastNameTest() throws Exception {
        ContactService service = new ContactService();

        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        service.newContact(contact);

        service.updateLastName(contactId, "NewLastName");

        assertEquals("NewLastName", service.getContactList().get(0).getLastName());
    }

    @Test
    void updatePhoneNumberTest() throws Exception {
        ContactService service = new ContactService();

        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        service.newContact(contact);

        service.updatePhoneNumber(contactId, "1234567890");

        assertEquals("1234567890", service.getContactList().get(0).getPhoneNumber());
    }

    @Test
    void updateAddressTest() throws Exception {
        ContactService service = new ContactService();

        Contact contact = new Contact(contactId, firstNameTest, lastNameTest, phoneNumberTest);
        service.newContact(contact);

        service.updateAddress(contactId, "New Address, City, Zip");

        assertEquals("New Address, City, Zip", service.getContactList().get(0).getAddress());
    }
}

