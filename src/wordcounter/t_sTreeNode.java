package wordcounter;

public class t_sTreeNode<E extends Comparable< ? super E > > implements Comparable
{
	// public access so the tree and other classes can access
	public t_sTreeNode<E> lftChild, rtChild;
	public E data;
	public t_sTreeNode<E> myRoot;
	public int count;
	
	// default constructor
	public t_sTreeNode( E d, t_sTreeNode<E> lft, t_sTreeNode<E> rt)
	{
		lftChild = lft;
		rtChild = rt;
		data = d;
	}
	
	// backup constructor
	public t_sTreeNode()
	{
		this(null, null, null);
	}
	
	// use with AVL Trees when extended
	public int getHeight() { return 0; }
	boolean setHeight( int height ) { return true; }

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
