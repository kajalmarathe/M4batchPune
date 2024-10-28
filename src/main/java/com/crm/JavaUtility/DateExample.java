package com.crm.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample 
{
    
    // Method 1: Returning date in yyyy-MM-dd format
    public static String dates(int day) {
        // Get the current date using Calendar
        Calendar cal = Calendar.getInstance();
        // Add the specified number of days
        cal.add(Calendar.DAY_OF_MONTH, day);
        
        // Create a SimpleDateFormat to format the date in yyyy-MM-dd pattern
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        // Format and return the date
        return sim.format(cal.getTime());  // getTime() returns a Date object
    }

    // Method 2: Returning date in a custom format
    public static String date1(String format, int day) {
        // Get the current date using Calendar
        Calendar cal = Calendar.getInstance();
        // Add the specified number of days
        cal.add(Calendar.DAY_OF_MONTH, day);
        
        // Create a SimpleDateFormat with the user-specified format
        SimpleDateFormat sim = new SimpleDateFormat(format);
        // Format and return the date
        return sim.format(cal.getTime());
    }

   
}




/* public static void main(String[] args) {
// Call the methods
String futureDate = dates(5);
System.out.println("Future date (yyyy-MM-dd): " + futureDate);

String customDate = date1("dd-MM-yyyy", 5);
System.out.println("Custom future date (dd-MM-yyyy): " + customDate);
}*/