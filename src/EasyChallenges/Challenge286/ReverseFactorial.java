package EasyChallenges.Challenge286;

/**
 * @author Patrick Lin
 * Instructions found here: https://www.reddit.com/r/dailyprogrammer/comments/3h9pde/20150817_challenge_228_easy_letters_in/
 * */
public class ReverseFactorial
{
	private static int reverseFactorial(int num)
	{
		int n = 2;
		while(num % n == 0)
		{
			num = num / n;
			n++;
		}

		if(num == 1)
			return n-1;
		else
			return 0;
	}

	public static void main(String[] args)
	{
		System.out.println("3628800 = " + (reverseFactorial(3628800) != 0 ? reverseFactorial(3628800) + "!" : "NONE"));
		System.out.println("479001600 = " + (reverseFactorial(479001600) != 0 ? reverseFactorial(479001600) + "!" : "NONE"));
		System.out.println("6 = " + (reverseFactorial(6) != 0 ? reverseFactorial(6) + "!" : "NONE"));
		System.out.println("18 = " + (reverseFactorial(18) != 0 ? reverseFactorial(18) : "NONE"));
	}
}
