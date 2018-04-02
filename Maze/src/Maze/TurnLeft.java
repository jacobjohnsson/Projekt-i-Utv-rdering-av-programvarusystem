package Maze;

import java.util.Stack;

public class TurnLeft implements IMazeRunner{
	private int count;

	public TurnLeft() {
		count = 0;
	}

	@Override
  public void solve(Maze maze){
    System.out.println("Not yet implemented!");
  }

  @Override
  public int nrOfVisitedNodes() {
  	return count;
  }

  public void solvePrinting(Maze maze){
    int heading = 2;
    int turn = 1;


    boolean complete = false;

    Stack<Cell> stack = new Stack<Cell>();
    Cell current = maze.getStartCell().getNeighbours()[2];

    if (current == null) {
      return;
    }

    while (!complete) {
      //maze.print();
      System.out.println(current);

      stack.push(current);
      count++;

      current.setVisited(true);

      if (current.equals(maze.getEndCell())) {
        complete = true;
        System.out.println("SOLVED!");
        return;
      }

      Cell[] neighbours = current.getNeighbours();

      if (neighbours[Math.floorMod(heading - turn, 4)].isWall() == false) {
        heading = heading - turn % 4;
        current = neighbours[heading];
      } else if (neighbours[(heading) % 4].isWall() == false) {
        current = neighbours[heading];
      } else if (neighbours[(heading + turn) % 4].isWall() == false) {
        heading = (heading + turn) % 4;
      } else if (neighbours[(heading + 2) % 4].isWall() == false) {
        heading = (heading + 2) % 4;
        current = neighbours[heading];
      }
    }


  }


}
