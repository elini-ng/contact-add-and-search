import java.util.List;

public class AddressBook {
    List<Contact> contacts;

    public AddressBook (List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다");
        } else {
            contacts.forEach(System.out::println);
        }
    }

    void searchContact(String name) {
        contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                () -> System.out.println("연락처를 찾을 수 없습니다.")
        );
    }
}
