package com.thanthu.thread.creation.mulitexecuter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiExecutor {
	
	List<Runnable> tasks = new ArrayList<>();

	/*
	 * @param tasks to executed concurrently
	 */
	public MultiExecutor(List<Runnable> tasks) {
		if(tasks != null) {
			this.tasks = tasks;
		}
	}

	/**
	 * Starts and executes all the tasks concurrently
	 */
	public void executeAll() {
		for (Runnable runnable : tasks) {
			new Thread(runnable).start();
		}
	}
}
