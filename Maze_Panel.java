package Code_a_star;

import java.awt.*;
import javax.swing.*;

public class Maze_Panel extends JPanel {
	/**
	 * Version ID 1.1
	 */
	private static final long serialVersionUID = 1L;
	
	private final int UNBLOCK = 1;// 1 means unblocked
	private final int Panel_SIZE = 1000;//the whole size of maze panel 
	private final int ROW; // row
	private final int COL; // column
	private final int INTERVAL;//cell size
	private final int BORDER_NS = 30; //margin left
	private final int BORDER_WE = 400; //margin left
	private int[][] maze; // maze arr[][]
//	private Integer[] AgentX; //agent location
//	private Integer[] AgentY; //agent location
	Agent agent;
	public Maze_Panel(int [][] maze_arr, Agent agent) {
		maze = maze_arr;
		ROW=maze.length;
		COL=maze[1].length;
		INTERVAL = Panel_SIZE/ROW;
		this.setBackground(Color.white);
		this.agent = agent;

		agent.x_coord.trimToSize();
		agent.y_coord.trimToSize();
//		AgentX = (Integer[])agent.x_coord.toArray();
//		AgentY = (Integer[])agent.y_coord.toArray();
	}
	
	public void paintComponent(Graphics g) {// Graphics is MazePanel
		super.paintComponent(g);
		g.setColor(Color.gray);//set color of lines
		//draw grids
		for (int i = 0; i <= ROW; i++) {
			g.drawLine(0 + BORDER_WE, i * INTERVAL + BORDER_NS, 
					COL * INTERVAL + BORDER_WE, i * INTERVAL + BORDER_NS);
		}
		for(int i=0; i<= COL; i++ ){
			g.drawLine(i * INTERVAL + BORDER_WE, 0 + BORDER_NS, 
					i * INTERVAL + BORDER_WE, ROW * INTERVAL + BORDER_NS);
		}
		g.setColor(Color.black); //set color of block cells
		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze.length; j++){
				if(maze[i][j]!=UNBLOCK)
					g.fillRect(j*INTERVAL+BORDER_WE+1, i*INTERVAL+BORDER_NS+1, INTERVAL-1, INTERVAL-1);
			}
		}
		g.setColor(Color.green);
		for(int i=0; i<agent.x_coord.size(); i++){
			g.fillRect(agent.x_coord.get(i)*INTERVAL+BORDER_WE+1, agent.y_coord.get(i)*INTERVAL+BORDER_NS+1, INTERVAL-2, INTERVAL-2);
		}

	}
	

}
