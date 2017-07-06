/**
 * SingleLinkedList
 */
public class SingleLinkedList<T> {
	private Node<T> head = null;
	private int size = 0;
	
	public void add(T element){
		Node<T> node = new Node<T>();
		node.setValue(element);
		if(head==null){
			head=node;
		} else {
			Node<T> tmp = head;
			while (tmp.getNextRef()!=null){	
				tmp=tmp.getNextRef();
			}
			tmp.setNextRef(node);
		}
		size++;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public T getFirst(){
		return head.getValue();
	}
	
	public T get(int nodeNumber){
		Node<T> tmp = head;
		int index = 0;
		while (tmp.getNextRef()!=null && index<nodeNumber){	
			tmp=tmp.getNextRef();
			index++;
		}
		return tmp.getValue();
	}

	public void reverse(){
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		
		while(current!=null){
			next = current.getNextRef();
			current.setNextRef(prev);
			prev=current;
			current=next;
		}
		head=prev;
	}
	
	public void print(){
		Node<T> tmp = head;
		while (tmp!=null){	
			System.out.print(tmp.getValue()+", ");
			tmp=tmp.getNextRef();
		}
	}
}
