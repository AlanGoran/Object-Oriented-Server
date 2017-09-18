import java.util.ArrayList;


class Model {
	ArrayList<Figure> allFigures;
	
	public Model(){
		allFigures = new ArrayList<Figure>();
	}
	
	public void addFigure(Figure f){
		allFigures.add(f);
	}

	public void addFigure(Object p) {
		allFigures.add( (Figure) p);
		
	}

}
