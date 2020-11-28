package com.ds.queue;

public class CircularQueue {

	private int size;
	private String[] arr;
	private int front, rear;

	public CircularQueue(int size) {
		this.size = size;
		arr = new String[this.size];
		front = rear = -1;

	}

	public boolean enqueue(String item) {
		if ((rear == size - 1 && front == 0) || front == rear + 1) {
			return false;
		} else if (front == -1 && rear == -1) {
			front = rear = 0;
			arr[rear] = item;
		} else if (rear == size - 1) {
			rear = 0;
			arr[rear] = item;
		} else {
			rear++;
			arr[rear] = item;
		}
		return true;
	}

	public boolean dequeue() {
		if (front == -1 && rear == -1) {
			return false;
		} else if (front == rear) {
			arr[front] = null;
			front = rear = -1;
		} else if (front == size - 1) {
			arr[front] = null;
			front = 0;
		} else {
			arr[front] = null;
			front++;
		}
		return true;
	}

	public void display() {
		if (rear > front) {
			int i = front;
			while (i <= rear) {
				System.out.println("Printing records :" + arr[i]);
				i++;
			}
		} else {
			int i = front;
			while (i <= size - 1) {
				System.out.println("Printing records :" + arr[i]);
				i++;
			}
			i = 0;
			while (i <= rear) {
				System.out.println("Printing records :" + arr[i]);
				i++;
			}
		}

	}
}
