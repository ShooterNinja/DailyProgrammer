/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3kx6oh/20150914_challenge_232_easy_palindromes/
 */

package EasyChallenges.Challenge232;

import java.util.Scanner;

public class Palindromes
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of lines to read in the first line. Then enter the phrase to be checked.");

		while(input.hasNextInt())
		{
			int linesToRead = Integer.parseInt(input.nextLine());
			int count = 0;
			String line = "";
			while (input.hasNextLine() && count != linesToRead)
			{
				line += input.nextLine().replaceAll("\\W", "").toLowerCase();
				count++;

				if(count == linesToRead)
				{
					if (isPalindrome(line))
						System.out.println("Palindrome");
					else
						System.out.println("Not a palindrome");
				}
			}
		}
		input.close();
	}

	public static boolean isPalindrome(String str)
	{
		StringBuilder reverseStr = new StringBuilder(str).reverse();
		return reverseStr.toString().equals(str);
	}
}
