package thienTree;

public class tAvlTree<E extends Comparable< ? super E > >
extends tBST<E>
{
	// public methods of AVL Tree
	public tAvlTree() { super(); }
	
	public int showHeight() { return heightOf(tRoot); }
	
	// public insert(), remove(), clone() do not need to be overridden
	
	// private helper methods of AVL tree
	
	protected static int heightOf(t_sTreeNode t)
	{
		return t == null? -1 : t.getHeight();
	}
	
	protected t_sTreeNode<E> insert( t_sTreeNode<E> root, E x )
	{
		int compareResult;
		
		if (root == null)
		{
			tSize++;
			return new tAvlNode<E>(x, null, null, 0);
		}
		
		compareResult = x.compareTo(root.data);
		if ( compareResult < 0 )
		{
			root.lftChild = insert(root.lftChild, x);
			if(heightOf(root.lftChild) - heightOf(root.rtChild) == 2)
				if( x.compareTo(root.lftChild.data) < 0 )
					root = rotateWithLeftChild(root);
				else
					root = doubleWithLeftChild(root);
		}
		else if ( compareResult > 0 )
		{
			root.rtChild = insert(root.rtChild, x);
			if(heightOf(root.rtChild) - heightOf(root.lftChild) == 2)
				if( x.compareTo(root.rtChild.data) > 0 )
					root = rotateWithRightChild(root);
				else
					root = doubleWithRightChild(root);
		}
		else
			return root;	// duplicate
		
		// successfully inserted at this or lower level; adjust height
		root.setHeight(
				Math.max( heightOf(root.lftChild), heightOf(root.rtChild))
				+ 1);
		return root;
	}
	
	protected t_sTreeNode<E> remove( t_sTreeNode<E> root, E x )
	{
		int compareResult;
		
		if (root == null)
		{
			return null;
		}
		
		compareResult = x.compareTo(root.data);
		if ( compareResult < 0 )
		{
			root.lftChild = remove(root.lftChild, x);
			
			// rebalance - shortened left branch so right may now be higher by 2
			if(heightOf(root.rtChild) - heightOf(root.lftChild) == 2)
				if( heightOf(root.rtChild.rtChild) < heightOf(root.rtChild.lftChild) )
					root = doubleWithRightChild(root);
				else
					root = rotateWithRightChild(root);
		}
		else if ( compareResult > 0 )
		{
			root.rtChild = remove(root.rtChild, x);
			
			// rebalance - shortened right branch so left may now be higher by 2
			if(heightOf(root.lftChild) - heightOf(root.rtChild) == 2)
				if( heightOf(root.lftChild.lftChild) < heightOf(root.lftChild.rtChild) )
					root = doubleWithLeftChild(root);
				else
					root = rotateWithLeftChild(root);
		}
		
		// found the node - goes through complicated case
		else if (root.lftChild != null && root.rtChild != null)
		{
			root.data = findMin(root.rtChild).data;
			root.rtChild = remove(root.rtChild, root.data);
			
			// rebalance - shortened right branch so left may now be higher by 2
			if(heightOf(root.lftChild) - heightOf(root.rtChild) == 2)
				if(heightOf(root.lftChild.lftChild) < heightOf(root.lftChild.rtChild))
					root = doubleWithLeftChild(root);
				else
					root = rotateWithLeftChild(root);
		}
		else	// easy base case + 1
		{
			// no rebalancing needed at this external (1 + null children) node
			root =
				(root.lftChild != null)? root.lftChild : root.rtChild;
			tSize--;
			return root;
		}
		
		// successfully removed at this or lower level; adjust height
		root.setHeight(
				Math.max( heightOf(root.lftChild), heightOf(root.rtChild))
				+ 1);
		return root;
	}
	
	// rotation algorithms
	protected t_sTreeNode<E> rotateWithLeftChild(
		t_sTreeNode<E> k2 )
	{
		t_sTreeNode<E> k1 = k2.lftChild;
		k2.lftChild = k1.rtChild;
		k1.rtChild = k2;
		k2.setHeight( Math.max( heightOf(k2.lftChild), heightOf(k2.rtChild) ) + 1);
		k1.setHeight( Math.max( heightOf(k1.lftChild), k2.getHeight() ) + 1);
		
		//System.out.println("Single left rotation: " + k2.data);
		
		return k1;
	}
	
	protected t_sTreeNode<E> rotateWithRightChild(
			t_sTreeNode<E> k2 )
	{
		t_sTreeNode<E> k1 = k2.rtChild;
		k2.rtChild = k1.lftChild;
		k1.lftChild = k2;
		k2.setHeight( Math.max( heightOf(k2.lftChild), heightOf(k2.rtChild) ) + 1);
		k1.setHeight( Math.max( heightOf(k1.rtChild), k2.getHeight() ) + 1);
		
		//System.out.println("Single right rotation: " + k2.data);
		
		return k1;
	}
	
	protected t_sTreeNode<E> doubleWithLeftChild(
		t_sTreeNode<E> k3 )
	{
		//System.out.println("Double left right rotation starting: " + k3.data);
		
		k3.lftChild = rotateWithRightChild(k3.lftChild);
		return rotateWithLeftChild(k3);
	}
	
	protected t_sTreeNode<E> doubleWithRightChild(
			t_sTreeNode<E> k3 )
	{
		//System.out.println("Double right left rotation starting: " + k3.data);

		k3.rtChild = rotateWithLeftChild(k3.rtChild);
		return rotateWithRightChild(k3);
	}
	
	// AVL clone, overrides BST version by adding height info
	protected tAvlNode<E> cloneSubtree(t_sTreeNode<E> root)
	{
		tAvlNode<E> newNode;
		if (root == null)
			return null;
		
		newNode = new tAvlNode<E>
		(
			root.data,
			cloneSubtree(root.lftChild),
			cloneSubtree(root.rtChild),
			root.getHeight()
		);
		
		return newNode;
	}
}
