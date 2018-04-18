package Maze;


import java.util.ArrayList;
import java.util.Random;

public class Cell {
  private int row;								// starts at 0
  private int col;								// starts at 0
  private boolean visited;
  private boolean isWall;					// true if this cell i a wall.
  private Cell[] neighbours;			// North, East, South, West. Som en klocka!

  public Cell(int row, int col, boolean isWall, boolean isVisited){
    this.row = row;
    this.col = col;
    visited = isVisited;
    this.isWall = isWall;
    neighbours = new Cell[4];
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean isVisited) {
	    visited = isVisited;
	  }

  public ArrayList<Cell> getNeighbours() {
    ArrayList<Cell> neighbourList = new ArrayList<Cell>();
    for (int i = 0; i < neighbours.length; i++) {
      Cell current = neighbours[i];
      if (current != null){
        neighbourList.add(current);
      }
    }
    return neighbourList;
  }

  public void setNeighbour(int x, Cell c) {
	  if (x >= 0 && x < 4) {
		  neighbours[x] = c;
	  } else {
		  throw new IllegalArgumentException();
	  }
  }

  // returns null if no such neighbour exists.
  public Cell getRandomUnvisitedNeighbour(){
    ArrayList<Cell> unvisitedNeighbours = new ArrayList<Cell>();
    Random rnd = new Random();

    for (Cell cell : neighbours) {
      if (!cell.isVisited()) {
        unvisitedNeighbours.add(cell);
      }
    }

    if (unvisitedNeighbours.size() == 0) {
      return null;
    }

    return unvisitedNeighbours.get(rnd.nextInt(unvisitedNeighbours.size()));
  }

  public boolean isWall(){
    return isWall;
  }

  public void setWall(boolean isWall){
    this.isWall = isWall;
  }

  public int getRow(){
    return row;
  }

  public int getCol(){
    return col;
  }


  public int getRowBetween(Cell cell){
    int result = row - cell.getRow();
    if(result == 0){
      return row;
    } else {
      return row + result/2;
    }
  }

  public int getColBetween(Cell cell){
    int result = col - cell.getCol();
    if(result == 0){
      return col;
    } else {
      return col + result/2;
    }
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
