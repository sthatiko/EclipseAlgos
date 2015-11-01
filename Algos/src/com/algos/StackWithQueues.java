package com.algos;

public class StackWithQueues<T> {
	
	private Queue<T> q1 ;
	private Queue<T> q2 ;
	int size =0;
	
	public StackWithQueues() {
		q1 = new Queue<T>(25);
		q2 = new Queue<T>(25);
	}
	
	public void push(T element){
		 q1.enqueue(element);
	}

	public T pop(){
		while(q1.getCount()>1){
			q2.enqueue(q1.dequeue());
		}
		T ret = q1.dequeue();
		Queue<T> temp = q1;
		q1=q2;
		q2=temp;
		return ret;
	}
	public static void main(String[] args) {
		StackWithQueues<Integer> ds = new StackWithQueues<Integer>();
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
