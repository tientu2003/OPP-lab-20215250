package hust.soict.globalict.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;

import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBookToStoreScreen extends JFrame{
	
	
	public AddBookToStoreScreen(Store store,Cart cart) {
		super();
		
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Add Book");
		this.setSize(512,384);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/AddItemToStoreScreen.fxml"));
					AddItemController controller = new AddItemController(store,cart,1);
					loader.setController(controller);
					Parent root = loader.load();
					
					fxPanel.setScene(new Scene(root));
					
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
