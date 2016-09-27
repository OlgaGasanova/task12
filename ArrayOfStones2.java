package fillList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayOfStones {

	private static final String FILE_NAME = "/stones.txt";
	private static List <Stone> Stones = new ArrayList <Stone>();

	public List <Stone> getStones() {
		return Stones;
	}

	public void setStones() throws IOException {
		int i = 0;
		try {
			String path=System.getProperty("user.dir");
		    String filePath = path + FILE_NAME;
		    BufferedReader reader = new BufferedReader (new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null){
				Stones.add(new Stone(line));
				i ++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
