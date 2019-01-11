package Challenge3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class PartTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./inputs/input3.txt");
		Stack<Integer> wrong = new Stack<Integer>();
		String[][] fabric = new String[1000][1000];
		for (String[] arr : fabric) {
			Arrays.fill(arr, "");
		}
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int id = -1;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" ");
				String[] directions = tokens[2].split(",");
				String[] size = tokens[3].split("x");
				id = Integer.parseInt(tokens[0].replace("#", ""));
				int left = Integer.parseInt(directions[0]);
				int top = Integer.parseInt(directions[1].replaceAll(":", ""));
				int width = Integer.parseInt(size[0]);
				int height = Integer.parseInt(size[1]);
				for (int x = left; x < (left + width); x++) {
					for (int y = top; y < (top + height); y++) {
						fabric[x][y] = fabric[x][y] + "a" + id;
					}
				}

			}

			for (int x = 0; x < 1000; x++) {
				for (int y = 0; y < 1000; y++) {
					if (fabric[x][y] != null) {
						String[] arr = fabric[x][y].split("a");
						if (arr.length > 2) {
							for (String s : arr) {
								if (!s.equals("")) {
									wrong.push(Integer.parseInt(s));
								}
							}
						}
					}
				}
			}

			for (int i = 1; i < id; i++) {
				if (!wrong.contains(i))
					System.out.println(i);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
