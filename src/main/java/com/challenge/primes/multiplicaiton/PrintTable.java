package com.challenge.primes.multiplicaiton;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrintTable {
	private List<Integer> primes;
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		ProductMatrix obj = (ProductMatrix) context.getBean("productMatrix");
		SieveEratosthenes sieveTool = (SieveEratosthenes) context.getBean("sieveEratosthenes");
		
		int n = 10;//default sum of prime numbers
		if(args.length>0) n = Integer.parseInt(args[0]);
		
		System.out.print("Enter prime number:\r\n");
		Scanner input = new Scanner(System.in);
		
		while(n<Long.MAX_VALUE){				
			n = input.nextInt();
			
			if(n<=0){
				System.out.print("exit");
				System.exit(-1);
			}
			
			List<Integer> primes = sieveTool.getPrimes(n);
			obj.initilize(primes, primes);

			int[][] products = obj.getSymmetricProducts();
			
			System.out.print("Your multipliation table generated:\r\n");
			int rownum = 0;
			int colnum = 0;
			for(int[] rows:products){
				rownum +=1;		
				colnum = 0;
				for(int cell: rows){
					if(cell==0)System.out.print(" \t");				
					else {
						if(colnum==0)
							System.out.print(cell + "\t");
						else 
							System.out.print("|" + cell + "\t");
					}
					colnum +=1;
				}
				System.out.print("\r\n");

				if(rownum==1||rownum==rows.length){
					for(int cell: rows){
						System.out.print("--------");
					}
					System.out.print("\r\n");
				}
			}
			
		}
	}
	
	public static String pad(int x) {
	      String s = new String();
	      if (x < 10) s = "  " + x;
	      else if (x < 100) s = " " + x;
	      else s = "" + x;
	      return s;
	}
}
