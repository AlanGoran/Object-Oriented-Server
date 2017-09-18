import java.awt.Graphics;
import java.io.Serializable;

public class Circle extends Figure implements Serializable{
	
	private int x;
	private int y;
	private int m;
	private int k;
	Coordinates p1, p2;
	
	public Circle(Coordinates p1, Coordinates p2) {
		super(p1, p2);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public void draw(Graphics g) {
		int x= p1.x<p2.x?p1.x:p2.x;
		int y= p1.y<p2.y?p1.y:p2.y;
		int m= p1.x>p2.x?p1.x:p2.x;
		int k= p1.y>p2.y?p1.y:p2.y;
		g.drawOval(x,y,(m-x),(m-x));
	}

	@Override
	public boolean isInside(Coordinates p) {
		int x= p1.x<p2.x?p1.x:p2.x;
		int y= p1.y<p2.y?p1.y:p2.y;
		int m= p1.x>p2.x?p1.x:p2.x;
		int k=p1.y>p2.y?p1.y:p2.y;
		if(x <= p.x && p.x <= m && y <= p.y && p.y <= k ){
			return true;
			}
		else 
			return false;
	}
}
