package maze;

import java.util.ArrayList;
import java.util.Stack;

public class TurnLeft implements IMazeRunner{
	private int count;

	public TurnLeft() {
		count = 0;
	}

	@Override
  public void solve(Maze maze){
    int heading = 2;
    int turn = 1;

    boolean complete = false;

    Stack<Cell> stack = new Stack<Cell>();
    Cell current = maze.getStartCell().getOneStepNeighboursArray()[2];

    if (current == null) {
      return;
    }

    while (!complete) {
      //maze.print();
      System.out.println(current);

      stack.push(current);
      count++;
      System.out.println(count);

      current.setVisited(true);

      if (current.equals(maze.getEndCell())) {
        complete = true;
        System.out.println("SOLVED!");
        return;
      }

      Cell[] neighbours = current.getOneStepNeighboursArray();

      
      if (neighbours[Math.floorMod(heading - turn, 4)].isWall() == false) {
        heading = Math.floorMod(heading - turn, 4);
        current = neighbours[Math.floorMod(heading, 4)];
      } else if (neighbours[Math.floorMod(heading, 4)].isWall() == false) {
        current = neighbours[Math.floorMod(heading, 4)];
      } else if (neighbours[Math.floorMod(heading + turn, 4)].isWall() == false) {
        heading = Math.floorMod(heading + turn, 4);
      } else if (neighbours[Math.floorMod(heading + 2, 4)].isWall() == false) {
        heading = Math.floorMod(heading + 2, 4);
        current = neighbours[heading];
      }
    }
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
    Cell current = maze.getStartCell().getOneStepNeighboursArray()[2];

    if (current == null) {
      return;
    }

    while (!complete) {
      //maze.print();
      System.out.println(current);

      stack.push(current);
      count++;
      System.out.println(count);

      current.setVisited(true);

      if (current.equals(maze.getEndCell())) {
        complete = true;
        System.out.println("SOLVED!");
        return;
      }

      Cell[] neighbours = current.getOneStepNeighboursArray();

      
      if (neighbours[Math.floorMod(heading - turn, 4)].isWall() == false) {
        heading = Math.floorMod(heading - turn, 4);
        current = neighbours[Math.floorMod(heading, 4)];
      } else if (neighbours[Math.floorMod(heading, 4)].isWall() == false) {
        current = neighbours[Math.floorMod(heading, 4)];
      } else if (neighbours[Math.floorMod(heading + turn, 4)].isWall() == false) {
        heading = Math.floorMod(heading + turn, 4);
      } else if (neighbours[Math.floorMod(heading + 2, 4)].isWall() == false) {
        heading = Math.floorMod(heading + 2, 4);
        current = neighbours[heading];
      }
    }


  }


}
