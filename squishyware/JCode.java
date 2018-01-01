package squishyware;

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


public class JCode extends JEditorPane{

    
  private  String languageName;

 private String[] keywordList; 
 
 public static final String NAME="Name";
 public static final String STYLE="Style";
 public static final String KEYWORDS="Keywords";
 private String[] multilineStartTags=null;
 private String[] multilineEndTags=null;
 private Color  keywordColor=null;
 private Color commentColor=null;
 
   public JCode(String langName){
   this.languageName=langName;
  
   
   
   
   
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
      
      
	  
	  Style comment = doc.addStyle("keyword" , keyword);
	  StyleConstants.setForeground(comment,commentColor);
	  doc.addStyle("comment",comment);

	  
	
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
 * in blue.
 * 
 * The method used by this class <em>may not</em> be the fastest way to perform
 * this operation.
 */
private class KeywordFilter extends DocumentFilter  {

public void insertString(FilterBypass fb,int offs,String str,AttributeSet a){
	super.insertString(fb,offs,str,a);
	StyledDocument doc= (StyledDocument)     this.getDocument();
	for(int i=0;i<keywordList.length;i++ ){
		Pattern pattern=Pattern.compile(keywordList[i] );
		Matcher matcher=pattern.matcher(getDocument().getText());
		while(matcher.find()){
			super.replace(fb,matcher.start(),matcher.end()-matcher.start(),matcher.group(),doc.getStyle("keyword") );
		}
	}
	}
       
	public void replace(FilterBypass fb,int offs,int len,String str,AttributeSet a){
			super.replace(fb,offs,len,str,a);
			this.insertString(fb,offs,null,a );


			}
		public void remove(FilterBypass fb,int offs,int len ){
			super.remove(fb,offs,len);  
		}

}

	/**
	
	*/        
		private class CommentFilter extends DocumentFilter{
	   
	   public void insertString(FilterBypass fb,int offs,String str,AttributeSet a){
		   super.insertString(fb,offs,str,a); 
		   StyledDocument doc= (StyledDocument)     this.getDocument();
		   for(int i=0;i<multilineStartTags.length;i++){
			   Pattern pattern=Pattern.compile(multilineStartTags[i]+".*?"+multilineEndTags[i] );
		   
		   Matcher match=pattern.matcher(getDocument().getText());
		   
		
			while(match.find())	{
				super.replace(fb,match.start(),match.end()-match.start(),match.group(),doc.getStyle("comment"))  ;				
				
			}				
			}
		   } 	   
		}	
		
		public void replace(FilterBypass fb,int offs,int len,String str,AttributeSet a){
			super.replace(fb,offs,len,str,a);
			this.insertString(fb,offs,null,a );


			}
		public void remove(FilterBypass fb,int offs,int len ){
			super.remove(fb,offs,len);  
		}
			
			
			
		}//end of CommentListener
}//end of JCode



