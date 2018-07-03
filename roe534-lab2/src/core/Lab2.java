package core;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Lab2.java will input the data from a text file into an array so that Grades.java can
 * manipulate the data
 * 
 * @Katelyn Schmeisser
 *
 */
public class Lab2 {

	/**
	 * @param args
	 * In the main data.txt will open and scanner will take each token and place it inside
	 * an array. Once done, the length of each persons grades are calculated and a call to
	 * Grades.java is made to create a grade object.
	 * Lastly all the info will be printed with the method testGrades and then data.txt
	 * is closed.
	 */
	public static void main(String[] args) 
	{
		Grades[] gradesArray = new Grades[4];
		ArrayList<Integer> gradeList = new ArrayList<Integer>();

		String name;
		int counter = 0;
		int[] grades = new int[1];
		int i = 0;
		Scanner in = null;
		
		//Open data.txt
		try 
		{
			in = new Scanner(new File("data.txt"));
		} 
		//If file not found throw error
		catch (FileNotFoundException exception) 
		{
			System.err.println("failed to open data.txt");
			System.exit(1);
		}
		
		//Start reading tokens
		while (in.hasNext()) 
		{
			name = in.next();

			while (in.hasNextInt()) 
			{
				int grade = in.nextInt();

				//Add tokens to array
				gradeList.add(grade);
				counter++;
			}

			//New grades array with correct length for each persons grades
			grades = new int[gradeList.size()];
			
			//for loop to input grades from gradeList into grades
			for (int index = 0; index < gradeList.size(); index++) 
			{
				grades[index] = gradeList.get(index);
			}

			//Create Grades object for each person
			gradesArray[i] = new Grades(name, grades);
			gradeList.clear();

			i++;
		}
		
		//Prints each persons name with there grades and information
		testGrades(gradesArray[0]);
		testGrades(gradesArray[1]);
		testGrades(gradesArray[2]);
		testGrades(gradesArray[3]);
		
		//Close file
		in.close();
		
	}//END main()

	
	/**
	 * Simple method to print out the information in the array
	 */
	public static void testGrades(Grades grades) 
	{
		System.out.println(grades.toString());
		System.out.printf("\tName:    %s\n", grades.getName());
		System.out.printf("\tLength:  %d\n", grades.length());
		System.out.printf("\tAverage: %.2f\n", grades.average());
		System.out.printf("\tMedian:  %.1f\n", grades.median());
		System.out.printf("\tMaximum: %d\n", grades.maximum());
		System.out.printf("\tMininum: %d\n", grades.minimum());
	}

}//END Lab2.java
