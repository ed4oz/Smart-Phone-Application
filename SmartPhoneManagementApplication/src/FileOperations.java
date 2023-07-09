import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private static final String PHONE_DATA = "phone_data.txt";
    private static final String APPLICATION_DATA = "application_data.txt";
    private static final String PERSON_DATA = "person_data.txt";

    public void backUpPhoneData(List<Phone> phoneList) {
        try (FileWriter writer = new FileWriter(PHONE_DATA);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Phone phone : phoneList) {
                bufferedWriter.write(phone.getBrand() + ", " + phone.getModel() + ", " + phone.getSerialNumber() + ", " + phone.getOperatingSystem() + ", " + phone.getStorageSpace());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while backing up phone data: " + e.getMessage());

        }

    }

    public List<Phone> restorePhoneData() {

        List<Phone> phoneList = new ArrayList<>();
        try (FileReader reader = new FileReader(PHONE_DATA);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String brand = data[0];
                    String model = data[1];
                    String serialNumber = data[2];
                    String storageSpace = data[3];
                    String operatingSystem = data[4];

                    Phone phone = new Phone(brand, model, serialNumber, Integer.parseInt(storageSpace), operatingSystem);
                    phoneList.add(phone);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while restoring phone data: " + e.getMessage());
        }
        return phoneList;
    }

    public void backUpApplicationData(List<Application> applications) {
        try (FileWriter writer = new FileWriter(APPLICATION_DATA)) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Application application : applications) {
                bufferedWriter.write(application.getName() + "," +
                        application.getVersion() + "," +
                        application.getSize());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("An error occurred while backing up application data:" + e.getMessage());
        }
    }

    public List<Application> restoreApplicationData() {
        List<Application> applications = new ArrayList<>();
        try (FileReader reader = new FileReader(APPLICATION_DATA);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String version = data[1];
                    String size = data[2];

                    Application application = new Application(name, version, size);
                    applications.add(application);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while restoring application data: " + e.getMessage());
        }
        return applications;
    }

    public void backUpPersonData(List<Person> personList) {
        try (FileWriter writer = new FileWriter(PERSON_DATA);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (Person person : personList) {
                bufferedWriter.write(person.getFirstname() + "," +
                        person.getLastName() + "," +
                        person.getPhoneNumber() + "," +
                        person.getMail());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while backing up contact data: " + e.getMessage());
        }
    }

    public List<Person> restorePersonData() {
        List<Person> personList = new ArrayList<>();

        try (FileReader reader = new FileReader(PERSON_DATA);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String phoneNumber = data[2];
                    String mail = data[3];

                    Person person = new Person(firstName, lastName, phoneNumber, mail);
                    personList.add(person);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while restoring contact data: " + e.getMessage());
        }

        return personList;


    }
}
