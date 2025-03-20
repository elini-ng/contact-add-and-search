import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Contact> contacts = new ArrayList<>();
    static AddressBook addressBook = new AddressBook(contacts);

    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu(){
        Scanner menuSelect = new Scanner(System.in);
        System.out.println("1. 비즈니스 연락처 추가\n" +
                "2. 개인 연락처 추가\n" +
                "3. 연락처 출력\n" +
                "4. 연락처 검색\n" +
                "5. 종료\n" +
                "메뉴를 선택해주세요:");
        String selectedMenu = menuSelect.nextLine();

        switch (selectedMenu) {
            case "1" -> addBusinessContact();
            case "2" -> addPersonalContact();
            case "3" -> getContactList();
            case "4" -> searchContactList();
            case "5" -> System.exit(0);
            default -> invalidInput();
        }

    }

    static void addBusinessContact(){
        Scanner bizContactInput = new Scanner(System.in);
        System.out.println("이름을 입력하세요:");
        String name = bizContactInput.nextLine();
        System.out.println("전화번호를 입력하세요:");
        String phoneNumber = bizContactInput.nextLine();
        System.out.println("회사명을 입력하세요:");
        String company = bizContactInput.nextLine();

        Contact bizContact = new BusinessContact(name, phoneNumber, company);
        addressBook.addContact(bizContact);
        MainMenu();
    }

    static void addPersonalContact(){
        Scanner perContactInput = new Scanner(System.in);
        System.out.println("이름을 입력하세요:");
        String name = perContactInput.nextLine();
        System.out.println("전화번호를 입력하세요:");
        String phoneNumber = perContactInput.nextLine();
        System.out.println("관계를 입력하세요:");
        String relationship = perContactInput.nextLine();

        PersonalContact perContact = new PersonalContact(name, phoneNumber, relationship);
        addressBook.addContact(perContact);
        MainMenu();
    }

    static void getContactList(){
        addressBook.displayContacts();
        MainMenu();
    }

    static void searchContactList(){
        Scanner searchByName = new Scanner(System.in);
        System.out.println("검색할 이름을 입력하세요:");
        String name = searchByName.nextLine();

        addressBook.searchContact(name);
        MainMenu();
    }

    static void invalidInput(){
        System.out.println("1부터 5까지의 번호 중 하나를 입력해주세요");
        MainMenu();
    }
}