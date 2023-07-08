package com.completablefuture.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExamples {

	
public static int findSquarePlusOne(int num){
		
		System.out.println("In findSquarePlusOne function: " + num + "thread: " + Thread.currentThread().getName());
		return (num * num) + 1;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		int num1 = 10;
		
		Future<Integer> future;
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		
		future  = es.submit(() -> findSquarePlusOne(num1));
		
		 System.out.println("the number after proceessing is:  ");
		
		int result  = future.get();// blocking call
		// here the boss is waiting for the employee to complete the task
		// so that boss can proceed futher 
		//wait and notify
		
		 System.out.println("the number after proceessing is :  " + result/2);
		 System.out.println("the number after proceessing is:  ");
		
		
		

	}

}
