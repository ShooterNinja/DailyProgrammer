/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3x3hqa/20151216_challenge_245_intermediate_ggggggg_gggg/
 */

package IntermediateChallenges.Challenge245;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GggDecode
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Map<String,String> keyInput = new HashMap<>();

		System.out.println("Enter the key in the first line. Then enter the message to be decoded. Type NEW KEY " +
				"to enter a new key. Type END to stop.");

		// Add the decoding key to a Map so that every letter is associated with a code
		String str = input.nextLine();
		readKey(keyInput, str);

		while(input.hasNextLine())
		{
			String line = input.nextLine();

			if(line.equals("END"))
				break;

			if(line.equals("NEW KEY"))
			{
				System.out.println("Enter a new key");
				readKey(keyInput, input.nextLine());
			}
			else
				System.out.println(decodeMessage(keyInput, line)); // Print the decoded message
		}

		input.close();
	}

	public static void readKey(Map<String,String> keyInput, String str)
	{
		keyInput.clear();
		String[] keyLine = str.split(" ");
		for(int i = 0; i < keyLine.length-1; i+=2)
		{
			String letter = keyLine[i];
			String code = keyLine[i+1];
			keyInput.put(code, letter);
		}
	}

	public static String decodeMessage(Map<String,String> keyInput, String str)
	{
		int count = 0;
		String checking = "";
		String msg = "";
		while(count < str.length())
		{
			if(str.substring(count,count+1).equalsIgnoreCase("g")) // Check if the character is a g
			{
				checking += str.substring(count, count + 1); // Add the character to the string being checked
				if (keyInput.containsKey(checking)) // Check to see if the string being checked was given in the key
				{
					msg += keyInput.get(checking); // Append to the decoded message string
					checking = ""; // Clear the string
				}
				count++;
			}
			else // If the character is not a g, just append it to the decoded message string
			{
				msg += str.substring(count,count+1);
				count++;
			}
		}
		return msg;
	}

}
