package Maze;

public abstract interface MazeRunner {

  void solve(Maze maze);
  
  int nrOfVisitedNodes();

}
