package maze;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Maze maze = new Maze(199);

		MazeRunner tl = new TurnLeft();
		for ( int i = 0; i < 100; i++){
			maze = new Maze(219);
			long t1 = System.nanoTime();
			tl.solve(maze);
			long t2 = System.nanoTime();
			System.out.println((t1 - t2) / 1000000 + "ms");
		}
		
		maze.print();
	}
}
