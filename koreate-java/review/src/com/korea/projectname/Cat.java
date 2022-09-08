package com.korea.projectname;

public class Cat extends Animal {
    
 final int clowDamage;
  
  public Cat(String b){
    super(b);
    this.clowDamage = 1000;
    }
  
  @Override
  public void fly() {
    System.out.println("고양이가 날아갑니다.");
  }
  
}
