public class BinarySearchTree {

	static Node root;
	public BinarySearchTree() {
		
	}
	
	public Node insert(Node root,int item){
		if (root==null)
		{
			root=new Node(item);
			//root.key=item;
			//System.out.println("root"+root.key);
			return root;
		}
		else if (root.key>item)
		{	
			root.left=insert(root.left, item);
		}
		else if (root.key<item)
		{
			root.right=insert(root.right, item);
		}
		return root;
	    }
	
	public boolean contains(Node root,int item){
		//System.out.println("?"+item+","+root.key);
		if (root==null){
			return false;
		}
		else if	(root.key==item){
			return true;
		}
		else if(root.key>item){
			 return contains(root.left, item);
		}
		else {
			return contains(root.right, item);
		}
		}
	
	public void print(Node root){
		if (root!=null){
		print(root.left);
		System.out.println(root.key);
		print(root.right);
		}
			
	}

	public int size(Node root){
		int count=0;
		if (root!=null){
			count=size(root.left)+size(root.right)+1;
			}
		return count;
	}

	public int smallest(Node root){
		if (root.left!=null){
			return smallest(root.left);
			}
		else 
			return root.key;
	}
	
	public int largest(Node root){
		if (root.right!=null){
			return largest(root.right);
			}
		else 
			return root.key;
	}
	
	
	public void greaterSumTree(Node root){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree a=new BinarySearchTree();
		Node c=new Node(10);
		a.insert(c, 54);
		a.insert(c, 60);
		a.insert(c, 5);
		a.insert(c, 1);
		a.insert(c, 4545);
		a.insert(c, 54535545);
		//System.out.print(a.contains(c, 60));
		//a.print(c);
		//Size 
	//	System.out.print(a.size(c));
		System.out.print(a.smallest(c)+"\n");
		System.out.print(a.largest(c));
	}

}