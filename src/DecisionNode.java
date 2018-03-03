import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface DecisionNode { //Interface for QuestionNode and GuessNode
	public int countObjects(); //return the number of GuessNode from a given node
	public DecisionNode guess(Scanner in); //initiate the 'guess' process from this node
	public void write(FileWriter out) throws IOException; //write out the current node to output file
}
