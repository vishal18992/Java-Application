package com.mobile.recharge;

public class MainApp {
	public static void main(String args[]) {
		VodaphoneRecharge vp = new VodaphoneRecharge();
		float balance = 100.99f;
		vp.recharge(balance);
		MobileRecharge idr = new IdeaRecharge();
		idr.recharge(balance);
		
		String  s = "sss";
		
	}
}
