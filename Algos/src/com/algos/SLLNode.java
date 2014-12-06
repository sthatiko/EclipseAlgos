package com.algos;

public class SLLNode<E> {
	public E data;
	public SLLNode<E> next;
	
	public SLLNode(E data){
		this.data = data;
	}
	
	public SLLNode(E data, SLLNode<E> next){
		this.data = data;
		this.next = next;
	}
}
