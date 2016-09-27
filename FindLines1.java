package findLinesAndPoints;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lineAndPoints.Line;

public class FindLines {
 
	private static final String POINTS = " точки";
	private static final String PASS_THROUGH = " проходит через ";
	private static final double ERROR = 0.001;
	private static final String FILE_NAME = "/lines.txt";
	private static final String RESULT = "–езультат работы записан в файл ";

	private Map <Line, Integer> linesMap = new HashMap <Line, Integer> ();
	
	//нахождение неповтор€ющихс€ коэффициентов уравнений пр€мых
	public void findLines(){
		float x1;
		float x2;
		float y1;
		float y2;
		float a;
		float b;
		for (int i = 0; i < FillPointsArray.getPointsArray().size(); i ++){
			x1 = FillPointsArray.getPointsArray().get(i).getX();
			y1 = FillPointsArray.getPointsArray().get(i).getY();
			for (int j = i + 1; j < FillPointsArray.getPointsArray().size(); j ++){
				x2 = FillPointsArray.getPointsArray().get(j).getX();
				y2 = FillPointsArray.getPointsArray().get(j).getY();
				a = (y2 - y1) / (x2 - x1);
				b = (y1 * x2 - y2 * x1) / (x2 - x1);
				linesMap.put(new Line(a, b), 0);
			}
		}
	}
		
	//нахождение количества точек на каждой пр€мой
	public void findCountOfPoints(){
		for (Map.Entry<Line, Integer> entry: linesMap.entrySet()){
			float a = entry.getKey().getA();
			float b = entry.getKey().getB();
			float x;
			float y;
			int count;	
			for (int i = 0; i < FillPointsArray.getPointsArray().size(); i ++){
				x = FillPointsArray.getPointsArray().get(i).getX();
				y = FillPointsArray.getPointsArray().get(i).getY();
				if (Math.abs(y - (a * x + b)) <= ERROR){
					count = entry.getValue();
					entry.setValue(count + 1);
				}
			}
		}
	}
	
	//вывод результатов в файл
	public void printLinesInFile() throws IOException{
		findLines();
		findCountOfPoints();
		try {
			String path=System.getProperty("user.dir");
			String filePath = path + FILE_NAME;
			BufferedWriter writer = new BufferedWriter (new FileWriter(filePath));
			for(Map.Entry<Line, Integer> entry: linesMap.entrySet()){
				writer.write(entry.getKey().toString() + PASS_THROUGH + entry.getValue() + POINTS);
				writer.newLine();
			}
			System.out.println(RESULT + filePath);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
