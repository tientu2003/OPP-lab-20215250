package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class AddItemController  {
	private Store store;
	private int type;
	private Cart cart;
	private String title,cost,category,id;
	
    @FXML
    private Label lbAdd;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfTitle;

    @FXML
    void btnAddPressed(ActionEvent event) {
    	try {
    	if (type == 1) {
    		Book newBook = new Book();
    		newBook.setTitle(title);
    		newBook.setCategory(category);
    		newBook.setId(Integer.parseInt(id));
    		newBook.setCost(Float.parseFloat(cost));
    		store.addMedia(newBook);
    	}else if(type == 2) {
    		DigitalVideoDisc newDVD = new DigitalVideoDisc(title,category,Float.parseFloat(cost));
    		newDVD.setId(Integer.parseInt(id));
    		store.addMedia(newDVD);
    		
    	}else if(type == 3) {
    		CompactDisc newCD =  new CompactDisc();
    		newCD.setTitle(title);
    		newCD.setCategory(category);
    		newCD.setId(Integer.parseInt(id));
    		newCD.setCost(Float.parseFloat(cost));
    		store.addMedia(newCD);
    	}
    	}catch (Exception e) {
    		Dialog<String> dialog = new Dialog<String>();
    		dialog.setTitle("Error");
    		dialog.setContentText("Could not add this media to store\n Cause: Invalid Input of Cost or Id");
    		ButtonType type = new ButtonType("Ok",ButtonData.OK_DONE);
    		dialog.getDialogPane().getButtonTypes().add(type);
    		dialog.showAndWait();
    		return;
		}
    	Dialog<String> dialog = new Dialog<String>();
		dialog.setTitle("Add to store");
		dialog.setContentText("Success");
		ButtonType type = new ButtonType("Ok",ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		dialog.showAndWait();
    	
    	
    	
    }
    @FXML
    void menuViewStorePressed(ActionEvent event) throws PlayerException {
    	new StoreScreen(store, cart);
    }
    
    @FXML
    private void initialize() {
    	if(type == 2)
    		lbAdd.setText("Add DigitalVideoDisc");
    	else if (type == 1)
    	{
    		lbAdd.setText("Add Book");
    		
    	}else if (type == 3)
    	{
    		lbAdd.setText("Add CompactDisc");
    	}
    	tfTitle.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newVaule) {
    			title =  tfTitle.getText();
    		}
    			 
		});
    	tfCategory.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newVaule) {
    			category =  tfCategory.getText();
    		}
    			 
		});
    	tfCost.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newVaule) {
    			cost =  tfCost.getText();
    		}
    			 
		});
    	tfId.textProperty().addListener(new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newVaule) {
    			id =  tfId.getText();
    		}
    			 
		});
    }	
    
	public AddItemController(Store store,Cart cart,int type) {
		super();
		this.store = store;
		this.cart = cart;
		this.type = type;
	}
	
    
    

}

