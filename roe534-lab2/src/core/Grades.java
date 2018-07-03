package core;
import java.util.*;

/**
 * Grades.java will calculate the average, median, maximum, and minimum for each persons
 * grades and will return them, it will also return there name and how many grades
 * they have.
 * 
 * @Katelyn Schmeisser
 * 
 */
public class Grades 
{
	private int[] grades;
	private String studentName;

	public Grades(String name, int[] gradesArray) 
	{
		grades = gradesArray;
		studentName = name;
	}

	
	public String getName() 
	{
		//return students name
		String name = studentName;
		return name;
	}

	
	public int length() 
	{
		//return how many grades there are
		int length;
		length = grades.length;
		return length;
	}

	
	public double average() 
	{
		int total = 0;
		int index = 0;
		
		//while loop to get a grade at a certain index
		// and add them together
		while (index < grades.length) 
		{
			int grade = grades[index];
			total += grade;
			index++;
		}

		//returns average of grades for one person at a time
		return (double) total / grades.length;
	}

	
	public double median() 
	{
		//Will try and find the middle number by diving the length in half
		// and trying to find where the median is
		int length = grades.length;
		Arrays.sort(grades);
		int index = length / 2;
		double median;
		
		if (length % 2 != 0) 
		{
			median = grades[index];
		} 
		else 
		{
			median = grades[index - 1];
			median = grades[index] + median;
			median = median / 2;
		}
		return median;
	}

	
	public int maximum() 
	{
		int highGrade = grades[0];

		//Using enhanced for loop to go through each grade and find which one
		// is the highest
		for (int grade : grades) 
		{
			//If current grade is higher than higher grade, replace
			if (grade > highGrade)
			{
				highGrade = grade;
			}
		}

		return highGrade;
	}

	
	public int minimum() 
	{
		int lowGrade = grades[0];

		//Using enhanced for loop to go through each grade and find which one
		// is the lowest
		for (int index = 0; index < grades.length; index++) 
		{
			int grade = grades[index];
			
			if (grade < lowGrade)
			{
				lowGrade = grade;
			}
		}
		return lowGrade;
	}
	
	
	public String toString() 
	{
		return studentName + " " + Arrays.toString(grades);
	}

}//END Grades.java
