package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	@Override
	public String toString() {
		return "Book " + getTitle() +" - "+ getAuthor() + " - " + getCost() ;
	}
	
	public Book() {
		super();
	}

	public List<String> getAuthor() {
		return authors;
	}

	public void setAuthor(String authorName) {
		if(!(this.authors.contains(authorName)))
			this.authors.add(authorName);
		else System.out.println("The list book had contained "+authorName);
	}
	public void removeAuthor(String authorName) {
		if(this.authors.contains(authorName)) {
			this.authors.remove(authorName);
		}else System.out.println("The list book had not contained "+authorName);
	}
	
	public static void main(String[] args) {
		
		Book a = new Book();
		a.setAuthor("1");
		a.setAuthor("1");
		a.removeAuthor("2");
	} 
	
	
}
