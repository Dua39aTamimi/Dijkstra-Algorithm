package application;

public class Vertix {
	double x;
	double y;
	boolean isVisited;
	double pathFromSource;
	String name;
	int index;
	String indexSource;
	public Vertix(int index,String name,double x, double y) {
		this.index = index;
		this.name = name;
		this.x = x;
		this.y = y;
		this.isVisited = false;
		this.pathFromSource = Double.POSITIVE_INFINITY;
		this.indexSource = "";
	}
	
	@Override
	public String toString() {
		return "Vertix [x=" + x + ", y=" + y + ", isVisited=" + isVisited + ", pathFromSource=" + pathFromSource
				+ ", name=" + name + ", index=" + index + ", indexSource=" + indexSource + "]";
	}
	
	
}