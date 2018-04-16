package squishyware.swing;

import javax.swing.*;
import java.awt.*;


public class MiniatureProfile extends JPanel{
	
	private ClippedImage cimg = null;
	private  JLabel nameLabel;
	private JLabel popularityLabel;
	private JLabel badgeLabel;
	private boolean available;
	private JLabel availableLabel;
	
	
	private ImageIcon badge=SquishyWare.getDefaultBadgeIcon();
	private ImageIcon popularityIcon=SquishyWare.getDefaultPopularityIcon();
	private ImageIcon availableIcon=SquishyWare.getAvailableIcon();
	private ImageIcon unavailableIcon=SquishyWare.getUnavailableIcon();
	
	public MiniatureProfile(ImageIcon img,String name,int rank,int noOfBadges,boolean available ){
		
		popularityLabel=new JLabel(new Integer(rank).toString(),popularityIcon,0);
		badgeLabel=new JLabel(new Integer(noOfBadges).toString(),badge,0);
		this.available=available;  
		
		if(this.available==true){
			availableLabel=new JLabel(availableIcon);
		}else{
			availableLabel=new JLabel(unavailableIcon);
		}
		
		}
		
		public void setProfileImage(Image img){
			clipImage(img);
		} 
		
	public void setNameLabel(String str){
		nameLabel=new JLabel(str);     
	}	
	public void setPopularityLabel(int rank ){
		popularityLabel=new JLabel(Integer.toString(rank),popularityIcon,0);
	}
	
	public void setBadgeLabel(int noOfBadges ){
		badgeLabel=new JLabel(Integer.toString(noOfBadges),badge,0);
	}
	
	public void setAvailable(boolean available){
		this.available=available;
	}
	
        @Override
	public void paintComponent(Graphics g){
		renderComponents();
		super.paintComponent(g);
		
	}
	
	private void renderComponents(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.anchor=GridBagConstraints.CENTER;

		this.add(cimg,c);		
		c.gridx=1;
		c.gridy=0;
		c.gridwidth=2;
		
		this.add(nameLabel,c);
		
		c.gridy=1;
		c.gridwidth=1;
		
		this.add(popularityLabel,c);
		
		c.gridx=1;
		
		this.add(badgeLabel,c);
		
		c.gridx=2;
		c.anchor=GridBagConstraints.CENTER;
		this.add(new JLabel(availableIcon),c);
		
		
		
	}
	
	private void clipImage(Image img){
		cimg=ClippedImage.getInstance(img, 0,64,0,64,0,img.getWidth(null),0,img.getHeight(null));
		
	}

	
}

