import javax.swing.*;
import java.awt.*;

/**
	This class clips the images according to specified constraints
*/

public class ClippedImage extends JComponent{
	
	protected ClippedImage(){}
	
	private int dstx1,int dstx2,int dsty1,int dsty2,
    int srcx1,int srcx2,int srcy1,int srcy2 ;
	Image img;	
	
	/**
	
	* This method creates an instance of the ClippedImage class.
	* @param img
	* This is the image to be clipped
	* @param dstx1
	* This is the first coordinate of the destination's x axis.
	* It specifies the point at which <code>img</code>should be painted from on the x axis.
	* It in conjunction with <code>dstx2</code>is used to calculate the width of the painting area.
	* I.e dstx2-dstx1	
	* @param dstx2
	* This is the second coordinate of the destination's x axis.
	* It specifies the point where the painting of <code>img</code>should be stopped on the x axis.
	* It in conjunction with <code>dstx1</code>is used to calculate the width of the painting area.    
	* I.e dstx2-dstx1	
	* @param dsty1
    * This is the first coordinate of the destination's y axis.    
	* It specifies the point at which <code>img</code>should be painted from on the y axis.
	* It in conjunction with <code>dsty2</code>is used to calculate the height of the painting area.
	* I.e dsty2-dsty1
	* @param dsty2    	
	* This is the second coordinate of the destination's y axis.    
	* It specifies the point at which <code>img</code>should be painted from on the y axis.
	* It in conjunction with <code>dsty1</code>is used to calculate the height of the painting area.
	* I.e dsty2-dsty1
	* @param srcx1     
	* This is the first coordinate of the source's x axis.	
	* It specifies the starting index at which the source's (img) pixels should be selected for painting on the x axis.
	* @param srcx2        
	* This is the second coordinate of the source's x axis.    
	* It specifies the end index at which the source's (img) pixels should be selected for painting on the x axis.
	* @param srcy1    
	* This is the first coordinate of the source's y axis.
	* It specifies the starting index at which the source's (img) pixels should be selected for painting on the y axis.
	* @param srcy2 
	* This is the second coordinate of the source's x axis.
	* It specifies the end index at which the source's (img) pixels should be selected for painting on the y axis.
	* @return   
	* an instance of the ClippedImage class
	*
	*
	
	
	
	
*/
	
	
	public static ClippedImage getInstance(Image img,int dstx1,int dstx2,int dsty1,int dsty2,
    int srcx1,int srcx2,int srcy1,int srcy2 	){
		this.dstx1=dstx1;
		this.dstx2=dstx2;
		this.dsty1=dsty1;
		this.dsty2=dsty2;
		this.srcx1=srcx1;
		this.srcx2=srcx2;
		this.srcy1=srcy1;
		this.srcy2=srcy2;
		this.img=img;
		return ClippedImage();
		
	}

	public void paintComponent(Graphics g){
		Graphics2D g2d=(Graphics2D)	g;
		g2d.drawImage(img,dstx1,dsty1,dstx2,dsty2,
			srcx1,srcy1,srcx2,srcy2,null);

		
	}

public Dimension getPreferredSize(){
	
	return new Dimension(dstx2-dstx1,dsty2-dsty1  );
	
}
	
}