/**
 * Node
 */

public class Node<T> {
	private T value;			// stored value
	private Node<T> nextRef;	// reference to next Node
	
	public void setValue(T value){
		this.value = value;
	}

	public T getValue(){
		return this.value;
	}	
	
	public void setNextRef(Node<T> nextRef){
		this.nextRef = nextRef;
	}
	
	public Node<T> getNextRef(){
		return this.nextRef;
	}

}

