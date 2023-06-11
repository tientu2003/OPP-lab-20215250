package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	
	public int compare(Media first,Media second) {
		int cost = 0;
		int title = first.getTitle().compareTo(second.getTitle());
	
		if((first.getCost() - second.getCost()) > 0)
			cost = -1;
		else if((first.getCost() - second.getCost())<0)
			cost = 1;
		
		return (title == 0)? cost:title;
	}
}
