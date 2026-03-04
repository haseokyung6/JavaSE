package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;
import workshop.animal.entity.Fish;

public class AnimalTest {

	public static void main(String[] args) {
		//Cat 객체를 생성하는 3가지 방법
		Cat cat1 = new Cat(); //5개
		Pet cat2 = new Cat(); //3개
		Animal cat3 = new Cat();//2개
		
		//Pet로 부터 상속 받은 메서드 
		cat1.setName("Joy");
		System.out.println(cat1.getName());
		cat1.play();		
		//Animal로 부터 상속 받은 메서드 
		cat1.eat();
		cat1.walk();
		
		//Pet로 부터 상속 받은 메서드 
		cat2.setName("Merry");
		System.out.println(cat2.getName());
		cat2.play();
		
		//Animal로 부터 상속 받은 메서드
		cat3.eat();
		cat3.walk();
		
		Fish fish1 = new Fish();
		fish1.setName("Amy");
		System.out.println(fish1.getName());
		fish1.play();
		fish1.eat();
		

	}

}