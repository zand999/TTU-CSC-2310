//import keyboard.java;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class JobClient{

	
	private static ArrayList<Visitable> employees = new ArrayList<Visitable>();

	public static void main(String[] args){



		int selection;

		Keyboard kb = Keyboard.getKeyboard();

		run:
		while(true){



			System.out.println("\r\nMenue");
			System.out.println("(1). Add an employee");
			System.out.println("(2). One Visitor");
			System.out.println("(3). All Visitors");
			System.out.println("(4). End Program");
			selection = kb.readInt("Choice (1-3): ");

			switch(selection){

				case 1:
					addJob();
					break;

				case 2:
					oneVisit();

					break;

				case 3:
					visitAll();
					break;
				case 4:
					break run;
				default:
					System.out.println("BAD INPUT \r\n");
					break;


			}




		}


	}


	public static void addJob(){

		int selection,vacation;
		String name;
		double salary;

		Scanner reader = new Scanner(System.in);
		Keyboard kb = Keyboard.getKeyboard();


		while(true){
			System.out.println("\r\nWhat kind of employee would you like to add");
			System.out.println("(1). Software Developer");
			System.out.println("(2). Database Administrator");
			System.out.println("(3). Computer Systems Analyst");
			System.out.println("(4). Web Developer");
			System.out.println("(5). Information Security Analyst");
			selection = kb.readInt("Choice (1-5): ");

			if(selection <=5 && selection >= 1){
				break;
			}else{
				System.out.println("ERROR: Please select (1-5)\r\n");
			}
		}

		name = kb.readString("\r\nWhat is the name of the employee\r\n");

		while(true){
			
			salary = kb.readDouble("What is the salary of the employee?");

			if(salary <= 0){
				System.out.println("ERROR: Please provide number greater than zero.\r\n");
				
			}else{
				break;
			}
		}

		while(true){
			
			vacation = kb.readInt("How many vacation does does the employee have?");

			if(vacation < 0){
				System.out.println("ERROR: Please provide number greater than or equal to zero.\r\n");
				
			}else{
				break;
			}
		    
		}

		Visitable temp;

		switch(selection){

			case 1:
				temp = new SoftwareDev(name,salary,vacation);
				employees.add(temp);
				break;
			case 2:
				temp = new DatabaseAdmin(name,salary,vacation);
				employees.add(temp);
				break;

			case 3:
				temp = new ComputerSysAnalyst(name,salary,vacation);
				employees.add(temp);
				break;
			case 4:
				temp = new WebDev(name,salary,vacation);
				employees.add(temp);
				break;
			case 5:
				temp = new InfoSecurityAnalyst(name,salary,vacation);
				employees.add(temp);
				break;


		}

		System.out.println("\r\nNew Employee");
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Vacation Days: " + vacation);

	}

	

	public static void oneVisit(){

		Keyboard kb = Keyboard.getKeyboard();
		int selection;


		while(true){
			
			System.out.println("\r\nWhich Visitor would you like to use?");
			System.out.println("(1). Income Visitor");
			System.out.println("(2). Vacation Visitor");
			selection = kb.readInt("Choice (1-2): ");

			if(selection <=2 && selection >= 1){
				break;
			}else{
				System.out.println("ERROR: Please select (1-5)\r\n");
			}

		    
		}
		if(selection == 1){
			IncomeVisitor visitor = new IncomeVisitor();
			for(Visitable temp: employees){

				temp.accept(visitor);
				System.out.println("Name: " + temp.getName() + "\r\nIncome: " + visitor.getNewIncome());

			}
				
		}else if(selection == 2){
			
			VacationVisitor visitor = new VacationVisitor();
			for(Visitable temp: employees){

				temp.accept(visitor);
				System.out.println("Name: " + temp.getName() + "\r\nVacation Days: " + visitor.getVacationDays());

			}
		}
				


		

		

	}

	public static void visitAll(){

		IncomeVisitor visitor = new IncomeVisitor();
		VacationVisitor visitor2 = new VacationVisitor();

		for(Visitable temp: employees){

				temp.accept(visitor);
				temp.accept(visitor2);
				System.out.println("Name: " + temp.getName() + "\r\nIncome: " + visitor.getNewIncome());
				System.out.println("Name: " + temp.getName() + "\r\nVacation Days: " + visitor2.getVacationDays());

			}

	}


}