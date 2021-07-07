package pokedex;

public class Pokemon {

	private String Name;
	private String Type;
	private int Attack;
	private int Damage;
	private int Health;

	public void setName(String givenName) {
		Name = givenName.toUpperCase();
	}

	public void setType(String givenType) {
		Type = givenType.toUpperCase();
	}

	public void setAttack(int givenAttack) {
		Attack = givenAttack;
	}

	public void setDamage(int givenDamage) {
		Damage = givenDamage;
	}

	public void setHealth(int givenHealth) {
		Health = givenHealth;
	}

	public String getName() {
		return Name;
	}

	public String getType() {
		return Type;
	}

	public int getAttack() {
		return Attack;
	}

	public int getDamage() {
		return Damage;
	}

	public int getHealth() {
		return Health;
	}

	public Pokemon(String pokemonName, String pokemonType, int pokemonAttack, int pokemonDamage, int pokemonHealth) {
		Name = pokemonName;
		Type = pokemonType;
		Attack = pokemonAttack;
		Damage = pokemonDamage;
		Health = pokemonHealth;
	}

}
