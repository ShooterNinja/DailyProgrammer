/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/4msu2x/challenge_270_easy_transpose_the_input_text/
 */

package EasyChallenges.Challenge270;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransposeText
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your input. When you are done, type END.");

		// List to hold every line of input
		List<String> lines = new ArrayList<>();

		// Keep track of the max length
		int max = 0;

		// Read the input
		while(input.hasNextLine())
		{
			String line = input.nextLine();

			if(line.equals("END"))
				break;

			// Find the max length
			if(line.length() > max)
				max = line.length();

			lines.add(line);
		}

		// Transpose the input
		for(int i = 0; i < max; i++)
		{
			String output = "";
			for(String s : lines)
			{
				if(i < s.length())
					output += s.charAt(i);
				else
					output += " ";
			}
			System.out.println(output);
		}

		input.close();
	}
}
