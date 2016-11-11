package Code_a_star;

import java.lang.management.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		start();
	}
	
	private static void start() {
//		System.gc();
//		MemoryMXBean bean_init = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_init_1 = bean_init.getHeapMemoryUsage();
//		MemoryUsage memory_init_2 = bean_init.getNonHeapMemoryUsage();
//		long init_mm = memory_init_1.getUsed() + memory_init_2.getUsed();
//		init_mm = 0;

		// maze size
		int x = 101;
		int y = 101;
		MazeGenerator mazeGen = new MazeGenerator(x, y);
		// mazeGen.display();
		int[][] maze_arr = mazeGen.getMaze();
		int xs, ys, xt, yt;
		// start and end coordinates
		Random rand = new Random();
		int max_s = 10, min_t = 90;
		do {
			xs = rand.nextInt(max_s) + 1;
			ys = rand.nextInt(max_s) + 1;
			xt = rand.nextInt(101 - min_t) + min_t;
			yt = rand.nextInt(101 - min_t) + min_t;
		} while (maze_arr[ys - 1][xs - 1] == 5 || maze_arr[yt - 1][xt - 1] == 5);
		System.out.println("xs " + xs + "," + "ys " + ys + "\nxt " + xt + "," + "yt " + yt);

//		MemoryMXBean bean_Maze = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_Maze_1 = bean_Maze.getHeapMemoryUsage();
//		MemoryUsage memory_Maze_2 = bean_Maze.getNonHeapMemoryUsage();
//		long maze_mm = memory_Maze_1.getUsed() + memory_Maze_2.getUsed() - init_mm;
//		System.out.println("Maze Memory: " + (double) maze_mm / 1024 / 1024 + "MB");

		long startTime = System.currentTimeMillis();// start time
		Agent agent = new Agent();
		agent.start(xs, ys, xt, yt, maze_arr);
		long endTime = System.currentTimeMillis(); // end time
		System.out.println("Runing time of Repeat Forward A* is " + (endTime - startTime) + "ms");
		 Maze_Frame mazeframe1 = new Maze_Frame();
		 mazeframe1.MazeFrame(maze_arr, agent);

//		MemoryMXBean bean_rf = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_rf_1 = bean_rf.getHeapMemoryUsage();
//		MemoryUsage memory_rf_2 = bean_rf.getNonHeapMemoryUsage();
//		long rf_mm = memory_rf_1.getUsed() + memory_rf_2.getUsed();
//		System.out.println("Repeat Forward A* Memory: " + (double) (rf_mm - init_mm) / 1024 / 1024 + "MB");
		System.out.println();

		startTime = System.currentTimeMillis();// start time
		Agent_largerG agent_lg = new Agent_largerG();
		agent_lg.start(xs, ys, xt, yt, maze_arr);
		endTime = System.currentTimeMillis(); // end time
		System.out.println("Runing time of Repeat Forward A* " + "with larger g-value in tie breaking is "
				+ (endTime - startTime) + "ms");
		 Maze_Frame mazeframe2 = new Maze_Frame();
		 mazeframe2.MazeFrame(maze_arr, agent_lg);

//		MemoryMXBean bean_rf_lg = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_rf_lg_1 = bean_rf_lg.getHeapMemoryUsage();
//		MemoryUsage memory_rf_lg_2 = bean_rf_lg.getNonHeapMemoryUsage();
//		long rf_lg_mm = memory_rf_lg_1.getUsed() + memory_rf_lg_2.getUsed();
//		System.out.println("Repeat Forward A* Memory: " + (double) (rf_lg_mm - rf_mm + maze_mm) / 1024 / 1024 + "MB");
		System.out.println();

		startTime = System.currentTimeMillis();// start time
		Agent_smallerG agent_sg = new Agent_smallerG();
		agent_sg.start(xs, ys, xt, yt, maze_arr);
		endTime = System.currentTimeMillis(); // end time
		System.out.println("Runing time of Repeat Forward A* " + "with smaller g-value in tie breaking is "
				+ (endTime - startTime) + "ms");
		 Maze_Frame mazeframe3 = new Maze_Frame();
		 mazeframe3.MazeFrame(maze_arr, agent_sg);

//		MemoryMXBean bean_rf_sg = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_rf_sg_1 = bean_rf_sg.getHeapMemoryUsage();
//		MemoryUsage memory_rf_sg_2 = bean_rf_sg.getNonHeapMemoryUsage();
//		long rf_sg_mm = memory_rf_sg_1.getUsed() + memory_rf_sg_2.getUsed();
//		System.out.println("Repeat Forward A* with smaller g-values Memory: "
//				+ (double) (rf_sg_mm - rf_lg_mm + maze_mm) / 1024 / 1024 + "MB");
		System.out.println();

		startTime = System.currentTimeMillis();// start time
		Agent_Backward agent_back = new Agent_Backward();
		agent_back.start(xs, ys, xt, yt, maze_arr);
		endTime = System.currentTimeMillis(); // end time
		System.out.println("Runing time of Repeat Backward A* is " + (endTime - startTime) + "ms");
		 Maze_Frame mazeframe4 = new Maze_Frame();
		 mazeframe4.MazeFrame(maze_arr, agent_back);
//
//		MemoryMXBean bean_rb = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_rb_1 = bean_rb.getHeapMemoryUsage();
//		MemoryUsage memory_rb_2 = bean_rb.getNonHeapMemoryUsage();
//		long rb_mm = memory_rb_1.getUsed() + memory_rb_2.getUsed();
//		System.out.println("Repeat Backward A* Memory: " + (double) (rb_mm - rf_sg_mm + maze_mm) / 1024 / 1024 + "MB");
		System.out.println();

		startTime = System.currentTimeMillis();// start time
		Agent_Adaptive agent_adaptive = new Agent_Adaptive();
		agent_adaptive.start(xs, ys, xt, yt, maze_arr);
		endTime = System.currentTimeMillis(); // end time
		System.out.println("Runing time of Adaptive A* is " + (endTime - startTime) + "ms");
		 Maze_Frame mazeframe5 = new Maze_Frame();
		 mazeframe5.MazeFrame(maze_arr, agent_adaptive);

//		MemoryMXBean bean_adaptive = ManagementFactory.getMemoryMXBean();
//		MemoryUsage memory_adaptive_1 = bean_adaptive.getHeapMemoryUsage();
//		MemoryUsage memory_adaptive_2 = bean_adaptive.getNonHeapMemoryUsage();
//		long adaptive_mm = memory_adaptive_1.getUsed() + memory_adaptive_2.getUsed();
//		System.out.println("Adaptive A* Memory: " + (double) (adaptive_mm - rb_mm + maze_mm) / 1024 / 1024 + "MB");
//		System.out.println();

	}

}
