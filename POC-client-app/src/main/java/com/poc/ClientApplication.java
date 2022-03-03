package com.poc;

import java.util.Scanner;

import com.poc.config.ClientConfig;

public class ClientApplication {

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		int loop;
		try {
			do {
				System.out.println("----------------------------------------");
				System.out.println("WELCOME TO SIN CITY VAPE SHOP");
				System.out.println("----------------------------------------");
				System.out.println("[1]View Products [2]Add Products [3]Order Products \nPlease choose: ");
				Scanner scanner = new Scanner(System.in);
				int homeScanner = scanner.nextInt();
				if (homeScanner == 1) {
					clientConfig.viewProducts();
				}

				if (homeScanner == 2) {
					clientConfig.addProduct();
				}

				if (homeScanner == 3) {
					main(args);
				}
				System.out.println("----------------------------------------");
				System.out.println("DO YOU WANT TO CONTINUE? [1]YES | [2]NO");
				loop = scanner.nextInt();
			} while (loop == 1);
		} catch (NumberFormatException numberFormatException) {
			System.out.println("Error! Please input a number 1 or 2");
		}
		System.out.println("Program is shutting down, please close!");
	}
}
