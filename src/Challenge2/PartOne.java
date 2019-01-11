package Challenge2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class PartOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./inputs/input2.txt");
		int length;
		char[] chars = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		int[] count = new int[] { 0, 0 };
		Stack<Integer> stack;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				stack = new Stack<Integer>();
				length = line.length();
				for (char c : chars) {
					line = line.replace(c + "", "");
					int amount = (length - line.length());
					length = line.length();
					if (amount >= 2 && amount <= 3 && stack.search(amount) == -1)
						stack.push(amount);
				}
				while (stack.empty() != true) {
					int pop = stack.pop();
					count[pop - 2]++;
				}

			}
			System.out.println(count[0] * count[1]);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
