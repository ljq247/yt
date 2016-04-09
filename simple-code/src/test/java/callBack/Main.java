package callBack;

public class Main {
	
	public static void main(String[] args) {
		
		Tiger tiger=new Tiger();
	
	    final String string="hello world!";
		tiger.speak(new IPrintf() {
			
			//@Override
			public void printf() {
				// TODO Auto-generated method stub
				System.out.println(
						this.getClass());
				System.out.println(string);
			}
		});
		
		
	}

}
