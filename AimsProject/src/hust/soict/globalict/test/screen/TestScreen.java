package hust.soict.globalict.test.screen;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.screen.StoreScreen;
import hust.soict.globalict.aims.store.Store;

public class TestScreen {
	
	public static void main(String[] args) {
		
		CompactDisc a = new CompactDisc("A");
		a.setTitle("tt1");
		CompactDisc b = new CompactDisc("A");
		b.setTitle("tt2");
		CompactDisc c = new CompactDisc("A");
		c.setTitle("tt3");
		CompactDisc d = new CompactDisc("A");
		d.setTitle("tt4");
		CompactDisc e = new CompactDisc("A");
		e.setTitle("tt5");
		CompactDisc f = new CompactDisc("A");
		f.setTitle("tt6");
		Store astore = new Store();
		astore.addMedia(a);
		astore.addMedia(b);
		astore.addMedia(c);
		astore.addMedia(d);
		astore.addMedia(e);
		astore.addMedia(f);
		new StoreScreen(astore);
		
	}
}
