package Maze;

public class Cell {
  private int row;								// starts at 0
  private int col;								// starts at 0
  private boolean visited;
  private boolean isWall;					// true if this cell i a wall.
  private Cell[] neighbours;			// North, East, South, West. Som en klocka!

  public Cell(int row, int col, boolean isWall){
    this.row = row;
    this.col = col;
    visited = false;
    this.isWall = isWall;
    neighbours = new Cell[4];
  }

  public boolean visited() {
    return visited;
  }
  
  public void setVisited(boolean isVisited) {
	    visited = isVisited;
	  }

  public Cell[] getNeighbours() {
    return neighbours;
  }

  public void setNeighbour(int x, Cell c) {
	  if (x >= 0 && x < 4) {
		  neighbours[x] = c;
	  } else {
		  throw new IllegalArgumentException();
	  }
  }

  public boolean isWall(){
    return isWall;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Cell) {
      Cell cell = (Cell) o;
      return row == cell.row && col == cell.col;
    }
    return false;
  }

  public String toString() {
	  StringBuilder sb = new StringBuilder();
	  
	  sb.append(row + ", " + col + '\n');

    sb.append("State: ");
    if (isWall) {
      sb.append("# ");
    } else {
      sb.append("  ");
    }

	  sb.append("Visited: ");
	  if (visited) {
      sb.append("True ");
    } else {
      sb.append("False ");
    }

    sb.append("Neighbours(N,W,S,E): ");
    for (Cell cell  : neighbours) {
      int count = 0;
      if (cell != null) {
    	  if (!cell.isWall()) {
    		  count++;
    	  }
      }
      sb.append(count);
    }

    return sb.toString();
  }
}
