package contact_package;

public class Contact {
	// Constants defining maximum lengths for contact attributes

	private static final byte CONTACT_FNAME_LENGTH = 10;
	private static final byte CONTACT_LNAME_LENGTH = 10;
	private static final byte CONTACT_ADDRESS_LENGTH = 30;

	// Contact attributes
	private String contactId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;

	public Contact(String contactId) {
		this.contactId = contactId;
	}

	public Contact(String contactId, String firstName) {
		this.contactId = contactId;
		this.firstName = firstName;
	}

	public Contact(String contactId, String firstName, String lastName) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Contact(String contactId, String firstName, String lastName, String phoneNumber) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	// Getter methods for contact attributes
	public final String getContactId() {
		return contactId;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final String getAddress() {
		return address;
	}

	// Setter methods with validation for updating contact attributes

	/**
	 * Update the first name of the contact.
	 *
	 * @param firstName The new first name to be set.
	 * @throws IllegalArgumentException If the first name is null or exceeds the
	 *                                  maximum length.
	 */
	public void updateFirstName(String firstName) {
		String regex = ".{1," + CONTACT_FNAME_LENGTH + "}"; // Regular expression to match 1 to CONTACT_FNAME_LENGTH
															// characters
		if (firstName == null || !firstName.matches(regex)) {
			throw new IllegalArgumentException(
					"First name cannot be empty or longer than " + CONTACT_FNAME_LENGTH + " characters");
		} else {
			this.firstName = firstName;
		}
	}

	/**
	 * Update the last name of the contact.
	 *
	 * @param lastName The new last name to be set.
	 * @throws IllegalArgumentException If the last name is null or exceeds the
	 *                                  maximum length.
	 */
	public void updateLastName(String lastName) {
		String regex = ".{1," + CONTACT_LNAME_LENGTH + "}"; // Regular expression to match 1 to CONTACT_LNAME_LENGTH
															// characters
		if (lastName == null || !lastName.matches(regex)) {
			throw new IllegalArgumentException(
					"Last name cannot be empty or longer than " + CONTACT_LNAME_LENGTH + " characters");
		} else {
			this.lastName = lastName;
		}
	}

	/**
	 * Update the phone number of the contact.
	 *
	 * @param phoneNumber The new phone number to be set.
	 * @throws IllegalArgumentException If the phone number is null, has an invalid
	 *                                  length, or contains non-numeric characters.
	 */
	public void updatePhoneNumber(String phoneNumber) {
		String regex = "\\d{10}";
		if (phoneNumber == null || !phoneNumber.matches(regex)) {
			throw new IllegalArgumentException("Phone number must contain exactly 10 digits");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}

	/**
	 * Update the address of the contact.
	 *
	 * @param address The new address to be set.
	 * @throws IllegalArgumentException If the address is null or exceeds the
	 *                                  maximum length.
	 */
	public void updateAddress(String address) {
		String regex = ".{1," + CONTACT_ADDRESS_LENGTH + "}";
		if (address == null || !address.matches(regex)) {
			throw new IllegalArgumentException(
					"Address cannot be empty or longer than " + CONTACT_ADDRESS_LENGTH + " characters");
		} else {
			this.address = address;
		}
	}

}
