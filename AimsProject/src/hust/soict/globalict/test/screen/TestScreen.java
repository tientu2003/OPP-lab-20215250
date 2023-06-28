package hust.soict.globalict.test.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.aims.screen.StoreScreen;
import hust.soict.globalict.aims.store.Store;

public class TestScreen {
	
	public static void main(String[] args) throws PlayerException {
		
		
		Store astore = new Store();
		Cart cart = new Cart();
		
		new CartScreen(cart,astore); 
		
	}
}
