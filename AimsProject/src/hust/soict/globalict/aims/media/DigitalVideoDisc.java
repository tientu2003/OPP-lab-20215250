package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable,Comparable<DigitalVideoDisc>{

	@Override
	public int compareTo(DigitalVideoDisc a) {
		if (this.getTitle().compareTo(a.getTitle())!= 0)
			return this.getTitle().compareTo(a.getTitle());
		else if(this.getLength() - a.getLength() != 0)
			return a.getLength() - this.getLength();
		else{
			if (this.getCost() > a.getCost())
				return 1;
			else if (this.getCost() < a.getCost())
				return -1;
			else 
				return 0;
		}
	}
	
	// class member
	private static int nbDigitalVideoDiscs = 0;
	//
	@Override
	public String toString() {
		return "DVD " + getTitle() +" - "+ getCategory() + " - " + getCost() ;
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		
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
