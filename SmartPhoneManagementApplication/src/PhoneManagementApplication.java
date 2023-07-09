
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PhoneManagementApplication {
    private List<Phone> phones;
    private List<Application> applications;
    private List<Person> personList;

    private FileOperations fileOperations;

    public PhoneManagementApplication() {
        phones = new ArrayList<>();
        applications = new ArrayList<>();
        personList = new ArrayList<>();
        fileOperations = new FileOperations();
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public FileOperations getFileOperations() {
        return fileOperations;
    }

    public void setFileOperations(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------Smart Phone Management Application------");
            System.out.println("1. Add a Phone");
            System.out.println("2. Manage applications");
            System.out.println("3. Manage person");
            System.out.println("4. Check storage capacity");
            System.out.println("5. Backup data");
            System.out.println("6. Restore data");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    manageApplications();
                    break;
                case 3:
                    managePerson();
                    break;
                case 4:
                    checkStorageCapacity();
                    break;
                case 5:
                    backupData();
                    break;
                case 6:
                    restoreData();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);

    }

    private void restoreData() {
        FileOperations fileOperations1 = new FileOperations();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What data do you want to restore?");
            System.out.println("1. Phone");
            System.out.println("2. Person");
            System.out.println("3. Application");
            System.out.println("0. Back");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    fileOperations1.restorePhoneData();
                    break;
                case 2:
                    fileOperations1.restorePersonData();
                    break;
                case 3:
                    fileOperations1.restoreApplicationData();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }


    private void backupData() {
        FileOperations fileOperations1 = new FileOperations();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("What data do you want to backup?");
            System.out.println("1. Phone");
            System.out.println("2. Person");
            System.out.println("3. Application");
            System.out.println("0. Back");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    fileOperations1.backUpPhoneData(phones);
                    break;
                case 2:
                    fileOperations1.backUpPersonData(personList);
                    break;
                case 3:
                    fileOperations1.backUpApplicationData(applications);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }


    private void checkStorageCapacity() {
        int totalCapacity = 0;
        int usedCapacity = 0;
        for (Phone phone : phones) {
            totalCapacity += phone.getStorageSpace();
        }
        for (Application application : applications) {
            usedCapacity += Integer.parseInt(application.getSize());

        }
        int availableCapacity = totalCapacity - usedCapacity;
        System.out.println("Total Storage Capacity: " + totalCapacity + " GB");
        System.out.println("Used Storage Capacity: " + usedCapacity + " GB");
        System.out.println("Available Storage Capacity: " + availableCapacity + " GB");
    }

    private void managePerson() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------Person Management------");
            System.out.println("1. Add a person");
            System.out.println("2. Remove a person");
            System.out.println("3. Update a person");
            System.out.println("4. Call a person");
            System.out.println("5. Display a person");
            System.out.println("0. Back");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    removePerson();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    callPerson();
                    break;
                case 5:
                    displayPerson();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }

    private void displayPerson() {
        if (personList.isEmpty()) {
            System.out.println("No person found.");
        } else {
            System.out.println("Person List: ");
            personList.forEach(person -> {
                System.out.println("First Name: " + person.getFirstname());
                System.out.println("Last Name: " + person.getLastName());
                System.out.println("Phone Number: " + person.getPhoneNumber());
                System.out.println("Mail: " + person.getMail());
            });
        }
    }

    private void callPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a name to call: ");
        String name = sc.nextLine();
        for (Person person : personList) {
            if (person.getFirstname().equalsIgnoreCase(name)) {
                System.out.println(name + " "+ person.getLastName() + " calling..");
            }
        }
        if (personList.contains(name)!=true){
            System.out.println("No phone record found!");
        }
    }

    private void updatePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the mail: ");
        String mail = scanner.nextLine();

        System.out.println("Enter the new first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the new last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the new phone number: ");
        String phoneNumber = scanner.nextLine();

        personList.stream().filter(person -> person.getMail().equalsIgnoreCase(mail))
                .findFirst()
                .ifPresent(person -> {
                    person.setFirstName(firstName);
                    person.setLastName(lastName);
                    person.setPhoneNumber(phoneNumber);
                });
        System.out.println("Person updated successfully!");
    }

    private void removePerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the mail: ");
        String mail = scanner.nextLine();

        personList.removeIf(person -> person.getMail().equalsIgnoreCase(mail));
        System.out.println("Person removed successfully!");
    }

    private void addPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the mail: ");
        String mail = scanner.nextLine();
        Person person = new Person(firstName, lastName, phoneNumber, mail);
        personList.add(person);
        System.out.println("Person added successfully!");
    }


    private void manageApplications() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------Application Management------");
            System.out.println("1. Add an application");
            System.out.println("2. Remove an application");
            System.out.println("3. Update an application");
            System.out.println("4. Display Information");
            System.out.println("0. Back");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addApplication();
                    break;
                case 2:
                    removeApplication();
                    break;
                case 3:
                    updateApplication();
                    break;
                case 4:
                    displayInformation();
                    break;
                case 0:
                    System.out.println("Returning to main menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);

    }

    private void displayInformation() {
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
        } else {
            System.out.println("Applications: ");
            applications.forEach(application -> {
                System.out.println("Name: " + application.getName());
                System.out.println("Version: " + application.getVersion());
                System.out.println("Size: " + application.getSize());
            });
        }
    }


    private void updateApplication() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the application name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the application new version: ");
        String version = scanner.nextLine();
        System.out.println("Enter the application new size: ");
        String size = scanner.nextLine();

        applications.stream().filter(application -> application.getName().equalsIgnoreCase(name)).findFirst().ifPresent(application -> {
            application.setVersion(version);
            application.setSize(size);
        });

        System.out.println("Application updated successfully!");
    }

    private void removeApplication() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the application name: ");
        String name = scanner.nextLine();

        applications.removeIf(application -> application.getName().equalsIgnoreCase(name));

        System.out.println("Application removed successfully!");
    }

    private void addApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the application name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the application version");
        String version = scanner.nextLine();
        System.out.println("Enter the application size");
        String size = scanner.nextLine();
        Application application = new Application(name, version, size);
        applications.add(application);
        System.out.println("Application added successfully!");


    }

    private void addPhone() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter the model: ");
        String model = scanner.nextLine();
        System.out.println("Enter the serial number: ");
        String serialNumber = scanner.nextLine();


        try {
            System.out.println("Enter the storage capacity: ");
            int storageCapacity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the operating system: ");
            String operatingSystem = scanner.nextLine();
            Phone phone = new Phone(brand, model, serialNumber, storageCapacity, operatingSystem);
            phones.add(phone);
            System.out.println("Phone added successfully!");
        } catch (InputMismatchException e) {
            System.out.println("Invalid enter!");
        }

    }


}
