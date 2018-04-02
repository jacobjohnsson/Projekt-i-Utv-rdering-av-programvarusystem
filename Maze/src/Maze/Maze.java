/*
 * Observera att konstruktorn antar att "starten" är i första raden och "slutet" i sista raden.
 * Funkar endast för kvadratiska labyrinter.
 */

package Maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

public class Maze {
	private Cell[][] maze;
	private int startCol;
	private int endCol;
	private int size;
	Stack<Cell> unvisitedCells;

	// Konstruktorn som tar från file
	public Maze(String file) throws IOException {
		String line = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		} catch (FileNotFoundException fe) {
			System.out.println("File not found: " + file);
		}

		line = bufferedReader.readLine();
		maze = new Cell[line.length()][line.length()];
		size = maze.length;

		// Fill the Cell[][] with correkt wall-info.
		int row = 0;
		int col = 0;
		while (line != null) {
			for (char c : line.toCharArray()) {
				switch (c) {
					case '#': maze[row][col] = new Cell(row, col, true, false);
										break;
					case ' ': maze[row][col] = new Cell(row, col, false, false);
										break;
				}
				col++;
			}
			col = 0;
			row++;
			line = bufferedReader.readLine();
		}
		bufferedReader.close();

		// Hitta startkolumnen!
		for (col = 0; col < maze[0].length;	col++) {
			if (maze[0][col].isWall() == false) {
				startCol = col;
			}
		}

		// Hitta slutkolumnen!
		for (col = 0; col < maze[0].length;	col++) {
			if (maze[size - 1][col].isWall() == false) {
				endCol = col;
			}
		}

		BuildNeighbourRelations();

	}

	public Maze(int size) {
		// Genererar en labyrint av storlek size
		this.size = size;
		maze = new Cell[size][size];

		initialize();
		//generate();
	}

	public void	print() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				if (maze[i][j].isWall()) {
					System.out.print("#");
				} else {
					System.out.print(".");
				}

			}
			System.out.println();
		}
	}

	public int getStartCol() {
		return startCol;
	}

	public int getEndCol() {
		return endCol;
	}

	public int getSize() {
		return size;
	}

	public Cell	getStartCell() {
		return maze[0][startCol];
	}

	public Cell getEndCell() {
		return maze[size - 1][endCol];
	}

	private void initialize(){
		unvisitedCells = new Stack<Cell>();

		// Initialize all edge cells as walls and all others as non-walls.
		// Also adds the cells to the stack.
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (row == 0 || col == 0) {
					maze[row][col] = new Cell(row, col, true, true);
				}
				if (row == (size - 1) || col == size - 1) {
					maze[row][col] = new Cell(row, col, true, true);
				}
				if (row != 0 && row != size - 1 && col != 0 && col != size - 1) {
					maze[row][col] = new Cell(row, col, false, false);
					unvisitedCells.add(maze[row][col]);
				}
			}
		}
		Random rnd = new Random();
		this.startCol = rnd.nextInt((size - 1) / 2) * 2 + 1; // för att få ojämna tal.
		this.endCol = rnd.nextInt((size - 1) / 2) * 2 + 1; // för att få ojämna tal.

		maze[0][startCol].setWall(false);
		maze[size - 1][endCol].setWall(false);

	}

	private void generate(){
		Stack<Cell> path = new Stack<Cell>();

		maze[0][startCol].setVisited(false); // sätt starten som obesökt
		maze[size - 1][endCol].setVisited(false); // sätt målet som obesökt

		// fyll stacken
		for (int row = 0; row < size - 1; row++) {
			for (int col = 0; col < size - 1; col++) {
				if (!maze[row][col].isVisited()) {
					unvisitedCells.add(maze[row][col]);
				}
			}
		}

		Cell current = getStartCell();

		while (!unvisitedCells.isEmpty()) {
			Cell unvisitedNeighbour = current.getRandomUnvisitedNeighbour();
			if (unvisitedNeighbour != null) {
				path.push(current);
			}
		}



	}

	private void BuildNeighbourRelations() {
		// Construct all inner neighbour relationships (of length 1).
		for (int row = 1; row < size - 1; row ++) {
			for (int col = 1; col < size - 1; col++) {

				// North
				maze[row][col].setNeighbour(0, maze[row - 1][col]);

				// West
				maze[row][col].setNeighbour(1, maze[row][col + 1]);

				//South
				maze[row][col].setNeighbour(2, maze[row + 1][col]);

				// East
				maze[row][col].setNeighbour(3, maze[row][col - 1]);
			}
		}

		// Construct the neighbour relations for start and end cells
		getStartCell().setNeighbour(2, maze[1][startCol]);
		getEndCell().setNeighbour(0, maze[size - 2][endCol]);
	}

	public static void main(String[] args) throws IOException {
		//Maze myMaze = new Maze("resources/Maze2.txt");
		Maze myMaze = new Maze(7);
		TurnLeft tl = new TurnLeft();

		myMaze.print();

		tl.solvePrinting(myMaze);

		System.out.println(tl.nrOfVisitedNodes());
	}

}
