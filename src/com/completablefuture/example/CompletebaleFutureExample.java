package com.completablefuture.example;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class CompletebaleFutureExample {
	
	//q1 Given a number find the square + 1 of the number 
	
	public static int findSquarePlusOne(int num){
		
		System.out.println("In findSquarePlusOne function: " + num + "thread: " + Thread.currentThread().getName());
		return (num * num) + 1;
	}
	
	public static CompletableFuture<Integer> calculate(int num){
		return CompletableFuture.supplyAsync(() -> findSquarePlusOne(num));
	}
	
	

	public static void main(String[] args) {
		
	Stream<Integer> obj = Stream.of(1,2,3,4,5,6,7);
	
	int num1 = 10;
	
	 CompletableFuture<Integer>  result = calculate(num1);
	 CompletableFuture<Integer>  result2 = calculate(num1 + 2);
		
		
	 result.thenApply(x -> {
		 System.out.println( "thread: " + Thread.currentThread().getName());
		 return x/2;
	 }).thenAccept(y->{
		 System.out.println("the number after proceessing is " + y);
	 });
		
	 System.out.println( "thread2");
	 System.out.println( "thread3");
		

	}

}
