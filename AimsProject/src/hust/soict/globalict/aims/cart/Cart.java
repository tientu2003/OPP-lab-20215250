package hust.soict.globalict.aims.cart;
import java.util.ArrayList;
import hust.soict.globalict.aims.media.Media;
public class Cart {
	
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public void addMedia(Media media) {
		if(!(itemsOrdered.contains(media))){
			this.itemsOrdered.add(media);
		}else {
			System.out.println("The cart had contained " + media.getTitle());
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
		int i = 1;
		for (Media a: itemsOrdered) {
			System.out.println( i + " " + a.getTitle());
			i++;
		}
	}
	
	// Print list of the Cart
	
	public void printCart() {
		System.out.println("************************CART**************************");
		System.out.println("Ordered Items:");
		int i = 1;
		for (Media a: itemsOrdered) {
			System.out.println( i+ " " + a.getTitle());
			i++;
		}
		System.out.printf("Total cost: %.2f\n", totalCost());
		System.out.println("******************************************************");
		
	}
	// Search methods
	
		// by ID
		public void searchID(int id) {
			int flag = 0;
			for (Media a: itemsOrdered) {
				if (a.getId() == id) {
					System.out.println("The item found");
					System.out.println(a);
					flag = 1;
				}	
			}
			if (flag == 0) System.out.println("Could not found the items having ID: " + id);
		}
		
		//by Title
		public void searchTitle(String title) {
			int flag = 0;
			for (Media a: itemsOrdered) {
				if (a.getTitle().equals(title)) {
					System.out.println("The item found");
					System.out.println(a);
					flag = 1;
				}	
			}
			if (flag == 0) System.out.println("Could not found the items having title: " + title);
		}
}
