package com.del.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.del.demo.entity.Course;
import com.del.demo.entity.Order;
import com.del.demo.entity.OrderItem;
import com.del.demo.entity.User;
import com.del.demo.repository.UserDAO;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// test1();
		test2();
		
	}
	public static void test1(){
		User u1 = new User(1, "Deler", "Kongphop Worawutkasem", "del2547.pv@gmail.com", "Del1311");
		User u2 = new User(2, "Wisan", "Wisan Tangwongcharoen", "wisan@gmail.com", "wisan1234");
		User u3 = new User(3, "Adam", "Adam Smith", "adam@gmail.com", "adam1234");
		System.out.println("**************add new User already**************");
		System.out.println(u1);

		Course c1 = new Course(1,"Java for Beginners", "เรียนรู้พื้นฐาน Java ตั้งแต่ 0", 19.99, u2);
		Course c2 = new Course(2,"Spring Boot Crash Course", "สร้าง API ด้วย Spring Boot", 29.99, u3);
		System.out.println("**************upload Course already**************");
	
		System.out.println("**************View Course (getCourseDetails())**************");
		System.out.println(c1.getCourseDetails());
		System.out.println(c2.getCourseDetails());;

		System.out.println("**************add Course to cart(Order)**************");
		OrderItem item1 = new OrderItem(0, c1, c1.getPrice());
		Order order1 = new Order('1', item1.getPrice(), item1);
		System.out.println("\n**************purchase Course [Java for Beginners] (purchaseCourse())**************");

		u1.purchaseOrder(order1);
		// System.out.println("\n--------purchase Course [Spring Boot Crash Course] (purchaseCourse())--------");

		System.out.println("**************Now you can access Course [Java for Beginners]**************");
		// System.out.println("let's check your enrolledCourse");

	}
	public static void test2(){
		User u1 = new User(1, "Deler", "Kongphop Worawutkasem", "del2547.pv@gmail.com", "Del1311");
		User u2 = new User(2, "Wisan", "Wisan Tangwongcharoen", "wisan@gmail.com", "wisan1234");
		User u3 = new User(3, "Adam", "Adam Smith", "adam@gmail.com", "adam1234");
		System.out.println("**************add new User already**************");
		System.out.println(u1);

		Course c1 = new Course(1,"Java for Beginners", "เรียนรู้พื้นฐาน Java ตั้งแต่ 0", 19.99, u2);
		Course c2 = new Course(2,"Spring Boot Crash Course", "สร้าง API ด้วย Spring Boot", 29.99, u3);
		System.out.println("**************upload Course already**************");
	
		System.out.println("**************View Course (getCourseDetails())**************");
		System.out.println(c1.getCourseDetails());
		System.out.println(c2.getCourseDetails());;

		System.out.println("**************add Course to cart(Order)**************");
		OrderItem item1 = new OrderItem(1, c1, c1.getPrice());
		OrderItem item2 = new OrderItem(3, c2, c2.getPrice());
		Order order1 = new Order('1', item1.getPrice(), item1);
		order1.addItem(item2);
		System.out.println("\n**************purchase Course [Java for Beginners]**************");
		System.out.println("\n**************purchase Course [Spring Boot Crash Course]**************");
		u1.purchaseOrder(order1);
		

		System.out.println("**************Now you can access Course [Java for Beginners]**************");
		System.out.println("**************Now you can access Course [Spring Boot Crash Course]**************");
		// System.out.println("let's check your enrolledCourse");

	}
	// @Bean
	// public CommandLineRunner commandLineRunner(UserDAO dao){
	// 	return runner ->{
	// 		System.out.println("startup successfully");
	// 	};

	// }
	// public void insert(UserDAO dao){
	// 	User u = new User("deler", "del2547.pv@gmail.com", "del1311");
	// 	dao.save(u);
	// 	System.out.println("Insert Success");
	// }
	// public void delete(UserDAO dao){
	// 	dao.delete(7);
	// 	System.out.println("Delete Complete");
	// }

}
