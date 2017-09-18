import java.awt.Graphics;
import java.io.Serializable;


class Coordinates implements Serializable{

	private static final long serialVersionUID = 1L;
	int x,y;
    
    public Coordinates(int x, int y){
    	this.x=x;
    	this.y=y;
    }
}

public abstract class Figure implements FigureInterface, Serializable{
	Coordinates p1,p2;
	
	public Figure(Coordinates p1, Coordinates p2){
//		this.func=function;
		this.p1=p1;
		this.p2=p2;
	 }}

	 /*public void co(Graphics g){
			if (Mus.function == "Rectangle"){
	        	Rectangle r= new Rectangle(p1,p2);
	        	r.draw(g);}
			else if(Mus.function == "Square"){
				Square s= new Square(p1,p2);
	        	s.draw(g);}
			else if(Mus.function == "Circle"){
				Circle c= new Circle(p1,p2);
	        	c.draw(g);}
			else if(Mus.function  == "Oval"){
				Oval o= new Oval(p1,p2);
	        	o.draw(g);}
			else if(Mus.function == "Line"){
				Line l= new Line(p1,p2);
	        	l.draw(g);} 
	 }

}
	 /*public void drawR(Graphics g){
		int x= p1.x<p2.x?p1.x:p2.x;
		int y= p1.y<p2.y?p1.y:p2.y;
		int m= p1.x>p2.x?p1.x:p2.x;
		int k= p1.y>p2.y?p1.y:p2.y;
		g.drawRect(x,y,m-x,k-y);
	 }
	 public void drawS(Graphics g){
			int x= p1.x<p2.x?p1.x:p2.x;
			int y= p1.y<p2.y?p1.y:p2.y;
			int m= p1.x>p2.x?p1.x:p2.x;
			int k= p1.y>p2.y?p1.y:p2.y;
			g.drawRect(x,y,m-x,m-x);
	 }
	 public void drawC(Graphics g){
			int x= p1.x<p2.x?p1.x:p2.x;
			int y= p1.y<p2.y?p1.y:p2.y;
			int m= p1.x>p2.x?p1.x:p2.x;
			int k= p1.y>p2.y?p1.y:p2.y;
			g.drawOval(x,y,(m-x),(m-x));
	 }
	 public void drawO(Graphics g){
			int x= p1.x<p2.x?p1.x:p2.x;
			int y= p1.y<p2.y?p1.y:p2.y;
			int m= p1.x>p2.x?p1.x:p2.x;
			int k= p1.y>p2.y?p1.y:p2.y;
			g.drawOval(x,y,(m-x)/2,(k-y));
	 }
	 public void drawL(Graphics g){
			int x= p1.x<p2.x?p1.x:p2.x;
			int y= p1.y<p2.y?p1.y:p2.y;
			int m= p1.x>p2.x?p1.x:p2.x;
			int k= p1.y>p2.y?p1.y:p2.y;
			g.drawLine(x, y, m, k);
	 }
	 
	 public void erase(Graphics g){
		 
		 
	 }
	    

} */
