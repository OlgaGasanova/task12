package findLinesAndPoints;

import java.util.ArrayList;
import java.util.Scanner;
import lineAndPoints.Point;

public class FillPointsArray {
	
	private static final String ENTER_POINTS_COORDINATE = "������� ���������� ����� � ������� '� �'";
	private static final String ENTER_COUNT_OF_POINTS = "������� ���������� ����� ��� �������";

	private static ArrayList <Point> pointsArray = new ArrayList <Point> ();
	
	public static ArrayList <Point> getPointsArray(){
		return pointsArray;
	}
	
	//���������� ������������ ����� �� ���������
	public void fillPointsArray(){
		System.out.println(ENTER_COUNT_OF_POINTS);
		Scanner in = new Scanner(System.in);
		int count = 0;
		if (in.hasNextInt()){
			count = in.nextInt();
		}
		
		System.out.println(ENTER_POINTS_COORDINATE);
		for (int i = 0; i < count; i ++){
			float x = in.nextFloat(); 
			float y = in.nextFloat();
			pointsArray.add(new Point(x, y));
		}
		in.close();
	}
}
