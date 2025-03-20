public class BusinessContact extends Contact{
    String company;

    BusinessContact(String name, String phoneNumber, String company){
        super(name, phoneNumber);
        this.company = company;
    }

    public String getCompany(){
        return this.company;
    }
}
