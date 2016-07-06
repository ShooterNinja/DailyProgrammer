/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3twuwf/20151123_challenge_242_easy_funny_plant/
 */

package EasyChallenges.Challenge242;

import java.util.ArrayList;
import java.util.Scanner;

public class FunnyPlant
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> results = new ArrayList<>();

		while(input.hasNextLine())
		{
			// VARIABLES
			int week = 1;
			int currentFruits = 0;
			int previousFruits;
			int numPeople;

			String inputLines = input.nextLine();

			// STOP CONDITION
			if(inputLines.equals("STOP"))
				break;

			// GET THE INPUT DATA
			String[] nums = inputLines.split(" ");
			numPeople = Integer.valueOf(nums[0]);
			previousFruits = Integer.valueOf(nums[1]);

			// KEEP LOOPING UNTIL THE TOTAL FRUITS IS EQUAL TO OR GREATER THAN THE NUMBER OF PEOPLE
			while(currentFruits < numPeople)
			{
				currentFruits += previousFruits;
				previousFruits += currentFruits;
				week++;
			}

			results.add(week);
		}

		// PRINT THE RESULTS
		for(int result : results)
			System.out.println(result);

		input.close();
	}
}
