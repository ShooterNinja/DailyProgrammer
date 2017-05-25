package EasyChallenges.Challenge283;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Patrick Lin
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/52enht/20160912_challenge_283_easy_anagram_detector/
 */
public class AnagramDetector
{
	private static boolean anagramDetector(String str1, String str2)
	{
		char[] chs1 = str1.toLowerCase().replaceAll("\\s+", "").toCharArray();
		char[] chs2 = str2.toLowerCase().replaceAll("\\s+", "").toCharArray();
		Arrays.sort(chs1);
		Arrays.sort(chs2);
		return Arrays.equals(chs1, chs2);
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine())
		{
			String line = in.nextLine();
			String[] splitLine = line.split(" \\? ");

			if(anagramDetector(splitLine[0], splitLine[1]))
				System.out.println(splitLine[0] + " is an anagram of " + splitLine[1]);
			else
				System.out.println(splitLine[0] + " is NOT an anagram of " + splitLine[1]);
		}
		in.close();
	}
}
