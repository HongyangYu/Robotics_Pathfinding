package Code_a_star;

public class State{
	private int cx;
	private int cy;
	private int gs;
	private int hs;
	private int fs;
	private int search;
	private State tree;
	private final static int C = 11000;
	private boolean hnew;
	
	public State(int cx, int cy){
		this.cx = cx;
		this.cy = cy;
	}
	
	public int getCx(){
		return cx;
	}
	
	public int getCy(){
		return cy;
	}
	
	public void setGs(State s, int cost){
		this.gs = s.gs + cost;
	}
	
	public void setGsIni(){
		gs = 0;
	}
	
	public int getGs(){
		return gs;
	}
	
	public void setHs(State goal){
		hs = Math.abs(goal.cx - cx) + Math.abs(goal.cy - cy);
	}
	
	public void setnHs(State goal){
		hs = goal.getGs() - gs;
		hnew = true;
	}
	
	public void setFs(){
		fs = gs + hs;
	}
	
	public void setFs2(){//largerG
		fs = C * (hs+gs) - gs;
	}
	
	public void setFs3(){ //smallerG
		fs = C * (hs+gs) + gs;
	}
	
	public int getFs(){
		return fs;
	}
	
	public void setTree(State s){
		this.tree = s;
	}
	
	public State getTree(){
		return tree;
	}
	
	public void setSearch(int search){
		this.search = search;
	}	
	
	public int getSearch(){
		return search;
	}
	
	public boolean equalTo(State s){
		if(this.cx == s.cx && this.cy == s.cy) return true;
		else return false;
	}
	
	public int compareTo(State b){
		return this.fs - b.fs;
	}
	
	public boolean getHnew(){
		return hnew;
	}
	
	
	
}