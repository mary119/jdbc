package com.xworkz.creatingjar;

public class Tester {

	public static void main(String[] args) {

		Metro metro=new Metro();
		
		metro.name="Namma Metro";
		metro.coach=6;
		
		System.out.println(metro.toString());
		metro.transportation();
	}

}
