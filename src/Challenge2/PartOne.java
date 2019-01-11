package Challenge2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PartOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./inputs/input1.txt");
		int sum = 0;
		int length;
		char[] chars = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
			for(char c : chars)
			{
				map.put(c, 0);
			}
		    while ((line = br.readLine()) != null) {
		    	length = line.length();
		       for(char c : chars)
				{
					map.put(c, (line.length() - length));
					line.replace(c+"", "");

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
