package com.intface;

public class DeskPhone implements Telephone {

    private String myNumber;
    private boolean isRinging;

    public DeskPhone(String myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void PowerOn() {
        System.out.println("DeskPhone is On");
    }

    @Override
    public void Dial(String phonenumber) {
    	System.out.println("Now ringing " + myNumber + "on a deskphone");
    }

    @Override
    public void Answer() {
        if(isRinging) {
        	System.out.println("Answering on the deskphone");
        	isRinging=false;
        }else {
        	System.out.println("DeskPhone is not ringing");
        }
    }

    @Override
    public boolean callPhone(String phoneNumber) {
        if(phoneNumber == myNumber) {
        	isRinging = true;
        	System.out.println("Phone is Ringing");
        }else {
        	isRinging=false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        
        return isRinging;
    }
}

