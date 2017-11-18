

class Node 
 	{
	 int key;				//Retained value 
	 Node right,left;		//linking the nodes

	//@SuppressWarnings("null")
	 public Node() {
			//key=(Integer) null;
			right=null;
			left=null;
			//System.out.println("Node "+ key + "left" +left + "right" +right);
		// TODO Auto-generated constructor stub
	}


}

public class BinarySearchTree {

	Node root;						//initialize a node 
	static int temp=0;				//Static variable to externally handle the sum in greater sum tree traversal
	
	public BinarySearchTree() {}

	//------------------------------------------------------------------------------//
	void insert(int item)
	{									//Wrapper for insert
		root=insert_wrap(root,item);
	}
	
	public Node insert_wrap(Node root,int item){
		if (root==null)
		{
			root=new Node();
			root.key=item;
			return root;
		}
		else if (root.key>item)
		{	
			root.left=insert_wrap(root.left, item);
		}
		else if (root.key<item)
		{
			root.right=insert_wrap(root.right, item);
		}
		return root;
	    }
	
	//------------------------------------------------------------------------------//
	void contains(int item)
	{			//Wrapper for contains fuction
		boolean exist=contains_wrap(root,item);
		System.out.println("Item->"+item+" available ? "+exist);
	}
	
		private boolean contains_wrap(Node root,int item){
			if (root==null)
				{
				return false;
				}
		else if	(root.key==item){
			return true;
		}
		else if(root.key>item){
			 return contains_wrap(root.left, item);
		}
		else {
			return contains_wrap(root.right, item);
		}
		}
	
	//------------------------------------------------------------------------------//
	void print (){
		print_wrap(root); //Wrapper for inorder print
	}
	
	public void print_wrap(Node root){			// in order printing function of BST
		if (root!=null){
		print_wrap(root.left);
		System.out.println(root.key);
		print_wrap(root.right);
		}
			
	}

	//------------------------------------------------------------------------------//
	public void size(){
		int sz=size_wrap(root);
		System.out.print("Size "+sz+"\n");
	}
	public int size_wrap(Node root){
		int count=0;
		if (root!=null){
			count=size_wrap(root.left)+size_wrap(root.right)+1;
			}
		return count;
	}
	
	//------------------------------------------------------------------------------//
	void smallest()
	{
		int small=smallest_wrap(root);
		System.out.print("Smallest "+small+"\n");
		
	}
	public int smallest_wrap(Node root){
		if (root.left!=null){
			return smallest_wrap(root.left);
			}
		else 
			return root.key;
	}
	
	//------------------------------------------------------------------------------//
	void largest()
	{
		int large=largest_wrap(root);
		System.out.print("Largest "+large+"\n");
	}
		public int largest_wrap(Node root){
			if (root.right!=null)
				{
				return largest_wrap(root.right);
				}
			else 
				return root.key;
	}
	
	//------------------------------------------------------------------------------//
		
	public void greaterSumTree(){
		System.out.print("Tree before greater-sum transformation"+"\n"+"\n");
			print();
			int sum=0;
			greaterSumTree_wrap(root,sum);
			System.out.print("\n"+"Tree after greater-sum transformation"+"\n");
			print();
			//return root;
		}
		public void greaterSumTree_wrap(Node root,int sum){
			if (root==null){
				return;
			}
			greaterSumTree_wrap(root.right,sum);
			sum=temp+root.key;
			temp=sum;
			root.key=sum-root.key;
			greaterSumTree_wrap(root.left,sum);
	}
	

	//------------------------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {56,34,6,1,4,7,9,564,344,3};
		BinarySearchTree a=new BinarySearchTree();
		System.out.print("-----------------------BST Insert-----------------------"+"\n");
		for (int i=0;i<array.length;i++){
			a.insert(array[i]);
		}
		System.out.print("-----------------------Invoke inorder print-----------------------"+"\n");
		a.print();
		System.out.print("-----------------------Invoke contains-----------------------"+"\n");
		a.contains(4);
		a.contains(100);
		a.contains(564);
		System.out.print("-----------------------Invoke size-----------------------"+"\n");
		a.size();
		System.out.print("-----------------------Invoke smallest-----------------------"+"\n");
		a.smallest();
		System.out.print("-----------------------Invoke largest-----------------------"+"\n");
		a.largest();
		System.out.print("-----------------------Invoke GreaterSumTree-----------------------"+"\n");
		a.greaterSumTree();

	}

}
