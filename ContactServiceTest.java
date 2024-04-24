/*
 * Developer: Courtney Thim
 */

package ContactServiceApplicationTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import contactservicepackage.Contact;
import contactservicepackage.ContactService;

class ContactServiceTest {
	
	@Test
	@DisplayName("Adding a single contacts")
	void testAddSingleContact() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		newContact.addContact(newContact1);
		assertEquals(newContact1.getContactId(), "C10005");
		assertEquals(newContact1.getFirstName(), "Dave");
		assertEquals(newContact1.getLastName(), "Manning");
		assertEquals(newContact1.getPhone(), "2225550940");
		assertEquals(newContact1.getAddress(), "16 Chestnut Ave, Grey, CA");
	}
	
	@Test
	@DisplayName("Adding multiple contacts")
	void testAddingMultipleContacts() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		Contact newContact2 = new Contact("C60005", "Miranda", "Davis", "5558881234", "36 Love Lane, China, ME");
		Contact newContact3 = new Contact("C20005", "Charlie", "Sands", "1112223456", "282 Main St, Derry, NH");
		newContact.addContact(newContact1);
		newContact.addContact(newContact2);
		newContact.addContact(newContact3);
		
		assertEquals(newContact1.getContactId(), "C10005");
		assertEquals(newContact1.getFirstName(), "Dave");
		assertEquals(newContact1.getLastName(), "Manning");
		assertEquals(newContact1.getPhone(), "2225550940");
		assertEquals(newContact1.getAddress(), "16 Chestnut Ave, Grey, CA");
		
		assertEquals(newContact2.getContactId(), "C60005");
		assertEquals(newContact2.getFirstName(), "Miranda");
		assertEquals(newContact2.getLastName(), "Davis");
		assertEquals(newContact2.getPhone(), "5558881234");
		assertEquals(newContact2.getAddress(), "36 Love Lane, China, ME");
		
		assertEquals(newContact3.getContactId(), "C20005");
		assertEquals(newContact3.getFirstName(), "Charlie");
		assertEquals(newContact3.getLastName(), "Sands");
		assertEquals(newContact3.getPhone(), "1112223456");
		assertEquals(newContact3.getAddress(), "282 Main St, Derry, NH");
	}
	
	@Test
	@DisplayName("Adding duplicate contacts")
	void testingAddingDuplicateContactId() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		Contact newContact2 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		
		newContact.addContact(newContact1);
		newContact.addContact(newContact2);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			newContact.addContact(newContact2);
		});
	}
	
	@Test
	@DisplayName("Deleting a contact")
	void testingDeletingContacts() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {      // Tries to delete null contact ID
			newContact.deleteContact("");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {      // Tries to delete ID that's too long
			newContact.deleteContact("012345678917");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {      // Tries to delete from an empty list
			newContact.deleteContact("0123456789");
		});
		
		newContact.addContact(newContact1);
		
		newContact.deleteContact("C10005");
		assertTrue(newContact.getContactList().isEmpty());
	}
	
	@Test
	@DisplayName("Test updating a contact - change address")
	void testUpdatingContactAddress() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		newContact.addContact(newContact1);
		newContact.updateContact("C10005", "Dave", "Manning", "2225550940", "17 Chestnut Ave, Grey, CA");
		
		assertEquals(newContact1.getAddress(), "17 Chestnut Ave, Grey, CA");
	}
	
	@Test
	@DisplayName("Test updating a contact - change phone")
	void testUpdatingContactPhone() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		newContact.addContact(newContact1);
		newContact.updateContact("C10005", "Dave", "Manning", "6234518473", "16 Chestnut Ave, Grey, CA");
		
		assertEquals(newContact1.getPhone(), "6234518473");
	}
	
	@Test
	@DisplayName("Test updating a contact - change last name")
	void testUpdatingContactLastName() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		newContact.addContact(newContact1);
		newContact.updateContact("C10005", "Dave", "Johnson", "2225550940", "16 Chestnut Ave, Grey, CA");
	
		assertEquals(newContact1.getLastName(), "Johnson");
	}
	
	@Test
	@DisplayName("Test updating a contact - change first name")
	void testUpdatingContactFirstName() {
		ContactService newContact = new ContactService();
		Contact newContact1 = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		newContact.addContact(newContact1);
		newContact.updateContact("C10005", "Cameron", "Manning", "2225550940", "17 Chestnut Ave, Grey, CA");
		
		assertEquals(newContact1.getFirstName(), "Cameron");
	}
	
	@Test
	@DisplayName("Adding a contact and requesting it back")
	void TestAddingContactAndGettingItBack() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("C10005", "Dave", "Manning", "2225550940", "16 Chestnut Ave, Grey, CA");
		contactService.addContact(contact);
		
		Contact retrievedContact = contactService.getContact("C10005");
		assertNotNull(retrievedContact);
		assertEquals(retrievedContact.getFirstName(), "Dave");
		assertEquals(retrievedContact.getLastName(), "Manning");
		assertEquals(retrievedContact.getPhone(), "2225550940");
		assertEquals(retrievedContact.getAddress(), "16 Chestnut Ave, Grey, CA");
		
	}


}
