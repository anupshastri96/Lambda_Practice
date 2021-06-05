package stream.practical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {
		
		IntStream.range(1, 10).forEach((x) -> System.out.print(x));
		
		System.out.println();
		
		IntStream.range(1, 10).skip(5).forEach((x) -> System.out.print(x));
		
		System.out.println();
		
		int val = IntStream.range(1, 5).sum();
		System.out.println(val);

		System.out.println();
		
		Stream.of("Aditi", "Anup", "Deepak", "Kanchan").sorted().findFirst().ifPresent((x) -> System.out.println(x));
	
		System.out.println();
		
		String[] items = {"toothpaste", "brush", "shampoo", "icecream", "chochlate", "vitamins"};
		
		Stream.of(items).sorted().findFirst().ifPresent((x)-> System.out.println(x));
		
		System.out.println();
		
		Stream.of(items).sorted().forEach(x -> System.out.print(x+","));
		
		System.out.println();
		
		Arrays.stream(new int[] {2, 4, 6, 8, 10}).map((x) -> x * x).average().ifPresent(x->System.out.println(x));
	
		System.out.println();
		
		List<String> listofString = Arrays.asList("Hello", "Powerade", "Samantha", "Bitcoin", "Camera", "Dry Cleaner", "Computer Application","Health Insurance","Keyboard","Bottle","White Board","Education");
	
		listofString.stream().map(x-> x.toLowerCase()).filter(x-> x.startsWith("c")).sorted().forEach(x->System.out.print(x+","));
	
//		Stream<String> lines = Files.lines(Paths.get("Files/wordfile.txt"));
//		
//		lines.filter(x-> x.length() < 6).sorted().forEach(x->System.out.print(x+","));
//		lines.close();
		
		List<String> words = Files.lines(Paths.get("Files/wordfile.txt")).filter(x-> x.contains("th")).collect(Collectors.toList());
		
		words.forEach(x-> System.out.print(x+", "));
		System.out.println();
		
		Stream<String> rows = Files.lines(Paths.get("Files/stockDataCsv.txt"));
		
		int rowCount = (int) rows.map(x-> x.split(",")).filter(x -> x.length>3).count();
		System.out.println(rowCount);
		rows.close();
		
		System.out.println();
		
		Stream<String> row = Files.lines(Paths.get("Files/stockDataCsv.txt"));
		
		row.map(x->x.split(",")).filter(x->x.length > 3).filter(x->Integer.parseInt(x[1].trim())>15).forEach(x->System.out.println(x[0]+" "+x[1]+" "+x[2]));
		row.close();
		
	}

}