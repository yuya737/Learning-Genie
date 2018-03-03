import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class QuestionNode implements DecisionNode{
	public String question; //attributes for QuestionNode: a string, left and right DecisionNodes
	public DecisionNode left;
	public DecisionNode right;

	public QuestionNode(String str, DecisionNode left, DecisionNode right){ //contructor for QuestionNode given a string, left and right QuestionNode
		this.question =  str;
		this.left = left;
		this.right = right;
	}
	public QuestionNode(String str){ //constructor for QuestionNode given a string
		this.question =  str;
		this.left = null; //set left and right DecisionNode fields to null
		this.right = null;
	}
	public int countObjects() { //return  the sum of countObjects() runs on the left and right DecisionNode
		return this.left.countObjects() + this.right.countObjects();
	}

	public DecisionNode guess(Scanner in) { //start guess process at QuestionNode
		System.out.print(this.question + " ");
		while(true){
			String input = in.nextLine(); //prompt a response for the question
			if (input.equalsIgnoreCase("yes")){ //check if user input is yes (regardless of the case of characters)
				DecisionNode newNode = this.left.guess(in); //create a new node by starting the the guess process on the left DecisioNode
				this.left = newNode; //set the new node to be the left field
				return this; //return this node
			}
			else if (input.equalsIgnoreCase("no")){ //check if user input is no (regardless of the case of characters)
				DecisionNode newNode = this.right.guess(in); //create a new node by starting the the guess process on the right DecisioNode
				this.right = newNode; //set the new node to be the right field
				return this; //return this node
			}
			else {
				System.out.println("Please enter vallid input! A valid input is either Yes or No"); //otherwise prompt for valid input
			}
		}
	}

	public void write(FileWriter out) throws IOException { //write out information of the QuestionNode
		out.write("#"); 
		out.write(this.question);
		out.write("\n");
		this.left.write(out); //write out information for left DecisionNode
		this.right.write(out); //write out information for right DecisionNode
	}             
}
