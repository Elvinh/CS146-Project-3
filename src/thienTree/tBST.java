package thienTree;

import java.util.NoSuchElementException;

public class tBST< E extends Comparable< ? super E > > implements Cloneable
{
	protected int tSize;
	protected t_sTreeNode<E> tRoot;
	
	// default constructor
	public tBST() { clear(); }
	
	// initialize properties
	public void clear() { tSize = 0; tRoot = null; }
	
	// basic accessors
	public int size() { return tSize; }
	public int showHeight() { return findHeight(tRoot, -1); }
	
	
	// find min and max in the tree, leaf up to root (choose master root node to search whole tree)
	public E findMin()
	{
		if (tRoot == null)
			throw new NoSuchElementException();
		return findMin(tRoot).data;
	}
	
	public E findMax()
	{
		if (tRoot == null)
			throw new NoSuchElementException();
		return findMax(tRoot).data;
	}
	
	// want to run insert and remove starting from the master root
	public boolean insert( E x )
	{
		int oldSize = tSize;
		tRoot = insert(tRoot, x);
		return (tSize != oldSize);
	}
	
	public boolean remove( E x )
	{
		int oldSize = tSize;
		tRoot = remove(tRoot, x);
		return (tSize != oldSize);
	}
	
	// determine if an element in in the tree using find and contains
	public E find( E x )
	{
		t_sTreeNode<E> resultNode;
		resultNode = find(tRoot, x);
		if (resultNode == null)
			throw new NoSuchElementException();
		return resultNode.data;
	}
	public boolean contains(E x) { return find(tRoot, x) != null; }
	
	// in-order traversals (good for BST) as result will be in sorted order
	public < F extends Traverser<? super E > >
	void traverse(F func)
	{
		traverse(func, tRoot);
	}
	
	// clone method
	public Object clone() throws CloneNotSupportedException
	{
		tBST<E> newObject = (tBST<E>)super.clone();	// shallow copy
		newObject.clear();	// can't point to other's data
		
		newObject.tRoot = cloneSubtree(tRoot);		// call protected helper method
		newObject.tSize = tSize;
		
		return newObject;
	}
	
	// all private helper methods add parameter to start from master node -----------------
	
	// want only height of master root, start from bottom up to check number of subtrees. Start at -1
	protected int findHeight ( t_sTreeNode<E> treeNode, int height)
	{
		int leftHeight, rightHeight;
		if (treeNode == null)
			return height;
		height++;
		leftHeight = findHeight(treeNode.lftChild, height);
		rightHeight = findHeight(treeNode.rtChild, height);
		return (leftHeight > rightHeight)? leftHeight : rightHeight;
	}
	
	// top down search
	protected t_sTreeNode<E> findMin( t_sTreeNode<E> root )
	{
		if (root == null)
			return null;
		if (root.lftChild == null)
			return root;
		return findMin(root.lftChild);
	}
	
	protected t_sTreeNode<E> findMax( t_sTreeNode<E> root )
	{
		if (root == null)
			return null;
		if (root.lftChild == null)
			return root;
		return findMax(root.lftChild);
	}
	
	protected t_sTreeNode<E> insert( t_sTreeNode<E> root, E x )
	{
		int compareResult;	// avoid multiple calls to compareTo()
		
		if (root == null)	//2 things: if no tree nodes yet, set up master
		{
			tSize++;
			return new t_sTreeNode<E>(x, null, null);	// or on recursive call, if no child exists then add
		}
		
		compareResult = x.compareTo(root.data);
		if ( compareResult < 0 )
			root.lftChild = insert(root.lftChild, x);
		else if ( compareResult > 0 )
			root.rtChild = insert(root.rtChild, x);
		
		return root;
	}
	
	protected t_sTreeNode<E> remove( t_sTreeNode<E> root, E x )
	{
		int compareResult;	// avoid multiple calls to compareTo()
		
		if (root == null)	//2 things: if no tree nodes yet, set up master
			return null;
		
		compareResult = x.compareTo(root.data);
		if ( compareResult < 0 )
			root.lftChild = remove(root.lftChild, x);
		else if ( compareResult > 0 )
			root.rtChild = remove(root.rtChild, x);
		
		// found the node, 2 child case (take min of right subtree and copy into removed node
		else if (root.lftChild != null && root.rtChild != null)
		{
			root.data = findMin(root.rtChild).data;
			root.rtChild = remove(root.rtChild, root.data);
		}
		else
		{
			root = (root.lftChild != null)? root.lftChild : root.rtChild;
			tSize--;
		}
		return root;
	}
	
	protected t_sTreeNode<E> find( t_sTreeNode<E> root, E x )
	{
		int compareResult;	// avoid multiple calls to compareTo()
		
		if (root == null)
			return null;
		
		compareResult = x.compareTo(root.data);
		if (compareResult < 0)
			return find(root.lftChild, x);
		if (compareResult > 0)
			return find(root.rtChild, x);
		return root;	// found
	}
	
	// 
	protected < F extends Traverser< ? super E > >
	void traverse( F func, t_sTreeNode treeNode)
	{
		if (treeNode == null)	
			return;
		
		traverse(func, treeNode.lftChild);
		func.visit((E) treeNode.data);
		traverse(func, treeNode.rtChild);
	}
	
	// clone all the nodes
	protected t_sTreeNode<E> cloneSubtree(t_sTreeNode<E> root)
	{
		t_sTreeNode<E> newNode;
		if (root == null)	// when tree is null, or done with recursive calls
			return null;
		
		newNode = new t_sTreeNode<E>
		(	// bottom up construction
			root.data, cloneSubtree(root.lftChild), cloneSubtree(root.rtChild)
		);
		return newNode;
	}
}
