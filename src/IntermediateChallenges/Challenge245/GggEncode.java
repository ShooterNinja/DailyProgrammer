/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3x3hqa/20151216_challenge_245_intermediate_ggggggg_gggg/
 * NO BONUS
 * NOTE: ONLY WORKS WITH ONE LINE INPUTS
 */

package IntermediateChallenges.Challenge245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GggEncode
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Map<String,String> keyInput = new HashMap<>();

		System.out.println("Enter the message that will be encoded. Type END to stop.");

		while(input.hasNextLine())
		{
			String line = input.nextLine();

			if(line.equals("END"))
				break;

			encodeMessage(keyInput, line);
		}

		input.close();
	}

	public static void generateKey(Map<String, String> keyInput, String str)
	{
		String s = str.replaceAll("[\\W^_]","");

		// Get the number of unique letters in the original message and keep track of the letters
		int numLetters = 0;
		ArrayList<Character> uniqueLetters = new ArrayList<>();
		for(int i = 0; i < s.length(); i++)
		{
			if(!uniqueLetters.contains(s.charAt(i)))
			{
				numLetters++;
				uniqueLetters.add(s.charAt(i));
			}
		}

		// Generate a length of g's based on the log of unique letters with a minimum length of 3
		int codeLength = ((int)(Math.log(numLetters)) < 3) ? 3 : (int)(Math.log(numLetters));

		// Generate the key
		for(int j = 0; j < uniqueLetters.size(); j++)
		{
			String code = "";
			while(code.length() < codeLength)
			{
				String upperLowerG = Math.random() < 0.5 ? "g" : "G"; // Randomly determine if uppercase or lowercase
				code += upperLowerG;

				// Make sure each letter has a unique code
				if(keyInput.containsValue(code))
					code = "";
			}
			keyInput.put(uniqueLetters.get(j).toString(), code);
		}

		// Print the key
		for(Map.Entry entry : keyInput.entrySet())
		{
			System.out.print(entry.getKey() + " " + entry.getValue() + " ");
		}
	}

	public static void encodeMessage(Map<String, String> keyInput, String str)
	{
		generateKey(keyInput,str);

		// Generate the encoded message
		String msg = "\n";
		for(int k = 0; k < str.length(); k++)
		{
			if(Character.isLetter(str.charAt(k)))
			{
				msg += keyInput.get(Character.toString(str.charAt(k)));
			}
			else
				msg += str.charAt(k);
		}

		System.out.println(msg);
	}
}
