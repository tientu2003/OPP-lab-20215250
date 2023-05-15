package aimsprogram;

public class DigitalVideoDisc {
	
	// Attitudes
	private String title;
	private String category;
	private String director;
	private int length; 
	private float cost;
	private int id;
	// class member
	private static int nbDigitalVideoDiscs = 0;
	
	
	// Accessors 
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public static int getNbDigitalVideoDiscs() {
		return nbDigitalVideoDiscs;
	}
	
	//Setter
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(int newid) {
		this.id = newid;
	}
	
	//Constructor 
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	//Lab 03 Part 6
	public String toString() {
		return id + ". DVD - " + title +" - " + category + " - " 
				+ director + " - " +length + ": " + cost +"$";
	}
	public boolean isMatch(String find) {
		return title.contains(find);
	}
}
