package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import hust.soict.globalict.aims.media.Media;

public class Store {
	
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();

	public void addMedia(Media media) {
		if(!(itemsInStore.contains(media))){
			this.itemsInStore.add(media);
		}else {
			System.out.println("The cart had contained " + media.getTitle());
		}	
	}	
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media))
		{
			itemsInStore.remove(media);
		}else {
			System.out.println("The cart hadn't contained " + media.getTitle());
		}
	}
	// Print method the list of DVDS in store
	public void printStore() {
		int i = 1;
		System.out.println("Stored Items:");
		for (Media a: itemsInStore) {
			System.out.println(i + " " + a.getTitle());	
			i++;
		}
	}
	
}
