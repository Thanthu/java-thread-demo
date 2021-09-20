package com.thanthu.thread.synchronization.atomicreference;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
	
	public static void main(String[] args) {
		String oldName = "old name";
		String newName = "new name";
		String newerName = "newer name";
		AtomicReference<String> atomicReference = new AtomicReference<>(oldName);
		
		atomicReference.compareAndSet(oldName, newName);
		System.out.println(atomicReference.get());
		
		atomicReference.compareAndSet(oldName, newerName);
		System.out.println(atomicReference.get());
	}

}
