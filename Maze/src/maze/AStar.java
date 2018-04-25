// Frågor? Hör med Jacob. hejhej

package maze;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class AStar {
	private boolean complete;
	private int count;
	private Set<TreeCell> closedSet;					// Alla celler som redan är besökta.
	private Set<TreeCell> openSet;						// Mängden "aktiva" celler.
	private Map<TreeCell, TreeCell> cameFrom;	// Cellens kortaste väg.
	private Map<TreeCell, Integer> gScore;		// Kostnaden från start till cellen.

	public AStar(){
		complete = false;
		count = 0;
		closedSet = new HashSet<TreeCell>();
		openSet = new HashSet<TreeCell>();
		cameFrom = new HashMap<TreeCell, TreeCell>();
		gScore = new HashMap<TreeCell, Integer>();
	}

	public void solve(TreeMaze tMaze) {
		TreeCell startCell = tMaze.getStartCell();
		TreeCell endCell = tMaze.getEndCell();

		// Totala kostnaden från start till end genom denna cell. Komparatorn jämför avståndet från startcellen och avständet till slutcellen. Innehåller endast "aktiva" celler.
		//TreeMap<TreeCell, Double> fscore =
		//	new TreeMap<TreeCell, Double> ((c1, c2) ->
		//		getHeuristicValue(c1, endCell) + gScore.get(c1) <
		//		getHeuristicValue(c2, endCell) + gScore.get(c2));


		// Lägg till startCellen i mängden "aktiva" celler.
		openSet.add(startCell);

		// Kostnaden från start till start är 0.
		gScore.put(startCell, 0);

		// Kostnaden från start till end är pyth.
		//fScore.add(startCell);

		while (!openSet.isEmpty()) {

			// Flytta rund den nuvarande cellen i alla mängder och heapar.
			//TreeCell current = fScore.poll();
			//openSet.remove(current);
			//closedSet.add(current);

			//if (current == endCell){
			//	complete = true;
			//}

			//for (TreeCell neighbour : current.getNeighbours()) {
				// if closedSet.contains(neighbour){
				//
				// }

				// Hey! Vi hittade en hittills obesökt cell!
				//if (!openSet.contains(current)) {
				//	openSet.add(neighbour);
				//}

				// Avståndet från start till denna grannen.
				//Integer tentativeGScore = gScore.get(current) + distBetween(current, neighbour);

				//if (tentativeGScore >= gScore.get(neighbour)) {
					// Då är detta in en närmare väg.
				//	continue;
				//}

				// Detta är den hittills bästa vägen till denna cellen!
				//cameFrom.put(neighbour, current);
				//gScore.put(neighbour, tentativeGScore);
				

			//}
		}

	}

	public double getHeuristicValue(TreeCell current, TreeCell endCell){
		// Pyth mellan current och endCell.
		return Math.sqrt(
						Math.pow(current.getRow() - endCell.getRow(), 2) +
						Math.pow(current.getCol() - endCell.getCol(), 2));
	}
	
	public Integer distBetween(TreeCell c1, TreeCell c2){
		return 0;
	}


	public int nrOfVisitedNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

}
