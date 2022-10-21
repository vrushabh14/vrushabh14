package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	//@Test
	public void Regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijit");
		names.add("Don");
		names.add("Alek");
		names.add("Adam");
		names.add("Ram");
		int count =0;
		for(int i =0; i<names.size(); i++) {
			String name = names.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	//@Test
	public void StreamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijit");
		names.add("Don");
		names.add("Alek");
		names.add("Adamsetia");
		names.add("Ram");
		
		//there is no life for intermediate op if there no terminal op
		//terminate op only execute if iner op (filter) returns true
		//we can create stream
		//how to use filter in stream api
		
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		Long d = Stream.of("Abhijit","Don","Alek","Adamsetia","Ram").filter(r->{
			
			r.startsWith("A");
			return true; 
		}).count();
		System.out.println(d);
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void StreamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("amol");
		names.add("Don");
		names.add("women");
		names.add("Adam");
		names.add("Ram");
		
		//print the name which has letter as "a" uppercase
		Stream.of("Abhijit","Don","Alek","Adamsetia","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//print the name of arraylist with first letter "a" as uppercase & sorted
		List<String> nam = Arrays.asList("Abhijit","Don","Alek","Adamsetia","Rama");
		nam.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		///merge two differen list & perform operations
		Stream<String> newstream = Stream.concat(nam.stream(),names.stream());
		boolean value = newstream.anyMatch(s->s.equalsIgnoreCase("ada77"));
		Assert.assertTrue(value);		
	}
	
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Abhijit","Don","Alek","Adamsetia","Rama").filter(s->s.endsWith("a"))
				.map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		
		List<Integer> values = Arrays.asList(1,3,1,2,4,7,9,10,7,5,2);
		//values.stream().distinct().forEach(s->System.out.print(s+" "));
		
		List<Integer> ls1 = values.stream().distinct()
				.sorted().collect(Collectors.toList());
		System.out.println(ls1.get(2));
	}
}
