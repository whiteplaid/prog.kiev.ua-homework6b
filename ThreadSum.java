package com.homework.threadsum;


public class ThreadSum implements Runnable {

	private int[] mass;
	private int number;
	private int start;
	private int stop;


	public ThreadSum(int[] mass, int start, int stop) {
		super();
		this.mass = mass;
		this.start = start;
		this.stop = stop;
	}

	public ThreadSum() {
		super();
	}

	public int getNumber() {
		return number;
	}

	private void setNumber(int number) {
		this.number = number;
	}

	private int calculateSum (int[] mass, int start, int stop) {
		int result=0;
		for (int i = start; i < stop; i++) {
				result += mass[i];
		}
		return result;
	}
	@Override
	public void run() {
		synchronized (mass) {
			setNumber(calculateSum(mass,start,stop));
		}
		
	}

}
