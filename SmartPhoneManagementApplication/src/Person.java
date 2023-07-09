public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;

    public Person(String name, String lastName, String phoneNumber, String mail){
        this.firstName=name;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.mail=mail;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
