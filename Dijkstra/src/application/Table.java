package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {
	 Graph[] graph;
	 ArrayList<Vertix> edge = new ArrayList<>();

	

	public void setGraph(String fileName) {
		File file = new File(fileName);
		int a = 0;
		try {
			Scanner in = new Scanner(file);
			a = Integer.parseInt(in.nextLine());
			graph = new Graph[a];
			int i = 0;
			while (in.hasNext()) {
				String[] line = in.nextLine().split(",");
				if (line.length == 4) {

					graph[i] = new Graph();
					double x= Double.parseDouble(line[2]);
					double y =Double.parseDouble(line[3]);
					graph[i].source = new Vertix(Integer.parseInt(line[0]),line[1],x, y);
					//System.out.println(graph[i].source);
					i++;
				} else if (line.length == 0) {
					continue;
				} else if (line.length == 2) {
					Edges edge = new Edges(graph[Integer.parseInt(line[1])].source.x,
							graph[Integer.parseInt(line[1])].source.y, Integer.parseInt(line[1]));
					edge.setPath(graph[Integer.parseInt(line[0])].source);
					graph[Integer.parseInt(line[0])].edge.add(edge);
					//System.out.println(graph[Integer.parseInt(line[0])].edge.toString());
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void dijkstra(int start , int e) {
		Vertix end = graph[e].source;
		graph[start].source.isVisited = true;
		graph[start].source.pathFromSource = 0;
		int i=start;
		
		int ind = 0 ;
		while(!end.isVisited) {
			double min = Double.POSITIVE_INFINITY;
			graph[i].source.isVisited = true;
			
			int size = graph[i].edge.size();
			int j = 0;
			while(j < size) {
				
				Edges ed = graph[i].edge.get(j);
				double path =ed.path +graph[i].source.pathFromSource;
				if(graph[ed.index].source.pathFromSource>path) {	
					graph[ed.index].source.pathFromSource = path;
					graph[ed.index].source.indexSource = i+"";
				}else if(graph[ed.index].source.pathFromSource<path) {
					graph[ed.index].source.pathFromSource = graph[ed.index].source.pathFromSource;
				}
				
				
				j++;
			}
			for(int c =0;c<graph.length;c++) {
				//System.out.println(graph[c].source);
				if(!graph[c].source.isVisited) {
					if(graph[c].source.pathFromSource < min ) {
						min = graph[c].source.pathFromSource;
						//System.out.println(min);
						ind =c;
					
					}
				}
				
			}
			i = ind;
			
			
			
		}
		
		
	}
	public  int getVertix(int start,int end) {
		if(end==start) {
			edge.add(graph[end].source);
			return 0;
		}else {
			//System.out.println(graph[end].source);
			edge.add(graph[end].source);
			
			return getVertix(start, Integer.parseInt(graph[end].source.indexSource));
		}
	}
	

}
