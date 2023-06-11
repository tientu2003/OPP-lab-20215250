package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class SortMedia {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		Book book = new Book();
		book.setAuthor("author 1");
		book.setTitle("BOOK 1");
		book.setCost(50.2f);
		CompactDisc cd = new CompactDisc("Artist 1");
		cd.setTitle("Aladin");
		cd.setCost(19.95f);
		
	
		List<Media> mediae = new ArrayList<Media>();
		
		mediae.add(cd);
		mediae.add(dvd1);
		mediae.add(dvd3);
		mediae.add(book);
		for (Media m: mediae) {
			System.out.println(m.toString());
			
		}
		System.out.println();
		System.out.println("Sorting********************");
		
		// Sort
		Collections.sort(mediae,Media.COMPARE_BY_COST_TITLE);
		for (Media m: mediae) {
			System.out.println(m.getTitle() + " " + m.getCost());
		}
		System.out.println();
		Collections.sort(mediae,Media.COMPARE_BY_TITLE_COST);
		for (Media m: mediae) {
			System.out.println(m.getTitle() + " " + m.getCost());
		}
		
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King 2", "Animation", "Roger Allers", 87, 19.95f);
			
		System.out.println("");
			
		ArrayList<DigitalVideoDisc> examplecomparablesort = new ArrayList<DigitalVideoDisc>();
		
		examplecomparablesort.add(dvd1);
		examplecomparablesort.add(dvd2);
		examplecomparablesort.add(dvd3);
		examplecomparablesort.add(dvd4);
		//Test the comparable interface sort method
		
		System.out.println("***************");
		for (DigitalVideoDisc d: examplecomparablesort)
			System.out.println(d);
			
		Collections.sort(examplecomparablesort);
		System.out.println("Sorting***************");
		for (DigitalVideoDisc d: examplecomparablesort)
			System.out.println(d);
			
		
		
			//Create a new cart
//			Cart aCart = new Cart();
			// Create new DVD 
			
//			// Part 2 Method overloading
//			DigitalVideoDisc dvdList[] = {dvd1,dvd2,dvd3};
//			// Add the list of DVDs
//			aCart.addMedia(dvdList);
//			// Add two List of DVDs
//			aCart.addMedia(dvd2,dvd3);
	//	
//			//print total cost of items in the cart
//			System.out.printf("Total cost is: %.2f\n",aCart.totalCost());
//			
//			
//			//Part 5 Class member
//			System.out.println(dvd1.getId() +" " + dvd1.getTitle());
//			System.out.println(dvd3.getId() +" " + dvd3.getTitle());
//			
//			System.out.println("The number of DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());

		
	}
	
}
