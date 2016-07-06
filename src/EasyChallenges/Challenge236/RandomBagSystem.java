/**
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3ofsyb/20151012_challenge_236_easy_random_bag_system/
 */

package EasyChallenges.Challenge236;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomBagSystem
{
	public static void main(String[] args)
	{
		// The pieces
		List<String> pieces = Arrays.asList("O", "I", "S", "Z", "L", "J", "T");
		List<String> tmp = new ArrayList<>();

		// Output
		String output = "";
		for(int i = 0; i < 50; i++)
		{
			// Randomly select a piece
			int current = (int)(Math.random() * 7);

			if(tmp.size() == 7)
				tmp.clear();

			// Make sure piece was not already selected
			while(tmp.contains(pieces.get(current)))
				current = (int)(Math.random() * 7);

			output += pieces.get(current);
			tmp.add(pieces.get(current)); // Keep track of pieces that have already been selected
		}
		System.out.println(output);
	}
}
