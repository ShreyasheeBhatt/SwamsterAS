import java.util.ArrayList;

public class SwimmerTester 
{
	public static void main(String [] args) 
	{
		/*
		 * user inputs would be created as variables, and the variables would be inputted as parameters into the Swimmer object and Race objects. 
		 */
		Race fly50 = new Race("15 & over 50 meter Butterly", 9, 4, 0);
		Race free50 = new Race("15 & over 50 meter Freestyle", 12, 2, 0);
		Race free200 = new Race("15 & over 200 meter Freestyle", 3, 5, 0);
		ArrayList<Race> races = new ArrayList<Race>();
		races.add(fly50);
		races.add(free50);
		races.add(free200);
		Swimmer shreya = new Swimmer("Bhatt","Shreya", 16, "Evo", races);
		Swimmer emma = new Swimmer("Kudej","Emma", 16, "Evo", races);
		System.out.println(shreya);
		System.out.println(emma);
		System.out.println("Shreya's Unique ID: " + String.valueOf(shreya.getUniqueID()));
		System.out.println("Emma's Unique ID: " + String.valueOf(emma.getUniqueID()));
	}
}
