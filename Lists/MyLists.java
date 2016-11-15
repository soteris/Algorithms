public class MyLists{

	public static void main(String[] args){


	}


	/**
	* Reverse a singly linked list
	*/
	private static Node reverseLinkedList(Node root){
		//BC 
		if (root == null) return null;

		Node previous = null;
		Node current = root;
		

		while(current != null){
			Node next = current.next;
			current.next = previous;
			
			previous = current;
			current = next;	
		}

		root = previous;
		return root;

	}

	/** 
	* Find middle element of list
	*
	*/
	private static Node findMiddle(Node head){
		//BC
		if(head == null)
			return null;

		if(head.next == null || head.next.next == null)
			return head;


		Node slow = head;
		Node fast = head.next.next;

		while(fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.next;
	}

	private static Node findMiddleSimpler(Node head){
		//BC
		if (head == null)
			return null;

		Node slow = head; 
		Node fast = head;
	
		while(fast.next != null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	private static Node findNthFromEnd(Node head, int n){
		//BC
		if(head == null)
			return null;

		Node slow = head;
		Node fast = head;

		// move fast n positions in front
		for(int i = 0; i < n; i++){
			fast = fast.next;
			if(fast == null)
				return null;
		}

		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}

class Node{
	Node next;
	int value;

}
