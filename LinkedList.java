package com.snigdha.task;
public class LinkedList {
	
	int data;
	LinkedList next;
	static int i=0;
	LinkedList first=null;
	LinkedList tail=null;
	LinkedList prev=null;
public LinkedList setValues(int data,LinkedList next){
		LinkedList ll1=new LinkedList();
		ll1.data=data;
		ll1.next=next;
		return ll1;
	}
public void add(int data){
		LinkedList ll2=setValues(data,null);
		if (i==0){
			first=ll2;
			tail=ll2;
			prev=ll2;
		}
		else if (i==1){
			first.next=ll2;
			prev=first;
			tail=ll2;
		}
		else{
			prev=tail;
			tail.next=ll2;
			tail=ll2;
		}
		i++;
	}
	public void display(){
		for (LinkedList ll=first;ll!=null;ll=ll.next){
			System.out.print(ll.data+ "--> ");
		}
		System.out.println("End of the Linked List");
	}
	public void remove(int data){
		LinkedList llp=first;
		int count=0;
		if (data==first.data){
			first=first.next;
		}
		for (LinkedList ll=first;ll!=null;ll=ll.next){
			if (ll.data==data){
				llp.next=ll.next;
				count++;
			}
			else
				llp=ll;
		}
		tail=llp;
		if (count==0)
			System.out.println("Such element doesn't exist");
	}
	/*public static void main(String[] args){
		LinkedList l1=new LinkedList();
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.display();
		l1.remove(3);
		l1.display();
		
	}*/
		
}

