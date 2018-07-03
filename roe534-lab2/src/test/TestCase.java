package test;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import core.Grades;

/**
 * TestCase.java is a JUnit test class to run through each method and
 * gives output for the amount of errors, failures, and runs
 * 
 * @author Katelyn Schmeisser
 *
 */
public class TestCase
{
	/**
	 * Will use a 5 element array and test to see if the output for
	 * grade averages is correct
	 */
	@Test
	public void testAverage()
	{
		int[] grades = { 50, 60, 70, 80, 90 };
		Grades gradeObject = new Grades("test", grades);
		double average = 0;
		for (int grade : grades)
		{
			average += grade;
		}
		average /= grades.length;
		assertEquals("5 element test failed", average, gradeObject.average(), 0.000001);
	}

	
	/**
	 * Will use a 5 element array and test to see if the output for
	 * grade median is correct
	 */	
	@Test
	public void testMedian()
	{
		// Will try and find the middle number by diving the length in half
		// and trying to find where the median is
		int[] grades = { 50, 60, 70, 80, 90 };
		Grades gradeObject = new Grades("test", grades);
		
		int length = grades.length;
		Arrays.sort(grades);
		int index = length / 2;
		double median;

		if (length % 2 != 0)
		{
			median = grades[index];
		} else
		{
			median = grades[index - 1];
			median = grades[index] + median;
			median = median / 2;
		}
		assertEquals("5 element test failed", median, gradeObject.median(), 0.000001);
	}

	
	/**
	 * Will use a 5 element array and test to see if the output for
	 * grade minimum is correct
	 */	
	@Test
	public void testMinimum()
	{
		int[] grades = { 50, 60, 70, 80, 90 };
		Grades gradeObject = new Grades("test", grades);
		int lowGrade = grades[0];

		for (int index = 0; index < grades.length; index++)
		{
			int grade = grades[index];

			if (grade < lowGrade)
			{
				lowGrade = grade;
			}
		}
		assertEquals("5 element test failed", lowGrade, gradeObject.minimum(), 0.000001);
	}
	
	
	/**
	 * Will use a null array to catch nullPointerExceptions 
	 * in the average method
	 */
	@Test
    public void testAverageNull() 
	{
        Grades gradeObject = new Grades("test", null);
        boolean nullError = false;
        try 
        {
            gradeObject.average();
        }
        catch (NullPointerException e) 
        {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
	
	/**
	 * Will use a null array to catch nullPointerExceptions 
	 * in the median method
	 */
	@Test
    public void testMedianNull() 
	{
        Grades gradeObject = new Grades("test", null);
        boolean nullError = false;
        try 
        {
            gradeObject.median();
        }
        catch (NullPointerException e) 
        {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
	
	/**
	 * Will use a null array to catch nullPointerExceptions 
	 * in the minimum method
	 */
	@Test
    public void testMinimumNull() 
	{
        Grades gradeObject = new Grades("test", null);
        boolean nullError = false;
        try 
        {
            gradeObject.minimum();
        }
        catch (NullPointerException e) 
        {
            nullError = true;
        }
        assertTrue("should be a NullPointerException", nullError);
    }
	
}//END TestCase
