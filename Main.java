package com.homework.threadsum;


public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int sum = 0;
		int[] mass = new int[1000000];
		
		for (int i = 0; i < mass.length; i++) {
			mass[i] = (int)(Math.random()*100);
			sum+=mass[i];
		}
		System.out.println("" + sum + " " + (System.currentTimeMillis() - start) + "ms");
		long start2 = System.currentTimeMillis();
		Thread[] tmp = new Thread[4];
		ThreadSum[] st = new ThreadSum[4];
		int countMas = 0;
		int separator = mass.length/tmp.length;
		
		for (int i = 0; i < tmp.length; i+=1) {
			st[i] = new ThreadSum (mass,countMas,separator * (i+1));
			for (int j = 0; j < separator;j++) {
				countMas++;
			}
			
			tmp[i] = new Thread(st[i]);
			
			
		}
		for (int i = 0; i < tmp.length;i++) {
			tmp[i].start();
		}
		try {
		for (int i = 0; i < tmp.length;i++) {
			tmp[i].join();
		}
		} catch (InterruptedException e) {
			
		}
		int result = 0;
		for (int i = 0; i < st.length;i++) {
			result += st[i].getNumber();
		}
		
		System.out.println(result + " " + (System.currentTimeMillis() - start2) + "ms");
	}
}
