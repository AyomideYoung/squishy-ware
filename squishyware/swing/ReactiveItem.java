package squishyware.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;



public class ReactiveItem extends JLabel{
	
	private boolean firstExecution=true;
	private Color focusedColor=Color.white;
	private Color clickedColor=Color.white;
	private Color color=Color.white;
	private List<ActionListener> actionListeners = new ArrayList<>(); 
	
	private int id=0;
	private String command=null;
	
	
	public ReactiveItem(){
		super();
		setOpaque(true);
		
	}
	
	public ReactiveItem(Icon icon ){
		super(icon);
		setOpaque(true);	
	}
	
	public ReactiveItem(String str ){
		super(str);
		setOpaque(true);
	}
	
	public ReactiveItem(String str,Icon icon,int orientation ){
		super(str,icon,orientation);
		setOpaque(true);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(firstExecution){
			this.addMouseListener(new ReactiveItemListener());
			firstExecution=false;
		} 	
	}
	
	public void setClickedColor(Color color){
		clickedColor=color;
		}	
		
	public void setNormalColor(Color color ){
		this.color=color;
	}
	

	public void setFocusedColor(Color color){
		focusedColor=color;
	}
	
	public void setColors(Color color,Color focusedColor,Color clickedColor ){
		this.color=color;
		this.focusedColor=focusedColor;
		this.clickedColor=clickedColor;
		setBackground(color);		
	}
		
	
	public void fireActionEvent(){
		
		for(ActionListener l:actionListeners){
			
			if(l==null)
				continue;
		
		l.actionPerformed(new ActionEvent(this,id,command)); 
	
		}		
		
		
	}	

	public void addActionListener(ActionListener listener ){
		actionListeners.add(listener);
		
	}
	
	public void  removeActionListener(ActionListener a ){
		
		actionListeners.remove(a);
		
	}
	
	public ActionListener[] getActionListeners(){
		
		return (ActionListener[]) actionListeners.toArray();
	}
		
	public void setID(int id){
		this.id=id;
	}
	
	public int getID(){
		return id;
	}
	
	
	public Dimension getPreferredSize(){
		return super.getPreferredSize();
		}     
	
	public void setActionCommand(String command){
		this.command=command;
	}
	
	public String getActionCommand(){
		return this.command;
	}
	
	
	
	class ReactiveItemListener extends MouseAdapter{
	
	public void mouseEntered(MouseEvent e ){
		setBackground(focusedColor);	
		
		}
		
	public void mouseExited(MouseEvent e){
		setBackground(color);
		
		}
	public void mouseClicked(MouseEvent e){
		setBackground(clickedColor);
		
		fireActionEvent();
		
		
	}	
	
	}
	}