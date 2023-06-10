package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.List;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Book;
// Nguyen Tien Tu 20215250
public class Aims {
	public static void main (String[] Args) {
		//Create a new cart
		Cart aCart = new Cart();
		// Create new DVD 
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		Book book = new Book();
		book.setAuthor("author 1");
		book.setTitle("BOOK 1");
		book.setCost(50.2f);
		CompactDisc cd = new CompactDisc("Artist 1");
		cd.setTitle("CD1");
		cd.setCost(10.1f);
		
	
		List<Media> mediae = new ArrayList<Media>();
		
		mediae.add(cd);
		mediae.add(dvd1);
		mediae.add(dvd3);
		mediae.add(book);
		
		for (Media m: mediae) {
			System.out.println(m.toString());
			
		}
		
//		// Part 2 Method overloading
//		DigitalVideoDisc dvdList[] = {dvd1,dvd2,dvd3};
//		// Add the list of DVDs
//		aCart.addMedia(dvdList);
//		// Add two List of DVDs
//		aCart.addMedia(dvd2,dvd3);
//	
//		//print total cost of items in the cart
//		System.out.printf("Total cost is: %.2f\n",aCart.totalCost());
//		
//		
//		//Part 5 Class member
//		System.out.println(dvd1.getId() +" " + dvd1.getTitle());
//		System.out.println(dvd3.getId() +" " + dvd3.getTitle());
//		
//		System.out.println("The number of DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
		
	}	
	
}
