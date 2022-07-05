import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GuessNumber
{
   public static void main(String args[])
     {
       Test obj=new Test();
     }
}

class Test extends JFrame implements ActionListener
{
  JLabel l1,l2,l3,l4;
  JTextField t1,t2,t3;
  JButton b1,b2,b3;
  Random randI = new Random();
  int myRandInt = randI.nextInt(100)+1;
  int i=0,round=1;
  public Test()
   {

     setLayout(null);	
	 JLabel welcomeMsg = new JLabel("Guess the Number If you can!!!!!");
     welcomeMsg.setBounds(420,100,800,80);
     welcomeMsg.setFont( new Font("Serif",Font.PLAIN,60));
	 welcomeMsg.setForeground(Color.GREEN);

     setLayout(null);
         JLabel welcomeMsg2 = new JLabel("You Have 10 Attempts to Guess!!!");
     welcomeMsg2.setBounds(420,350,850,80);
     welcomeMsg2.setFont( new Font("Serif",Font.PLAIN,60));
	 welcomeMsg2.setForeground(Color.BLUE);
     Font font1 = new Font("SansSerif", Font.BOLD, 25);
     
     l1=new JLabel("Guess the number(1-100) : ");
     l1.setBounds(380,200,400,40);
     l1.setFont( new Font("Serif",Font.ITALIC,30));
	 
     t1=new JTextField(20);
     t1.setBounds(720,200,300,40); 
     t1.setFont(font1);
     
     l2=new JLabel("The number you entered is: ");
     l2.setBounds(380,250,400,40);
     l2.setFont( new Font("Serif",Font.ITALIC,30));
     
     t2=new JTextField(20);
     t2.setBounds(720,250,300,40);
     t2.setFont(font1); 
     
     b1=new JButton("TRY");
     b1.setBounds(720,300,140,50);
     b1.setFont(new Font("Dialog", Font.BOLD, 25));
 
     b2=new JButton("CLEAR");
     b2.setBounds(880,300,140,50);
     b2.setFont(new Font("Dialog", Font.BOLD, 25));
	
	 b3=new JButton("NEXT ROUND");
     b3.setBounds(720,450,300,40);
     b3.setFont(new Font("Dialog", Font.BOLD, 25));
		
	 l3=new JLabel();
     l3.setBounds(440,370,600,40);
     l3.setFont( new Font("SansSerif", Font.BOLD, 25));

	 t3=new JTextField(20);
     t3.setBounds(1030,200,50,40);
     t3.setFont(font1);
		
	 l4=new JLabel("ROUND 1");
     l4.setBounds(660,40,300,40);
     l4.setFont(new Font("Serif",Font.BOLD,30));
	 l4.setForeground(Color.RED);

     
	
     add(t1);
     add(t2);
     add(t3);
     add(b1);
     add(b2);
     add(b3);
	 add(l1);
	 add(l2);
	 add(l3);   
	 add(l4);
     add(welcomeMsg);
     

     
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	add(welcomeMsg2);
     setVisible(true);
     setSize(1650,1080);

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  void number(int user)
  {
	   i++;
	   t3.setText(Integer.toString(i));
	   if(i>10)
	   {
			l3.setText("SORRY! You have reached maximum attempts");
			l3.setForeground(Color.RED);
			return;
	    }
        if( user < 1 || user > 100) t2.setText("Invalid");
        else if ( user > myRandInt ) 
        {
            if(user-myRandInt>10) t2.setText("too high");
            else t2.setText("little high");
        }
        else if ( user < myRandInt ) 
        {
            if(myRandInt-user<10) t2.setText("little low");
            else t2.setText("too low");
        }
        else if(user==myRandInt)
	    { 
			t2.setText("MATCHED");
			String sc = Integer.toString(110-i*10);
			l3.setText("CONGRATS! YOU WON...YOUR SCORE IS "+sc);
			l3.setForeground(Color.GREEN);
        }
   }
   public void actionPerformed(ActionEvent ae)
   {	
	  if(ae.getSource() == b1)
      {
		int user = Integer.parseInt(t1.getText());
     	number(user);
      }
      else if(ae.getSource() == b2)
	  {
		t1.setText("");
		t2.setText("");
      }
	  else if(ae.getSource() == b3)
	  {
		t1.setText("");
	    t2.setText("");
		t3.setText("");
		i=0;
		l3.setText("");
		l4.setText("ROUND "+Integer.toString(round+1));
		myRandInt = randI.nextInt(100)+1;
		round++;
      }
   }
}