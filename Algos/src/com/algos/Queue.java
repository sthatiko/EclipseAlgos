package com.algos;



public class Queue<T> {
	
	private T[] array;
	private int front=-1,rear=-1;
	private final int capacity;
	

	@SuppressWarnings("unchecked")
	public Queue(int capacity){
		array = (T[])new Object[capacity];
		this.capacity = capacity;
	}
	
	public Queue(){
		this(29);
	}	

	
	public void enqueue(T element){
		   if (isFull()) {
	            throw new IllegalStateException("Queue is full");
	        } else if (isEmpty()) {
	            front++;
	            rear++;
	            array[rear] = element;
	        } else {
	            rear=(rear+1)%capacity;
	            array[rear] = element;
	        }
	}
	
	public T dequeue(){
		T element=null;
		if(isEmpty()){
			throw new IllegalStateException("Queue is empty");
		}
		else if(front==rear){
			element = (T)array[front];
			array[front]=null;
			front = -1;
			rear = -1;
		}else{
			element = (T)array[front];
			array[front]=null;
			front = (front+1)%capacity;
		}		
		return element;
	}
	
	public boolean isFull(){
		return (rear+1)%capacity==front;
	}
	
	public boolean isEmpty(){
		return (front==-1 && rear ==-1);
	}
	
	public int getCount(){
		if(isEmpty()) return 0;
		else if(rear>=front) return rear-front+1;
		else if(isFull()) return capacity;
		else return capacity-front+rear;
	}
	
	public T front(){
		if(!isEmpty()) return (T)array[front];
		else throw new IllegalStateException("Queue is empty");
	}
}
