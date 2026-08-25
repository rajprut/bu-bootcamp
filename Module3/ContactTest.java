import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ContactTest {

    private Contact contact;
    private Contact contact2;
    private Contact contact3;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
        contact2 = new Contact("Grace Hopper", "555-0000");
        contact3 = new Contact("Alan Turing", "555-0001");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Grace Hopper", contact2.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact3.toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact3.toString().contains("555-0001"));
    }

    // Addtional tests for step 7:

    @Test
    void toString_containsFirstandLastName() {
        String[] testContact = contact3.getName().trim().split(" ");
        assertEquals(2, testContact.length);
    }

    @Test
    void toString_validLengthPhoneNumber() {
        String testContact2 = contact.getPhone().replaceAll("[^0-9]", "");
        assertTrue(testContact2.length() >= 10);
    }
}