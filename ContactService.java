/*
 * Developer: Courtney Thim
 */

package contactservicepackage;

import java.util.ArrayList;

public class ContactService {
	
	// Contains a list of contacts
	private ArrayList<Contact> contactList;
	
	// Default constructor
	public ContactService() {
		contactList = new ArrayList<>();
	}
	
	// Getter for contact list
	public ArrayList<Contact> getContactList() {
		return contactList;
	}
	
	// Method to retrieve a contact
	public Contact getContact(String contactId) {
		for (Contact contact : contactList) {                 // Loop through the contacts list
			if (contact.getContactId().equals(contactId)) {      // If contact IDs match
				return contact;
			}
		}
		return null;
	}
	
	// Add contact to list if not already present
	public void addContact(Contact newContact) {
		boolean isPresent = false;
		for (Contact contacts : contactList) {          // Loop through the contacts list
			if (contacts.equals(newContact)) {          // Checks if contact is in existing contacts list
				isPresent = true;
				throw new IllegalArgumentException("Contact already exists");
			}
		}
		
		// Add contact if not in contacts list
		if (!isPresent) {
			contactList.add(newContact);        // Adds contact to the contact list
		}
		else {
		}
	}
	
	// Delete contact from contacts list
	public void deleteContact(String contactId) {
		
		// Verify supplied contactID is valid
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid ContactID");
		}
		
		// Verify there is a contactID to remove
		if (contactList.isEmpty()) {
			throw new IllegalArgumentException("Contacts list is empty");
		}
		
		int index = -1;
		for (Contact contacts : contactList) {                   // Loop through the contact list
			if (contacts.getContactId().equals(contactId)) {     // Checks if the contact ID is in the contacts list
				index = contactList.indexOf(contacts);
			}
		}
		contactList.remove(index);             // Remove the contact
	}
	
	// Update contact in contact list given a specific contactID
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		
		int index = -1;
		
		for (Contact contacts : contactList) {                   // Loop through the contact list
			if (contacts.getContactId().equals(contactId)) {     // If the contactId matches a contactId in the contacts list
				index = contactList.indexOf(contacts);
			}
		}
		
		Contact updateContact = contactList.get(index);          // Create temp variable that will hold updated information
		
		updateContact.setFirstName(firstName);
		updateContact.setLastName(lastName);
		updateContact.setPhone(phone);
		updateContact.setAddress(address);
		
		
		contactList.remove(index);                               // Delete the old information
		contactList.add(updateContact);                          // Make the temp variable the new entry
			
	}
	
	/*public static void main(String[] args) {
		ContactService contactService = new ContactService();
		
		// Create contacts
		Contact newContact1 = new Contact("C10005", "Courtney", "Thim", "1736482749", "387 Elm St, Springfield, MA");
		Contact newContact2 = new Contact("C10006", "Daniel", "Baker", "1739572222", "15 Pine St, Albany, NY");
		
		// Add contacts to the contact list
		contactService.addContact(newContact1);
		contactService.addContact(newContact2);
		
		// Get a contact
		Contact retrievedContact = contactService.getContact("C10005");
		if (retrievedContact != null) {
			System.out.println("Retrieved Contact: ");
			System.out.println("ID: " + retrievedContact.getContactId());
			System.out.println("First Name: " + retrievedContact.getFirstName());
			System.out.println("Last Name: " + retrievedContact.getLastName());
			System.out.println("Phone: " + retrievedContact.getPhone());
			System.out.println("Address: " + retrievedContact.getAddress());
		}
		else {
			System.out.println("Contact not found");
		}
		
		// Update a contact
		contactService.updateContact("C10005", "Diane", "Thim", "1736482749", "387 Elm St, Springfield, MA");
		Contact updateContact = contactService.getContact("C10005");
		if (updateContact != null) {
			System.out.println("Updated Contact: ");
			System.out.println("ID: " + updateContact.getContactId());
			System.out.println("First Name: " + updateContact.getFirstName());
			System.out.println("Last Name: " + updateContact.getLastName());
			System.out.println("Phone: " + updateContact.getPhone());
			System.out.println("Address: " + updateContact.getAddress());
		}
		
		// Delete a contact
		contactService.deleteContact("C10006");
		Contact deletedContact = contactService.getContact("C10006");
		if (deletedContact == null) {
			System.out.println("Contact deleted");
		}
		
	}*/

}
