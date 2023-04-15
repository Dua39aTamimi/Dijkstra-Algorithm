package application;


public class Edges {
	double x ;
	double y ;
	int index;
	double path;
	
	public Edges(double x, double y, int index) {
		this.x = x;
		this.y = y;
		this.index = index;
	}
	
	public void setPath(Vertix v2) {
		double x = v2.x - this.x;
		double y = v2.y - this.y;
		double xx = Math.pow(x,2);
		double yy = Math.pow(y,2);
		double a =xx+yy;
		double path =Math.sqrt(a);
		this.path = path;
	}

	@Override
	public String toString() {
		return "edges index" +index+ ", path=" + path + "]";
	}
}
