package com.algos;

import java.util.Stack;

public class QueueWithStack<T> {
	private Stack<T> stack;
	int size =0;
	public QueueWithStack(){
		stack = new Stack<T>();
	}
	
	public T enqueue(T element){
			stack.push(element);
			return element;
	}
	
	public T dequeue(){
		return getReverseTop();
		
	}
	
	public T getReverseTop(){
		if(stack.size()==0) return null;
		T res = stack.pop();
		T e = getReverseTop();
		if(e==null) return res;
		else{
			stack.push(res);
			return e;
		}
	}
	
	public static void main(String... args){
		QueueWithStack<Integer> ds = new QueueWithStack<Integer>();
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
