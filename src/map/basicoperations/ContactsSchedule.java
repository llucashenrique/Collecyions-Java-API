package map.basicoperations;

import set.search.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactsSchedule {

    private Map<String, Integer> contactsSchedule;

    public ContactsSchedule( ){
        this.contactsSchedule = new HashMap<>();
    }

    public void addContact(String name, Integer phone) {
        contactsSchedule.put(name, phone);
    }

    public void removeContacts(String name) {
        if (!contactsSchedule.isEmpty()) {
            contactsSchedule.remove(name);
        } else {
            System.out.println("The schedule is empty");
        }
    }

    public void displayContacts() {
        System.out.println(contactsSchedule);
    }

    public Integer searchByName(String name) {
        Integer numberForName = null;
        if (!contactsSchedule.isEmpty()) {
            numberForName = contactsSchedule.get(name);
        }
        return numberForName;
    }

    public static void main(String[] args) {
        ContactsSchedule scheduleContacts = new ContactsSchedule();

        scheduleContacts.addContact("Lucas", 12458);
        scheduleContacts.addContact("Lucas", 5485);
        scheduleContacts.addContact("Lucas Dio", 0);
        scheduleContacts.addContact("Vitor", 5485);
        scheduleContacts.addContact("Marcos", 54544);
        scheduleContacts.addContact("Maria", 0);


        System.out.println("Showing all contacts: ");
        scheduleContacts.displayContacts();
        System.out.println("-------------------------");

        System.out.println("Removing contacts: ");
        scheduleContacts.removeContacts("Vitor");
        System.out.println("-------------------------");

        System.out.println("Showing all contacts now that some only they are removed : ");
        scheduleContacts.displayContacts();
        System.out.println("---------------------------");

        System.out.println("Searching by name: ");
        System.out.println("The number is: "+ scheduleContacts.searchByName("Lucas"));

    }
}
