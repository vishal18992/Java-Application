package com.mobile.recharge;

public class VodaphoneRecharge extends MobileRecharge{
	VodaphoneRecharge() {
		super();
	}
	
	public void recharge(float balance) {
		System.out.println("VodaphoneRecharge of MobileRecharge" + balance);
	};
}
