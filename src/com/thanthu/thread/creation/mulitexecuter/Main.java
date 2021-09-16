package com.thanthu.thread.creation.mulitexecuter;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Runnable runnableOne = new Runnable() {

			@Override
			public void run() {
				System.out.println("Executing task one.");
			}
		};

		Runnable runnableTwo = new Runnable() {

			@Override
			public void run() {
				System.out.println("Executing task two.");
			}
		};

		MultiExecutor multiExecutor = new MultiExecutor(Arrays.asList(runnableOne, runnableTwo));
		multiExecutor.executeAll();
	}

}
