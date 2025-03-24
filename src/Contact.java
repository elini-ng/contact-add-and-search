public class Contact {
    String name;
    String phoneNumber;

    Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public String toString(){
        String msg = "이름: " + getName() + ", 전화번호: " + getPhoneNumber();

        if (this instanceof BusinessContact) {
            msg = msg + ", 회사명: " + ((BusinessContact) this).getCompany();
        } else {
            msg = msg + ", 관계: " + ((PersonalContact) this).getRelationship();
        }
        return msg;
    }
}
