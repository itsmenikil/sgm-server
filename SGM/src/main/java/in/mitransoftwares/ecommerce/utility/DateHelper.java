package in.mitransoftwares.ecommerce.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	public static Date getCurrentSystemDate(DateFormatter format) {
		long currentDateTime = System.currentTimeMillis();
		  Date currentDate = new Date(currentDateTime);
	      DateFormat df=null; 
	      Date convertFormat=null;
	      
	      	try {
	    	  if(format.equals("ddMMyyHHmmss")){
		    	   df=new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
		    	   convertFormat= df.parse(df.format(currentDate));
		       }	
			} catch (ParseException e) {
				e.printStackTrace();
			}
	       
	    return convertFormat;
	}
}
