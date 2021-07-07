package pokedex;

import java.util.Scanner;

public class Pokedex {

	public static void MenuOptions() {
		System.out.println("------------------------\n");
		System.out.println("Welcome to your PokeDex!\n");
		System.out.println("------------------------\n");
		System.out.println("1 - Add Pokemon");
		System.out.println("2 - Search Pokemon");
		System.out.println("3 - Battle Pokemon");
		System.out.println("4 - Exit");
		System.out.println("------------------------\n");
		System.out.print("Your selection please: ");

	}

	public static void SearchPokemon() {
		System.out.println("--------------------\n");
		System.out.println("Search your PokeDex!\n");
		System.out.println("--------------------\n");
		System.out.println("1 - Search by Name");
		System.out.println("2 - Search by Type");
		System.out.println("--------------------\n");
		System.out.print("Your selection please: ");
	}

	public static void SearchPokemonByName() {
		System.out.println("----------------------------\n");
		System.out.println("Search your PokeDex by Name!\n");
		System.out.println("----------------------------\n");
		System.out.print("Please enter Pokemon Name: ");
	}

	public static void SearchPokemonByType() {
		System.out.println("----------------------------\n");
		System.out.println("Search your PokeDex by Type!\n");
		System.out.println("----------------------------\n");
		System.out.print("Please enter Pokemon Type: ");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Pokemon Pokedex[] = new Pokemon[200];

		int selection;
		String Name;
		String Type;
		int Attack;
		int Damage;
		int Health;
		String PokemonA;
		String PokemonB;
		int PokemonAAttack = 0;
		int PokemonAHealth = 0;
		int PokemonBAttack = 0;
		int PokemonBHealth = 0;
		int PokemonARemainingHealth;
		int PokemonBRemainingHealth;
		int PokemonALastRemainingHealth;
		int PokemonBLastRemainingHealth;
		int PokemonAUltimate;
		int PokemonBUltimate;
		int AttackFirst;
		int i = 0;

		do {
			MenuOptions();
			selection = scanner.nextInt();
			if (selection == 0 && selection > 4) {
				break;
			}
			System.out.println("\n");
			// Add Pokemon
			if (selection == 1) {
				for (i = 0; i < Pokedex.length; i++) {
					if (Pokedex[i] == null) {
						System.out.println("--------------------------------------\n");
						System.out.println("\tADD YOUR POKEMON\n");
						System.out.println("--------------------------------------\n");
						System.out.print("Pokemon Name: ");
						Name = scanner.next().toUpperCase();
						System.out.print("Pokemon Type (Fire, Water, Wind, Earth): ");
						Type = scanner.next().toUpperCase();
						System.out.print("Pokemon Attack (Numbers only): ");
						Attack = scanner.nextInt();
						System.out.print("Pokemon Damage (Numbers only): ");
						Damage = scanner.nextInt();
						System.out.print("Pokemon Health (Numbers only): ");
						Health = scanner.nextInt();
						System.out.println("\n");
						Pokedex[i] = new Pokemon(Name, Type, Attack, Damage, Health);
						break;
					}
				}

				// Search Pokemon by name and type;
			} else if (selection == 2) {
				SearchPokemon();
				selection = scanner.nextInt();
				if (selection == 0 && selection > 2) {
					break;
				}
				System.out.println("\n");
				// Search by name
				if (selection == 1) {
					SearchPokemonByName();
					Name = scanner.next().toUpperCase();
					System.out.println("\n");
					for (i = 0; i < Pokedex.length; i++) {
						if (Pokedex[i] == null) {
							break;
						}
						if (Pokedex[i].getName().equals(Name)) {
							System.out.println("Name: " + Pokedex[i].getName() + "\n" + "Type: " + Pokedex[i].getType()
									+ "\n" + "Attack: " + Pokedex[i].getAttack() + "\n" + "Damage: "
									+ Pokedex[i].getDamage() + "\n" + "Health: " + Pokedex[i].getHealth() + "\n");
							System.out.println("\n");
						}
					}
					// search by type
				} else {
					SearchPokemonByType();
					Type = scanner.next().toUpperCase();
					System.out.println("\n");
					for (i = 0; i < Pokedex.length; i++) {
						if (Pokedex[i] == null) {
							break;
						}
						if (Pokedex[i].getType().equals(Type)) {
							while (true) {
								System.out.println("Name: " + Pokedex[i].getName() + "\n" + "Type: "
										+ Pokedex[i].getType() + "\n" + "Attack: " + Pokedex[i].getAttack() + "\n"
										+ "Damage: " + Pokedex[i].getDamage() + "\n" + "Health: "
										+ Pokedex[i].getHealth() + "\n");
								System.out.println("\n");
								break;
							}
						}
					}
				}
				// do battle
			} else if (selection == 3) {
				for (i = 0; i < Pokedex.length; i++) {
					if (Pokedex[i] == null) {
						break;
					}
					if (Pokedex[i] != null) {
						System.out.println(Pokedex[i].getName());
					}
				}
				System.out.println("\n");
				System.out.println("Who is your first Pokemon (Type the name of the Pokemon): ");
				PokemonA = scanner.next().toUpperCase();
				System.out.println("Who is your second Pokemon (Type the name of the Pokemon): ");
				PokemonB = scanner.next().toUpperCase();
				for (i = 0; i < Pokedex.length; i++) {
					if (Pokedex[i] == null) {
						break;
					}
					if (Pokedex[i].getName().equals(PokemonA)) {
						PokemonAAttack = Pokedex[i].getAttack();
						PokemonAHealth = Pokedex[i].getHealth();
					}
					if (Pokedex[i].getName().equals(PokemonB)) {
						PokemonBAttack = Pokedex[i].getAttack();
						PokemonBHealth = Pokedex[i].getHealth();
					}
				}
				System.out.println("\n");
				System.out.println("----------------------------------------");
				System.out.println(PokemonA + " and " + PokemonB + " are fighting");
				System.out.println("----------------------------------------\n");
				System.out.println("Who should attack first?");
				System.out.println("1 - " + PokemonA);
				System.out.println("2 - " + PokemonB);
				System.out.print("Place your answer here: ");
				AttackFirst = scanner.nextInt();

				PokemonARemainingHealth = PokemonAHealth - PokemonBAttack;
				PokemonBRemainingHealth = PokemonBHealth - PokemonAAttack;
				PokemonAUltimate = 999999999;
				PokemonBUltimate = 999999999;
				PokemonALastRemainingHealth = PokemonARemainingHealth - PokemonBUltimate;
				PokemonBLastRemainingHealth = PokemonBRemainingHealth - PokemonAUltimate;

				if (AttackFirst == 1) {
					do {
						System.out.println("\n");
						System.out.println(PokemonA + " is attacking " + PokemonB + ".");
						System.out.println(PokemonB + " received " + PokemonAAttack + " damage and is left with "
								+ PokemonBRemainingHealth + " HP.");
						System.out.println("\n");
						if (PokemonBRemainingHealth <= 0) {
							System.out.println(PokemonB + " fainted!");
							System.out.println("\n");
							break;
						} else if (PokemonBRemainingHealth != 0) {
							System.out.println("\n");
							System.out.println(PokemonB + " with a remaining health of " + PokemonBRemainingHealth
									+ "HP" + ", will now commence counter attack!.");
							System.out.println(PokemonA + " received " + PokemonBAttack + " damage and is left with "
									+ PokemonARemainingHealth + " HP.");
							System.out.println("\n");
							if (PokemonARemainingHealth <= 0) {
								System.out.println(PokemonA + " fainted!");
								System.out.println("\n");
								break;
							} else if (PokemonARemainingHealth != 0) {
								System.out.println("\n");
								System.out.println("/////////////////////////////");
								System.out.println("Trigger " + PokemonA + " Ultimate Move");
								System.out.println("/////////////////////////////");
								System.out.println("1 - Confirm");
								System.out.print("Your selection please: ");
								selection = scanner.nextInt();
								if (selection == 0 && selection > 1) {
									break;
								}
								System.out.println("\n");
								if (selection == 1) {
									System.out.println("\n");
									System.out.println(PokemonA + " used his ultimate move against " + PokemonB
											+ " with damage total of " + PokemonAUltimate + ".");
									System.out.println(PokemonB + " did not have a chance and is left with "
											+ PokemonBLastRemainingHealth + "HP.");
									System.out.println("\n");
									if (PokemonBLastRemainingHealth <= 0) {
										System.out.println(PokemonB + " fainted! T_T");
										System.out.println("\n");
										break;
									}
								}
							}
						}
					} while (PokemonBRemainingHealth != 0 || PokemonARemainingHealth != 0);

				} else if (AttackFirst == 2) {
					do {
						System.out.println("\n");
						System.out.println(PokemonB + " is attacking " + PokemonA);
						System.out.println(PokemonA + " received " + PokemonBAttack + " damage and is left with "
								+ PokemonARemainingHealth + " HP.");
						System.out.println("\n");
						if (PokemonARemainingHealth <= 0) {
							System.out.println(PokemonA + " fainted!");
							System.out.println("\n");
							break;
						} else if (PokemonARemainingHealth != 0) {
							System.out.println("\n");
							System.out.println(PokemonA + " with a remaining health of " + PokemonARemainingHealth
									+ "HP" + ", will now commence counter attack!.");
							System.out.println(PokemonB + " received " + PokemonAAttack + " damage and is left with "
									+ PokemonBRemainingHealth + " HP.");
							System.out.println("\n");
							if (PokemonBRemainingHealth <= 0) {
								System.out.println(PokemonB + " fainted!");
								System.out.println("\n");
								break;
							} else if (PokemonBRemainingHealth != 0) {
								System.out.println("\n");
								System.out.println("/////////////////////////////");
								System.out.println("Trigger " + PokemonB + " Ultimate Move");
								System.out.println("/////////////////////////////");
								System.out.println("1 - Confirm");
								System.out.print("Your selection please: ");
								selection = scanner.nextInt();
								if (selection == 0 && selection > 1) {
									break;
								}
								System.out.println("\n");
								if (selection == 1) {
									System.out.println("\n");
									System.out.println(PokemonB + " used his ultimate move against " + PokemonA
											+ " with damage total of " + PokemonBUltimate + ".");
									System.out.println(PokemonA + " did not have a chance and is left with "
											+ PokemonALastRemainingHealth + " HP.");
									System.out.println("\n");
									if (PokemonALastRemainingHealth <= 0) {
										System.out.println(PokemonA + " fainted! T_T");
										System.out.println("\n");
										break;
									}
								}
							}
						}
					} while (PokemonARemainingHealth != 0 || PokemonBRemainingHealth != 0);
				}
			}
		} while (selection != 4);
	}

}
