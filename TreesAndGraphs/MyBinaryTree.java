public class myBinaryTree{
	
	public static void main(String[] args){

	}

	public static boolean isBST(Node root){
		//BC
		if(root == null)
			return true;

		/* IN ORDER TRAVERSAL */
		//go left
		if(!isBST(root.left)){
			return false;
		}
		
		//visit current
		if(previous != null && root.value < previous){
			return false;
		}

		previous = root.value;

		//go right
		return isBST(root.right);
	}

	/**
	* Find the value of the Lowest Common Ancestor(deepest) of the Nodes with values valueA and valueB respectively, 
	* Input: a BST
	*/
	public static int findLCA(Node root, int valueA, int value B){
		if(root == null){
			return -1;
		}

		/* PRE ORDER TRAVERSAL */

		// check if this node is the LCA
		if(root.value > valueA && root.value < valueB){
			//BINGO!
			return root.value;
		}
		
		//go left
		if(root.value > valueA && root.value > valueB){
			return findLCA(root.left, valueA, valueB);
		}

		//go right
		if(root.value < valueA && root.value < valueB){
			return findLCA(root.right, valueA, valueB);
		}

		return -1;
	}

	/**
	* Determine if a BT is balanced
	*/
	public static boolean isBalanced(Node root){
		//bc
		if(root == null)
			return true;

		if(maxDepth(root) - minDepth(root) <= 1) ? true : false;
	}

	private static int maxDepth(node root){
		//bc
		if(root == null)
			return 0;

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	private static int minDepth(Node root){
		//bc
		if(root == null)
			return 0;

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	/**
	* Given a sorted array, create a binary tree with minimal height
	*/
	private static Node getTreeWithMinHeight(int[] arr){
		//bc
		if(arr == null || arr.length == 0)
			return null;

		return addNode(arr, 0, arr.length -1);

	}

	private static Node addNode(int[] arr, int start, int end){
		//bc
		if (end < start)
			return null;		

		//get middle, make node
		int middle = start + (end - start) / 2;
		Node parent = new Node(arr[middle]);

		//recurse left
		parent.setLeft(addNode(arr, start, middle -1));

		//recurse right
		parent.setRight(addNode(arr, start, middle + 1));

		return parent;
		
	}


	/**
	* BFS
	*/
	private static Node BFS(Node root, int key){
		//bc
		if(root == null)
			return null;

		markAll(root, Status.UNVISITED);
		LinkedList<Node> queue = new LinkedList<Node>();

		//add first element in bag
		queue.addFirst(root);

		while(queue.size > 0){
			//remove last
			Node curr = queue.removeLast();
			curr.status = Status.VISITED;
			if(curr.value == key){
				return curr;
			}

			//add left child
			queue.addFirst(curr.left);

			//add right child
			queue.addFirst(curr.right);
		
		}
		
		return null;
	}

	/**
	* BFS print level-by-level
	*/
	private static void printByLevel(Node root){
		//BC
		if(root == null){
			return;
		}

		/* CREATE BAG DS */
		LinkedList<Node> queue = new LinkedList<Node>();

		// add first element in
		queue.addFirst(root);

		int currLevel = 1;
		int nextLevel = 0;

		while(queue.size() > 0){
			Node curr = queue.removeLast();
			System.out.print(curr.value);
			currLevel--;

			//add next level
			if(root.left != null){
				queue.addFirst(root.left);
				nextLevel++;
			}
			if(root.right != null){
				queue.addFirst(root.right);
				nextLevel++;
			}

			//if current level is zero, switch levels
			if(currLevel == 0){
				System.out.println("-------------");
				currLevel = nextlevel;
				nextLevel = 0;
			}
		}
		
	}
}

class Node{
	Node left;
	Node right;
	Status status;

	int value;

	public Node(int value){
		this.value = value;
	}

	public void setLeft(Node left){
		this.left = left;
	}

	public void setRight(Node right){
		this.right = right;
	}
}

public enum Status{
	UNVISITED;
	VISITED;
}

































































