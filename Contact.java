/*
 * Developer: Courtney Thim
 */

package contactservicepackage;

public class Contact {

	// Declaration of variables
	private String contactId;       // Length must be 10 or less + cannot be null or updatable
	private String firstName;       // Length must be 10 or less + cannot be null
	private String lastName;        // Length must be 10 or less + cannot be null
	private String phone;           // Length must be exactly 10 + cannot be null
	private String address;         // Length must be 30 or less + cannot be null
	
	// Creating constant variables for max length values
	private static final int CONTACT_ID_LENGTH = 10;
	private static final int FIRST_NAME_LENGTH = 10;
	private static final int LAST_NAME_LENGTH = 10;
	private static final int PHONE_LENGTH = 10;
	private static final int ADDRESS_LENGTH = 30;
	
	/*
	 * Constructor methods
	 */
	
	// Constructor
	public Contact() {
		this.contactId = "00000";
		this.firstName = "firstname";
		this.lastName = "lastname";
		this.phone = "0123456789";
		this.address = "address";
	}
	
	// Parameterized Constructor
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		setContactId(contactId);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	/*
	 * Accessor Methods
	 */
	
	// Getter for contactId
	public String getContactId() {
		return this.contactId;
	}
	
	// Getter for firstName
	public String getFirstName() {
		return this.firstName;
	}
	
	// Getter for lastName
	public String getLastName() {
		return this.lastName;
	}
	
	// Getter for phone
	public String getPhone() {
		return this.phone;
	}
	
	// Getter for address
	public String getAddress() {
		return this.address;
	}
	
	/*
	 * Mutator methods
	 */

	// Setter for contactId
	public void setContactId(String contactId) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID cannot be empty.");
		}
		else if (contactId.length() > CONTACT_ID_LENGTH) {
			throw new IllegalArgumentException("Contact ID must be " + CONTACT_ID_LENGTH + " characters or less.");
		}
		else {
			this.contactId = contactId;
		}
	}
	
	// Setter for firstName
	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be empty.");
		}
		else if (firstName.length() > FIRST_NAME_LENGTH) {
			throw new IllegalArgumentException("First name must be " + FIRST_NAME_LENGTH + " characters or less.");
		}
		else {
			this.firstName = firstName;
		}
	}
	
	// Setter for lastName
	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be empty.");
		}
		else if (lastName.length() > LAST_NAME_LENGTH) {
			throw new IllegalArgumentException("Last name must be " + LAST_NAME_LENGTH + " characters or less.");
		}
		else {
			this.lastName = lastName;
		}
	}
	
	// Setter for phone
	public void setPhone(String phone) {
		if (phone == null) {
			throw new IllegalArgumentException("Phone number cannot be empty.");
		}
		else if (phone.length() != PHONE_LENGTH) {
			throw new IllegalArgumentException("Phone number must be exactly " + PHONE_LENGTH + " characters.");
		}
		else {
			this.phone = phone;
		}
	}
	
	// Setter for address
	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be empty.");
		}
		else if (address.length() > ADDRESS_LENGTH) {
			throw new IllegalArgumentException("Address must be " + ADDRESS_LENGTH + " characters or less.");
		}
		else {
			this.address = address;
		}
	}
	
	/*public static void main(String args[]) {
		Contact newContact = new Contact("C10005", "Courtney", "Thim", "1736482749", "387 Elm St, Springfield, MA");
		
		System.out.println(newContact.getContactId());
		System.out.println(newContact.getFirstName());
		System.out.println(newContact.getLastName());
		System.out.println(newContact.getPhone());
		System.out.println(newContact.getAddress());
	}*/
}
