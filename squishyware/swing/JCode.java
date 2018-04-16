package squishyware.swing;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.*;
import  java.util.regex.Pattern;
import java.util.regex.Matcher;


public class JCode extends JTextPane{

    
  private  String languageName;

 private String[] keywordList= {"public","void", "static", "class","import","if" ,
	"else","do","while","int","boolean" }; 
 
 public static final String NAME="Name";
 public static final String STYLE="Style";
 public static final String KEYWORDS="Keywords";
 private String[] multilineStartTags={"/\\*","//","/\\*\\*" } ;
 private String[] multilineEndTags= {"\\*/", "(\n|$)","\\*/" } ;
 private Color  keywordColor=Color.blue ;
 private Color commentColor=Color.green;
 
   public JCode(String langName){
   this.languageName=langName;
  
   
   
   
   
   }
   
   public JCode(){
	   this.languageName = null;
	   AbstractDocument doc =(AbstractDocument)  this.getDocument();
	   doc.setDocumentFilter(new Filter());
	   addAllStyles();
	   setDragEnabled(true);
	   }
    
public JCode(String langName,String text)throws IOException{
super.setText(text);
this.languageName=langName;
 

}
   
/**
 * This method sets the name of the language in which the code is written
 * 
 * @param name 
 * the name of the language
 */


public void setLanguageName(String name){
languageName=name;
}   



   
public String getLanguageName(){
   
return languageName;
};


public void addAllStyles(){
    StyledDocument doc=(StyledDocument)getDocument();       
	 Style def= StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
       Style keyword= doc.addStyle("keyword",def );
      StyleConstants.setForeground(keyword, keywordColor);
      StyleConstants.setBold(keyword, true);
      
      
	  
	   Style comment=doc.addStyle("comment", def);
	  StyleConstants.setForeground(comment,commentColor);
	  

	  
	
} 

/**
 * This method paints the inputed substring in a specified color.
 * The color would have been specified for the language in the xml file 
 * that describes the language's basics. 
 * @param substring
 * the substring to be painted.
 * @param startIndex
 * the index with which the string should be inserted.
 * @param endIndex 
 * the end index in which the text should be painted. Basically
 * the length of the string.
 * 
 * 
 */




	
	
	

/**
 * This class is used to listen for keyword inputs.
 * The <code>KeywordListener</code> class uses the <code>keyTyped()</code>
 * method to listen for key events and see if selected words match any
 * of the words specified as the language's keywords. It then paints them
 * in the specified color.
 * 
 * The method used by this class <em>may not</em> be the fastest way to perform
 * this operation.
 */
	private class Filter extends DocumentFilter  {

		public void insertString(FilterBypass fb,int offs,String str,AttributeSet a){
			int caretPosition=getCaretPosition();
			try{
			super.insertString(fb,offs,str,a);
			StyledDocument doc= (StyledDocument)JCode.this.getDocument();
			
			resetDocumentStyles(doc,fb);
			System.out.println("Reset" );
			
			//keyword listener
			for(int i=0;i<keywordList.length;i++ ){
				//TODO: Use event handling in my term i.e where isert occurs
				//from last whitespace to next whitespace for speed
				
				Pattern pattern=Pattern.compile("(^|\\W)"+keywordList[i]+"(\\W|$)" );	
				
				Matcher matcher=pattern.matcher(doc.getText(0,doc.getLength()));
				while(matcher.find()){
					super.replace(fb,matcher.start(),matcher.end()-matcher.start(),matcher.group(),doc.getStyle("keyword") );
					System.out.println("Replacing keyword");
				}
				
			}
			
			//comment listener
			for(int i=0;i<multilineStartTags.length;i++){
				Pattern pattern=Pattern.compile(multilineStartTags[i]+"(.|\\n)*?"+multilineEndTags[i] );
		   
				Matcher match=pattern.matcher(doc.getText(0,doc.getLength()));
		   
		
				while(match.find())	{
					super.replace(fb,match.start(),match.end()-match.start(),match.group(),doc.getStyle("comment"))  ;				
				System.out.println("Done" );
				}				
			}
			
			}catch(BadLocationException e ){
				System.out.println(e);
			}
			
			setCaretPosition(caretPosition);
			
		}
       
		public void replace(FilterBypass fb,int offs,int len,String str,AttributeSet a)throws BadLocationException{
			super.replace(fb,offs,len,str,a);
			this.insertString(fb,offs,null,a );


		}
		public void remove(FilterBypass fb,int offs,int len )throws BadLocationException{
			super.remove(fb,offs,len);  
		}
		
		private void resetDocumentStyles(StyledDocument doc,FilterBypass fb )throws BadLocationException{
			super.replace(fb,0,doc.getLength(),doc.getText(0,doc.getLength()),null );
		} 
		
	}//end of filter

	       
		
}//end of JCode



