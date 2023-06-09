package hust.soict.globalict.test.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.util.List;
public class CartTest {
	
	
	
	
	public static void main (String[] args) {
		// Create a new cart
		Cart cart = new Cart();
		
		// Create new dvd objects and add them to the cart
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		Book dvd2 = new Book();
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King 2", "Animation", "Roger Allers", 87, 19.95f);
		
		
		
		
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
