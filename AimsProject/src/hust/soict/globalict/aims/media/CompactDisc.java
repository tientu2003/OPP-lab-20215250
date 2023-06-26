package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	
	@Override
	
	public String toString() {
		return "CD " + getTitle() +" - "+ artist + " - " + getCost() ;
	}
	
	public void play() {
		System.out.println("Playing: " + getTitle());
		System.out.println("Artist: " + getArtist());
		for(Track a: tracks) {
			a.play();
		}
		
	}
	
	public void addTrack(Track a){
		if(tracks.contains(a))
		{
			System.out.println("The tracks had contained" + a.getTitle());
		}else {
			tracks.add(a);
		}
	}	
	
	public void removeTrack(Track a) {
		if(tracks.contains(a)) {
			tracks.remove(a);
		}else {
			System.out.println("The tracks had not contained" + a.getTitle());
		}
		
	}
	
	public int getLength() {
		int length = 0;
		for(Track a: tracks) {
			length = length + a.getLength();
		}
		return length;
	}
	
	public String getArtist() {
		return artist;
	}

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String artist) {
		super();
		this.artist = artist;
	}

	public CompactDisc(int length, String director,String artist) {
		super(length, director);
		this.artist = artist;
	}

	public CompactDisc(int length,String artist) {
		super(length);
		this.artist = artist;
	}

	public CompactDisc(String director,String artist) {
		super(director);
		this.artist = artist;
	}
	
}
