/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squishyware;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;
import java.util.* ;

/**
 *
 * @author Yg2
 */
 class GUILoad {
    
    
    JFrame frame=null; 
JPanel pane=null; 
private final static int REGISTER=0;
private final static int LOGIN=1;
Map<String,Object> list =new HashMap<>();  

    
    public GUILoad(){
    frame=new JFrame("SquishyWare");
       gb = new GridBagLayout();
     pane=new JPanel();
     
    
    }     
    
    
    
     GridBagLayout gb;
    
    /**
     * This method displays the dialog that asks for username and password.
     * The method
     * @param cl 
     */

    void pass(ConLoad cl) {
        GridBagLayout gbl=new GridBagLayout();
    JDialog jd=new JDialog((JFrame)  null,"SquishyWare");    
   JPanel panel=new JPanel();
     panel.setLayout(gbl);
       JTextField username=new JTextField(20);
       //create uslab and pwlab for username and password respectively
       
       
       JLabel usernameLabel=new JLabel("Username: "),passwordLabel=new JLabel("Password: "  )    ;            
          
       
     
      JPasswordField pf = new JPasswordField(20);
      JButton button=new JButton("GO!");
      JLabel label = new JLabel("Password must be up to at least 6 characters");
     usernameLabel.setLabelFor(username);
     passwordLabel.setLabelFor(pf);        
      label.setForeground(Color.red);
      
     button.setFont(new Font("Arial",Font.BOLD,17));
      button.setEnabled(false);
      
    
      
     //lay 
     
     GridBagConstraints c=new GridBagConstraints();
     c.gridx=0;
     c.gridx=0;
     panel.add(usernameLabel, c);
     c.gridx=1;
     c.gridy=0;
     c.insets=new Insets(0,8,0,0); 
     panel.add(username,c);     
     c.gridx=0;
     c.gridy=1;
     c.insets=new Insets(0,0,0,0) ;
     panel.add(passwordLabel,c);
     c.gridx=1;
     c.gridy=1;
     c.insets=new Insets(0,8,0,0); 
     panel.add(pf,c);
     c.gridx=0;
     c.gridy=2;
     c.gridwidth=2;
     c.insets=new Insets(0,0,0,0) ;
     panel.add(label, c);     
     c.gridx=0;
     c.gridy=3;
     c.gridwidth=2;
     c.fill=GridBagConstraints.BOTH ;    
     panel.add(button,c);
     
     //ends lay
     
     
     
     
        
     
      
      //creates a thread that checks if the password is up to 6 characters
pf.addKeyListener(  new KeyAdapter(){
        @Override
        public void keyReleased(KeyEvent evt) {
        if(pf.getPassword().length<6){
        label.setText("Password must be up to at least 6 characters");
        button.setEnabled(false);
        }else{
            label.setText("");
        button.setEnabled(true);   }               
        }
    }    );

      
      
      
      
  class GOListener implements ActionListener   {
       
ConLoad cl=null;
        public GOListener(ConLoad cl) {
       GOListener.this.cl=cl;
            
        }

        @Override
@SuppressWarnings("UnnecessaryReturnStatement")
        public void actionPerformed(ActionEvent e) {
       if(    cl.login(GUILoad.this)==0){
           jd.dispose();
            return;
      }
       else
           GUILoad.this.showFrame();      
            
        }
    }
  
  button.addActionListener( new GOListener(cl) ); 
    
  jd.setContentPane(panel);
  
  jd.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2   , Toolkit.getDefaultToolkit().getScreenSize().height/2);
     jd.pack();
     jd.getRootPane().setDefaultButton(button);
     jd.setVisible(true);
     
     
     
     
     
     
     
    }

    private void showFrame() {
        pane.setLayout(new BorderLayout()  ); 
        frame.setContentPane(pane);
        ImageIcon imgi= new ImageIcon(GUILoad.class.getResource("images/welcome.jpg" )  ) ;
      JLabel labimg=new JLabel("Loading...")   ;
      
labimg.setFont(new Font("Cambria  ",Font.ITALIC,20  )  ); 
 labimg.setIcon(imgi);

 labimg.setVerticalTextPosition(JLabel.BOTTOM );
 labimg.setHorizontalTextPosition(JLabel.CENTER);
   frame.setResizable(false);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   pane.setBackground(Color.white); 
   
     pane.add(labimg);
     frame.setLocation(800   , 600); ;
     
  frame.setUndecorated(true);
      frame.pack();
      
      frame.setVisible(true);
        
        
         }

  public void showMainPage(int op){
      this.showMainPage(op,null);
  
  
  
  
  
  
  
  
  
  
  
  }

  
  
  
  
  
  public void showWelcome(){

JDialog qadiag=new JDialog();   
JPanel firstPane=new JPanel();





doFirstPane: {
GridBagLayout gbl=new GridBagLayout();
firstPane.setLayout(gbl);

SquishBalloon ball=new SquishBalloon();
GridBagConstraints c= new GridBagConstraints();
JLabel firstLabel=new JLabel("Looks like you are a newbie. Are you? ");
JButton yesButton=new JButton("Yes" );
JButton noButton = new  JButton("No" );
qadiag.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
c.gridx=0;
c.gridy=0;
c.gridwidth=2;
c.gridheight=2;
firstPane.add(firstLabel,c );
c.gridy=2;
c.gridwidth=1;
c.gridheight=1;
c.insets =new Insets(10,0,5,20);
firstPane.add(yesButton,c );
c.gridx=1;
c.insets= new Insets(10,20,5,0);  
firstPane.add(noButton ,c   );
c.gridx=5;

firstPane.add(ball,c);
  
        
class ButtonL implements ActionListener{



@Override
public void actionPerformed(ActionEvent e ) {
if(e.getSource()==noButton ){
System.out.println(noButton.getText());
System.exit(LOGIN);

} else{
   showYippee(); 
    System.out.println(yesButton.getText() );
    qadiag.dispose();
    return;
  }  
    
    

}  

          

   
}


noButton.addActionListener(new ButtonL() );
yesButton.addActionListener(new ButtonL());

} 
qadiag.setContentPane(firstPane);
 qadiag.pack();
 qadiag.setVisible(true);

  
  
  } 
          
  private void showYippee() {
      
      JDialog ypdiag= new JDialog();
      JPanel ypanel=new JPanel(new GridBagLayout()  ) ;
      JLabel lab=new JLabel("Yippee. We are happy to have you in the community. \n Press \"Continue\" "
      +"to register or \"X\" to close this app. "      
      
      );
      JButton cont=new JButton("Continue"  ); 
      GridBagConstraints c=new GridBagConstraints();
      c.gridx=0;
      c.gridy=0;
      c.gridwidth=2;
      c.gridheight=2;
      ypanel.add(lab, c);
      c.gridx=1;
      c.gridy=2;
      c.gridwidth=1;
      c.gridheight=1;
      c.insets=new Insets(10,0,0,0);
      c.anchor=GridBagConstraints.EAST; 
      
      
     
      ypanel.add(cont, c);
      
      
      cont.addActionListener(e->{
      showMainPage(GUILoad.REGISTER);
      
      }     );
      
      ypdiag.addPropertyChangeListener("displayable"  , (e->{
      if(! ypdiag.isDisplayable())    
      System.exit(0);
      }   )  );
      ypdiag.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      ypdiag.setContentPane(ypanel);
      ypdiag.pack();
      ypdiag.setVisible(true);
      
      
      
      
      
      
      
              }

    public void showMainPage(int op, Properties props) {
        
        
        
        
        }
    
    
    
    
    private void registerMe(){
    JFrame regFrame=new JFrame();
    regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    regFrame.getContentPane().setLayout(gb);
    
    //Prepare JComponents for display
    
    JLabel email=new JLabel("E-mail: " );
    JLabel username= new JLabel("Username: "  );
    JLabel password=new JLabel("Password: "  );
    JLabel cpassword=new JLabel("Confirm password:  "  );
    
    
    
    }
  
  private JMenuBar giveBar(){
  JMenuBar bar=new JMenuBar();
  JMenu menu= new JMenu("Menu" );
  
      
      
      
      
      
  return bar;
  } 
  

  void setMap(Map map){
  this.list=null;
  this.list=map;
  }  

  
  
  Object getObject(String key ){
 return list.get(key) ;
  
  } 
  
    
}
