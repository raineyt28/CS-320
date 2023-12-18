package contact_package;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;
    private String validContactId, validFirstName, validLastName, validPhoneNumber, validAddress;
    private String invalidContactId, invalidFirstName, invalidLastName, invalidPhoneNumber, invalidAddress;

    @BeforeEach
    void setUp() {
        validContactId = "ABCD1234XY";
        validFirstName = "Jane";
        validLastName = "Doe";
        validPhoneNumber = "9998887776";
        validAddress = "22 Park Street, New York NY 10001";

        invalidContactId = "11223344AA"; // Invalid ID length
        invalidFirstName = "Jennifer Lynn"; // Invalid first name length
        invalidLastName = "von Something"; // Invalid last name length
        invalidPhoneNumber = "5559876543"; // Invalid phone number length
        invalidAddress = "10 Elmwood Avenue, Los Angeles, CA 90001"; // Invalid address length

        contact = new Contact(validContactId, validFirstName, validLastName, validPhoneNumber, validAddress);
    }

    @Test
    void testContactCreation_Success() {
        assertNotNull(contact);
        assertEquals(validContactId, contact.getContactId());
        assertEquals(validFirstName, contact.getFirstName());
        assertEquals(validLastName, contact.getLastName());
        assertEquals(validPhoneNumber, contact.getPhoneNumber());
        assertEquals(validAddress, contact.getAddress());
    }

    @Test
    void testUpdateFirstName_Success() {
        contact.updateFirstName("NewFirstName");
        assertEquals("NewFirstName", contact.getFirstName());
    }

    @Test
    void testUpdateLastName_Success() {
        contact.updateLastName("NewLastName");
        assertEquals("NewLastName", contact.getLastName());
    }

    @Test
    void testUpdatePhoneNumber_Success() {
        contact.updatePhoneNumber("9998887777");
        assertEquals("9998887777", contact.getPhoneNumber());
    }

    @Test
    void testUpdateAddress_Success() {
        contact.updateAddress("New Address");
        assertEquals("New Address", contact.getAddress());
    }

    @Test
    void testInvalidContactIdConstructor_Failure() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(invalidContactId, validFirstName, validLastName, validPhoneNumber, validAddress));
    }

    @Test
    void testInvalidFirstNameConstructor_Failure() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(validContactId, invalidFirstName, validLastName, validPhoneNumber, validAddress));
    }

    @Test
    void testInvalidLastNameConstructor_Failure() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(validContactId, validFirstName, invalidLastName, validPhoneNumber, validAddress));
    }

    @Test
    void testInvalidPhoneNumberConstructor_Failure() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(validContactId, validFirstName, validLastName, invalidPhoneNumber, validAddress));
    }

    @Test
    void testInvalidAddressConstructor_Failure() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(validContactId, validFirstName, validLastName, validPhoneNumber, invalidAddress));
    }
}

