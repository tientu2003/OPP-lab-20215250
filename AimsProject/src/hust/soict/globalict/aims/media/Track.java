package hust.soict.globalict.aims.media;

public class Track implements IPlayable{
	
	private String title;
	private int length;
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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