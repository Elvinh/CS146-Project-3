package wordcounter;

public class newAvlTree<E extends Comparable< ? super E > >
extends BinarySearchTree<E>
{
	// public methods of AVL Tree
	public newAvlTree() { super(); }
	
    protected class AvlNode {
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
         * Create a new data node. Also takes care of incrementing the tree
         * size.
         *
         * @param data data element to be stored at this node.
         */
                
        public AvlNode(E data, int height) {
            this.data = data;
            count = 1;
            left = right = null;
            size++;
        }
    }
}
