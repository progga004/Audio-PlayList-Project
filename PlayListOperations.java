//Name:Progga Paromita Dutta
//Id: 114751436=

import java.util.Scanner;
/**
 * This is the class where all the operations on the audio files of the Playlist will be conducted
 * @author Progga Paromita Dutta
 *
 */
public class PlayListOperations {
/**
 * This is the main method which makes use of all the classes
 * @param args Unused
 * @throws FullPlaylistException on input error
 */
	public static void main(String[] args) throws FullPlaylistException {
		Playlist playList=new Playlist();//create a new Playlist object 
		Scanner input=new Scanner(System.in);
		System.out.println("A) Add Song");
		System.out.println("B) Print Songs by Artist");
		System.out.println("G) Get Song");
		System.out.println("R) Remove Song");
		System.out.println("P) Print All Songs");
		System.out.println("S) Size");
		System.out.println("Q) Quit");
		char ch,ch1;
		int minutes, seconds,position;
		
		do
		{
			System.out.println("Select a menu option:");
			ch=input.next().charAt(0);
			ch1=Character.toUpperCase(ch);
			switch(ch1)
			{
			case 'A':
			{
				input.nextLine();
				System.out.println("Enter the song title:");
				String title=input.nextLine();
				System.out.println("Enter the song artist:");
				String artist=input.nextLine();
			    System.out.println("Enter the song length(minutes):");
			    minutes=input.nextInt();
			    System.out.println("Enter the song length(seconds):");
			    seconds=input.nextInt();
				System.out.println("Enter the position:");
				position=input.nextInt();
				SongRecord c1=new SongRecord();//create a new SongRecord object
				// call the setter method to give information about an audio file
				c1.setTitle(title);
				c1.setArtist(artist);
				c1.setMinutes(minutes);
				c1.setSeconds(seconds);
				// calls the method to add the song at a specific position
				playList.addSong(c1, position);
				if((position>=1 && position<=playList.size()+1 && playList.size()!=playList.maximum))
				{System.out.println("Song added "+title+" by "+artist);}
				break;
			}
			case 'P':
			{
				//calls the method to print the songs in tabular form
				playList.printAllSongs();
				break;
			}
			case 'S':
			{
				System.out.println("There are "+ playList.size()+" song(s) in the current playlist.");
				break;
			}
			case 'R':
			{
				System.out.println("Enter the position:");
				int pos=input.nextInt();
				//calls the method to remove an audio file
				playList.removeSong(pos);
				break;
				
			}
			case 'B':
			{  
				input.nextLine();
				System.out.println("Enter the artist:");
				String s2=input.nextLine();
				Playlist c2=new Playlist();
				// calls the method to show the songs by a particular artist
				c2=playList.getSongsByArtist(playList,s2);
				break;
			}
			case 'G':
			{
				System.out.println("Enter the position:");
				int n1=input.nextInt();
				SongRecord c1=new SongRecord();
				//calls the method to get the audio file at a specific position
				c1=playList.getSong(n1);
				System.out.println(String.format("%-21s%-21s%-26s%24s","#Songs","Title","Artist","Length"));
				System.out.println("------------------------------------------------------------------------------------------------------");
			    System.out.format("%-21d%-21s%-35s%10d:%02d",n1,c1.getTitle(),c1.getArtist(),c1.getMinutes(),c1.getSeconds());
				System.out.println();
			
				break;
				
			}
			case 'O':
			{
				System.out.println("Enter the filename:");
				String s3=input.next();
				playList.playMusic(s3);
			    break;
			    
			}
			case 'Q':
			{
				System.out.println("Program terminating normally....");
				break;
			}
			}
		}while(ch1!='Q');
		

		
}}