import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


class Mus extends JFrame implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	int numberOfClicks=1;
    int x=0;
    int y=0;
    int m=0;
    int k=0;
    
    int h=0;
    int j=0;
    
    Model model;
    Client c;
    static String function= "Rectangle";
    static Button buttonObject = new Button();
    
    public Mus(Model m, Client c){
    	super("Client");	
    	model=m;
    	this.c=c;
    
    	setVisible(true);
    	setSize(650,300);
    	setLayout(new FlowLayout(FlowLayout.CENTER));

       	add(buttonObject);
    	addMouseListener(this);
    	addMouseMotionListener(this);
    	
    	    }
    
    public void mouseExited(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    
    public void mouseClicked(MouseEvent me){
		Graphics g =getGraphics();  
		if(numberOfClicks%2!=0){
		    x=me.getX();
		    y=me.getY();
		    g.fillOval(x,y,1,1);
		    numberOfClicks++;	
	    }
		else{
		    m=me.getX();
		    k=me.getY();		   
		    Figure f  = null;
		    
		    if (Mus.function == "Rectangle"){
	        	f= new Rectangle(new Coordinates(m,k),new Coordinates(x,y));
	        	model.addFigure(f);
	        	}
			else if(Mus.function == "Square"){
				f= new Square(new Coordinates(m,k),new Coordinates(x,y));
				model.addFigure(f);
	        	}
			else if(Mus.function == "Circle"){
				f= new Circle(new Coordinates(m,k),new Coordinates(x,y));
				model.addFigure(f);
	        	}
			else if(Mus.function  == "Oval"){
				f= new Oval(new Coordinates(m,k),new Coordinates(x,y));
				model.addFigure(f);
	        	}
			else if(Mus.function == "Line"){
				f= new Line(new Coordinates(m,k),new Coordinates(x,y));
				model.addFigure(f);  
	        	}
			else if (Mus.function == "Erase"){
				model.allFigures=removeFig(new Coordinates(x,y));
				}
		    
		    c.sendObject(f);
		    drawAllFigures();
		    numberOfClicks=1;

			}
    }
    
    public ArrayList removeFig(Coordinates p){
    	List<Figure> copy = new ArrayList<Figure>(model.allFigures);
    	for(Figure f:model.allFigures) {  		
    	    if(f.isInside(p)) {                
    	        copy.remove(f);
    	    }       	
    	}
    	model.allFigures = new ArrayList<Figure>(copy);
    	return model.allFigures;
//	    for(Figure f:model.allFigures){
//	    	if(f.isInside(p)){
//	    		model.allFigures.remove(f);
//	    		System.out.println("removed");
//	    		break;
//	    	}
//	    	else
//	    		System.out.println("NOT removed");
//    	}
    }
    
    public void drawAllFigures(){
    	Graphics g = getGraphics();
    	super.paintComponents(g);
    	for(Figure f:model.allFigures){
    		f.draw(g);
    	}
    }
    
    public void mouseReleased(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseMoved(MouseEvent me){}
    public void mouseDragged(MouseEvent me){}
}
