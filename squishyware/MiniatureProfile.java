package squishyware;

import javax.swing.*;
import java.awt.*;


public class MiniatureProfile extends JPanel{
	
	private  JLabel nameIconLabel;
	private JLabel popularityLabel;
	private JLabel badgeLabel;
	private boolean available;
	private JLabel availableLabel;
	
	
	private ImageIcon badge=SquishyWare.getDefaultBadgeIcon();
	private ImageIcon popularityIcon=SquishyWare.getDefaultPopularityIcon();
	private ImageIcon availableIcon=SquishyWare.getAvailableIcon();
	private ImageIcon unavailableIcon=SquishyWare.getUnavailableIcon();
	
	public MiniatureProfile(ImageIcon img,String name,int rank,int noOfBadges,boolean available ){
		nameIconLabel=new JLabel(name, img, 0);
		popularityLabel=new JLabel(new Integer(rank).toString(),popularityIcon,0);
		badgeLabel=new JLabel(new Integer(noOfBadges).toString(),badge,0);
		this.available=available;  
		
		if(this.available==true){
			availableLabel=new JLabel(availableIcon);
		}else{
			availableLabel=new JLabel(unavailableIcon);
		}
		
		}
	
	public void setNameIconLabel(ImageIcon img,String name){
	nameIconLabel=new JLabel(name, img, 0);	
		
	}
	
	public void setPopularityLabel(int rank ){
		popularityLabel=new JLabel(new Integer(rank).toString(),popularityIcon,0);
	}
	
	public void setBadgeLabel(int noOfBadges ){
		badgeLabel=new JLabel(new Integer(noOfBadges).toString(),badge,0);
	}
	
	public void setAvailable(boolean available){
		this.available=available;
	}
	
	public void paintComponent(Graphics g){
		renderComponents();
		super.paintComponent();
		
	}
	
	private void renderComponents(){
		GridBagLayout gb=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		
		c.gridx=0;
		c.gridy=0;
		c.width=3;
		
		gb.add(nameIconLabel,c);
		
		c.gridy=1;
		c.width=1;
		
		gb.add(popularityLabel,c);
		
		c.gridx=1;
		
		gb.add(badgeLabel,c);
		
		c.gridx=2;
		c.anchor=GridBagConstraints.CENTER;
		gb.add(availableIcon,c);
		
		this.setLayout(gb);
		
	}
	
}

