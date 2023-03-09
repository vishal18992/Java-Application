class Pattern {
	public static void main(String[] args) {

		for(int i=0;i<=10;i++) {
			for(int j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		for(int i=0;i<=14-1;i++) {
			for(int j=14;j>i;j--){
				if(i%2!=0 ) {
					System.out.print("*");
				}
			}
			if(i%2==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}