package com.crm.JavaUtility;
import java.util.Random;

public class Random_Number 
{
	public static int random_num()
	{
		 Random random = new Random();
	     int randomIntInRange = random.nextInt(1000); // 0 to 999
	    return randomIntInRange;
	}

}


