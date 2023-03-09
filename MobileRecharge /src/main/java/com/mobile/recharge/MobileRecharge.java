package com.mobile.recharge;

public abstract class MobileRecharge implements RechargeService {
	private float rechageAmount;
	
	
	MobileRecharge(){
	}
	public void recharge(float balance) {
		System.out.println("Recharge of MobileRecharge" + balance);
	};
}
