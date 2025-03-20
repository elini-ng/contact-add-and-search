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
            contacts.forEach(contact -> {
                System.out.print("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber());

                if (contact instanceof BusinessContact) {
                    System.out.println(", 회사명: " + ((BusinessContact) contact).getCompany());
                } else {
                    System.out.println(", 관계: " + ((PersonalContact) contact).getRelationship());
                }
            });
        }
    }

    void searchContact(String name) {
        contacts.stream()
                .filter(contact -> contact.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresentOrElse(contact -> {
                    System.out.print("이름: " + contact.getName() + ", 전화번호: " + contact.getPhoneNumber());

                    if (contact instanceof BusinessContact) {
                        System.out.println(", 회사명: " + ((BusinessContact) contact).getCompany());
                    } else {
                        System.out.println(", 관계: " + ((PersonalContact) contact).getRelationship());
                    }
                },
                () -> System.out.println("연락처를 찾을 수 없습니다.")
        );
    }
}
