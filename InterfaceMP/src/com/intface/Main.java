package com.intface;

public class Main {

	public static void main(String[] args) {
//		DeskPhone myphone = new DeskPhone("123456");
//		myphone.PowerOn();
//		myphone.callPhone("123456");
//		myphone.Answer();
		
		MobilePhone myPhone = new MobilePhone("12345656");
		myPhone.PowerOn();
		myPhone.callPhone("123456");
		myPhone.Answer();

	}

}
