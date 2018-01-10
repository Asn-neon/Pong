# Pong
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PongProGUI implements ActionListener, KeyListener{
  //Properties
  JFrame theframe;
  PongAnimationPanel thepanel;
  Timer thetimer;
  boolean blnspressed = false;
  boolean blnwpressed = false;
  boolean blnipressed = false;
  boolean blnkpressed = false;
  
  //Methods
  public void actionPerformed(ActionEvent evt){
    if(blnspressed){
      thepanel.intRect1Y = thepanel.intRect1Y + 2;
    }else if(blnwpressed){
      thepanel.intRect1Y = thepanel.intRect1Y - 2;
    }else if(blnipressed){
      thepanel.intRect2Y = thepanel.intRect2Y - 2;
    }else if(blnkpressed){
      thepanel.intRect2Y = thepanel.intRect2Y + 2;
    }
    if(evt.getSource() == thetimer){
      thepanel.repaint();
    }
  }
  public void keyReleased(KeyEvent evt){
//    System.out.println("Something was released");
    //Released only happens when a key is released
    if(evt.getKeyChar() == 's'){
      blnspressed = false;
    }else if(evt.getKeyChar() == 'w'){
      blnwpressed = false;
    }else if(evt.getKeyChar() == 'i'){
      blnipressed = false;
    }else if(evt.getKeyChar() == 'k'){
      blnkpressed = false;
    }
    thepanel.repaint();
  }
  public void keyPressed(KeyEvent evt){
    //The getKeyChar method works and returns a character
    //The getKeyCode method works and returns an integer
//    System.out.println("Something was pressed");
//    System.out.println(evt.getKeyChar());
//    System.out.println(evt.getKeyCode());
    //Pressed only happens when a key is pressed
    if(evt.getKeyChar() == 's'){
      blnspressed = true;
    }else if(evt.getKeyChar() == 'w'){
      blnwpressed = true;
    }else if(evt.getKeyChar() == 'i'){
      blnipressed = true;
    }else if(evt.getKeyChar() == 'k'){
      blnkpressed = true;
    }
  }
  public void keyTyped(KeyEvent evt){
  }
  //Constructor
  public PongProGUI(){
    thepanel = new PongAnimationPanel();
    thepanel.setPreferredSize(new Dimension(1200, 650));
    thepanel.setLayout(null);
    
    thetimer = new Timer(100/60, this);
    thetimer.start();
    
    theframe = new JFrame("Pong");
    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(true);
    theframe.addKeyListener(this); 
  }
  
  //Main Method
  public static void main(String[] args){
    PongProGUI pong = new PongProGUI();
  }
}
