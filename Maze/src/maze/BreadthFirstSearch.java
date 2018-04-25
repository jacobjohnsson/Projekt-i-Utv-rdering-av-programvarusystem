package maze;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeMap;

public class BreadthFirstSearch extends MazeRunner {
	private Set<TreeCell> closedSet;
	private Set<TreeCell> openSet;
	private List<TreeCell> graph;

	public BreadthFirstSearch(){
		super();
		closedSet = new HashSet<TreeCell>();
		openSet = new HashSet<TreeCell>();
		graph = new LinkedList<TreeCell>();
	}

	@Override
	public void solve(Maze maze) {
		// TODO Auto-generated method stub

	}

	@Override
	public int nrOfVisitedNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

}
