package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main (String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		
		// Create new dvd objects and add them to the cart
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King 2", "Animation", "Roger Allers", 87, 19.95f);

		
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		cart.addMedia(dvd4);
		
		//Test the print method
		cart.printCart();
		System.out.println();
		
	
		//Test the ID search method
		System.out.println("Search by ID:");
		cart.searchID(2);
		cart.searchID(5);
		System.out.println();
		//Test the Title search method
		System.out.println("Search by Title:");
		cart.searchTitle("The");
		cart.searchTitle("ABC");

	
	}
}
