
public class test2 extends test {

	@Override
	public void syso() {
		System.out.println("자식 메서드");
	}
	
	public static void main(String[] args) {
		test t = new test2();
		t.syso();
	}
}
