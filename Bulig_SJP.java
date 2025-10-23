import java.util.Scanner;//import Scanner Class for user input
public class Main {
	public static void main(String[] args) {
	//The Scanner object reads input from the user or keyboard
		Scanner sc  = new  Scanner(System.in);
		System.out.println("Student Information");System.out.println("");
		
//ask and read your name.Output should look like this Enter your name: Marcelo Bulig Jr.
		System.out.print("Enter your name: ");
		String name = sc.nextLine();
		
		//ask and read your age.The output should look like this Enter your age: 20
		System.out.print("Enter your age: ");
		int age = sc.nextInt();
		sc.nextLine();
		
		//ask and read your course.The output should look like this Enter your Course: BSIT 
		System.out.print("Enter your Course: ");
		String Course = sc.nextLine();
		
		//ask and read your year level.The output should look like this Enter year level: 1
		System.out.print("Enter  Year  level: ");
		String Yearlevel= sc.nextLine();
		
		//ask and read your favorite Qoute.
		//the output should look like this Enter your Qoute: "The fake is far greater than value.In it's deliberate attempt  to be real,it's more real than the real thing"
	System.out.print("Enter your Favorite Qoute: ");
		String Qoute = sc.nextLine();
		
		//it computes birth year using age
		int birthday = 2025 - age ;
		 
		 //print Student Information
	 System.out.println("");
	System.out.println("Student Information");        System.out.println("");
	System.out.println("Name: " + name.toUpperCase());
	System.out.println("Age: " + age);
	System.out.println("Birthday: " + birthday);
	System.out.println("Course: " + Course);
System.out.println("Year level: " + Yearlevel);
System.out.println("Favorite Qoute: " + Qoute);
		//close Scanner to free resources
		sc.close();
	}
}