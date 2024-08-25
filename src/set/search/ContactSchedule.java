package set.search;

import java.util.HashSet;
import java.util.Set;

public class ContactSchedule {

    private Set<Contact> contactSet;


    public ContactSchedule() {
        this.contactSet = new HashSet<>();
    }

    public void addContact(String name, int numero) {
        contactSet.add(new Contact(name, numero));
    }

    public void displayContacts() {
        System.out.println(contactSet);
    }

    public Set<Contact> searchByName(String name) {
        Set<Contact> contactsByName = new HashSet<>();
        if (!contactSet.isEmpty()) {
            for (Contact contact : contactSet) {
                if (contact.getName().startsWith(name)) {
                    contactsByName.add(contact);
                }
            }
            return contactsByName;
        } else {
            throw new RuntimeException("The set is empty");
        }
    }

    public Contact updateContact(String name, int newNumber) {
        Contact contactUpdated = null;
        if (!contactSet.isEmpty()) {
            for (Contact contact : contactSet) {
                if (contact.getName().equalsIgnoreCase(name)) {
                    contact.setNumber(newNumber);
                    contactUpdated = contact;
                    break;
                }
            }
            return contactUpdated;
        } else {
            throw new RuntimeException("The set is empty");
        }
    }

    public static void main(String[] args) {
        ContactSchedule contactSchedule = new ContactSchedule();

        contactSchedule.displayContacts();

        contactSchedule.addContact("Lucas", 12458);
        contactSchedule.addContact("Lucas", 5485);
        contactSchedule.addContact("Lucas Dio", 0);
        contactSchedule.addContact("Vitor", 414);
        contactSchedule.addContact("Marcos", 54544);
        contactSchedule.addContact("Maria", 0);

        System.out.println("List of contacts:");
        contactSchedule.displayContacts();
        System.out.println("-----------------------");

        System.out.println("Search by name:");
        System.out.println(contactSchedule.searchByName("Lucas"));
        System.out.println("--------------------------");

        System.out.println("Updating the agenda: ");
        Contact updateContact = contactSchedule.updateContact("Carolina", 54545454);
        System.out.println("Contact updated: "+ updateContact);
        System.out.println("----------------------");

        System.out.println("Contacts after update in schedule:");
        contactSchedule.displayContacts();
    }
}
