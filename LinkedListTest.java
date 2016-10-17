package com.snigdha.task;

import java.util.Scanner;

public class LinkedListTest {
	static LinkedList mon=new LinkedList();
	public static void main(String[] args){
	
		Scanner in=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		String ch=null;
		do{
		System.out.println("Choose the no. of the action you want to perform :");
		System.out.println("1.Adding elements");
		System.out.println("2.Deleting elements");
		System.out.println("3.Displaying the Linked List");
		int choice=sc.nextInt();
		switch(choice){
		case 1:
			System.out.println("Enter -1 to stop inserting elements :");
			int i=in.nextInt();
			while(i!=-1){
				mon.add(i);
				i=in.nextInt();
			}
			System.out.println("Linked List after insertion :");
			mon.display();
			break;
		case 2:
			System.out.println("Enter the element you want to delete :");
			int r=in.nextInt();
			mon.remove(r);
			System.out.println("Linked List after deletion :");
			mon.display();
			break;
		case 3:
			System.out.println("Linked List Display :");
			mon.display();
			break;
		default:
			System.out.println("Wrong option");
			break;
		}
		System.out.println("Would you like to continue y/n");
		ch=sc.next();
		}while(ch.equalsIgnoreCase("y"));
		System.out.println("----- End of the Operations on Linked List ------");
		sc.close();
		in.close();
	}
	
}
