package wordcounter;

public class newAvlTree<E extends Comparable< ? super E > >
extends BinarySearchTree<E>
{
	// public methods of AVL Tree	
	public newAvlTree() 
	{
        super();
	}
	
	// new nested class AvlNode adds height instance variable w/ acc, mut
    protected class AvlNode extends BSTNode {

		/**
         * The left child of this node.
         */
        public AvlNode left;

        /**
         * The right child of this node.
         */
        public AvlNode right;

        /**
         * The data element stored at this node.
         */
        public E data;

        /**
         * The count for this data element.
         */
        public int count;

        /**
         * 
         */
        public int height;
        
        /**
         * Create a new data node. Also takes care of incrementing the tree
         * size.
         *
         * @param data data element to be stored at this node.
         */
        
        public AvlNode(E data, int ht) {
            super(data);
			height = ht;
			// TODO Auto-generated constructor stub
		}
        
        // add accessor for height
        public int getHeight() { return height; }
        
        // add mutator for height
    	public boolean setHeight( int height)
    	{
    		if (height < -1)
    			return false;
    		this.height = height;
    		return true;
    	}
    }
    
	public int heightOf(BSTNode a)
	{
		return a == null? -1 : a.height;
	}
    
    // need to override incCount to include the "check and adjust balance" algorithm
    public void incCount(E data) {
        if (overallRoot == null) {
            overallRoot = new BSTNode(data, 0);
        } else {
            // traverse the tree
            BSTNode currentNode = overallRoot;
            while (true) {
                // compare the data to be inserted with the data at the current node
                int cmp = data.compareTo(currentNode.data);

                if (cmp == 0) {
                    // current node is a match
                    currentNode.count++;
                    return;
                } else if (cmp < 0) {
                    // new data goes to the left of the current node
                    if (currentNode.left == null) {
                        currentNode.left = new AvlNode(data, 0);
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    // new data goes to the right of the current node
                    if (currentNode.right == null) {
                        currentNode.right = new AvlNode(data, 0);
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
        // add balancing algo
        selfBalance(overallRoot);
    }
    
    // balancing algorithm taken from CS 146 slides
    protected BSTNode selfBalance( BSTNode node )
    {
    	if (heightOf(node.left) - heightOf(node.right) > 1)
    	{
    		if (heightOf(node.left.left) >= heightOf(node.left.right))
    			node = rotateWithLeftChild(node);
    		else
    			node = doubleWithLeftChild(node);
    	}
    	
    	else if (heightOf(node.right) - heightOf(node.left) > 1)
    	{
    		if (heightOf(node.right.right) >= heightOf(node.right.left))
    			node = rotateWithRightChild(node);
    		else
    			node = doubleWithRightChild(node);
    	}
		return node;
    }
    
 // rotation algorithms implemented from Project 2 (Thien)
 	protected BSTNode rotateWithLeftChild(
 			BSTNode k2 )
 	{
 		BSTNode k1 = k2.left;
 		k2.left = k1.right;
 		k1.right = k2;
 		k2.height = ( Math.max( heightOf(k2.left), heightOf(k2.right) ) + 1);
 		k1.height = ( Math.max( heightOf(k1.left), k2.height ) + 1);
 		
 		//System.out.println("Single left rotation: " + k2.data);
 		
 		return k1;
 	}
 	
 	protected BSTNode rotateWithRightChild(
 			BSTNode k2 )
 	{
 		BSTNode k1 = k2.right;
 		k2.right = k1.left;
 		k1.left = k2;
 		k2.height =  Math.max( heightOf(k2.left), heightOf(k2.right) ) + 1;
 		k1.height = Math.max( heightOf(k1.right), k2.height ) + 1;
 		
 		//System.out.println("Single right rotation: " + k2.data);
 		
 		return k1;
 	}
 	
 	protected BSTNode doubleWithLeftChild(
 			BSTNode k3 )
 	{
 		//System.out.println("Double left right rotation starting: " + k3.data);
 		
 		k3.left = rotateWithRightChild(k3.left);
 		return rotateWithLeftChild(k3);
 	}
 	
 	protected BSTNode doubleWithRightChild(
 			BSTNode k3 )
 	{
 		//System.out.println("Double right left rotation starting: " + k3.data);

 		k3.right = rotateWithLeftChild(k3.right);
 		return rotateWithRightChild(k3);
 	}
    
}
