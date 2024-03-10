package com.Adesh;

public class Player2 extends Player1{
	private int health;
	private boolean Armour;
	
	public Player2(String name, String weapon, int health, boolean armour) {
		super(name, weapon, health);
		this.health = health;
		this.Armour = armour;
	}

	@Override
	public void damageByGun1() {
		if (Armour) {
			this.health -= 20;
			if(this.health <=0) this.health = 0;
			System.out.println("Armour is on.Got hit by Gun1.Health reduced by 20." + "New Health is " + this.health);		
			}
		if (!Armour) {
			this.health -= 30;
			if(this.health <=0) this.health = 0;
			System.out.println("Armour is off.Got hit by Gun1.Health reduced by 30." + "New Health is " + this.health);			
		}
		if(this.health ==0) {
			System.out.println(getName() + "is dead");
		}
	}

	@Override
	public void damageByGun2() {
		if (Armour) {
			this.health -= 40;
			if(this.health <=0) this.health = 0;
			System.out.println("Armour is on.Got hit by Gun2.Health reduced by 40." + "New Health is" + this.health);		
			}
		if (Armour) {
			this.health -= 50;
			if(this.health <=0) this.health = 0;
			System.out.println("Armour is off.Got hit by Gun2.Health reduced by 50." + "New Health is" + this.health);			
		}
		if(this.health ==0) {
			System.out.println(getName() + "is deead");
		}
	}

	@Override
	public void heal() {
		// TODO Auto-generated method stub
		super.heal();
	}
	
	
	
	
	
	
	
	
	
	
}