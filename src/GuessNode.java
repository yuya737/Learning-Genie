import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class GuessNode implements DecisionNode {
	public String guess; //the guess String attribute for GuessNode

	public GuessNode(String str){ //constructor of GuessNode given a string
		this.guess =  str;
	}
	public int countObjects() { //the number of GuessNode for every GuessNode is 1
		return 1;
	}

	public DecisionNode guess(Scanner in) { //start guess process at GuessNode
		System.out.print("Are you thinking of " + this.guess + "? "); //ask the user if the 'guess' for this GuessNode is correct
		boolean flag = true; //boolean flag for the while loop
		while (flag){
			String input = in.nextLine(); //take in user input
			if (input.equalsIgnoreCase("Yes")){ //check if input is yes (regardless of the case for each character
				System.out.println("Excellent, thanks!"); //print if the guess is correct
				flag = false; //change boolean flag to false to exit while loop
				return this; //return this GuessNode since no new information was obtained
			}
			else if (input.equalsIgnoreCase("No")){ //check if input is no (regardless of the case for each character
				System.out.println("Oh no, I was wrong");
				System.out.print("What country were you thinking of? ");
				String answer = in.nextLine(); //take in the correct guess 
				System.out.print("What is a yes/no question that distinguishes a " + this.guess + " from a " + answer + "\n" + "(Yes corresponds to " + this. guess + "; No corresponds to " + answer + ") ");
				String newQuestion = in.nextLine(); //prompt user for the distinguishing question
				DecisionNode newNode = new QuestionNode(newQuestion, new GuessNode(this.guess), new GuessNode(answer)); //create a new QuestioNode with the given disinguishing question and the corresponding responses
				System.out.println("Thanks! I'll learn from this experience!");
				flag = false; //change boolean flag to false to exit while loop
				return newNode; //return the new QuestionNode with new information 
			}
				System.out.println("Please enter valid input! A valid input is either Yes or No"); //if user input was neither yes or no, loop again		
		}
		return null;
	}

	public void write(FileWriter out) throws IOException { //write out the information of this GuessNode
		out.write(this.guess); //write out the guess string
		out.write("\n"); //write out a newline character
	}
}
