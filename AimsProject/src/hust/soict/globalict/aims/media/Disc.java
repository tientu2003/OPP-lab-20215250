package hust.soict.globalict.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	//Getter
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	//Constuctor
	public Disc() {
		super();
	}
	
	public Disc(int length) {
		super();
		this.length = length;
	}
	
	public Disc(String director) {
		super();
		this.director = director;
	}
	
	public Disc(int length, String director) {
		super();
		this.length = length;
		this.director = director;
	}
	
	
}
