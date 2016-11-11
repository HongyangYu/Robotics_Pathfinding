package Code_a_star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Agent_largerG{
	ArrayList<Integer> x_coord;
	ArrayList<Integer> y_coord;
	int start_X;
	int start_Y;
	private State cs;
	private State[][] map = new State[101][101];

	private State[] Closed = new State[11000];
	private int sizeClosed;
	private State[] Block = new State[5000];
	private int sizeBlock;
	private int counter;
	private State goal;
	private BinaryHeap OpenHeap;
	public static int pinf = 9999999;
	private int numec;
	
	public Agent_largerG(){
		x_coord = new ArrayList<Integer>();
		y_coord = new ArrayList<Integer>();
	}
	
	 private boolean between(int x){
		 if(x >= 0 && x < 101) return true;
		 else return false;
	 }
	

	 
	 private boolean isClosed(State s){
		 for(int i = 0; i < sizeClosed; i++){
			 if(s.equalTo(Closed[i])) return true;
		 }
		 return false;
	 }
	 
	 private void addClosed(State s){
		 Closed[sizeClosed] = s;
		 sizeClosed++;
	 }
	 
	 private boolean isBlock(State s){
		 for(int i = 0; i < sizeBlock; i++){
			 if(s.equalTo(Block[i])) return true;
		 }
		 return false;
	 }
	 
	 
	 private void addBlock(State s){
		 Block[sizeBlock] = s;
		 sizeBlock++;
	 }
	 
	 
	 private boolean goalTest(State s){
		 return s.equalTo(goal);
	 }
	 
	 public boolean computePath(){
		 while(!goalTest(OpenHeap.findMin())){
			 State es = OpenHeap.findMin();
			 OpenHeap.deleteMin();
			 addClosed(es);
			 DIR[] dirs = DIR.values();
			 Collections.shuffle(Arrays.asList(dirs));			 
			 for (DIR dir : dirs){
				 int sx = es.getCx() + dir.dx;
				 int sy = es.getCy() + dir.dy;
				 if(between(sx) && between(sy) && !isBlock(map[sy][sx])){
					 if(map[sy][sx].getSearch() < counter){
						 map[sy][sx].setGs(es, pinf);
						 map[sy][sx].setSearch(counter);
					 }
					 if(map[sy][sx].getGs() > (es.getGs() + 1)){
						 map[sy][sx].setGs(es, 1);
						 map[sy][sx].setTree(es);
						 int heapi = OpenHeap.isOpen(map[sy][sx]);
						 if(heapi > 0){
							 OpenHeap.delete(heapi);
							 map[sy][sx].setHs(goal);
							 map[sy][sx].setFs2();
							 OpenHeap.insert(map[sy][sx]);
						 }
						 else if(!isClosed(map[sy][sx])){
							 map[sy][sx].setHs(goal);
							 map[sy][sx].setFs2();
							 OpenHeap.insert(map[sy][sx]);
						 }
					 }
				 }
			 }
			 if(OpenHeap.isEmpty()){
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 
	 public void move(){
		 State s = goal;
		 while(s.getTree() != cs){
			 State ls = s.getTree();
			 s = ls;
		 }
		 cs = s;

		 x_coord.add(cs.getCx());
		 y_coord.add(cs.getCy());
		 
//		 System.out.print((s.getCx() + 1) + "," + (s.getCy() + 1) + "   ");
	 }
	 
	 public boolean detect(int[][] maze){
		 DIR[] dirs = DIR.values();
		 for (DIR dir : dirs){
			 int sx = cs.getCx() + dir.dx;
			 int sy = cs.getCy() + dir.dy;
			 if(between(sx) && between(sy) && maze[sy][sx] == 5 && !isBlock(map[sy][sx])){
				 addBlock(map[sy][sx]);
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 public void start(int x, int y, int gx, int gy, int[][] maze){
		start_X = x-1;
		start_Y = y-1;
		x_coord.add(start_X);
		y_coord.add(start_Y);
		 for(int i = 0; i < 101; i++){
			 for(int j = 0; j < 101; j++){
				 map[i][j] = new State(j, i);
			 }
		 }
		 cs = map[y - 1][x - 1];
		 goal = map[gy - 1][gx - 1];
		 counter = 0;
		 OpenHeap = new BinaryHeap();
		 while(!goalTest(cs)){
			 counter++;
			 cs.setGsIni();
			 cs.setSearch(counter);
			 OpenHeap.makeEmpty();
			 for(int i = 0; i < sizeClosed; i++){
				 Closed[i] = null;
			 }
			 sizeClosed = 0;
			 cs.setHs(goal);
			 cs.setFs2();
			 OpenHeap.insert(cs);
			 detect(maze);
			 if(computePath()){
				 while(!goalTest(cs) && detect(maze)){
					 move();
				 }
			 }
			 else{
				 System.out.println();
				 System.out.println("I cannot reach the target");
				 break;
			 }
			 numec = numec + sizeClosed;
		 }
		 System.out.println("\nnumber of expanded cells: " + numec);
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
	}
}

