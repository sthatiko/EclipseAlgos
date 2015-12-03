package com.algos;

public class SLLNode<E> {
	public E data;
	public SLLNode<E> next;
	
	public static void main(String[] args){
		SLLNode<Integer> sll = SLLNode.getSampleSLL();
		sll = mergeSort(sll);
		printSLL(sll);
	}
	
	public SLLNode(E data){
		this.data = data;
	}
	
	public SLLNode(E data, SLLNode<E> next){
		this.data = data;
		this.next = next;
	}
	
	public static <T> SLLNode<T> createSLL(T[] values){		
		SLLNode<T> head = null,current=null;
		for(T i: values){
			if(head==null){
				head = new SLLNode<T>(i);
				current = head;
				continue;
			}
			current.next = new SLLNode<T>(i);
			current = current.next;
		}
		printSLL(head);
		return head;
	}
	
	public static SLLNode<Integer> getSampleSLL(){
		Integer[] values = ArrayUtil.toObject(ArrayUtil.getRandomArray(5));
		return createSLL((Integer[])values);
	}
	
	public static <T> void printSLL(SLLNode<T> head){
		System.out.print("SLL : ");
		while(head!=null){
			System.out.print(head.data);
			head = head.next;
			if(head!=null) System.out.print(" -> ");
		}
		System.out.println();
	}
	
	public static <T> SLLNode<T> reverse(SLLNode<T> head){
		 SLLNode<T> c1=null,c2=head,c3;
		 while(c2!=null){
			 c3=c2.next;
			 c2.next = c1;
			 c1=c2;
			 c2=c3;
		 }
		 System.out.print("Reverse order ");
		 printSLL(c1);
		 return c1;
	}
	
	public static <T> SLLNode<T> split(SLLNode<T> head){
		if(head == null || head.next == null) return null;
		SLLNode<T> slow = head, fast = head.next;
		while(fast!=null){
			fast = fast.next;
			if(fast!=null){
				fast = fast.next;
				slow=slow.next;
			}
		}
		SLLNode<T> tmp = slow.next;
		slow.next=null;
		return tmp;
	}
	
	/* Merges two sorted linked lists */
	
	public static <T extends Comparable<T>> SLLNode<T> merge(SLLNode<T> A, SLLNode<T> B){
		SLLNode<T> fList,tmp = null;
		if(A.data.compareTo(B.data) <=0){
			fList = A;
			A=A.next;
		}else{
			fList = B;
			B = B.next;
		}
		tmp = fList;
		while(A!=null && B!=null){
			if(A.data.compareTo(B.data) <=0){
				tmp.next = A;
				A=A.next;
			}else{
				tmp.next = B;
				B = B.next;
			}
			tmp = tmp.next;
		}
		if(A!=null)tmp.next=A;
		else tmp.next = B;
		return fList;
	}
	
	public static <T extends Comparable<T>> SLLNode<T> mergeSort(SLLNode<T> head){
		if(head!=null && head.next!=null){
			SLLNode<T> a = split(head);
			head = mergeSort(head);
			a = mergeSort(a);
			head = merge(head,a);
		}
		return head;
	}
}
