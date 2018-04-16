/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squishyware.swing;


import java.util.*;
import javax.swing.plaf.nimbus.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;



/**
 *  <b> SquishyWare Application</b>
 * <p> <i> Connecting the techno-world</i> 
</p>
* 
* <br/> 
* <div > 
* <b> 
* 
*(c) ZapSoft Team
* </b> 
* </div>   
*@author  Bakare  Ayomide
*/
public class SquishyWare {

     /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
       UIManager.setLookAndFeel(new NimbusLookAndFeel()  );
        gl=new GUILoad();
        cl=new ConLoad();
        
     new Thread(SquishyWare::loadOperations).start();       
    }

    private static void loadOperations() {
  Properties p =   getProps();
  
  
     gl.pass(cl);
    
    
    }

    static ImageIcon getDefaultBadgeIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static ImageIcon getDefaultPopularityIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static ImageIcon getAvailableIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static ImageIcon getUnavailableIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ReactiveItem getDefaultBackItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultReferenceIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultLinkIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultSmileyIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultRandomFileIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultAddImageIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultAddCodeIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Icon getDefaultSendIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static int getDefaultMessageIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static ImageIcon getDefaultMinimizeIcon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public SquishyWare() {
        gl=new GUILoad();
        cl=new ConLoad();
        
    }
  
    
    
    
    private static GUILoad gl;            
    private static ConLoad cl;      
    
    
    
    
    
    static Properties getProps(){
    Properties p=new Properties();
System.out.println(  Paths.get("ad\\w3").toAbsolutePath() );
        try {
            p.load(new BufferedInputStream(Files.newInputStream( Paths.get("src\\squishyware\\others\\squish.prop" ))   ) );
        } catch (IOException ex) {
            Logger.getLogger(SquishyWare.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
        
    
    
    
    
    return p;
    }
    
    
    
            }
