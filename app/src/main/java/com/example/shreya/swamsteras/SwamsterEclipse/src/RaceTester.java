import java.util.ArrayList;
import java.util.Arrays;

public class RaceTester 
{
	public static void main(String [] args) 
	{
		Race fly50 = new Race("15 & over 50 meter Butterly", 9, 4, 0);
		Race free50 = new Race("15 & over 50 meter Freestyle", 12, 2, 0);
		Race free200 = new Race("15 & over 200 meter Freestyle", 3, 5, 0);
		
		ArrayList<Race> races = new ArrayList<Race>();
		races.add(fly50);
		races.add(free50);
		races.add(free200);
		
		System.out.println(Arrays.toString(races.toArray()).replace(",", "").replace("[", "").replace("]", ""));
	}
}
