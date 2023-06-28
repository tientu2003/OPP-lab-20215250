package hust.soict.globalict.aims.screen;




import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	private Store store;
	private Cart cart;
	@FXML
	private Button btnPlay,btnRemove;
	@FXML
	private Label lbCost;
	@FXML
	private TextField tfFilter ;
	@FXML
	private RadioButton radioBtnFilterId,radioBtnFilterTitle;
	@FXML 
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	
	public CartScreenController(Cart cart,Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}
	@FXML
    private void menuAddBookPressed(ActionEvent event) {
		new AddBookToStoreScreen(store,cart);
    }

    @FXML
    private void menuAddCDPressed(ActionEvent event) {
    	new AddCompactDiscToStoreScreen(store,cart);
    }

    @FXML
    private void menuAddDVDPressed(ActionEvent event) {
    	new AddDigitalVideoDiscToStoreScreen(store,cart);
    }

    @FXML
    private void menuViewCartPressed(ActionEvent event) {
    	Dialog<String> dialog = new Dialog<String>();
    	dialog.setTitle("Announce");
		dialog.setContentText("You are currently in Cart");
		ButtonType type = new ButtonType("Ok",ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		dialog.showAndWait();
    }

    @FXML
    private void menuViewStorePressed(ActionEvent event) {
    	new StoreScreen(store, cart);
    	
    }
	
	@FXML
	private void btnPlaceOrderPressed(ActionEvent event) {
		Dialog<String> dialog = new Dialog<String>();
		dialog.setTitle("Place Order");
		dialog.setContentText("Order is successful ");
		ButtonType type = new ButtonType("Ok",ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		dialog.showAndWait();
		}
	
	@FXML 
	private void btnPlayPressed(ActionEvent event) {
		Dialog<String> dialog = new Dialog<String>();
	
		Media tmpMedia = tblMedia.getSelectionModel().getSelectedItem();
		
		if(tmpMedia instanceof DigitalVideoDisc) {
			try {
				((DigitalVideoDisc) tmpMedia).play();
				dialog.setTitle("Play");
				dialog.setContentText("DigitalVideoDisc " + tmpMedia.getTitle() + " is playing");
			}catch ( PlayerException e) {
				// TODO: handle exception
				dialog.setTitle("ERROR");
				dialog.setContentText(e.getMessage());
			}
			
			
		
		}else if (tmpMedia instanceof CompactDisc){
			try {
				((CompactDisc) tmpMedia).play();
				dialog.setTitle("Play");
				dialog.setContentText("CompactDisc " + tmpMedia.getTitle() + " is playing");
			}catch ( PlayerException e) {
				// TODO: handle exception
				dialog.setTitle("ERROR");
				dialog.setContentText(e.getMessage());
			}
		}
		
		
		ButtonType type = new ButtonType("Ok",ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		dialog.showAndWait();
		}
	
	@FXML 
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		lbCost.setText(cart.totalCost() + " $");
	
		tblMedia.getItems().addListener(new ListChangeListener<Media>() {
			@Override
			public void onChanged(Change<? extends Media> c) {
				lbCost.setText(cart.totalCost() + " $");
			}
					
		});
			
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
				@Override
				public void changed(ObservableValue<? extends Media> observable,Media oldValue,Media newValue) {
					if (newValue!= null) {
						updateButtonBar(newValue);
					}
				}
			});
		
		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});

	}
	
	void showFilteredMedia(String value) {
		if (value.equals("")  ) {
			cart.resetFilter();
			tblMedia.setItems(cart.getItemsOrdered());
			return;
			}
		if(radioBtnFilterTitle.isSelected()) {
			if(cart.searchTitle(value) == 0) {
				cart.resetFilter();
				return;
			}
			tblMedia.setItems(cart.getItemsOrdered());
		}else if (radioBtnFilterId.isSelected()) {
			if(cart.searchID(Integer.parseInt(value)) == 0) {
				cart.resetFilter();
				return;
			}
			tblMedia.setItems(cart.getItemsOrdered());
		}
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if(media instanceof Playable) {
			btnPlay.setVisible(true);
		}else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		lbCost.setText(cart.totalCost() + " $");
	}
}
		
