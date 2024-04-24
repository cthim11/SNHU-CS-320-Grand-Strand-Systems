/*
 * Developer: Courtney Thim
 */

package ContactServiceApplicationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import contactservicepackage.Contact;

class ContactTest {

	@Test
	@DisplayName("Testing default constructor")
	void testContactDefaultConstructor() {
		Contact contact = new Contact();
		assertTrue(contact.getContactId().equals("00000"));
		assertTrue(contact.getFirstName().equals("firstname"));
		assertTrue(contact.getLastName().equals("lastname"));
		assertTrue(contact.getPhone().equals("0123456789"));
		assertTrue(contact.getAddress().equals("address"));
	}
	
	@Test
	@DisplayName("Testing parameterized constructor")
	void testContact() {
		Contact contact = new Contact("C1000", "Tyler", "Locke", "3334446283", "212 Dove Rd, Eliot, SC");
		assertTrue(contact.getContactId().equals("C1000"));
		assertTrue(contact.getFirstName().equals("Tyler"));
		assertTrue(contact.getLastName().equals("Locke"));
		assertTrue(contact.getPhone().equals("3334446283"));
		assertTrue(contact.getAddress().equals("212 Dove Rd, Eliot, SC"));
	}
	
	@Test
	@DisplayName("ContactID is too long")
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C0123456789", "Tyler", "Locke", "3334446283", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("ContactID is null")
	void testContactIdIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact(null, "Tyler", "Locke", "3334446283", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("First name is too long")
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler-James", "Locke", "3334446283", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("First name is null")
	void testFirstNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			Contact contact = new Contact("C1000", null, "Locke", "3334446283", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("Last name is too long")
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", "Lockewoods-Smith", "3334446283", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("Last name is null")
	void testLastNameIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", null, "3334446283", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("Phone number is too long")
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", "Locke", "333444628376", "212 Dove Rd, Eliot, SC");
		});
	}
	
	
	@Test
	@DisplayName("Phone number is too short")
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", "Locke", "33344462", "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("Phone number is null")
	void testPhoneNumberIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", "Locke", null, "212 Dove Rd, Eliot, SC");
		});
	}
	
	@Test
	@DisplayName("Address is too long")
	void TestContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", "Locke", "3334446283", "21256 Really Fake Address Made Up For Testing Purposes, Chicago, IL");
		});
	}
	
	@Test
	@DisplayName("Address is null")
	void testAddressIsNull() {
		Assertions.assertThrows(IllegalArgumentException.class,()-> {
			new Contact("C1000", "Tyler", "Locke", "3334446283", null);
		});
	}
	

}
