package lambda.practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {

		List<Car> cars = Arrays.asList(new Car("Honda", "Accord", "Red", 22300),
				new Car("Honda", "Civic", "Blue", 17700),
				new Car("Toyota", "Land Cruiser", "White", 48500),
				new Car("Toyota", "Corolla", "Black", 16200),
				new Car("Toyota", "Camry", "Blue", 24000),
				new Car("Nissan", "Sentra", "White", 17300),
				new Car("Mitsubishi", "Lancer", "White", 20000),
				new Car("Jeep", "Wrangler", "Red", 24500));
		
		
		Function<Car,String> priceandColor = (c)-> "price="+c.getPrice()+" color= "+c.getColor();
		String stringCar = priceandColor.apply(cars.get(0));
		System.out.println(stringCar);
		
//		printCars(cars, new CarCondition() {
//
//			@Override
//			public boolean work(Car c) {
//				return c.getPrice() >= 2000 && c.getPrice()<=3000 ;
//				
//			}
//		});
//		
//		printCars(cars, new CarCondition() {
//
//			@Override
//			public boolean work(Car c) {
//				return c.getColor().equalsIgnoreCase("Red");
//				
//			}
//		});

		printCars(cars, (c) -> c.getPrice() >= 20000 && c.getPrice()<=30000); 
		
		printCars(cars, (c) -> c.getColor().equalsIgnoreCase("Red"));
        	
	}	

//	public static void printCarByPriceRange(List<Car> cars, int low, int high) {
//		
//		for(Car c : cars) {
//			if(c.getPrice() >= low && c.getPrice()<=high) {
//				c.printCar();
//			}
//		}		
//	}
//	
//	public static void printCarByColor(List<Car> cars, String color) {
//		for(Car c : cars) {
//			if(c.getColor().equalsIgnoreCase(color)) {
//				c.printCar();
//			}
//		}
//	}
	




	private static void printCars(List<Car> cars, Predicate<Car> predicate) {
		for(Car c : cars) {
			if(predicate.test(c)) {
				c.printCar();
			}
		}
	}

//	@FunctionalInterface
//	interface Condition<T>{
//		
//		public boolean work(T t);
//		
//	}
}



