package hust.soict.globalict.aims;
import java.util.Collections;
import java.util.Scanner;


import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

// Nguyen Tien Tu 20215250
public class Aims {
	
	private static Media findresult;
	private static Store astore = new Store();
	private static Cart acart = new Cart();
	private static int menu = 0;
	private static int flag = 0;
	private static Scanner input = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println();
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update Store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		int choice = input.nextInt();
		System.out.println("********************************");
		System.out.println();
		switch (choice) {
			case 0: flag = 1;
				break;
			case 1:
				astore.printStore();
				menu = 1;	
				break;
			case 2:
				while(true) {
					if (updateStore()) break;
				}
				break;
			case 3:
				acart.printCart();
				menu = 3;
				break;
			default:
				System.out.println("ERROR");
		
		}
	}
	
	public static void storeMenu() {
		System.out.println();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		String name = new String();
		int choice = input.nextInt();
		System.out.println("********************************");
		System.out.println();
		switch (choice) {
		case 0:
			flag = 1;
			break;
		case 1:
			System.out.println("Enter the title of the media");
			name = input.next();
			findresult = astore.findMedia(name);
			if (findresult != null) {
				menu = 2;
				System.out.println(findresult);
			}
			break;
		case 2:
			System.out.println("Enter the title of the media");
			name = input.next();
			findresult = astore.findMedia(name);
			if (findresult != null) {
				acart.addMedia(findresult);
				System.out.println("Successful");
				acart.checkquantity();
			}
			break;
		case 3:
			System.out.println("Enter the title of the media");
			name = input.next();
			findresult = astore.findMedia(name);
			if(findresult == null) break;
			if (findresult instanceof CompactDisc )
			{
				CompactDisc tmp =(CompactDisc)findresult;
				tmp.play();
			}else if (findresult instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc tmp =(DigitalVideoDisc)findresult;
				tmp.play();
			}else {
				System.out.println("Play is not available");
			}
			break;
		case 4:
			acart.printCart();
			menu = 3;
			break;
		default:
			System.out.println("ERROR");
		}
	
		
	}
	
	public static void mediaDetailsMenu() {
		System.out.println();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int choice = input.nextInt();
		System.out.println("********************************");
		System.out.println();
		switch (choice) {
		case 0:
			menu = 1;
			break;
		case 1:
			acart.addMedia(findresult);
			System.out.println("Successful");
			acart.checkquantity();
			break;
		case 2:
			if (findresult instanceof CompactDisc )
			{
				CompactDisc tmp =(CompactDisc)findresult;
				tmp.play();
			}else if (findresult instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc tmp =(DigitalVideoDisc)findresult;
				tmp.play();
			}else {
				System.out.println("Play is not available");
			}
			break;
		default:
			System.out.println("ERROR");
	
	}
	}
	
	public static void cartMenu() {
		System.out.println();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		int choice = input.nextInt();
		System.out.println("********************************");
		System.out.println();
		String name;
		int c;
		switch (choice) {
		case 0:
			flag = 1;
			break;
		case 1:
			System.out.println("Choose: 1.By ID 2.By Title" );
			c = input.nextInt();
			if (c == 1) {
				System.out.println("Input ID: ");
				int d = input.nextInt();
				acart.searchID(d);
			}else if (c==2) {
				System.out.println("Input Title: ");
				String a = input.next();
				acart.searchTitle(a);
			}
			break;
		case 2:
			System.out.println("Sort: 1.By Title 2.By Cost" );
			c = input.nextInt();
			if (c == 1) {
				Collections.sort(acart.getItems(),Media.COMPARE_BY_TITLE_COST);
				acart.printCart();
			}else if (c==2) {
				Collections.sort(acart.getItems(),Media.COMPARE_BY_COST_TITLE);
				acart.printCart();
			}
			break;
		case 3:
			System.out.println("Enter title: ");name = input.next();
			findresult = astore.findMedia(name);
			if (findresult != null) {
				acart.removeMedia(findresult);
			}
			break;
		case 4:
			System.out.println("Enter the title of the media");
			name = input.next();
			findresult = astore.findMedia(name);
			if(findresult == null) break;
			if (findresult instanceof CompactDisc )
			{
				CompactDisc tmp =(CompactDisc)findresult;
				tmp.play();
			}else if (findresult instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc tmp =(DigitalVideoDisc)findresult;
				tmp.play();
			}else {
				System.out.println("Play is not available");
			}
			break;
		case 5:
			if (acart.getItems().size() == 0) {
				System.out.println("The cart is empty");
			}else {
				System.out.println("The Order is created");
			}
			break;
		default:
			System.out.println("ERROR");
	
		}
		
	}
	
	public static boolean updateStore() {
		System.out.println();
		System.out.println("Options: ");
		System.out.println("1.Add as a book");
		System.out.println("2.Add as a DVD");
		System.out.println("3.Add as a CD");
		System.out.println("4.Remove a media");
		System.out.println("5.Back");
		System.out.println("Please choose a number: 1-2-3-4-5");
		
		
		int choice = input.nextInt();
		System.out.println("********************************");
		System.out.println();
		String name;
		float cost;
		
		switch(choice){
		case 1:
		
		
			System.out.println("Enter title: ");name = input.next();
			System.out.println("Enter cost: "); cost = input.nextFloat();
			Book book = new Book();
			book.setTitle(name);
			book.setCost(cost);
			astore.addMedia(book);
			
			break;
		case 2:
			System.out.println("Enter title: ");name = input.next();
			System.out.println("Enter cost: "); cost = input.nextFloat();
			DigitalVideoDisc dvd = new DigitalVideoDisc(name);
			dvd.setCost(cost);
			astore.addMedia(dvd);
			
			break;
		case 3:
			System.out.println("Enter title: ");name = input.next();
			System.out.println("Enter cost: "); cost = input.nextFloat();
			CompactDisc cd = new CompactDisc();
			cd.setTitle(name);
			cd.setCost(cost);
			astore.addMedia(cd);
			break;
		case 4:
			System.out.println("Enter title: ");name = input.next();
			findresult = astore.findMedia(name);
			if (findresult != null) {
				astore.removeMedia(findresult);
			}
			System.out.println("Successfully");
			break;
		case 5:

			return true;
		}
		
		return false;
		
	}
	
	public static void main (String[] Args) {
		
		do {
			if (menu == 0) {
				showMenu();
				continue;
			}
			else if (menu == 1){
				storeMenu();
				continue;
			}else if (menu == 2){
				mediaDetailsMenu();
				continue;
			}else if (menu == 3){
				cartMenu();
				continue;
			}
			
		}while(flag == 0);
		
		
	}
}
