
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class DecisionTree {
	DecisionNode root;

	public DecisionTree(){ //constructor for tree when we do not have an input file
		this.root = new GuessNode("Dog"); //set the root note to a Guessnode with 'Dog'
	}

	public DecisionNode constructorHelper (Scanner scan) throws FileNotFoundException{ //helper for constructor with input file
		while (scan.hasNextLine()){ //conditional to run until the end of file
			String newString = scan.nextLine(); //read in the string in the next line 
			if (!newString.contains("#")){//see if 'newString' is a not a question
				DecisionNode newGuessNode = new GuessNode(newString); //create a node GuessNode with 'newString'
				return newGuessNode;
			}
			DecisionNode newQuestionNode = new QuestionNode(newString.substring(1, newString.length())); //create a QuestionNode with the given question.
			((QuestionNode) newQuestionNode).left = constructorHelper(scan); //run this helper recursively to set the left node
			((QuestionNode) newQuestionNode).right = constructorHelper(scan);//run this helper recursively to set the right node
			return newQuestionNode;
		}
		return new GuessNode("America"); //if file is empty, return a GuessNode with 'America'
	}
	public DecisionTree(File file) throws FileNotFoundException{ //constructor for tree with an input file
		Scanner scan = new Scanner(file); //initialize scanner
		this.root = constructorHelper(scan); //set the root to the nodes we retrieve from the file
	}


	public int countObjects(){ //return the number of GuessNode of the tree
		return root.countObjects(); 
	}
	public void guess(Scanner in){ //start the game for the tree
		System.out.println(); 
		System.out.println("Think of an object!"); //prompt user for an object
		DecisionNode newNode = this.root.guess(in); //Create a newNode by starting the game from the root
		this.root =  newNode; //set the new node with new information as the new root
	}

	public void write(FileWriter out) throws IOException{ //write out the tree information
		root.write(out); 
	}
}
