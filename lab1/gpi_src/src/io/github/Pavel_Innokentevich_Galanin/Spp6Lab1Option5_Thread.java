package io.github.Pavel_Innokentevich_Galanin;

import java.util.Scanner;

public class Spp6Lab1Option5_Thread extends Thread {
	public void run() {
		System.out.println("Дочерний поток создан");
	    Scanner in = new Scanner(System.in);  
	    
	    System.out.print("n = ");
	    int n = in.nextInt();
	    
	    double a;
	    double sum = 0;
		for (int i = 1; i < n; ++i) {
			a = (double) 1 / ( (2*i - 1) * (2 * i + 1) );
			//System.out.println(a);
			sum += a;
		}
		
		System.out.println("sum = " + sum);
		System.out.println("Дочерний поток закончен");
	}
}
