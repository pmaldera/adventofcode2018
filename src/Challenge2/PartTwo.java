package Challenge2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PartTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./inputs/input2.txt");
		ArrayList<String> list = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}

			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size() - 1; j++) {
					String l1 = list.get(i);
					String l2 = list.get(j);
					StringBuilder l3 = new StringBuilder(l2);
					String l4;
					for (int x = 0; x < l1.length(); x++) {
						if (l1.charAt(x) == l2.charAt(x)) {
							l3.setCharAt(x, '0');
						}
					}

					l4 = l3.toString().replace("0", "");
					if (l4.length() == 1) {

						System.out.println(l2.replace(l4, ""));
						break;
					}
				}
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
