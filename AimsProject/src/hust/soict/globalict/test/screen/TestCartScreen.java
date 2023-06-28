package hust.soict.globalict.test.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.aims.store.Store;

public class TestCartScreen {
	public static void main (String[] args) throws PlayerException {
	
		Store store = new Store();
		
		Cart cart = new Cart();
		Book book1 = new Book();
		book1.setTitle("book1");
		book1.setCategory("category1");
		book1.setCost(16);
		book1.setId(1);
	
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD 1","Category 1",12);
		dvd1.setId(2);
	
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("DVD 2","Category 2",23);
		dvd2.setId(2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("DVD 3","Category 3",45);
		dvd3.setId(4);
		
		
		
		new CartScreen(cart,store); 
		
	}
	
}

