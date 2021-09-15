package com.thanthu.thread.creation.threadinheritance;

public class Create {
	
	public static void main(String[] args) {
		Thread thread = new NewThread();

		System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
		thread.start();
		System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
	}
	
	public static class NewThread extends Thread {
		
		@Override
		public void run() {
			this.setName("New Worker Thread");
			this.setPriority(Thread.MAX_PRIORITY);
			
			System.out.println("we are now in thread " + Thread.currentThread().getName());
			System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
		}
	}

}
