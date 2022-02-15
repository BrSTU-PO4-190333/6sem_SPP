package io.github.Pavel_Innokentevich_Galanin;

public class Main {
	public static void main(String [] args) {
		System.out.println("Основной поток создан");
		Spp6Lab1Option5_Thread class_instance = new Spp6Lab1Option5_Thread();
		class_instance.start();
		try {
			class_instance.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Основной поток закончен");
	}
}
