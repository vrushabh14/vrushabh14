package test;

public class Constructor {
		int a = 10;
		int b = 20;
		
		public void details() {
			System.out.println("Addition result is: "+(a+b));
		}
		private Constructor() {
			System.out.println("Running private constructor");
		}
		static Constructor getinstance() {
			Constructor c1 = new Constructor();
			System.out.println("c :"+ c1);
			return c1;
			
		}
}
