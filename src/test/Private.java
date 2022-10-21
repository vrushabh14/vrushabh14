package test;

public class Private {
	private int a = 10;
	private int b;

	private void test() {
		System.out.println("running private method for test");
	}
	public void check() {
		this.test();
	}
	public int getacess() {
		return b;
		
	}
	public void setdigit(int b){
		this.b = b;
	}

}
