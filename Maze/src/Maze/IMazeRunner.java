package Maze;

public abstract interface IMazeRunner {

  void solve(Maze maze);

  int nrOfVisitedNodes();

}
