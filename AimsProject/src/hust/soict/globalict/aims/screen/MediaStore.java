package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.globalict.aims.media.Playable;

import javafx.application.Platform;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media,Cart cart) {
		this.media = media;
		this.cart = cart;
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel (media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+ media.getCost()+"$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		ButtonListener btnListener = new ButtonListener();
		JButton jbtn = new JButton("Add to cart");
		jbtn.addActionListener(btnListener);
		container.add(jbtn);
		
		if (media instanceof Playable) {
			jbtn =  new JButton("Play");
			jbtn.addActionListener(btnListener);
			container.add(jbtn);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	
		private class ButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				String button = e.getActionCommand();
				if(button.equals("Play")) {
					if(media instanceof CompactDisc) {
						try {
							CompactDisc tmp = (CompactDisc)media;
							tmp.play();
							JFrame f = new JFrame();
							
							JDialog tmpdialog = new JDialog(f,"Play Media");
							tmpdialog.setLayout(new FlowLayout(FlowLayout.CENTER));
							JLabel announce =  new JLabel("The CompactDisc "+ media.getTitle()+ " is playing" );;
							tmpdialog.add(announce);
							tmpdialog.setSize(300,100);
					        tmpdialog.setLocationRelativeTo(null);
					    	tmpdialog.setVisible(true);
					    	
							
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JFrame frame = new JFrame();
							JDialog error = new JDialog(frame,"Error");
							JLabel labelerror = new JLabel(e1.getMessage());
							error.setLayout(new FlowLayout(FlowLayout.CENTER));
							error.setAlwaysOnTop(true);
							error.add(labelerror);
							error.setSize(300,100);
							error.setLocationRelativeTo(null);
							error.setVisible(true);
				
						}
						
					
					}
					else if (media instanceof DigitalVideoDisc) {
						try {
							DigitalVideoDisc tmp = (DigitalVideoDisc)media;
							tmp.play();
							JFrame  f = new JFrame();            
							
							JDialog tmpdialog = new JDialog(f,"Play Media");
							tmpdialog.setLayout(new FlowLayout(FlowLayout.CENTER));
							JLabel announce =  new JLabel("The DigitalVideoDisc "+ media.getTitle()+ " is playing" );
							tmpdialog.add(announce);
							tmpdialog.setSize(300,100);
							
							tmpdialog.setLocationRelativeTo(null);
							tmpdialog.setVisible(true);
			
						
						} catch (PlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JFrame frame = new JFrame();
							JDialog error = new JDialog(frame,"Error");
							error.setLayout(new FlowLayout(FlowLayout.CENTER));
							JLabel labelerror = new JLabel(e1.getMessage());
							error.setAlwaysOnTop(true);
							error.add(labelerror);
							error.setSize(300,100);
							error.setLocationRelativeTo(null);
							error.setVisible(true);
						}
					}
						
				}else if(button.equals("Add to cart")) {
					//Lam sau 
					
					JFrame  f = new JFrame();            
					
					JDialog tmpdialog = new JDialog(f,"Add to cart");
					tmpdialog.setLayout(new FlowLayout(FlowLayout.CENTER));
					JLabel announce =  new JLabel("Success");
					tmpdialog.add(announce);
					tmpdialog.setSize(300,100);
					tmpdialog.setLocationRelativeTo(null);
					tmpdialog.setVisible(true);
					
					Platform.runLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
							cart.addMedia(media);
							}catch(LimitExceededException e) {
								JFrame  f = new JFrame();            
								
								JDialog tmpdialog = new JDialog(f,"Error");
								tmpdialog.setLayout(new FlowLayout(FlowLayout.CENTER));
								JLabel announce =  new JLabel("The Cart has reached its limit");
								tmpdialog.add(announce);
								tmpdialog.setSize(300,100);
								tmpdialog.setLocationRelativeTo(null);
								tmpdialog.setVisible(true);
							}
						}
					});
						
					
				}
			}
			
		}
}
