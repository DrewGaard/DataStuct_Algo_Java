package ds.graph;

import java.util.ArrayList;

public class Graph {
	private int vCount;
	private int eCount;
	
	private ArrayList[] adjacents;
	
	public Graph(int vCount) {
		this.vCount = vCount;
		this.eCount = 0;
		adjacents = new ArrayList [vCount];
		
		for(int i = 0; i < vCount; i++) {
			adjacents[i] = new ArrayList<Integer>();
		}
	}
	
	public int getVertexCount() {
		return vCount;
	}
}
