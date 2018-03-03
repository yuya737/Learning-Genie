import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class LearningGenie {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in); //intialize scanner for user input 
		File inputText = new File("/home/kawakami/csc207/LearningGenie/testoutput.txt"); //read in input/output text file
		Scanner scan1 = new Scanner(inputText); //intialize scanner for file input
		DecisionTree tree = new DecisionTree(inputText); //construct tree with the information we retrieve from the input file
		System.out.println("I am the learning genie!"); 
		System.out.println("I can figure out whatever you are thinking of by asking questions.");
		System.out.println("I know " + tree.countObjects() + " thing(s)!");
		tree.guess(scan); //start guess process for the tree
		while(true){
			System.out.print("Do you want to continue? "); 
			String input = scan.nextLine(); //prompt user if they want to continue 
			if (input.equalsIgnoreCase("no")){ //is input if no (regardless of the case of the character)
				break; //break from the while loop
			}
			else if (!input.equalsIgnoreCase("yes")){ //is input if yes (regardless of the case of the character)
				System.out.println("Please enter valid input. A valid input is either yes or no.");
			}
			else{
				tree.guess(scan); //since user has inputted yes, re-run the loop 
			}
		}
		scan1.close(); //close the scanner accessing the inputfile
		FileWriter outputText = new FileWriter("/home/kawakami/csc207/LearningGenie/testoutput.txt"); //intialize filewriter with input/output text file
		tree.write(outputText); //write out tree information into output text file
		outputText.close(); //close filewriter
	}
}
