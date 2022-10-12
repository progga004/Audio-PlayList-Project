//Name: Progga Paromita Dutta
// Id no: 114751436
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
/**
 * This class contains the information about all SongRecord objects that belongs to a particular audio file
 * @author Progga Paromita Dutta
 */

public class Playlist extends SongRecord implements Cloneable{// Class Playlist derived from Song Record and implements Cloneable interface
	//Declaring an array of objects for class SongRecord 
	SongRecord[]sr;
	private int currentSize;
	//Declaring a variable for the maximum number of storing SongRecord objects
	final int maximum;

	//This is a no argument constructor to create array of objects
public Playlist()
{
	maximum=50;
	sr=new SongRecord[maximum];//allocates the memory size to maximum
	currentSize=0;//assigns current size to zero
}
/**This clone method is used to make a copy of SongRecord objects
 * @exception CloneNotSupportedException when the user doesn't implement a cloneable interface
 * @return the copied object
 */
public Object clone()throws CloneNotSupportedException
{
	SongRecord []cloneSong=new SongRecord[maximum];
	for(int i=0;i<maximum;i++)
	{
		cloneSong[i]=(SongRecord)sr[i].clone();//copying the objects into cloneSong array of objects
		
	}
	return cloneSong;
	
}
/**
 * This method is used to compare two compare two audio files
 * @param obj-Object type to refer to the given audio file object
 * @return whether the two comparable audio files are same or not
 */
public boolean equals(Object obj)
{
	//check if the given audio file is null or both of the audio files belong to the same class or not
	if(obj==null|| this.getClass()!=obj.getClass())
	{
		return false;
	}
	//check both of their title,artist and duration time
	else 
	{
	   SongRecord cr=(SongRecord)obj;
	   return cr.getTitle().equals(this.getTitle())&& cr.getArtist().equals(this.getArtist())&&cr.getMinutes()==this.getMinutes()&&cr.getSeconds()==this.getSeconds(); 
				
			}}
/**
 * This method implements how many audio files are there in Playlist
 * @return the current size of the Playlist
 */
public int size()
{
	return currentSize;
}
/**
 * This method add an audio file to the Playlist
 * @param song the song with its properties to be added
 * @param position the position where the song will be inserted
 * @throws FullPlaylistException when the user input will be out of the bounds from the maximum size of the Playlist
 */

public void addSong(SongRecord song, int position)throws FullPlaylistException
{
	try {
	//check the position
	   if(position<1 ||position>currentSize+1)
	{
		throw new IllegalArgumentException("Invalid position for adding the new song");//throw exception
	}
	}
	catch(IllegalArgumentException e)
	{
		System.out.print(e.getMessage());
		System.out.println();
	}
	//check whether the playlist is full or not
	try {
	   if(currentSize==maximum)
	{
		throw new FullPlaylistException("The playlist is full");
	}}
	catch(FullPlaylistException e)
	{
		System.out.print(e.getMessage());
		System.out.println();
	}
	if(position>=1 && position<=currentSize+1 && currentSize!=maximum){
		for(int i=currentSize;i>=position;i--)
	
	{
			
		sr[i]=sr[i-1];// Shifts the object to one position right
	}
		
	sr[position-1]=song;// Insert the new song object to the specified position
	currentSize++;
	
	}
	
}
/**
 * This method removes a particular audio file from the Playlist in a particular position
 * @param position the position where the song will be removed
 * @throws IllegalArgumentException when the position is not within current size of the Playlist
 */
public void removeSong(int position)throws IllegalArgumentException
{
	// check the position
	try {
	  if(position<1||position>currentSize)
	{
		throw new IllegalArgumentException("No song at positions "+position+" to remove");//throw exception
		
	}}
	catch(IllegalArgumentException e){
		System.out.print(e.getMessage());
		System.out.println();
		
	}
	if(position>=1 && position<=currentSize) {
		for(int i=position;i<=currentSize;i++)
	
	{
		sr[i-1]=sr[i];//shift the object to one position left
	}
	     currentSize--;
	     System.out.println("Song Removed at position "+position);
	
}}
/**
 * This method get the particular audio file in a specific position
 * @param position the position where the audio file will be shown
 * @return the audio file with its properties
 */
public SongRecord getSong(int position)
{
	SongRecord c=new SongRecord();// declaring an object
	c.setTitle(sr[position-1].getTitle());
	c.setArtist(sr[position-1].getArtist());
	c.setMinutes(sr[position-1].getMinutes());
	c.setSeconds(sr[position-1].getSeconds());
	return c;}


// this method prints the songs in a tabulated form
public void printAllSongs() {
	System.out.println(String.format("%-21s%-21s%-26s%24s","#Songs","Title","Artist","Length"));
	System.out.println("------------------------------------------------------------------------------------------------------");
	for(int i=1;i<=currentSize;i++)
	{
		System.out.format("%-21d%-21s%-35s%10d:%02d",i,sr[i-1].getTitle(),sr[i-1].getArtist(),sr[i-1].getMinutes(),sr[i-1].getSeconds());
	    System.out.println();
		}
		   
		}
	

/**
 * This method is implemented to show the audio files by a specific artist
 * @param originalList where all the audio files are stored with its particular properties
 * @param artist which is the user input to be given, an artist's name
 * @throws FullPlaylistException when the Playlist is full
 * @return the audio files which is only by the particular artist
 */
public static Playlist getSongsByArtist(Playlist originalList, String artist)throws FullPlaylistException {
	Playlist answer=new Playlist();
	
    SongRecord c=new SongRecord();
	System.out.println(String.format("%-21s%-21s%-26s%24s","#Songs","Title","Artist","Length"));
	System.out.println("------------------------------------------------------------------------------------------------------");
	int count =0;
	//check whether the playlist is empty or not
	if(originalList==null||artist==null)
	{
		return null;
	}
	for(int i=1;i<originalList.currentSize;i++)
	{
			//check the equality between two artists
		if(originalList.getSong(i).getArtist().equals(artist))
		{ System.out.println(originalList.getSong(i).getArtist());
		 
		   answer.addSong(originalList.getSong(i), i);}
		 //System.out.println("First"+answer.currentSize);
		  answer.printAllSongs();
		   }
		System.out.println("First"+answer.currentSize);
	
		
	return answer;}
	
/** 
 * This method provides an option to play the music
 * @param location the path where the audiofile is located
 */
public void playMusic(String location)
{
  try {
		File path=new File(location);//allocating the location of file to path instance
		if(path.exists() )// do the path exists?
		{
			AudioInputStream audioInput=AudioSystem.getAudioInputStream(path);
			Clip clip=AudioSystem.getClip();
			clip.open(audioInput);// opening the audioInput of the clip
			clip.start();// starting the clip
		}
			
		else
		{
			System.out.println("Can't find file");
		}}
	
	catch(Exception e)// throws exception
	{
		e.printStackTrace();
	}
}
	
	


	

	


}

