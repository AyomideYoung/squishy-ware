package squishyware.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


 /*
  * To every programmer, developer and hacker who reviews
  * my code or uses it as a reference.
  * I'm sorry for any inconvinience that results from any use of this code 
  * I appreciate your use of this code and I am very much grateful to you.  
  *	I am a student, an high school student actually, and I don't have much 
  *	experience in coding and programming. This is actually my first serious program  
  * and even I expect myself to make mistakes.
  * So I apologize in advance for any discomfort.    
  *
  *
  *
  *
  *
  */



public class EditorUI extends JComponent {
	
	private Dimension preferredSize = null; 
	private int x=30;
	private int y=30;
	
	private Insets margin;
	
	private int width = this.getParent().getWidth();
	private int height = this.getParent().getHeight();
	private JPanel actionTray= new JPanel(new FlowLayout());
	
	private ImageIcon minimizeIcon=SquishyWare.getDefaultMinimizeIcon() ;
	private ImageIcon maximizeIcon=null;
	private ImageIcon closeIcon=null;
	
	private ReactiveItem minimizeButton=null;
	private ReactiveItem maximizeButton=null;
	private ReactiveItem closeButton=null;
	
	private JTextPane textPane=new SquishBalloon().getTextPane();
 	private JScrollPane textScrollPane=new JScrollPane(textPane);
	
	private JPanel buttonPanel=populateButtonPanel();
	private JPanel shapePanel=shapeEditorUI();
	
	private String state=null;

	private static final String NORMAL = "Normal";
	private static final String MINIMIZED = "Minimized";
	private static final String MAXIMIZED = "Maximized";	
	private static final String CLOSED = "Closed";	
	
	
	
	
	
	public void setPreferredSize(Dimension size){
		preferredSize=size;
	}	
	
	public Dimension getPreferredSize(){
		return preferredSize;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		
		JComponent parent=(JComponent) EditorUI.this.getParent();
		
		if(state.equals(NORMAL)){
			
			//overshadowing x and y
			int x=parent.getX();
			int y=parent.getY();
			
			//overshadowing width and height
			int width=parent.getWidth();
			int height=parent.getHeight()/3;
			
			RoundRectangle2D rect= new RoundRectangle2D.Float((float)x,(float)y,(float)width,
			(float)height,5.0f,5.0f	);
		
			g2d.fill(rect);
		
			shapePanel.setLocation(x+5,y+5 );
			shapePanel.setSize(width-5,height-5);
		
			shapePanel.paintComponents(g);
			
		} else if(state.equals(MINIMIZED)){
			
			float minimizedY= (float) this.getParent().getY()-64;
			int width=parent.getWidth();
			
			RoundRectangle2D rect = new RoundRectangle2D.Float((float)x, minimizedY,(float)width,
			128.0f,10.0f,10.0f);	

			JLabel msgLabel = new JLabel("Message",SquishyWare.getDefaultMessageIcon());
			msgLabel.setLocation(x+10,(int)minimizedY+(64/3));//y=middle of minimized ui or so thereof
			
			ReactiveItem closeButton=new ReactiveItem(closeIcon);
			closeButton.setColors(new Color(0,0,0,0.0f),Color.red,Color.red );
		
			/*
				First argument determines button's x location in editor.
				The editor's location on screen plus its width minus button size and roundrect arc width
				gives the button space to draw itself on the editor.
		 
				Second argument determines	button's y location in editor.
				The editor's location on screen minus just 2 pixels to give space 
				between the edge and button 
			*/
		
			closeButton.setLocation(x+width-(32+10),y-2);
			closeButton.setSize(32,32);
		
				
		  
		  
			closeButton.paintComponent(g);
		  
			//listener
			g2d.fill(rect);
			msgLabel.paintComponents(g);	
			
		} else if(state.equals(MAXIMIZED)){
			
						
			int maxX = parent.getX();
			int maxY = parent.getY();
			
			RoundRectangle2D rect= new RoundRectangle2D.Float((float)maxX,(float)maxY,(float)parent.getWidth(),
			(float)parent.getHeight(),5.0f,5.0f	);
			
			g2d.fill(rect);
			
			JPanel actionTray = new JPanel();
			
			ReactiveItem closeButton = new ReactiveItem(closeIcon);
			closeButton.setPreferredSize(new Dimension(32,32));
			
			ReactiveItem minimizeButton = new ReactiveItem(minimizeIcon);
			minimizeButton.setPreferredSize(new Dimension(32,32));
			
			actionTray.setPreferredSize(new Dimension(68,32));
			
			actionTray.add(minimizeButton);
			actionTray.add(closeButton);
			actionTray.setLocation((maxX+parent.getWidth())-75,maxY+5 );
			
			shapePanel.setLocation(maxX+5,maxY+37 );
			shapePanel.setSize(parent.getWidth()-10,parent.getHeight()-10);
		
			actionTray.paintComponents(g);
			shapePanel.paintComponents(g);
		
		
		} else {
			
			//state is closed
			//do nothing.
			
		}
		
		
	}
	
