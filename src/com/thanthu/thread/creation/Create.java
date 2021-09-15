package com.thanthu.thread.creation;

public class Create {

	public static void main(String[] args) {
		//create();
		createWithLambda();
	}

	private static void create() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// Code that will run in a new thread
				System.out.println("we are now in thread " + Thread.currentThread().getName());
				System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
			}
		});

		thread.setName("New Worker Thread");
		thread.setPriority(Thread.MAX_PRIORITY);

		System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
		thread.start();
		System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
	}

	private static void createWithLambda() {
		Thread thread = new Thread(() -> {
			// Code that will run in a new thread
			System.out.println("we are now in thread " + Thread.currentThread().getName());
			System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
		});

		thread.setName("New Worker Thread");
		thread.setPriority(Thread.MAX_PRIORITY);

		System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
		thread.start();
		System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
	}

}
