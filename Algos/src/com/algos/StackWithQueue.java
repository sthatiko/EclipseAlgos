package com.algos;

public class StackWithQueue<T> {
	
	Queue<T> q ;
	
	public StackWithQueue() {
		q  = new Queue<T>();
	}
	
	public void push(T element){
		q.enqueue(element);
	}
	
	public T pop(){
		reverseQ();
		T res = q.dequeue();
		reverseQ();
		return res;
	}
	
	private void reverseQ(){
		if(q.isEmpty()) return ;
		T res = q.dequeue();
		reverseQ();
		q.enqueue(res);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackWithQueue<Integer> ds = new StackWithQueue<Integer>();
		ds.push(2);
		ds.push(3);
		ds.push(4);
		ds.push(5);
		System.out.println(ds.pop()+" ");
		System.out.println(ds.pop()+" ");
		ds.push(6);
		ds.push(7);
		System.out.println(ds.pop()+" ");
		System.out.println(ds.pop()+" ");
		ds.push(8);
		System.out.println(ds.pop()+" ");
		System.out.println(ds.pop()+" ");

	}

}
