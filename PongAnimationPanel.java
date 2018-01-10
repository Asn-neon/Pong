import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class PongAnimationPanel extends JPanel{
  //Properties
  int intRect1X = 100;
  int intRect1Y = 300;
  int intRect2Y = 300;
  int intRect2X = 1100;
  int intBallX = 0;
  int intBallY = 0;
  int intBallXdelta = 3;
  int intBallYdelta = 3;
  
  //Methods
  public void paintComponent(Graphics g){
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 1200, 650);
    g.setColor(Color.WHITE);
    g.fillRect(intRect1X, intRect1Y, 50, 100);
    g.setColor(Color.WHITE);
    g.fillRect(intRect2X, intRect2Y, 50, 100);
    g.fillOval(intBallX, intBallY, 50, 50);
    intBallX = intBallX + intBallXdelta;
    intBallY = intBallY + intBallYdelta;
    if(intBallX > 1100 || intBallX < 0){
      intBallXdelta = -1*intBallXdelta;
    }
    if(intBallY > 580 || intBallY < 0){
      intBallYdelta = -1*intBallYdelta;
    }
  }
  
  //Constructor
  public PongAnimationPanel(){
    super();
  }
}
