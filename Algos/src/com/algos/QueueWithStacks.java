package com.algos;

public class QueueWithStacks<T> {
	Stack<T> inbox = new Stack<T>(10);
	Stack<T> outbox = new Stack<T>(10);
	
	public T enqueue(T x){
		return inbox.push(x);
	} 
	
	public T dequeue(){
		if(outbox.size()==0)
			while(inbox.size()>0)
				outbox.push(inbox.pop());
		return outbox.pop();
	}
	
	public static void main(String... args){
		QueueWithStacks<Integer> ds = new QueueWithStacks<Integer>();
		ds.enqueue(2);
		ds.enqueue(3);
		ds.enqueue(4);
		ds.enqueue(5);
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		ds.enqueue(6);
		ds.enqueue(7);
		ds.enqueue(8);
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		System.out.print(ds.dequeue() + " ");
		
	}
}
