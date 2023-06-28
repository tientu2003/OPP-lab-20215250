package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{
	
	private String title;
	private int length;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Track)) {
			return false;
		}
		Track o = (Track)obj;
		return title.equals(o.getTitle()) && (length == o.getLength()); 
	}
	
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
		
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track() {
		super();
	}
	public Track(String title) {
		super();
		this.title = title;
	}
	public Track(int length) {
		super();
		this.length = length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
		
		
	
}
