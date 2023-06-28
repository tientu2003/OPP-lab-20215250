package hust.soict.globalict.aims.cart;


import javax.naming.LimitExceededException;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.*;

public class Cart {
	private boolean filter = false;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private ObservableList<Media> displayedItems = FXCollections.observableArrayList();
	
	final static int MAX_NUMBERS_ORDERD = 20;
	
	public ObservableList<Media> getItemsOrdered(){
		if (!filter) {
			return itemsOrdered;
		}else {
			return displayedItems;
		}
	}
	
	public void resetFilter() {
		filter = false;
		displayedItems.clear();
	}
	
	public void addMedia(Media media) throws LimitExceededException {
		if(itemsOrdered.size() < MAX_NUMBERS_ORDERD) {
			
			if(!(itemsOrdered.contains(media))){
				this.itemsOrdered.add(media);
			}else {
				System.out.println("The cart had contained " + media.getTitle());
			}
		}else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}	
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media))
		{
			itemsOrdered.remove(media);
		}else {
			System.out.println("The cart hadn't contained " + media.getTitle());
		}
	}
	
	// Check the total cost in cart
	public double totalCost() {
		double sum = 0;
		for (Media a: itemsOrdered) {
			sum += a.getCost();
		}
		return sum; 	
	}
	
	// This method used to check the number of items in cart
	public void checkquantity() {
		System.out.println("The number of items in Cart: " + itemsOrdered.size());
	}
	
	// Print list of the Cart
	
	public void printCart() {
		System.out.println("************************CART**************************");
		System.out.println("Ordered Items:");
		int i = 1;
		for (Media a: itemsOrdered) {
			System.out.println( i+ " ||| " + a.getTitle() + " ||| " + a.getCost());
			i++;
		}
		System.out.printf("Total cost: %.2f\n", totalCost());
		System.out.println("******************************************************");
		
	}
	// Search methods
	
		// by ID
		public int searchID(int id) {
			filter = true;
			int flag = 0;
			for (Media a: itemsOrdered) {
				if (a.getId() == id) {
					System.out.println("The item found");
					System.out.println(a);
					displayedItems.add(a);
					flag = 1;
				}	
			}
			if (flag == 0) System.out.println("Could not found the items having ID: " + id);
			return flag;
		}
		
		//by Title
		public int searchTitle(String title) {
			filter = true;
			int flag = 0;
			for (Media a: itemsOrdered) {
				if (a.getTitle().equals(title)) {
					System.out.println("The item found");
					System.out.println(a);
					displayedItems.add(a);
					flag = 1;
				}	
			}
			if (flag == 0) System.out.println("Could not found the items having title: " + title);
			return flag;
		}
}
