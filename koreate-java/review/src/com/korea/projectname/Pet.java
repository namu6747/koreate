package com.korea.projectname;

public class Pet {
  
  
  public void fly(Animal animal) {
    animal.fly();
  }
  
  public void power(Animal animal) {
    animal.getPower(animal);
  }
  


public static void main(String[] args) {
  
  Pet candy = new Pet();
  Animal andy  = new Animal("ah");
//  Cat ruby = new Cat("hey");  
  
}
}