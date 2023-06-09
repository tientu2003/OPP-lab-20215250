package hust.soict.globalict.lab02.AimsProject;
// Nguyen Tien Tu 20215250
public class Aims {
	public static void main (String[] Args) {
		//Create a new cart
		Cart aCart = new Cart();
		
		// Create new DVD 
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		//Add them to the cart
		aCart.addDigitalVideoDisc(dvd1);
		aCart.addDigitalVideoDisc(dvd2);
		aCart.addDigitalVideoDisc(dvd3);
		
		//print total cost of items in the cart
	
		System.out.printf("Total cost is: %.2f\n",aCart.totalCost());
		// Check the remove method
		System.out.println("-----------------------------");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lord of the Rings","Action",35.39f);
		aCart.addDigitalVideoDisc(dvd4);
		
		aCart.removeDigitalVideoDisc(dvd1);
		aCart.removeDigitalVideoDisc(dvd4);
		
		// Check the remaining items in Cart
		aCart.checkquantity();
	}	
	
}
