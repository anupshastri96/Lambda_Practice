
public class App {

	public static void main(String[] args) {
		
		Human h = new Human();
		//walker(h);
		
		Robot r = new Robot();
		//walker(r);
		
//		walker(new Walkable() {
//
//			@Override
//			public void walk() {
//				System.out.println("Walk anony running");
//				
//			}});
		
		walker(() -> {
				System.out.println("Walk anony running");
				System.out.println("Walk lambda running");
				});

		Walkable aBlockOfCOde = () -> {
			System.out.println("Walk anony running");
			System.out.println("Walk lambda running");
			};

		walker(aBlockOfCOde);
		
		ALambdaClass helloThere = () -> System.out.println("Hello");
		
		SumInterface sumCaller = (a, b) -> a+b;
		
		SumInterface divideCaller = (a,b) ->{
			if(a==0) {
				return 0;
			}	
			return a/b;
		};
		
		SingleGenericOperation<String> reverse = (s) -> {
			
			String result="";
			
			for(int i=s.length()-1;i>=0;i--) {
				result += s.charAt(i);
			}
			return result;
			
		};
		
		//System.out.println(factorial(5));
		
		SingleGenericOperation<Integer> factorial = (x) -> {
			int result = 1;
			for(int i = 1; i <=x; i++) {
				result *= i;
			}
			return result;

		};
		
		
		
		System.out.println(sumCaller.sum(4, 10));
		System.out.println(divideCaller.sum(10, 5));
		System.out.println(reverse.work("Aditi"));
		System.out.println(factorial.work(5));
		//System.out.println(stringReverse("Anup"));
		
	}
	
	public int sum(int args1, int args2) {
		return args1+args2;
	}
	
	public void sayHello() {
		
		System.out.println("Hello");
		
	}
	
	public static String stringReverse(String s) {
		
		String result="";
		
		for(int i=s.length()-1;i>=0;i--) {
			result += s.charAt(i);
		}
		return result;
	}
	
	public static void walker(Walkable entity) {
		entity.walk();
	}
	
	public static int factorial(int num) {
		int result = 1;
		for(int i = 1; i <=num; i++) {
			result *= i;
		}
		return result;
	}
	
//	public interface StringManipulation {
//		
//		public String manipulate(String s);
//
//	}
//	
//	public interface SingleArgOperation {
//		
//		public int factorial(int fac);
//
//	}
	
	public interface SingleGenericOperation<T> {
		
		public T  work(T s);

	}


}
