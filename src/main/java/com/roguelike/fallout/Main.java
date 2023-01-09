package com.roguelike.fallout;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name = "";
    boolean playing = true;

    while (playing) {
      System.out.println("Welcome to Fallout: Text Adventure game!");
      System.out.print("Could you tell me your name? (8 characters or shorter): ");
      name = sc.nextLine();

      // Checking to make sure the name is not empty
      if (name.isEmpty()) {
        System.out.println("Sorry, I couldn't see your name!");
        continue;
      }

      if (name.length() > 8) {
        System.out.println(
            "I'm pretty sure that's more than 8 characters. Do you maybe have a shorter name I can call you?");
        continue;
      }
      // Start the game
      int health = 100;
      boolean alive = true;
      while (alive) {
        // TODO: 1/9/2023 Add Location Enum that randomizes. 
        System.out.println("\n" + name + ", you are currently in a dangerous forest.");
        System.out.println("Your health is at " + health + "%.");
        System.out.println("What would you like to do?");
        System.out.println("1. Explore the wilds");
        System.out.println("2. Use a Stimpack");
        System.out.println("3. Quit the game");

        int choice = sc.nextInt();
        if (choice == 1) {
          // Explore the wilds
          int randomEncounter = (int) (Math.random() * 100);
           // TODO: 1/9/2023 Fix the for loop to be NPC and/or Emeny encounters
            if (randomEncounter < 30) {
              // Encounter a friendly NPC
              // TODO: 1/9/2023 Add chance for NPC to give you Stimpacks. 
              System.out.println(
                  "\nYou have encountered a friendly NPC. They give you some helpful information.");
            } else if (randomEncounter < 60) {
              // Encounter a dangerous enemy
              // TODO: 1/9/2023 Add Enemy, Health, and Attack randomizer. 
              System.out.println("\nYou have encountered a dangerous enemy!");
              // TODO: 1/9/2023 Print Enemy name and stats. 
              System.out.println("What would you like to do?");
              System.out.println("1. Fight the enemy");
              System.out.println("2. Try to run away");

              int fightOrRun = sc.nextInt();
              if (fightOrRun == 1) {
                // Fight the enemy
                // TODO: 1/9/2023 Add enemy class 
                int attackPower = (int) (Math.random() * 25);
                health -= attackPower;
                System.out.println(
                    "\nYou attack the enemy and deal " + attackPower + " points of damage.");
                // TODO: 1/9/2023 Add print statement for remainder of enemy health. 
                System.out.println("The enemy attacks back and deals 5 points of damage.");
                if (health <= 0) {
                  alive = false;
                  System.out.println("\nOh no! You have been defeated.");
                } else {
                  System.out.println("You have " + health + "% health left.");
                }
              } else if (fightOrRun == 2) {
                // Try to run away
                int escapeChance = (int) (Math.random() * 100);
                if (escapeChance < 50) {
                  System.out.println("\nYou successfully escape from the enemy.");
                } else {
                  System.out.println("\nYou try to run away, but the enemy catches up to you.");
                  System.out.println("The enemy attacks and deals 10 points of damage.");
                  health -= 10;
                  if (health <= 0) {
                    alive = false;
                    System.out.println("\nOh no! You have been defeated.");

                  }
                  // Encounter Boss
                  System.out.println("\nYou have encountered the boss, Deathclaw!");
                }
              }
            }
          }
        }
      }
    }
  }

