package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		QueueNode newNode = new QueueNode<E>(e);
		if(last.next != null) {
			//Skapa en ny quaeNode new


			//Länkar man new.next som last.next
			newNode.next = last.next;
			//last.next = new
			last.next = newNode;
			last = newNode;
			size++;
			return true;
		}else if(last.next == null){
			last = newNode;
			last.next = last;
			size++;
			return true;
		}else return false;

	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		return last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		//Få tag på huvudnoden
		QueueNode<E> head = last.next;

		//Om tom raderar vi ej
		if(size == 0){
			return null;
		}else if(size == 1){
		    last = null;
		    size--;
			return head.element;
		}else{
            //Om innehåll raderar vi och tar bort en på size
            last.next = head.next;
            size--;
            return head.element;
        }
	}

	/**
     * Appends the specified queue to this queue
     * post: all elemetns from the specified queue are appended
     * to this queue. The specified queue (q) is empty after the call.
     * @param q the queue to append
     * @throws IllegalArgumentException if this queue and q are identical
     * */
    public void append(FifoQueue<E> q){
        //TODO: FALL ATT TÄNKA PÅ
        //TODO: Om q eller this är null får vi hantera
        //TODO: om båda tomma

        if(q == this){
            throw new IllegalArgumentException();
        }else if (q.size >= 1 && this.size >= 1){
            QueueNode<E> oldLast = this.last;
            this.last.next = q.last.next;
            last = q.last.next;
            last.next = oldLast.next;
            //Gör q tom (ej implem för behövs ej)
            size = size + q.size;
        }else if(q.size >=1 && this.size <= 0){
            last = q.last;
        }
    }
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
        private QueueNode<E> pos;
        private int iterated = 0;

        /** KONSTRUKTOR */
        private QueueIterator(){
            if(last == null){
                pos = null;
            }
            pos = last.next;
        }

        @Override
        public boolean hasNext() {
            if(pos.next == null || size <= iterated){
                return false;
            }else{
                return true;
            }
        }

        @Override
        public E next() {
            if(hasNext()){
                QueueNode<E> tmp = pos;
                pos = pos.next;
                iterated++;
                return tmp.next.element;
            }else{
                throw new NoSuchElementException();
            }
        }
    }
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
