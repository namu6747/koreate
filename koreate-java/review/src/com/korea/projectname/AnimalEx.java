package com.korea.projectname;

public class AnimalEx {
  
  public static void main(String[] args) {
    Cat catA = new Cat("mya");
    Animal CatAnimal = catA;
    
    Animal animalCat = new Cat("oh");
    Animal animalCat2 = new Animal("wow");
    
    System.out.println(catA);
    System.out.println(CatAnimal);
    System.out.println(animalCat);
    System.out.println(animalCat2);
    
    System.out.println(catA instanceof Animal);
    System.out.println(CatAnimal instanceof Animal);
    System.out.println(animalCat instanceof Animal);
    System.out.println(animalCat2 instanceof Animal);
    
    System.out.println(catA instanceof Cat);
    System.out.println(CatAnimal instanceof Cat);
    System.out.println(animalCat instanceof Cat);
    System.out.println(animalCat2 instanceof Cat);
    
  }
  
}
