package hust.soict.globalict.aims.screen;

import java.io.IOException;


import javax.swing.JFrame;


import javafx.scene.*;
import hust.soict.globalict.aims.cart.Cart;

import hust.soict.globalict.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
public class CartScreen extends JFrame {
	
	
	public CartScreen(Cart cart,Store store){
		super();
	
	
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1024,768);
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart,store);
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
