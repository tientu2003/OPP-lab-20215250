package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements IPlayable {
	
	// class member
	private static int nbDigitalVideoDiscs = 0;
	//
	@Override
	public String toString() {
		return "DVD " + getTitle() +" - "+ getCategory() + " - " + getCost() ;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	
	//Constructor 
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title); 
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost); 
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs); 
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(director);
		this.setTitle(title); 
		this.setCategory(category);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs); 
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(length,director);
		this.setTitle(title); 
		this.setCategory(category);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs); 
	}

	public boolean isMatch(String find) {
		return getTitle().contains(find);
	}
}
