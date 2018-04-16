/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squishyware;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.awt.geom.*;  
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
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
    private Insets in=null;
    private Dimension prefSize=new Dimension(300,100)  ;
    private Font font;
   private Map codeBoxList;
   private String[] codeNameList;
	private int lastIndexOfString=0;
   
   
   public SquishBalloon(){
	   codeBoxList=new HashMap<String,JCode>() ;
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
        super.paintComponent(g); 
        Graphics2D g2d=(Graphics2D)g.create() ;
        g2d.setColor(new Color(0,49,95) );
        
        //convert int data to float
        
        float fwidth= (float)this.balloonWidth;
        float fheight= (float)this.balloonHeight;
        
    rect=new RoundRectangle2D.Float(this.x,this.y,  fwidth,fheight,19.0f,19.0f);      
      g2d.fill(rect);
        setText("Ayomide Bakare",g2d );
     
        
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
    
    
    public void setText(String msg,Graphics2D g ){
  JTextPane mad=new JTextPane();
  
    
    }
       
    
    
    
    
    @Override
   public Dimension getPreferredSize(){
    return this.prefSize;
    
    }    
    
   /**
    * Sets the margin of the component.
    * @param in 
    *  an <code>Insets</code> object representing the margin.
    */
   
   
   public void setMargin(Insets in){
   this.in=in;
   
   
   }
   
   public void addToCodeList(JCode codebox){
	   String codeBoxName=generateComponentString();
	   codeBoxList.add(codeBoxName,codebox);
   }
   
   
   
   
   
   
   /**
    * Gets the margin between the text box and the component's outline.
    * @return
    * an <code>Insets</code> object representing the margin.
    */
   
   
  public Insets getMargin(){
  return this.in;
  }   
   
  
  private StyledDocument getDocument(){
      JEditorPane editor =new JEditorPane(); 
  StyledDocument doc=(StyledDocument)   editor.getDocument();
  Style s=StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

  
  
  return doc;
  }
  
  private String generateComponentString(){
	  while(true){
		  String COMPONENT="Component #";
	  Long componentId=new Long((long) Math.abs(Math.random()*10000000));
	  COMPONENT.concat(componentId.toString() );
	    
	collision:for(String name:codeNameList){
		  
		  if(name.equals(COMPONENT)){
			break collision;
			  
	  }	  } }	  
	  return COMPONENT;
	  
  }
  
  
    @Override
    public void setPreferredSize(Dimension d){
    this.prefSize=d;
    }

  
    
}
