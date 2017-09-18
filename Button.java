import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class Button extends JPanel implements ActionListener{
	
	JButton button1,button2,button3,button4,button5,button6;
	
	Button(){
		setPreferredSize(new Dimension(650,50));
		
		button1 = new JButton("Rectangle");
		button2 = new JButton("Square");
		button3 = new JButton("Oval");
		button4 = new JButton("Circle");
		button5 = new JButton("Line");
		button6 = new JButton("Erase");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)
			Mus.function = "Rectangle";
		else if(e.getSource()==button2)
			Mus.function = "Square";
		else if(e.getSource()==button3)
			Mus.function = "Oval";
		else if(e.getSource()==button4)
			Mus.function = "Circle";
		else if(e.getSource()==button5)
			Mus.function = "Line";
		else if(e.getSource()==button6){
			Mus.function = "Erase";
		}
	
	}
}