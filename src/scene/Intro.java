package scene;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Intro extends JPanel{
	
	JLabel introImage;
	JLabel introText;
	ArrayList<String> imageArray;
	ArrayList<String> textArray;
	
	final int THICKNESS = 1;
	
	public Intro() {
		setLayout(null);
		setBackground(Color.black);
		
		imageArray = new ArrayList<>(Arrays.asList(new String[]{
			"대충 이미지 주소1",
				
			"대충 이미지 주소2",
				
			"대충 이미지 주소3"
		}));
		
		textArray = new ArrayList<>(Arrays.asList(new String[]{
			"<html>대충 스토리1<br>"
			+ "<br>이러쿵 저러쿵<br>"
			+ "<br>어쩌고 저쩌고",
			
			"<html>대충 스토리2<br>"
			+ "<br>저러쿵 이러쿵<br>"
			+ "<br>저쩌고 어쩌고",
			
			"<html>대충 스토리3<br>"
			+ "<br>이러쿵 저러쿵<br>"
			+ "<br>저쩌고 어쩌고"
		}));
		
		introImage = new JLabel(imageArray.get(0), JLabel.CENTER);
		introImage.setFont(new Font("맑은 고딕", Font.BOLD, 32));
		introImage.setForeground(Color.white);
		introImage.setBorder(new LineBorder(Color.white, 3, false));
		introImage.setBounds(250, 125, 300, 150);
		add(introImage);
		
		introText = new JLabel(textArray.get(0));
		introText.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		introText.setForeground(Color.white);
		introText.setBounds(250, 300, 300, 150);
		add(introText);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(imageArray.size() == 1) {
					new Board();
				}
				else {
					imageArray.remove(0);
					textArray.remove(0);
					introImage.setText(imageArray.get(0));
					introText.setText(textArray.get(0));
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

}
