package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class MediaStore extends JPanel{
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
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
						JFrame f = new JFrame();
						JDialog tmpdialog = new JDialog(f,"Play Media");
						tmpdialog.setLayout(new FlowLayout(FlowLayout.CENTER));
						JLabel announce =  new JLabel("The CompactDisc "+ media.getTitle()+ " is playing" );;
						tmpdialog.add(announce);
						tmpdialog.setSize(300,100);
						tmpdialog.setVisible(true);
						CompactDisc tmp = (CompactDisc)media;
						tmp.play();
					}
					else if (media instanceof DigitalVideoDisc) {
						JFrame f = new JFrame();
						JDialog tmpdialog = new JDialog(f,"Play Media");
						tmpdialog.setLayout(new FlowLayout(FlowLayout.CENTER));
						JLabel announce =  new JLabel("The DigitalVideoDisc "+ media.getTitle()+ " is playing" );
						tmpdialog.add(announce);
						tmpdialog.setSize(300,100);
						tmpdialog.setVisible(true);
						DigitalVideoDisc tmp = (DigitalVideoDisc)media;
						tmp.play();
					}
						
				}else if(button.equals("Add to cart")) {
					//Lam sau 
				}
			}
			
		}
}
