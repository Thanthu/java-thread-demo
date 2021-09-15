package com.thanthu.thread.creation.runnableinterface;

public class CreateWithException {

	public static void main(String[] args) {
		// create();
		createWithLambda();
	}

	private static void create() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// Code that will run in a new thread
				throw new RuntimeException("Intentional Exception");
			}
		});

		thread.setName("Misbehaving thread");

		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"A critical error happened in thread " + t.getName() + " the error is " + e.getMessage());
			}
		});
		thread.start();
	}

	private static void createWithLambda() {
		Thread thread = new Thread(() -> {
			// Code that will run in a new thread
			throw new RuntimeException("Intentional Exception");
		});

		thread.setName("Misbehaving thread");

		thread.setUncaughtExceptionHandler((t, e) -> {
			System.out
					.println("A critical error happened in thread " + t.getName() + " the error is " + e.getMessage());
		});

		thread.start();
	}

}