	public void setLocation(int x,int y){
		this.x=x;
		this.y=y;
	}	
	
	public void setLocation(Point2D point){
		this.x=(int) point.getX();
		this.y=(int)point.getY();
	}
		
	public Point getLocation(){
		return new Point(x,y); 
	}
		
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
		
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
        @Override
	public int getWidth(){
		return width;
	}
	
        @Override
	public int getHeight(){
		return height;
	}
	
	public Insets getMargin(){
		return this.margin;
	}
	
	public void setMargin(Insets in){
	this.margin=in;	
	}
	
	private JPanel shapeEditorUI(){
		
		JPanel shapePanel= new JPanel(new GridBagLayout() );
		GridBagConstraints c = new GridBagConstraints();
		
		
		minimizeButton= new ReactiveItem(minimizeIcon);
		maximizeButton= new ReactiveItem(maximizeIcon);
		closeButton= new ReactiveItem(closeIcon);
		
		minimizeButton.setPreferredSize(new Dimension(32,32));
		maximizeButton.setPreferredSize(new Dimension(32,32) );
		closeButton.setPreferredSize(new Dimension(32,32));
		
		minimizeButton.addMouseListener(new MinimizeButtonListener());
		/*
		*listener
		*listener
		listener
		*
		*/
		
		
		actionTray.add(minimizeButton);
		actionTray.add(maximizeButton);
		actionTray.add(closeButton);
		
		c.gridx=1;
		c.gridy=0;
		c.anchor=GridBagConstraints.FIRST_LINE_END;
		
		shapePanel.add(actionTray,c);
		
		
		
		
		
		textPane.setEditable(true);
		textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
		
		
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, textScrollPane,buttonPanel) ;
		
		c.gridx=0;
		c.gridy=1;
		c.anchor=GridBagConstraints.CENTER;
		c.gridwidth=2;
		c.ipadx=5;
		c.ipady=5;
		
		
		shapePanel.add(splitPane,c);
		
		
		ReactiveItem sendButton=new ReactiveItem(SquishyWare.getDefaultSendIcon() );
		sendButton.setColors(Color.green.brighter(),Color.green,Color.green.darker() );
		//listener
		c.gridx=1;
		c.gridy=2;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.LINE_END;
		c.ipady=5;
		c.fill=GridBagConstraints.BOTH;
 		
		shapePanel.add(sendButton,c);
		
