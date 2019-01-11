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
		File file = new File("./inputs/input1.txt");
		int sum = 0;
		boolean found = false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (found == false) {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = br.readLine()) != null) {
					sum += Integer.parseInt(line);
					if(list.contains(sum))
					{
						found = true;
						break;
					}
					else
					{
						list.add(sum);
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
		System.out.println(sum);
	}

}
