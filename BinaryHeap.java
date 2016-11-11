package Code_a_star;

public class BinaryHeap {
	private int heapsize;
	private State[] array = new State[11000];
	
	public void exchange(int a, int b){
		State temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void MINIFY(int i){
		int l = 2*i;
		int r = 2*i + 1;
		int min = i;
		if(l <= heapsize && array[l].compareTo(array[min]) < 0) min = l;
		
		if(r <= heapsize && array[r].compareTo(array[min]) < 0) min = r;

		if(min != i){
			exchange(i, min);
			MINIFY(min);
		}
	}
	
	public void insert(State x){
		int hole = ++heapsize;
		for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
			array[ hole ] = array[ hole / 2 ];
		array[ hole ] = x;
	}
	
	
	public State findMin(){
		if( isEmpty( ) ) return null;
		return array[1];
	}
	
	public void deleteMin(){
		exchange(1, heapsize);
		heapsize--;
		MINIFY(1);
	}
	
	public void delete(int i){
		exchange(i, heapsize);
		heapsize--;
		MINIFY(i);
	}
	
	public int isOpen(State s){
		for(int i = 1; i <= heapsize; i++){
			if(s.equalTo(array[i])) return i;
		}
		return 0;
	}
	
	public void makeEmpty(){
		heapsize = 0;
	}
	
	public boolean isEmpty(){
		return heapsize == 0;
	}
}












