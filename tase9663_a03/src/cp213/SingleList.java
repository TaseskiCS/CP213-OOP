package cp213;

/**
 * A single linked list structure of <code>Node T</code> objects. These data
 * objects must be Comparable - i.e. they must provide the compareTo method.
 * Only the <code>T</code> object contained in the priority queue is visible
 * through the standard priority queue methods. Extends the
 * <code>SingleLink</code> class.
 *
 * @author David Brown
 * @version 2024-09-01
 * @param <T> this SingleList data type.
 */
public class SingleList<T extends Comparable<T>> extends SingleLink<T> {

    /**
     * Searches for the first occurrence of key in this SingleList. Private helper
     * methods - used only by other ADT methods.
     *
     * @param key The object to look for.
     * @return A pointer to the node previous to the node containing key.
     */
    private SingleNode<T> linearSearch(final T key) {

	// your code here
	SingleNode<T> current = this.front;
	SingleNode<T> prev = this.front;

	while (current != null) {
	    if (current.getObject().compareTo(key) == 0) {
		return prev;
	    }
	    prev = current;
	    current = current.getNext();
	}

	return null;
    }

    /**
     * Appends data to the end of this SingleList.
     *
     * @param data The object to append.
     */
    public void append(final T data) {
	// your code here
	SingleNode<T> node = new SingleNode<T>(data, null);

	if (this.front == null) {
	    this.front = node;
	    this.rear = this.front;

	} else {
	    this.rear.setNext(node);
	    this.rear = this.rear.getNext();

	}

	this.length++;

	return;
    }

    /**
     * Removes duplicates from this SingleList. The list contains one and only one
     * of each object formerly present in this SingleList. The first occurrence of
     * each object is preserved.
     */
    public void clean() {
	// your code here
	if (this.front == null || this.front == null) {
	    return;
	}

	SingleNode<T> current = this.front;
	while (current != null) {
	    SingleNode<T> runner = current;
	    while (runner.getNext() != null) {
		if (runner.getNext().getObject().compareTo(current.getObject()) == 0) {
		    runner.setNext(runner.getNext().getNext());
		} else {
		    runner = runner.getNext();
		}
	    }
	    current = current.getNext();
	}
	return;

    }

    /**
     * Combines contents of two lists into a third. Values are alternated from the
     * origin lists into this SingleList. The origin lists are empty when finished.
     * NOTE: data must not be moved, only nodes.
     *
     * @param left  The first list to combine with this SingleList.
     * @param right The second list to combine with this SingleList.
     */
    public void combine(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	while (left.getLength() != 0 && right.getLength() != 0) {
	    this.moveFrontToRear(left);
	    this.moveFrontToRear(right);
	}

	while (left.getLength() != 0) {
	    this.moveFrontToRear(left);
	}

	while (right.getLength() != 0) {
	    this.moveFrontToRear(right);
	}

	return;

    }

    /**
     * Determines if this SingleList contains key.
     *
     * @param key The key object to look for.
     * @return true if key is in this SingleList, false otherwise.
     */
    public boolean contains(final T key) {

	// your code here

	return this.linearSearch(key) != null;
    }

    /**
     * Finds the number of times key appears in list.
     *
     * @param key The object to look for.
     * @return The number of times key appears in this SingleList.
     */
    public int count(final T key) {

	SingleNode<T> curr = this.front;
	int count = 0;

	while (curr != null) {
	    if (curr.getObject().compareTo(key) == 0) {
		count++;
	    }

	    curr = curr.getNext();
	}

	return count;

    }

    /**
     * Finds and returns the object in list that matches key.
     *
     * @param key The object to search for.
     * @return The object that matches key, null otherwise.
     */
    public T find(final T key) {

	// your code here
	SingleNode<T> node = this.linearSearch(key);
	T value;

	if (node == null) {
	    value = null;

	} else {
	    value = node.getNext().getObject();
	}

	return value;

    }

