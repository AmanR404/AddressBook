import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AddressBookMain {
	
	void addContacts(Scanner scanner , int numOfContact , Contacts contact[]) 
	{
		int id;
		String firstName;
		String lastName;
		String address;
		String city;
		int zip;
		String email;
		String phoneNumber;
		
		for (int i=0; i<contact.length;i++ ) {
			
		    System.out.println("Enter id ");
		    id = scanner.nextInt();
			
			System.out.println("Enter First name: ");
			firstName = scanner.next();
			if(firstName.equals(contact[i].getfirstName)){
				throw new IllegalArgumentException("Contact already exists");
				break;
			}
			
			System.out.println("Enter Last name: ");
			lastName = scanner.next();
			
			System.out.println("Enter your Address: ");
			address = scanner.next();
			
			System.out.println("Enter Your City: ");
			city = scanner.next();
			
			System.out.println("Enter Zip code: ");
			zip = scanner.nextInt();

			System.out.println("Enter Your Email: ");
			email = scanner.next();

			System.out.println("Enter Your Number: ");
			phoneNumber = scanner.next();
			
			contact[i] = new Contacts(firstName, lastName , address, city, zip, email ,phoneNumber);
		}
		
		for (int i = 0 ; i<contact.length; i++) 
		{
			System.out.println(contact[i]);
		}
	}
	void deleteContacts(Scanner scanner , Contacts[] contact, String email) 
	{
		for (int i=0; i<contact.length;i++ ) {
			
			if(contact[i].getEmail().equalsIgnoreCase(email)) {
			contact[i].setFirstName(null);
			contact[i].setLirstName(null);
			contact[i].setAddress(null);
			contact[i].setCity(null);
			contact[i].setZip(null);
			contact[i].setEmail(null);
			contact[i].setPhoneNumber(null);
			}
		}
		
		for (int i = 0 ; i<contact.length; i++) 
		{
			System.out.println(contact[i]);
		}	
	}
	void storeinFile(){
		FileWriter filewriter = new FileWriter("addressbook.txt");
		for(int i = 0; i < contact.length; i++){
			filewriter.write(contact[i]);
			filewriter.write("\n");
		}
		filewriter.close();
	}
	void readFile() throws Exception{
		File file = new File("addressbook.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			System.out.println(sc.next());
		}
		sc.close();
	}
	
    public static void main(String[] args) {
        AddressBookMain addressbook = new AddressBookMain();
		
		System.out.print("How many Contacts do you want to add:  ");
		Scanner scanner = new Scanner(System.in);		
		int numOfContact = scanner.nextInt();	
		Contacts contact[] = new Contacts[numOfContact];
		addressbook.addContacts(scanner,numOfContact,contact );
		
        System.out.print("Enter a person email to edit the contact: ");
		String email = scanner.next();
		addressbook.deleteContacts(scanner, contact, email);
		}
}
