package com.korea.projectname;

public class Animal{
  String sound; 
  
  public Animal(String a){
    this.sound = a;
  }
  
  public void fly() {
    System.out.println("생물이 날아갑니다.");
  }
  
  public void getPower(Animal animal) {
    System.out.println(animal+" D");
  }
  
}
