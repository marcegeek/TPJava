package business.entities;

public class Personaje {
	public static final int PUNTOS_INICIALES = 200, MAX_DEFENSA = 20, MAX_EVASION = 80;
	private int codPersonaje;
	private String nombre;
	private int puntosTotales, vida, energia, defensa, evasion;

	public Personaje() {
		this.setPuntosTotales(PUNTOS_INICIALES);
	}

	public int getCodPersonaje() {
		return codPersonaje;
	}

	public void setCodPersonaje(int codPersonaje) {
		this.codPersonaje = codPersonaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

	@Override
	public boolean equals(Object per) {
		return per instanceof Personaje && ((Personaje)per).getCodPersonaje() == this.getCodPersonaje();
	}

	boolean recibirAtaque() {
		// evade el ataque si (numAleatorio * 100) < puntosDeEvasion
		// no lo evade cuando (numAleatorio * 100) >= puntosDeEvasion
		return Math.random() * 100 >= getEvasion();
	}

	public boolean atacar(Personaje oponente) {
		return oponente.recibirAtaque();
	}
		
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
}
