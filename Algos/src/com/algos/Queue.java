package com.algos;



public class Queue<T> {
	
	private Object[] array;
	private int front=-1,rear=0;
	private final int capacity;
	

	public Queue(int capacity){
		array = new Object[capacity];
		this.capacity = capacity;
	}
	
	public Queue(){
		this(25);
	}	

	
	public T enqueue(T element){
		if(!isFull()){
			array[rear]=element;
			rear = (rear+1)%capacity;
			if(front==-1)front=0;//first element inserted into queue so front should point first element.
			return element;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue(){
		T element=null;
		if(!isEmpty()){
			element = (T)array[front];
			array[front]=null;
			front = (front+1)%capacity;
		}
		return element;
	}
	
	public boolean isFull(){
		return getCount()==capacity;
	}
	
	public boolean isEmpty(){
		return getCount()==0;
	}
	
	public int getCount(){
		if(front==-1) return 0;
		else if(rear>=front) return rear-front;
		else return capacity-front+rear;
	}
	
	@SuppressWarnings("unchecked")
	public T front(){
		if(!isEmpty()) return (T)array[front];
		else return null;
	}
}
