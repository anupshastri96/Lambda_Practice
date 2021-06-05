package lambda.practical.two;

public class TypeInference {

	public static void main(String[] args) {

		lengthOfString(s -> s.length());
	}

	public static void lengthOfString(MyLamdaInterface mli) {
		System.out.print(mli.stringLength("Hello World"));
	}

	@FunctionalInterface
	interface MyLamdaInterface{

		int stringLength(String s);
	}

}




