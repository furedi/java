/**
 * Write a sample code to reverse Singly Linked List by iterating through it only once.
 * Idea: http://www.java2novice.com/java-interview-programs/revese-singly-linked-list/
 */

class SingleListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleLinkedList<Integer> sList = new SingleLinkedList<Integer>();
		
		// Test data
		for (int x = 2; x < 20; x+=2) {
			sList.add(x);
		}
		
		System.out.println("SingleLinkedList from first to last elemenet:");
		sList.print();
		
		System.out.println("\nSingleLinkedList from last to first elemenet:");
		sList.reverse();
		sList.print();
	}

}