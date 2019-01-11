package Challenge3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./inputs/input3.txt");
		int sum = 0;
		int[][] fabric = new int[1000][1000];
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" ");
				String[] directions = tokens[2].split(",");
				String[] size = tokens[3].split("x");
				int left = Integer.parseInt(directions[0]);
				int top = Integer.parseInt(directions[1].replaceAll(":", ""));
				int width = Integer.parseInt(size[0]);
				int height = Integer.parseInt(size[1]);
				for (int x = left; x < (left + width); x++) {
					for (int y = top; y < (top + height); y++) {
						fabric[x][y]++;
					}
				}

			}

			for (int x = 0; x < 1000; x++) {
				for (int y = 0; y < 1000; y++) {
					if (fabric[x][y] > 1)
						sum++;
				}
			}
			System.out.println(sum);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