    /**
     * Get the nth object in this SingleList.
     *
     * @param n The index of the object to return.
     * @return The nth object in this SingleList.
     * @throws ArrayIndexOutOfBoundsException if n is not a valid index.
     */
    public T get(final int n) throws ArrayIndexOutOfBoundsException {

	// your code here
	SingleNode<T> node = this.front;

	if (n < 0 || n > this.getLength() || node == null) {
	    throw new ArrayIndexOutOfBoundsException(n + " is not a valid index");
	}

	int i = n;
	while (i > 0) {
	    node = node.getNext();
	    i--;
	}

	return node.getObject();
    }

    /**
     * Determines whether two lists are identical.
     *
     * @param source The list to compare against this SingleList.
     * @return true if this SingleList contains the same objects in the same order
     *         as source, false otherwise.
     */
    public boolean equals(final SingleList<T> source) {

	// your code here
	SingleNode<T> currentNode = front;
	SingleNode<T> sourceCurrentNode = source.front;

	while (currentNode != null && sourceCurrentNode != null) {
	    if (!(currentNode.getObject().compareTo(sourceCurrentNode.getObject()) == 0)) {
		return false;
	    }

	    currentNode = currentNode.getNext();
	    sourceCurrentNode = sourceCurrentNode.getNext();
	}

	if (currentNode != null || sourceCurrentNode != null) {
	    return false;
	}

	return true;

    }

    /**
     * Finds the first location of a object by key in this SingleList.
     *
     * @param key The object to search for.
     * @return The index of key in this SingleList, -1 otherwise.
     */
    public int index(final T key) {

	// your code here
	SingleNode<T> curr = this.front;
	int index = 0;
	while (curr != null) {
	    if (curr.getObject().compareTo(key) == 0) {
		return index;
	    } else {
		index += 1;
		curr = curr.getNext();
	    }
	}

	return -1;
    }

    /**
     * Inserts object into this SingleList at index i. If i greater than the length
     * of this SingleList, append data to the end of this SingleList.
     *
     * @param i    The index to insert the new data at.
     * @param data The new object to insert into this SingleList.
     */
    public void insert(int i, final T data) {

	// your code here
	SingleNode<T> newNode = new SingleNode(data, null);
	if (i >= this.length) {
	    this.rear.setNext(newNode);
	    this.rear = newNode;
	} else {
	    SingleNode<T> curr = this.front;
	    SingleNode<T> prev = null;
	    for (int j = 0; j < i; j++) {
		prev = curr;
		curr = curr.getNext();
	    }
	    prev.setNext(newNode);
	    newNode.setNext(curr);

	}
	this.length += 1;

	return;

    }

    /**
     * Creates an intersection of two other SingleLists into this SingleList. Copies
     * data to this SingleList. left and right SingleLists are unchanged. Values
     * from left are copied in order first, then objects from right are copied in
     * order.
     *
     * @param left  The first SingleList to create an intersection from.
     * @param right The second SingleList to create an intersection from.
     */
    public void intersection(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> curr = left.front;

	while (curr != null) {
	    if (!this.contains(curr.getObject()) && right.contains(curr.getObject())) {
		this.append(curr.getObject());
	    }

	    curr = curr.getNext();
	}

	return;

    }

    /**
     * Finds the maximum object in this SingleList.
     *
     * @return The maximum object.
     */
    public T max() {

	// your code here
	SingleNode<T> curr = this.front;
	T max = curr.getObject();
	while (curr != null) {
	    if (curr.getObject().compareTo(max) > 0) {
		max = curr.getObject();
	    }
	    curr = curr.getNext();
	}

	return max;
    }

    /**
     * Finds the minimum object in this SingleList.
     *
     * @return The minimum object.
     */
    public T min() {

	// your code here
	SingleNode<T> curr = this.front;
	T min = curr.getObject();
	while (curr != null) {
	    if (curr.getObject().compareTo(min) < 0) {
		min = curr.getObject();
	    }
	    curr = curr.getNext();
	}

	return min;
    }

    /**
     * Inserts object into the front of this SingleList.
     *
     * @param data The object to insert into the front of this SingleList.
     */
    public void prepend(final T data) {

	SingleNode<T> newNode = new SingleNode<T>(data, null);
	if (this.front == null) {
	    this.rear = newNode;
	} else {
	    newNode.setNext(this.front);
	}
	this.front = newNode;
	this.length += 1;

	return;
    }

