/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3h9pde/20150817_challenge_228_easy_letters_in/
 */

package EasyChallenges.Challenge228;

import java.util.Scanner;

public class AlphabeticalOrder
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		while (input.hasNextLine())
		{
			String word = input.nextLine();
			if (isAlphabetical(word))
				System.out.println(word + " IN ORDER");
			else if (isReverseAlphabetical(word))
				System.out.println(word + " IN REVERSE ORDER");
			else
				System.out.println(word + " NOT IN ORDER");
		}
		input.close();
	}

	public static boolean isAlphabetical(String str)
	{
		for (int i = 0; i < str.length() - 2; i++)
		{
			if (str.substring(i, i + 1).compareToIgnoreCase(str.substring(i + 1, i + 2)) > 0)
				return false;
		}
		return true;
	}

	public static boolean isReverseAlphabetical(String str)
	{
		for (int i = 0; i < str.length() - 2; i++)
		{
			if (str.substring(i, i + 1).compareToIgnoreCase(str.substring(i + 1, i + 2)) < 0)
				return false;
		}
		return true;
	}
}
