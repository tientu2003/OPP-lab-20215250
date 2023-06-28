package hust.soict.globalict.aims;


import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.aims.store.Store;

// Nguyen Tien Tu 20215250
public class Aims {
	
	public static void main (String[] Args) throws PlayerException {
			Store store = new Store();
			Cart cart = new Cart();
			new CartScreen(cart,store);
	
	}
}
