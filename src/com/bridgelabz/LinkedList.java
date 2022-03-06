package com.bridgelabz;

/**
 *  We have created this generic class for the LinkedList implementation
 *  [1] - Method search to search for a specific key in the HashTable
 *  [2] Method append to add nodes 
 *  [3] Method remove to delete the key node from the LinkedList
 *  
 * @author Tom
 *
 * @param <K> : We have used the generic type of key for the LinkedKist
 */
public class LinkedList<K> {

	//we have initialize 2 variable for generic type 
	private Node<K> head;
	private Node<K> tail;

	public Node<K> search(K key) {
		/**
		 * [1] - Method search to search for a specific key in the HashTable
		 * 1. First we declare a variable of type node and assign it to head
		 * 2. Then we travel in the list till it is not null
		 * 3. While traversing we check if list key matches the input key
		 * 4. If key found then we return the node
		 * 5. If key not found then we return the null
		 * @param key -  here we are passing the key to search for a specific key in the LinkedList
		 * @return - once we find the key we return the node of that specific key
		 */
		Node<K> temp = head;
		while (temp != null) {
			if (temp.getKey().equals(key)) {
				return temp;
			}
			//incrementing the temp
			temp = temp.getNext();
		}
		return null;
	}

	
	public void append(Node<K> myNode) {
		/**
		 * [2] Method append to add nodes at the last
		 * 1. First we check if the head and tail is null and then we assign the new node to it.
		 * 2. If elements present then we add the element to the tail and make the newNode as tail
		 * @param myNode - Here we pass the node to append at last
		 */

		if (this.head == null) {
			this.head = myNode;
		}
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}
	

    public boolean remove(K key) {
    	/**
    	 * [3] Method remove to remove the node from the LinkedList
    	 * 1. First we assign the head to temp and prev as null
    	 * 2, Then we check if the temp key matches the imput key
    	 * 3. We increment the temp and prev till we get the key
    	 * 5. If we get the key match then we make the prev as temp and assign the temp next tp the prev i.e temp
    	 * @param key -  we pass the key to remove the node
    	 * @return - We return true if we find the node and found and deleted it and we return false
    	 */
		
		Node<K> temp =head;
		Node<K> prev = null;
		while(temp != null) {
			if(temp.getKey()==key) {
				prev.setNext(temp.getNext());
				return true;
			} 
			prev = temp;
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public String toString() {
		return "\n MyLinkedListNodes{" + head + "}";
	}
	

	public void printMyNodes() {
		System.out.println(" My Nodes :" + head);
	}
	
	
}
