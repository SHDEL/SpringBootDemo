package com.del.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.del.demo.entity.Course;
import com.del.demo.entity.Enrollments;
import com.del.demo.entity.Order;
import com.del.demo.entity.OrderItem;
import com.del.demo.entity.Payment;
import com.del.demo.entity.User;
import com.del.demo.repository.EntityService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	EntityService entityService;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	public void test1(){
		User u1 = new User("Deler", "Kongphop Worawutkasem", "del2547.pv@gmail.com", "Del1311");
		User u2 = new User("Peat", "Wichapon Buathong", "peat@gmail.com", "peat1234");
		User u3 = new User("Adam", "Adam Smith", "adam@gmail.com", "adam1234");
		System.out.println("**************add new User already**************");
		System.out.println(u1);
		entityService.saveUser(u1);
		entityService.saveUser(u2);
		entityService.saveUser(u3);

		Course c1 = new Course("Java for Beginners", "เรียนรู้พื้นฐาน Java ตั้งแต่ 0", 19.99, u2, "https://i.ytimg.com/vi/xTtL8E4LzTQ/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCVVzrKMKtkV3mwCev905Xq6fp4Zg");
		Course c2 = new Course("Spring Boot Crash Course", "สร้าง API ด้วย Spring Boot", 29.99, u3, "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3Dg7gYh-eryXA&psig=AOvVaw2xSyQd7dO_Xcbaz6cOafIc&ust=1744046610491000&source=images&cd=vfe&opi=89978449&ved=0CBUQjRxqFwoTCOCtsIf2w4wDFQAAAAAdAAAAABAg");
		entityService.saveCourse(c1);
		entityService.saveCourse(c2);
		System.out.println("**************upload Course already**************");
	
		System.out.println("**************View Course (getCourseDetails())**************");
		System.out.println(c1.getCourseDetails());
		System.out.println(c2.getCourseDetails());;


		System.out.println("**************add Course to cart(Order)**************");
		OrderItem item1 = new OrderItem( c1, c1.getPrice());
		entityService.saveItem(item1);

		Order order1 = new Order( item1.getPrice(), item1);
		entityService.saveOrder(order1);

		System.out.println("\n**************purchase Course [Java for Beginners] (purchaseCourse())**************");
		u1.purchaseOrder(order1, entityService);

		// System.out.println("\n--------purchase Course [Spring Boot Crash Course] (purchaseCourse())--------");

		System.out.println("**************Now you can access Course [Java for Beginners]**************");
		// System.out.println("let's check your enrolledCourse");
		// insert(dao, u1);

	}
	public void test2(){
		User u1 = new User("Deler", "Kongphop Worawutkasem", "del2547.pv@gmail.com", "Del1311");
		User u2 = new User("Wisan", "Wisan Tangwongcharoen", "wisan@gmail.com", "wisan1234");
		User u3 = new User("Adam", "Adam Smith", "adam@gmail.com", "adam1234");
		entityService.saveUser(u1);
		entityService.saveUser(u2);
		entityService.saveUser(u3);
		System.out.println("**************add new User already**************");
		System.out.println(u1);

		Course c1 = new Course("Java for Beginners", "เรียนรู้พื้นฐาน Java ตั้งแต่ 0", 19.99, u2,"https://i.ytimg.com/vi/xTtL8E4LzTQ/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCVVzrKMKtkV3mwCev905Xq6fp4Zg");
		Course c2 = new Course("Spring Boot Crash Course", "สร้าง API ด้วย Spring Boot", 29.99, u3, "https://i.ytimg.com/vi/g7gYh-eryXA/hqdefault.jpg");
		entityService.saveCourse(c1);
		entityService.saveCourse(c2);
		System.out.println("**************upload Course already**************");
	
		System.out.println("**************View Course (getCourseDetails())**************");
		System.out.println(c1.getCourseDetails());
		System.out.println(c2.getCourseDetails());;

		System.out.println("**************add Course to cart(Order)**************");
		OrderItem item1 = new OrderItem(c1, c1.getPrice());
		entityService.saveItem(item1);
		OrderItem item2 = new OrderItem(c2, c2.getPrice());
		entityService.saveItem(item2);
		Order order1 = new Order(item1.getPrice(), item1);
		order1.addItem(item2);
		entityService.saveOrder(order1);
		System.out.println("\n**************purchase Course [Java for Beginners]**************");
		System.out.println("\n**************purchase Course [Spring Boot Crash Course]**************");
		u1.purchaseOrder(order1, entityService);
		

		System.out.println("**************Now you can access Course [Java for Beginners]**************");
		System.out.println("**************Now you can access Course [Spring Boot Crash Course]**************");
		// System.out.println("let's check your enrolledCourse");

	}
	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner ->{
			System.out.println("startup successfully");
			// test1();
			test2();
		};
	}
}
