package hust.soict.globalict.aims.store;

import java.util.Scanner;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Store {
	
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX];
	
	private static int nbItems;
	
	private static final int MAX = 100;

	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore[nbItems] = dvd;
		nbItems++;
		
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		int i;
		int count = 0;
		for (i = 0; i < nbItems; i++) {
			if (dvd == this.itemsInStore[i]) // find the disc which will be removed
			{	
				Scanner x = new Scanner(System.in); 
				// Confirm 
				System.out.println("The disc " + dvd.getTitle() + " has found. Are you sure to remove it: y/n?");
				String choice = x.nextLine();
				// Remove
				if (choice.equals("y")) {
					for (int j = i;  j< nbItems - 1 ; j++) {
						this.itemsInStore[j] = this.itemsInStore[j+1];
						itemsInStore[j].setId(j+1);
					}
					this.itemsInStore[nbItems -1] = null;
					nbItems--;
					count++;
				}
			}
		}
		System.out.println("The number of DVD removed: " + count);
		System.out.println("The number of remaining DVDs in Store: "+ nbItems);
	}
	
	// Print method the list of DVDS in store
	public void printStore() {
		System.out.println("Stored Items:");
		for (int i = 0; i< nbItems; i++)
			System.out.println(itemsInStore[i]);		
	}
	
}
