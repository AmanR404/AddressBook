import java.util.Scanner;

public class AddressBookMain {

    void addContacts(Scanner scanner , int numOfContact){

        Contacts contact[] = new Contacts[numOfContact];

        String firstName;
		String lastName;
		String address;
		String city;
		int zip;
		String email;
		String phoneNumber;

        for(int i = 0; i <= contact.length; i++){
            System.out.print("Enter first name : ");
            firstName = sc.next();

            System.out.print("Enter Last name: ");
			lastName = scanner.next();
			
			System.out.print("Enter your Address: ");
			address = scanner.next();
			
			System.out.print("Enter Your City: ");
			city = scanner.next();
			
			System.out.print("Enter Zip code: ");
			zip = scanner.nextInt();

			System.out.print("Enter Your Email: ");
			email = scanner.next();

			System.out.print("Enter Your Number:");
			phoneNumber = scanner.next();

            contact[i] = new Contacts(firstName, lastName , address, city, zip, email ,phoneNumber);
        }
    }

    public static void main(String[] args) {  
             
		System.out.println("How many Contacts do you want to add:  ");
		Scanner scanner = new Scanner(System.in);
		int numOfContact = scanner.nextInt();
		AddressBookMain addressbook = new AddressBookMain();
        addressbook.addContacts(scanner,numOfContact);

        }
    }