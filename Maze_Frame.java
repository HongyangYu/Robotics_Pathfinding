package Code_a_star;

import java.awt.*;
import javax.swing.*;

public class Maze_Frame {
	public Maze_Frame(){}
	
	public void MazeFrame(int[][] maze_arr, Agent agent)
	{
		JFrame frame = new JFrame("Maze");//Maze frame
		
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(1100, 1050);//size
		frame.setLocation(400, 30);//location
		frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);// max window
		frame.setLayout(new BorderLayout());
		
		JPanel maze_panel = new Maze_Panel(maze_arr, agent);// Maze Panel
		frame.add(maze_panel, BorderLayout.CENTER);
		
//		JPanel control_panel = new Control_Panel(); // Input TextBoxs and start, reset Buttons
//		frame.add(control_panel, BorderLayout.NORTH);
		
		frame.repaint();
		frame.validate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void MazeFrame(int[][] maze_arr, Agent_largerG agent)
	{
		JFrame frame = new JFrame("Maze_largerG");//Maze frame
		
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(1100, 1050);//size
		frame.setLocation(400, 30);//location
		frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);// max window
		frame.setLayout(new BorderLayout());
		
		JPanel maze_panel = new Maze_Panel_largerG(maze_arr, agent);// Maze Panel
		frame.add(maze_panel, BorderLayout.CENTER);
		
//		JPanel control_panel = new Control_Panel(); // Input TextBoxs and start, reset Buttons
//		frame.add(control_panel, BorderLayout.NORTH);
		
		frame.repaint();
		frame.validate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void MazeFrame(int[][] maze_arr, Agent_smallerG agent)
	{
		JFrame frame = new JFrame("Maze_smallerG");//Maze frame
		
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(1100, 1050);//size
		frame.setLocation(400, 30);//location
		frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);// max window
		frame.setLayout(new BorderLayout());
		
		JPanel maze_panel = new Maze_Panel_smallerG(maze_arr, agent);// Maze Panel
		frame.add(maze_panel, BorderLayout.CENTER);
		
//		JPanel control_panel = new Control_Panel(); // Input TextBoxs and start, reset Buttons
//		frame.add(control_panel, BorderLayout.NORTH);
		
		frame.repaint();
		frame.validate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void MazeFrame(int[][] maze_arr, Agent_Backward agent)
	{
		JFrame frame = new JFrame("Maze_Backward");//Maze frame
		
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(1100, 1050);//size
		frame.setLocation(400, 30);//location
		frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);// max window
		frame.setLayout(new BorderLayout());
		
		JPanel maze_panel = new Maze_Panel_Back(maze_arr, agent);// Maze Panel
		frame.add(maze_panel, BorderLayout.CENTER);
		
//		JPanel control_panel = new Control_Panel(); // Input TextBoxs and start, reset Buttons
//		frame.add(control_panel, BorderLayout.NORTH);
		
		frame.repaint();
		frame.validate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void MazeFrame(int[][] maze_arr, Agent_Adaptive agent)
	{
		JFrame frame = new JFrame("Maze_Adaptive");//Maze frame
		
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(1100, 1050);//size
		frame.setLocation(400, 30);//location
		frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);// max window
		frame.setLayout(new BorderLayout());
		
		JPanel maze_panel = new Maze_Panel_Adaptive(maze_arr, agent);// Maze Panel
		frame.add(maze_panel, BorderLayout.CENTER);
		
//		JPanel control_panel = new Control_Panel(); // Input TextBoxs and start, reset Buttons
//		frame.add(control_panel, BorderLayout.NORTH);
		
		frame.repaint();
		frame.validate();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
