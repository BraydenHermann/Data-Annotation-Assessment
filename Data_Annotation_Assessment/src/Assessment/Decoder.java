package Assessment;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Decoder
{
	public String decode(String message_file)
	{
		// store values and their words in a list
		Map<Integer, String> list = new HashMap<>();
		
		// pull the values and words from the message and add them to a list
		Scanner scanner = new Scanner(message_file);
		
		while (scanner.hasNextInt())
		{
			list.put(scanner.nextInt(), scanner.next());
		}
		
		// arrange the list in a pyramid
		String pyramid = "", message = "", output = "";
		
		int rows = list.size() / 2;
		int count = 1; // counter to prevent the rows from starting from the same number
			
		// loop to run for all rows
		for (int r = 1; r <= rows; r++)
		{
			// loop to print spaces
            for (int s = 1; s <= rows - r; s++)
            {
                pyramid += " "; // add spaces to the pyramid shape
            }
            
            // loop to print numbers
            for (int j = 1; j <= r; j++)
            {
                //pyramid += count + " "; // add values to the pyramid shape
                
                // if the number is a triangular number (meaning the last number in the row)
                if (isTriangular(count))
                {
                	// display decoded message
                	message += list.get(count) + " ";
                }
                
                count++;
            }
            
            pyramid += "\n"; // append row to the pyramid shape
        }
		
		// append outputs
		output += pyramid;
		output += message;
		
		return output;
	}
	
	// sourced at https://stackoverflow.com/questions/17493483/test-if-inputted-number-is-a-triangular-number
	public static boolean isTriangular(int number)
	{
	    double val = (Math.sqrt(8 * number + 1) - 1) / 2;
	    return val % 1 == 0;
	}
}
