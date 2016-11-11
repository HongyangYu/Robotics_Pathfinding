package Code_a_star;

import java.util.Arrays;
import java.util.Collections;

public class MazeGenerator {
	private final int x;
	private final int y;
	private final int[][] maze;
	private static final int BLOCKED = 5;
	private static final int UNBLOCKED = 1;
 
	public MazeGenerator(int x, int y) {
		this.x = x;
		this.y = y;
		maze = new int[this.x][this.y];
		generateMaze(0, 0);
	}
	
	private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
	
	public int[][] getMaze(){
		return maze;
	}
	
	private int block(){
		double r = Math.random();
		if(r < 0.2) return BLOCKED;
		else return UNBLOCKED;
	}
	
	private void generateMaze(int cx, int cy) {
		maze[cx][cy] = block();
		DIR[] dirs = DIR.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (DIR dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, x) && between(ny, y)
					&& (maze[nx][ny] == 0)) {
				generateMaze(nx, ny);
			}
		}
	}
	
	public void display(){
		for(int i = 0; i < x; i++){
			for(int j =0; j < y; j++){
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	
	private enum DIR {
		N(0, 1), S(0, -1), E(1, 0), W(-1, 0);
		private final int dx;
		private final int dy;
 
		// use the static initializer to resolve forward references

 
		private DIR(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
	};

}
