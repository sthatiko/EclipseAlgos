package com.algos;

public class Stack<T> {
	private int top,size,capacity;
	T[] stack;
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		stack = (T[]) new Object[capacity];
		this.capacity = capacity;
	}

	public T push(T x){
		if(size<capacity){
			stack[top++]=x;
			size++;
			return x;
		}
		return null;
	}
	
	public T pop(){
		if(size>0) {
			size--;
			return stack[--top];
		}
		return null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public T peek(){
		if(top<=0)return null;
		return stack[top-1];
	}
}
