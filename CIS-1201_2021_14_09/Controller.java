import java.util.Scanner;

/**
* Mealdodale Dairy Fare - egg pricer
* @since 20210914
* @author Arthur Zuliani
*/

public class Controller{

	public static void main (String[] args){

		//Instation of the input
		Scanner input = new Scanner(System.in);

		//Prints a user prompt
		System.out.println("Enter the amount of eggs desired:");
		Integer eggsAmount = input.nextInt();	//Read the amount of eggs desired by the user

		Integer numberOfDozen = eggsAmount / 12;   //Calculate the dozen number
		Integer looseEggs = eggsAmount % 12;       //Calculate the loose eggs 

		double totalPrice = (numberOfDozen * 3.25) + (looseEggs * 0.45);  //Calculate the total price of the order

		if(looseEggs == 0)
		{
			//Printout the order receipt when there is only 1 egg loose
			System.out.println("Your ordered " + eggsAmount + " eggs. That's " + numberOfDozen + " dozen at $3.25 per dozen for a total of $" + totalPrice); 
		}
		else if(looseEggs == 1)
		{
			//Printout the order receipt
			System.out.println("Your ordered " + eggsAmount + " eggs. That's " + numberOfDozen + " dozen at $3.25 per dozen and " + looseEggs + " loose egg at 45.0 cents each for a total of $" + totalPrice); 
		}
		else
		{
			//Printout the order receipt
			System.out.println("Your ordered " + eggsAmount + " eggs. That's " + numberOfDozen + " dozen at $3.25 per dozen and " + looseEggs + " loose eggs at 45.0 cents each for a total of $" + totalPrice); 
		}

	}
}