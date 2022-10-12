//Name:Progga Paromita Dutta
// Id No: 114751436
import java.io.PrintStream;

/**
 * This class contains information about a particular audio file
 * @author Progga Paromita Dutta
 *
 */
public class SongRecord{

 //Instance variables to store data for a particular audio file
   private String title;
   private String artist;
   private int minutes;
   private  int seconds;
   //This is a default constructor to create a SongRecord object
 public SongRecord() {
	 title=null;
	 artist=null;
	 minutes=0;
	 seconds=0;
 }
 public Object clone()throws CloneNotSupportedException{  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
/**
 * @return the title of the audio file
 */
   
   
public String getTitle() {
	return title;
}
/**
 * @return the name of the artist of the audio file
 */
public String getArtist() {
	return artist;
}
/**
 * @return the length in minutes of the audio file
 */
public int getMinutes() {
	return minutes;
}
/**
 * @return the length of the audio file in seconds
 */
public  int getSeconds() {
	return seconds;
}
/**
 * This is a setter method which set the title of a particular audio file
 * @param title-the title that is to be set
 */
public void setTitle(String title)
{
	this.title=title;
}
/**
 * This is a setter method which set the name of the artist of a particular audio file
 * @param artist-the name of the artist to be set
 */
public void setArtist(String artist)
{
	this.artist=artist;
}
/**
 * This is a setter method which set the length in seconds of a particular audio file
 * @param seonds-the length in seconds to be set
 */
public void setSeconds(int seconds)
{
	//check if the seconds is less than 0 or greater than 59
	if(seconds<0 || seconds>59)
		throw new ArithmeticException("Invalid song length");
	else
	{
		this.seconds=seconds;
	}
}


/**
 * This is a setter method which set the length of a particular audio file in minutes
 * @param minutes-the length of the audio file in minutes to be set
 * @exception ArithmeticException when the user input of minutes is negative
 */
public void setMinutes(int minutes)
{
	//check if the input minutes is negative or not
  if(minutes<0)
	  throw new ArithmeticException("........");//throw exception
  else
  {
	  this.minutes=minutes;
  }
}
/**
 * This is a method which prints a detailed information about a specific audio file 
 * @return the audio file specification
 */
public String toString()
{
	System.out.println(String.format("%s %-21s %26s %26s","#Songs","Title","Artist","Length"));
	System.out.println("---------------------------------------------------------------------------------");
	String s=String.format("%-21s % 26s % 26d %s",getTitle(),getArtist(),getMinutes(),(getSeconds()));
	return s;
	
	

}
}