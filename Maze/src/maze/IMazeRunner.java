package maze;

public abstract interface IMazeRunner {

  void solve(Maze maze);

  int nrOfVisitedNodes();

}