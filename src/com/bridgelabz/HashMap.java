package com.bridgelabz;

import java.util.ArrayList;

/**
 *  We have created this class for the HashMap implementation  
 *  [1]- We have created the method get to find the value of a specific key
 *  [2] Method getBucketNumber to find the index of the arrayList
 *  [3] Method add to add the node with key & value to the MapNode
 *  [4] Method remove to delete the LinkList from array
 * @author Tom
 *
 * @param <K> - Here we have pass the Key
 * @param <V> - Here we pass the Value
 */
public class HashMap<K, V> {

	/**
	 * The numberOfBucket is the total size of the array
	 * And we have created the arrayList of LinkedList
	 */
	private final int numberOfBucket;
	ArrayList<LinkedList<K>> arrayList;

	public HashMap() {
		/**
		 * 1. We have made the arrayList of size 10
		 * Then we are creating a new ArrayList and adding the null vale to it
		 */

		numberOfBucket = 10;
		arrayList = new ArrayList<>();
		for (int i = 0; i < numberOfBucket; i++) {
			arrayList.add(null);
		}
	}


	public V get(K key) {
		/**
		 * [1]- We have created the method get to find the value of a specific key
		 * 1.  First we find the indexNumber which will range in between the bucket number.
		 * 2. Then we pass the index number to the arrayList to get the array's LinkedList & save this to the variable LinkedList
		 * 3. If LinkedList is null then we return null
		 * 4. If present then we  search the key in the LinkedList and save the value and key on the maNode
		 * 5. If mapNode is null then we return null or if value present then we return value 
		 * @param key -  We pass the key as input 
		 * @return -  After passing the key we will get the value of that key
		 */

		int indexNumber = this.getBucketNumber(key);
		LinkedList<K> linkedList = arrayList.get(indexNumber);

		if (linkedList == null) {
			return null;
		}
		MyMapNode<K, V> mapNode = (MyMapNode<K, V>) linkedList.search(key);
		return mapNode == null ? null : mapNode.getValue();
	}

	
	private int getBucketNumber(K key) {
		/**
		 * [2] Method getBucketNumber to find the index of the arrayList
		 * 1. First we get the hashcode of the key and save it into variable hashcode
		 * 2.Then we mod the hashCode with the size of the arrayList 
		 * 3. Then we get a number in the range of the arrayList
		 * @param key = Here the pass the key to find the index
		 * @return - We return the index value
		 */

		int hashCode = Math.abs(key.hashCode());
		return hashCode % this.numberOfBucket;
	}

	
	public void add(K key, V value) {
		/**
		 * [3] Method add to add the node with key & value to the MapNode
		 * 1.  First we find the indexNumber which will range in between the bucket number.
		 * 2. Then we pass the index number to the arrayList to get the array's LinkedList & save this to the variable LinkedList
		 * 3. If the arrayList is null then we create a new LinkedKist and set the LinkedList to that index
		 * 4. If LinkedList is preset then we search for that Key
		 * 5. If not preset then we make new node and append that to the LinkedList
		 * 6. if key is present then we just update the value
		 * @param key - Here we pass the key & value to add in the list
		 * @param value - Here we pass the key & value to add in the list
		 */

		int index = this.getBucketNumber(key);
		LinkedList<K> linkedList = this.arrayList.get(index);
		if (linkedList == null) {
			linkedList = new LinkedList<>();
			this.arrayList.set(index, linkedList);
		}

		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			linkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}
		
    public boolean remove(K key) {
    	/**
    	 * [4] Method remove to delete the LinkList from array
    	 * 1. First we pass the key and find the index of the LinkedList
    	 * 2. Then we check the arrayList and use the search to check the Node in the LinkedList
    	 * 3. Then we remove the Node and arrayList
    	 * @param key - we pass the key to remove the Mapnode
    	 * @return - We return true once it is deleted
    	 */
		
		int index = this.getBucketNumber(key);
		LinkedList<K> linkedList = this.arrayList.get(index);

		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);

		linkedList.remove(key);
		arrayList.remove(index);
		return true;	
	}

	@Override
	public String toString() {
		return "HashMap{" + arrayList +'}';
	}
}
