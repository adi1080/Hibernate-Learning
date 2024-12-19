package com.cjc.ims.app.client;

import java.util.*;
import com.cjc.ims.app.serviceimpl.Karvenagar;
import com.cjc.ims.app.serviceimpl.Karvenagar_practice;
import com.cjc.ims.app.serviceimpl.WrongInputException;

public class TestUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Karvenagar_practice k = new Karvenagar_practice();

		while (true) {
			System.out.println("**********MENU***********\n"
					+ "Enter your choice : \n 1.add course \n 2.view course \n 3.add faculty \n 4.view faculty"
					+ " \n 5.add batch \n 6.view batch \n 7.add student \n 8.view student \n************************");

			try {
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					try {
					    k.addCourse();
					} 
					catch (WrongInputException e) {
					    System.out.println("Error: " + e.getMessage());
					}
					break;

				case 2:
					k.viewCourse();
					break;

				case 3:
					try {
					    k.addFaculty();
					} catch (WrongInputException e) {
					    System.out.println("Error: " + e.getMessage());
					}
					break;

				case 4:
					k.viewFaculty();
					break;

				case 5:
					try {
					    k.addBatch();
					} catch (WrongInputException e) {
					    System.out.println("Error: " + e.getMessage());
					}
					
					break;

				case 6:
					k.viewBatch();
					break;

				case 7:
					try {
					    k.addStudent();
					} catch (WrongInputException e) {
					    System.out.println("Error: " + e.getMessage());
					}
					break;

				case 8:
					k.viewStudent();
					break;

				default:
					System.out.println("Invalid choice! Please enter a number between 1 to 8");
					break;
				}
			}
			 catch (Exception e1) {
				System.out.println("An error occured!"+e1.getMessage());
				sc.next();
			}
		}
	}
}
