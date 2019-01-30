package Challenge4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.text.DateFormatter;

public class PartTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("./inputs/input4.txt");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			int id = -1;
			int difference;
			String[] part;
			int[] timeTab;
			int maxAt = 0;
			Date d1 = null;
			Date d2;
			Map.Entry<Integer, Integer> maxEntry = null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			Map<Date, String> dateMap = new TreeMap<Date, String>(new Comparator<Date>() {
			    public int compare(Date date1, Date date2) {
			        return date1.compareTo(date2);
			    }
			});
			Map<Integer, Integer> sleepers = new TreeMap<Integer, Integer>();
			Map<Integer, int[]> sleepersMinutes = new TreeMap<Integer, int[]>();
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				//d2 = d1;
				part = line.split("]");
				d1 = format.parse(part[0].replace("[",""));
				dateMap.put(d1,part[1].replace(part[0], ""));
			}
			
			for (Map.Entry<Date, String> entry : dateMap.entrySet())
			{
			  	System.out.println(entry.getKey()+entry.getValue());
			    if(entry.getValue().contains("begins"))
			    {
			    	id = Integer.parseInt(entry.getValue().split("#")[1].split(" ")[0]);
			    	if(!sleepers.containsKey(id))
			    	{
			    		sleepers.put(id, 0);
			    		sleepersMinutes.put(id, new int[60]);
			    	}
			    }
			    else if(entry.getValue().contains("asleep"))
			    	d1 = entry.getKey();
			    else if(entry.getValue().contains("up"))
			    {
			    	d2 = entry.getKey();
			    	difference = (int) ((d2.getTime() - d1.getTime())/ (60 * 1000) % 60)-1; 
			    	if(sleepers.containsKey(id))
			    		sleepers.put(id, sleepers.get(id) + difference);
			    	timeTab = sleepersMinutes.get(id);
			    	System.out.println(difference);
			    	//System.out.println(d1 + " : start");
			    	for(int i = d1.getMinutes(); i<d2.getMinutes()-1; i++)
			    	{
			    		timeTab[i]++;
			    		//System.out.println(i + " : asleep");
			    	}
			    	//System.out.println(d2 + " : stop");
			    }
			}
			
			for (Map.Entry<Integer, Integer> entry : sleepers.entrySet())
			{
				System.out.println(entry.getKey()+":"+entry.getValue());
				if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
			        maxEntry = entry;
			    }
			}
			
			timeTab = sleepersMinutes.get(maxEntry.getKey());
			for (int i = 0; i < timeTab.length; i++) {
				System.out.println(i+"="+timeTab[i]);
			    maxAt = timeTab[i] >= timeTab[maxAt] ? i : maxAt;
			}
			System.out.println(maxEntry.getKey() + " : " + maxAt + " = " + timeTab[maxAt]);
			System.out.println(maxEntry.getKey() * maxAt);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
