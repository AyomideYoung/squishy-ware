/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squishyware.swing;

import java.awt.*;
import java.util.*;
import java.awt.geom.*;  
import javax.swing.*;
import javax.swing.text.* ;


/**
 *
 * @author Yg2
 */
public class SquishBalloon extends JComponent {
    
    private RoundRectangle2D rect=null;
    private int balloonWidth=300;
    private int balloonHeight=100;
    private float x=0.0f;
    private float y=0.0f;
    private Insets margin=null;
    private Dimension preferredSize=new Dimension(300,100)  ;
    private Font font;
   private Map<String,JCode> codeBoxList;
   private String[] codeNameList;
	private int lastIndexOfString=0;
	private Color color; 
   private JTextPane textPane=null;

   
   public SquishBalloon(){
	   codeBoxList=new HashMap<>() ;
	   codeNameList=new String[100];
   }
   
   
   
   
   
   
   
   
   
    @Override
    public void paintAll(Graphics g) {
        super.paintAll(g); //To change body of generated methods, choose Tools | Templates.
        this.paint(g);
    }
     
    
@Override
public void paint(Graphics g){ 
this.paintComponent(g);

}
    
    

    @Override
    public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D)g;         
		super.paintComponent(g);
		//Set rendering hints 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		//Create balloon rectangle 
        RoundRectangle2D.Float roundRect= new RoundRectangle2D.Float(x,y,balloonWidth,balloonHeight,5.0f,5.0f); 
		textPane.setLocation((int)x+margin.left,(int)y+ margin.top );	//Set location of balloon's textPane 
		textPane.setSize(textPane.getPreferredSize().width,textPane.getPreferredSize().height); //fix textpane size
		//extend roundRect's size
		
		roundRect.width=(float) textPane.getWidth()+margin.right; 
		roundRect.height=(float) textPane.getHeight()+margin.bottom;
		
		g2d.setColor(color);
		Point2D p1=new Point2D.Float(0.0f,0.0f);
		Point2D p2=new Point2D.Float((float) roundRect.getWidth(), (float)roundRect.getHeight());
		Color[] colors = {Color.white,color};
                float[] gradientPoints = {0.0f,0.3f,1.0f};
                
                
		LinearGradientPaint paintObject=new LinearGradientPaint(p1,p2,gradientPoints,colors);		//setComposite
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));  
		g2d.setPaint(paintObject); 
		g2d.fill(roundRect);
 		textPane.paint(g);
    }
	
	
    @Override
       public void setSize(int width,int height){
       balloonWidth=width;
       balloonHeight=height; 
       }   
    
    @Override
       public Dimension getSize(){
       return new Dimension(this.balloonWidth,this.balloonHeight); 
       }
       
       
    @Override
    public void setLocation(int x,int y){
    this.x=(float)x;
    this.y=(float)y;
    
    }  
     
    /**
     * Sets the text of this balloon.
     * This method processes the string inputed and sets it in a way
     * that the text is line wrapped within the component's margin.
     * @param msg
     * the string to be processed
     * @param g 
     * the graphics object needed.
     */
    
    
    public void setText(String msg ){
  textPane.setText(msg) ;
    
    }
       
    
    
    
    
    @Override
   public Dimension getPreferredSize(){
    return this.preferredSize;
    
    }    
    
   /**
    * Sets the margin of the component.
    * @param in 
    *  an <code>Insets</code> object representing the margin.
    */
   
   
   public void setMargin(Insets in){
   this.margin=margin;
   
   
   }
   
   public void addToCodeList(JCode codebox){
	   String codeBoxName=generateComponentString();
	   codeBoxList.put(codeBoxName,codebox);
   }
   
   
   
   
   
   
   /**
    * Gets the margin between the text box and the component's outline.
    * @return
    * an <code>Insets</code> object representing the margin.
    */
   
   
  public Insets getMargin(){
  return this.margin;
  }   
   
  
  private StyledDocument getDocument(){
      JEditorPane editor =new JEditorPane(); 
  StyledDocument doc=(StyledDocument)   editor.getDocument();
  Style s=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

  
  
  return doc;
  }
  
  private String generateComponentString(){
      String COMPONENT="Component #";
      check:  while(true){
		  
	  Long componentId=(long) Math.abs(Math.random()*10000000);
	  COMPONENT.concat(componentId.toString() );
	    
	collision:for(String name:codeNameList){
		  
		  if(name.equals(COMPONENT)){
			continue check;
			  }	  
        } 
          break;
          }	  
	  return COMPONENT;
	  
  }
  
  
    @Override
    public void setPreferredSize(Dimension d){
    this.preferredSize=d;
    }

  public void setColor(Color color){
	  this.color=color;
  }
   public Color getColor(){
	   return this.color;
	   
   } 

	public JTextPane getTextPane(){
		return textPane;
		
	}	
}


