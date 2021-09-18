package com.thanthu.thread.synchronization.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntersectionFixReentrantLock {

	public static void main(String[] args) {
		Intersection intersection = new Intersection();
		Thread trainAThread = new Thread(new TrainA(intersection));
		Thread trainBThread = new Thread(new TrainB(intersection));

		trainAThread.start();
		trainBThread.start();
	}

	public static class TrainB implements Runnable {
		private Intersection intersection;
		private Random random = new Random();

		public TrainB(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				long sleepingTime = random.nextInt(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
				}

				intersection.takeRoadB();
			}
		}
	}

	public static class TrainA implements Runnable {
		private Intersection intersection;
		private Random random = new Random();

		public TrainA(Intersection intersection) {
			this.intersection = intersection;
		}

		@Override
		public void run() {
			while (true) {
				long sleepingTime = random.nextInt(5);
				try {
					Thread.sleep(sleepingTime);
				} catch (InterruptedException e) {
				}

				intersection.takeRoadA();
			}
		}
	}

	public static class Intersection {
		private Lock roadA = new ReentrantLock();
		private Lock roadB = new ReentrantLock();

		public void takeRoadA() {
			if (roadA.tryLock()) {
				try {
					if (roadB.tryLock()) {
						try {
							System.out.println("Road A is locked by thread " + Thread.currentThread().getName());
							System.out.println("Train is passing through road A");
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
							}
						} finally {
							roadB.unlock();
						}
					}
				} finally {
					roadA.unlock();
				}
			}
		}

		public void takeRoadB() {
			if (roadB.tryLock()) {
				try {
					if (roadA.tryLock()) {
						try {
							System.out.println("Road B is locked by thread " + Thread.currentThread().getName());
							System.out.println("Train is passing through road B");
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
							}
						} finally {
							roadA.unlock();
						}
					}
				} finally {
					roadB.unlock();
				}
			}
		}
	}
}
