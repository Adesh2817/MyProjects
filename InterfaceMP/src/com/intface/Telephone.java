package com.intface;

public interface Telephone {
	
	void PowerOn();
	void Dial(String phonenumber);
	void Answer();
	boolean callPhone(String phoneNumber);
	boolean isRinging();

}
