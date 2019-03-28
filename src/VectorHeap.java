import java.util.Vector;

/**
 * The type Vector heap.
 *
 * @param <E> the type parameter
 */
//Tomado de libro JavaStructures
public class VectorHeap<E extends Comparable> implements PriorityQueue<E> {
    /**
     * Data, stores all the patients
     */
    protected Vector<E> data; // the data, kept in heap order

    /**
     * Instantiates a new Vector heap.
     */
    public VectorHeap()
    // post: constructs a new priority queue
    {
        data = new Vector<E>();
    }

    /**
     * Instantiates a new Vector heap.
     *
     * @param v the empty vector Heap
     */
    public VectorHeap(Vector<E> v)
    // post: constructs a new priority queue from an unordered vector
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++)
        { // add elements to heap
            add(v.get(i));
        }
    }

    /**
     * Parent int.
     *
     * @param i the position of the node
     * @return the position of the parent
     */
    protected static int parent(int i)
    // pre: 0 <= i < size
    // post: returns parent of node at location i
    {
        return (i-1)/2;
    }

    /**
     * Left int.
     *
     * @param i the position of the node
     * @return the position of the left element
     */
    protected static int left(int i)
    // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2*i+1;
    }

    /**
     * Right int.
     *
     * @param i the position of the node
     * @return the position of the left element
     */
    protected static int right(int i)
    // pre: 0 <= i < size
    // post: returns index of right child of node at location i
    {
        return (2*i+1) + 1;
    }

    /**
     * Percolate up.
     *
     * @param leaf the leaf to compare
     */
    protected void percolateUp(int leaf)
    // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }
    /**
     * Add.
     *
     * @param value to add
     */
    public void add(E value)
    // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * isEmpty
     *
     * returns if the Node is empty
     */
    @Override
    public boolean isEmpty() {
        if (data.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Size
     *
     * Gets the size of the vector
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Clear
     *
     * Empties the vector
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     * Push down root.
     *
     * @param root the root being pushed down
     */
    protected void pushDownRoot(int root)
    // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }
    /**
     * getFirst
     *
     * @param
     * @return The first element of the vector
     */
    @Override
    public E getFirst() {
        return data.firstElement();
    }
    /**
     * remove
     *
     * @param
     * @return the last element of the queue
     */
    public E remove()
    // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

}
