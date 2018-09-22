package com.in28minutes.spring.basics.springin5steps;

import com.in28minutes.spring.basics.springin5steps.basic.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//this mean that Spring will scan the package "com.in28minutes.spring.basics.springin5steps"
//and this sub packages for the Beans
public class SpringIn5StepsBasicApplication {

	public static void main(String[] args) {

		//Use Application Context for manage the beans
		ApplicationContext context =
				SpringApplication.run(SpringIn5StepsBasicApplication.class, args);

		BinarySearchImpl binarySearch =
				context.getBean(BinarySearchImpl.class);

		BinarySearchImpl binarySearch1 =
				context.getBean(BinarySearchImpl.class);

		System.out.println(binarySearch);
		System.out.println(binarySearch1);
//		There are different objects
//		com.in28minutes.spring.basics.springin5steps.BinarySearchImpl@2141a12
//		com.in28minutes.spring.basics.springin5steps.BinarySearchImpl@4196c360
		int result =
				binarySearch.binarySearch(new int[] {12,4,6}, 3);
		System.out.println(result);
//		3

	}
}

//: Searching directory [C:\Users\riskipradana\dev\spring-in-5-steps\target\classes\com\in28minutes\spring\basics\springin5steps] for files matching pa
//: Identified candidate component class: file [C:\Users\riskipradana\dev\spring-in-5-steps\target\classes\com\in28minutes\spring\basics\springin5steps\BinarySearchImpl.class]
//: Identified candidate component class: file [C:\Users\riskipradana\dev\spring-in-5-steps\target\classes\com\in28minutes\spring\basics\springin5steps\BubbleSortAlgorithm.class]

//creating instance of bean 'binarySearchImpl'
//creating instance of bean 'bubbleSortAlgorithm'
//Finished creating instance of bean 'bubbleSortAlgorithm'
//Autowiring by type from bean name 'binarySearchImpl' via constructor to bean named 'bubbleSortAlgorithm'
//Finished creating instance of bean 'binarySearchImpl'


