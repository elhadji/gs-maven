package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
	public String sum(String a, String b){
		return a+ b;
		
	}
	public static void main(String[] args) {
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);
		Greeter greeter = new Greeter();
		System.out.println(greeter.sayHello());
	}
}
