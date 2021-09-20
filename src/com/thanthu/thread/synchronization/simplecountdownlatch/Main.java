package com.thanthu.thread.synchronization.simplecountdownlatch;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int numberOfThreads = 3; // or any number you'd like

		List<Thread> threads = new ArrayList<>();
		
		SimpleCountDownLatch simpleCountDownLatch = new SimpleCountDownLatch(numberOfThreads);
		for (int i = 0; i < numberOfThreads; i++) {
			threads.add(new Thread(new CoordinatedWorkRunner(simpleCountDownLatch)));
		}

		for (Thread thread : threads) {
			thread.start();
		}
	}

	public static class CoordinatedWorkRunner implements Runnable {

		SimpleCountDownLatch simpleCountDownLatch;
		
		public CoordinatedWorkRunner(SimpleCountDownLatch simpleCountDownLatch) {
			this.simpleCountDownLatch = simpleCountDownLatch;
		}

		@Override
		public void run() {
			try {
				task();
			} catch (InterruptedException e) {
			}
		}

		private void task() throws InterruptedException {
			// Performing Part 1
			System.out.println(Thread.currentThread().getName() + " part 1 of the work is finished");

			if(simpleCountDownLatch.getCount() > 0) {
				simpleCountDownLatch.countDown();
			} else {
				simpleCountDownLatch.await();
			}
			
			// Performing Part2
			System.out.println(Thread.currentThread().getName() + " part 2 of the work is finished");
		}
	}

}
