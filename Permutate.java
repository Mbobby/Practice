import java.util.Scanner;
import java.util.ArrayList;
public class Permutate
{
	public static void main(String [] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string to Permutate: ");
		String string = input.nextLine();
		ArrayList<String> list = computePermutation(string, new ArrayList<String>());
		System.out.println();
		System.out.printf("The number of permutation generated for %s is %d\n" , string, list.size());
		System.out.println("Would you like to view the permutations? ");
		if(input.nextLine().toLowerCase().equals("yes"))
		{
			for(int i = 0; i < list.size(); i++)
			{
				System.out.println(list.get(i));
			}
		}
	}

	private static ArrayList<String> computePermutation(String string, ArrayList<String> list)
	{
		if (string.length() == 0)
		{
			return list;
		}

		if(list.isEmpty())
		{
			list.add(string.substring(0, 1));
			string = string.substring(1, string.length());
			return computePermutation(string, list);
		}
		else
		{
			ArrayList<String> newList = new ArrayList<String>();
			String listItem = "";
			String currentChar = string.substring(0, 1);
			string = string.substring(1, string.length());
			String newString = "";
			for(int i = 0; i < list.size(); i++)
			{
				listItem = list.get(i);
				for(int j = 0; j <= listItem.length(); j++)
				{
					newString = listItem.substring(0, j) + currentChar + listItem.substring(j, listItem.length());
					newList.add(newString);
				}
			}
			return computePermutation(string, newList);
		}

	}
} 