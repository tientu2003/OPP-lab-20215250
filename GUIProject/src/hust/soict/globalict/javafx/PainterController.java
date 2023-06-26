package hust.soict.globalict.javafx;


import javafx.css.Size;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	private Color color = Color.BLACK;
    private int size;
	
	@FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton pen,eraser;
 
    @FXML
    public void select(ActionEvent event) {
    	if(pen.isSelected()) {
    		color =  Color.BLACK;
    		size = 4;
    		
    	}else if (eraser.isSelected()) {
    		color = Color.WHITE;
    		size = 16;
    	}
    }
  
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(),event.getY(), size , color);
    	drawingAreaPane.getChildren().add(newCircle);
    }

}
