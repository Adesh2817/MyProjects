package com.intface;

public class MobilePhone implements Telephone{
	
	private String myNumber;
	private boolean isRinging;
	private boolean isPowerOn;
	
	public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void PowerOn() {
    isPowerOn = true;
        System.out.println("Phone is On");
    }

    @Override
    public void Dial(String phonenumber) {
    	System.out.println("Now ringing " + myNumber + "on a deskphone");
    }

    @Override
    public void Answer() {
        if(isRinging && isPowerOn) {
        	System.out.println("Answering on the deskphone");
        	isRinging=false;
        }else {
        	System.out.println("DeskPhone is not ringing");
        }
    }

    @Override
    public boolean callPhone(String phoneNumber) {
        if(phoneNumber == myNumber && isPowerOn) {
        	isRinging = true;
        	System.out.println("Phone is Ringing");
        }else {
        	System.out.println("Either Phone is Off or Wrong number called");
        	isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        
        return isRinging;
    }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
