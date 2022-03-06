package com.bridgelabz;

/**
 * Node Interface with Key and next
 * @author Tom
 *
 * @param <K> - We have created generic type of Key
 */
public interface Node<K> {

	K getKey();

	void setKey(K key);

	void setNext(Node<K> next);

	Node<K> getNext();

}
