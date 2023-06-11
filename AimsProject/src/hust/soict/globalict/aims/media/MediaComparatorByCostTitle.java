package hust.soict.globalict.aims.media;

import java.util.Comparator;
public class MediaComparatorByCostTitle implements Comparator<Media>{
	public int compare(Media first,Media second) {
		int cost = 0;
		if((first.getCost() - second.getCost()) > 0)
			cost = -1;
		else if((first.getCost() - second.getCost())<0)
			cost = 1;
		
		int title = first.getTitle().compareTo(second.getTitle());
		return (cost == 0)? title:cost;
	}
}
