package oldStuff;

// set up avl node from search tree node
public class tAvlNode<E extends Comparable< ? super E > >
extends t_sTreeNode<E>
{
	protected int height;
	
	public tAvlNode(
			E x,
			t_sTreeNode<E> lftChild,
			t_sTreeNode<E> rtChild,
			int ht )
	{
		super(x, lftChild, rtChild);
		if (!setHeight(ht))
			height = 0;
	}	
	
	public tAvlNode()
	{
		this(null, null, null, 0);
	}
	
	public int getHeight() { return height; }
	public boolean setHeight( int height)
	{
		if (height < -1)
			return false;
		this.height = height;
		return true;
	}
}

