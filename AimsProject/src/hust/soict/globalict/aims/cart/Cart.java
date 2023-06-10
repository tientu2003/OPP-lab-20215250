package hust.soict.globalict.aims.cart;
import java.util.Scanner;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
public class Cart {
	private int qtyOrdered;
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	// Add methods
	public void addDigitalVideoDisc(DigitalVideoDisc disc){
		if (qtyOrdered == 20) {
	
			System.out.println("The cart is almost full");
		}else {
			this.itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() +" has been added");
			System.out.println("The number of DVD in Cart: "+ qtyOrdered);
		}
	}
	// Part 2 add the list of DVDs
	public void addDigitalVideoDisc (DigitalVideoDisc [] dvdList) {
		int n = dvdList.length;
		if ((qtyOrdered + n)> 20) {
			System.out.println("The cart is almost full");
			System.out.println("The number of items in current cart: " + qtyOrdered);
		}else{
			
			for(int j  = 0; j< n; j++) {
				itemsOrdered[qtyOrdered] = dvdList[j];
				System.out.println("The disc " + itemsOrdered[qtyOrdered].getTitle() +" has been added");
				qtyOrdered++;
			}
			System.out.println("The number of DVD in Cart: "+ qtyOrdered);
		}
	
	}
	// Part 2 add two dvds 
	public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if ((qtyOrdered + 2) > 20) {
			System.out.println("The cart is almost full");
		}else {
			itemsOrdered[qtyOrdered] = dvd1;
			System.out.println("The disc " + itemsOrdered[qtyOrdered].getTitle() +" has been added");
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			System.out.println("The disc " + itemsOrdered[qtyOrdered].getTitle() +" has been added");
			qtyOrdered++;
			System.out.println("The number of DVD in Cart: "+ qtyOrdered);
		}
	}
	
	// Check the total cost in cart
	public double totalCost() {
		double sum = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum; 	
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i;
		int count = 0;
		for (i = 0; i < qtyOrdered; i++) {
			if (disc == this.itemsOrdered[i]) // find the disc which will be removed
			{	
				Scanner x = new Scanner(System.in); 
				// Confirm 
				System.out.println("The disc " + disc.getTitle() + " has found. Are you sure to remove it: y/n?");
				String choice = x.nextLine();
				// Remove
				if (choice.equals("y")) {
					for (int j = i;  j< qtyOrdered - 1 ; j++) {
						this.itemsOrdered[j] = this.itemsOrdered[j+1];
					}
					this.itemsOrdered[qtyOrdered -1] = null;
					qtyOrdered--;
					count++;
				}
			}
		}
		System.out.println("The number of DVD removed: " + count);
		System.out.println("The number of remaining DVD in Cart: "+ qtyOrdered);
	}
	
	// This method used to check the number of items in cart
	public void checkquantity() {
		System.out.println("The number of items in Cart: " + qtyOrdered);
		for (int i = 0; i < qtyOrdered;  i++) {
			System.out.println( (i+1)+ " " + itemsOrdered[i].getTitle());
		}
	}
	
	// Print list of the Cart
	
	public void printCart() {
		System.out.println("************************CART**************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i< qtyOrdered; i++)
			System.out.println(itemsOrdered[i]);
		System.out.printf("Total cost: %.2f\n", totalCost());
		System.out.println("******************************************************");
		
	}
	// Search methods
	
		// by ID
		public void searchID(int id) {
			int flag = 0;
			for(int i = 0 ; i < qtyOrdered ; i++) {
				if (itemsOrdered[i].getId() == id) {
					System.out.println("The item found");
					System.out.println(itemsOrdered[i]);
					flag = 1;
				}	
			}
			
			if (flag == 0) System.out.println("Could not found the items having ID: " + id);
		}
		//by Title
		public void searchTitle(String title) {
			int flag = 0;
			for (int i = 0; i < qtyOrdered; i++) {
				if (itemsOrdered[i].isMatch(title) == true) {
					System.out.println(itemsOrdered[i]);
					flag = 1;
				}
			}
			if (flag == 0) System.out.println("Could not found the items having title: " + title);
		}
}