		return shapePanel;
		}	


	private Shape testShape(){
		Arc2D arc= new Arc2D.Float((float)x,(float)y,30.0f,30.0f,180.0f,-90.0f,Arc2D.OPEN );
		
		return arc;
	}
	
	private JPanel populateButtonPanel(){
		JPanel tempButtonPanel=new JPanel(new GridLayout(3,3) );
	
		ReactiveItem addCodeButton = new ReactiveItem(SquishyWare.getDefaultAddCodeIcon() );
		addCodeButton.setToolTipText("Add a code segment" );
		addCodeButton.setColors(Color.white,Color.pink,Color.red );
		//listener
	
		tempButtonPanel.add(addCodeButton);
	
		ReactiveItem addImageButton = new ReactiveItem(SquishyWare.getDefaultAddImageIcon());
		addImageButton.setToolTipText("Add an image");
		addImageButton.setColors(Color.white,Color.pink,Color.red );
		//listener
	
		tempButtonPanel.add(addImageButton);
	
		ReactiveItem addArbitraryFile = new ReactiveItem(SquishyWare.getDefaultRandomFileIcon());	
		addArbitraryFile.setToolTipText("Add a file");
		addArbitraryFile.setColors(Color.white,Color.pink,Color.red );
		//listener
	
		tempButtonPanel.add(addArbitraryFile);
	
		ReactiveItem addSmileyButton= new ReactiveItem(SquishyWare.getDefaultSmileyIcon() );
		addSmileyButton.setToolTipText("Add a smiley" );
		addSmileyButton.setColors(Color.white,Color.pink,Color.red );
		//listener
	
		tempButtonPanel.add(addSmileyButton);
	
		ReactiveItem addLinkButton =new ReactiveItem(SquishyWare.getDefaultLinkIcon());
		addLinkButton.setToolTipText("Add a link");
		addLinkButton.setColors(Color.white,Color.pink,Color.red );
		//listener
	
		tempButtonPanel.add(addLinkButton);
	
		ReactiveItem addReferenceButton= new ReactiveItem(SquishyWare.getDefaultReferenceIcon());
		addReferenceButton.setToolTipText("Add reference. E.g previous questions, posts, articles e.t.c");
		addReferenceButton.setColors(Color.white,Color.pink,Color.red );
		//listener
	
		tempButtonPanel.add(addReferenceButton);
	
		return tempButtonPanel;
	}	
	
	
	
	public void setState(String state){
		
		switch(state){
			case EditorUI.NORMAL:{ 
				this.state=state;
				break;
			}
			case EditorUI.MINIMIZED:{ 
				this.state=state;
				break;
			}
			case EditorUI.MAXIMIZED:{
				this.state=state;
				break;
			}
			case EditorUI.CLOSED:{
				this.state=state;
				break;
			}
		
			default:{
				throw new IllegalArgumentException();
			}		
		}
		
	}
	
	public String getState(){
		return this.state;
	}


	public void minimize(){
		setState(MINIMIZED);
	}
	
	
	public void maximize(){
		setState(MAXIMIZED);
	}
	
	public void close(){
		setState(CLOSED);
	}	
	
	public JPanel getReferencePanel(){
		JPanel pane= new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		/*
		* the pane variable uses two text fields 
		* One for the text to be painted as link
		* and the other for the id of the question.
		*/		
		JTextField field = new JTextField();	
		JTextField idField = new JTextField();
		JLabel textLabel = new JLabel("Text: ");	
		JLabel idLabel = new JLabel("Question ID: ");		
		ReactiveItem back = SquishyWare.getDefaultBackItem();
		
		//button to carry out action
		
		JButton submit = new JButton("OK");

		//code for creation of panel
		
		c.gridx=0;
		c.gridy=0;
		c.insets= new Insets(5,5,5,5);
		
		back.addActionListener(new BackActionListener() );
		pane.add(back,c);
		
		c.gridx=0;
		c.gridy=1;
		
		textLabel.setLabelFor(field);
		pane.add(textLabel,c);
		
		c.gridx=1;
		c.gridwidth=2;
		
		pane.add(field,c);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		
		idLabel.setLabelFor(idField);
		pane.add(idLabel,c);
		
		c.gridx=1;
		c.gridwidth=2;
		
		pane.add(idField,c);
		
		c.gridy=3;
		c.gridwidth=1;
		
		
		pane.add(submit);
		
		return pane;
		}
	
	
	
	
	
	
	/*
	* Listener for the minimize button.
	*/
	
	
	
	private class MinimizeButtonListener extends MouseAdapter {
		
                @Override
		public void mouseClicked(MouseEvent e){
		EditorUI.this.minimize();	
		}
		
	}
	
	private class MaximizeButtonListener extends MouseAdapter {
		
                @Override
		public void mouseClicked(MouseEvent e){
		EditorUI.this.maximize();	
			
		}
		
	}
	
	private class CloseButtonListener extends MouseAdapter {
		
                @Override
		public void mouseClicked(MouseEvent e){
			EditorUI.this.close();	
		}
		
	}
	
	
	private class MinimizedUIClickListener extends MouseAdapter {
		
                @Override
		public void mouseClicked(MouseEvent e){
				
		} 
		
	}
	
	//Create class for back action
	private class BackActionListener implements ActionListener {
		
                @Override
		public void actionPerformed(ActionEvent e){
			buttonPanel=populateButtonPanel();
			}
		
	}
	
	
	/*
	  
	 *
	 * TODO: create method to draw send box when state is CLOSED
	 * TODO: Use BufferedImage for rendering 
	 * 
	
	*/
	
}