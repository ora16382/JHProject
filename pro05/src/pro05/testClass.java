package pro05;

class testClass2 {

	protected void parentOut() {
		System.out.println("parentOut");
	}
}


public class testClass extends testClass2{
	
	public void pubOut() {
		System.out.println("pubOut");
	}
	 void defOut() {
		System.out.println("defOut");
				
	}
	protected void proOut() {
		System.out.println("protected");
	}
}