    /**
     * Finds, removes, and returns the object in this SingleList that matches key.
     *
     * @param key The object to search for.
     * @return The object matching key, null otherwise.
     */
    public T remove(final T key) {

	// your code here
	if (this.front == null) {
	    return null;
	}

	if (this.front.getObject().compareTo(key) == 0) {
	    SingleNode<T> removedValue = this.front;
	    this.front = this.front.getNext();
	    this.length -= 1;
	    return removedValue.getObject();
	}

	SingleNode<T> current = this.front;
	while (current.getNext() != null) {
	    if (current.getNext().getObject().compareTo(key) == 0) {
		SingleNode<T> removedValue = current.getNext();
		current.setNext(current.getNext().getNext());
		this.length -= 1;
		return removedValue.getObject();
	    }
	    current = current.getNext();
	}

	return null;
    }

    /**
     * Removes the object at the front of this SingleList.
     *
     * @return The object at the front of this SingleList.
     */
    public T removeFront() {

	// your code here
	T value = null;

	if (this.front != null) {
	    if (this.front == this.rear) {
		this.rear = null;
	    }

	    value = this.front.getObject();
	    this.front = this.front.getNext();
	    this.length--;
	}

	return value;

    }

    /**
     * Finds and removes all objects in this SingleList that match key.
     *
     * @param key The object to search for.
     */
    public void removeMany(final T key) {

	// your code here
	if (this.front == null) {
	    return;
	}

	while (this.front != null && this.front.getObject().compareTo(key) == 0) {
	    this.front = this.front.getNext();
	    this.length -= 1;
	}

	SingleNode<T> current = this.front;
	while (current != null && current.getNext() != null) {
	    if (current.getNext().getObject().compareTo(key) == 0) {
		current.setNext(current.getNext().getNext());
		this.length -= 1;
	    } else {
		current = current.getNext();
	    }
	}

	return;
    }

    /**
     * Reverses the order of the objects in this SingleList.
     */
    public void reverse() {

	// your code here
	SingleNode<T> newFront = null;
	SingleNode<T> thisFront = null;

	while (this.front != null) {
	    thisFront = this.front.getNext();
	    this.front.setNext(newFront);

	    newFront = this.front;
	    this.front = thisFront;
	}

	this.front = newFront;

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move object or call the high-level methods insert
     * or remove. this SingleList is empty when done. The first half of this
     * SingleList is moved to left, and the last half of this SingleList is moved to
     * right. If the resulting lengths are not the same, left should have one more
     * object than right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void split(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	int rightLength = this.getLength() / 2;
	int leftLength = this.getLength() - rightLength;

	while (leftLength > 0) {
	    left.moveFrontToRear(this);
	    leftLength--;
	}

	while (rightLength > 0) {
	    right.moveFrontToRear(this);
	    rightLength--;
	}

	return;
    }

    /**
     * Splits the contents of this SingleList into the left and right SingleLists.
     * Moves nodes only - does not move object or call the high-level methods insert
     * or remove. this SingleList is empty when done. Nodes are moved alternately
     * from this SingleList to left and right. Order is preserved.
     *
     * @param left  The first SingleList to move nodes to.
     * @param right The second SingleList to move nodes to.
     */
    public void splitAlternate(final SingleList<T> left, final SingleList<T> right) {

	// your code here
	int i = 0;
	int currLength = this.getLength();

	while (currLength > 0) {
	    if (i % 2 == 0) { // even
		left.moveFrontToRear(this);
	    } else { // odd
		right.moveFrontToRear(this);
	    }
	    currLength--;
	    i++;
	}

	return;
    }

    /**
     * Creates a union of two other SingleLists into this SingleList. Copies object
     * to this list. left and right SingleLists are unchanged. Values from left are
     * copied in order first, then objects from right are copied in order.
     *
     * @param left  The first SingleList to create a union from.
     * @param right The second SingleList to create a union from.
     */
    public void union(final SingleList<T> left, final SingleList<T> right) {

	SingleNode<T> currLeft = left.front;
	SingleNode<T> currRight = right.front;

	while (currLeft != null) {
	    this.append(currLeft.getObject());
	    currLeft = currLeft.getNext();
	}

	while (currRight != null) {
	    this.append(currRight.getObject());
	    currRight = currRight.getNext();
	}

	return;
    }
}
