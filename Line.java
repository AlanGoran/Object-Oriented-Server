import java.awt.Graphics;
import java.io.Serializable;


public class Line extends Figure implements Serializable{
	
	private int x;
	private int y;
	private int m;
	private int k;
	Coordinates p1, p2;
	
	public Line(Coordinates p1, Coordinates p2) {
		super(p1, p2);
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}

	@Override
	public boolean isInside(Coordinates p) {
		int x= p1.x<p2.x?p1.x:p2.x;
		int y= p1.y<p2.y?p1.y:p2.y;
		int m= p1.x>p2.x?p1.x:p2.x;
		int k=p1.y>p2.y?p1.y:p2.y;
		if(x-10 <= p.x && p.x <= m+10 && y-10 <= p.y && p.y <= k+10 ){
			return true;
			}
		else 
			return false;
	}
	

}
