package squishyware.swing;

import javax.swing.*;
import java.awt.*;

public class Test{
	
 	static JCode code=new JCode();
	public static void main(String[] argv){
		
		JFrame frame = new JFrame();
	
		
		code.setPreferredSize( new Dimension(300,300) ) ;
		   
		frame.getContentPane().add(code);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );		
		
	}
	

}