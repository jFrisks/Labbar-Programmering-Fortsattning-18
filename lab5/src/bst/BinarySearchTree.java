package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
        return add(x, root);
	}

	private boolean add(E x, BinaryNode<E> node){
	    if(node.element == null){
	        //lägg till
            node.element = x;
            size++;
            return true;
        }else if(x.equals(node.element)){
            //finns redan
            return false;
        }else if(x.compareTo(node.element) > 0){
            //höger
            //gå ner ett steg
            return add(x, node.right);
        }else if(x.compareTo(node.element) < 0){
            //vänster
            //gå ner ett steg
            return add(x, node.left);
        }else{
            return false;
        }
    }
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return heightOfRoot(root);
	}

	private boolean isEmpy(){
	    if(root == null && size == 0){
	        return true;
        }else{
	        return false;
        }
    }

    //mid = first + (last-first)/2
    //mergeSort(, first, mid)
    //mergeSort(a, mid +1, last)
    //samsortera

	/**
     * Recursive Method to calculate height of binary tree
     * @return  the height of the tree
     * */
	private int heightOfRoot(BinaryNode node) {
	    if(root == null && size == 0){
	        return 0;
        }else{
	        return 1 + Math.max(heightOfRoot(node.left), heightOfRoot(node.right));
        }
	}

	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
	    if(!isEmpy()){
            printInOrder(root);
        }
	}

	private void printInOrder(BinaryNode<E> node){
        //om helt tom
        if(node.hasNoChildren()){
            //printa ut nodens element - TODO
            System.out.println(node.element);
        }else{
            printInOrder(node.left);
            printInOrder(node.right);
            printInOrder(node.right);
        }
    }

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		return 0;
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		return null;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}

		public boolean hasNoChildren(){
		    if(left == null && right == null){
		        return true;
            }else{
		        return false;
            }
        }
	}
	
}
