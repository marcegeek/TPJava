package business.entities;

import util.ApplicationException;

public class Personaje {
	private int codPersonaje;
	private String nombre;
	private int vida, energia, defensa, evasion, puntosTotales;

	public Personaje() {
		this.setPuntosTotales(200);
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

	public void setVida(int vida) throws ApplicationException {
		if (validarPuntosVida(vida)) {
			this.vida = vida;
		}
		else {
			throw new ApplicationException("Demasiados puntos de vida");
		}
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia)  throws ApplicationException {
		if (validarPuntosEnergia(energia)) {
			this.energia = energia;
		}
		else {
			throw new ApplicationException("Demasiados puntos de energía");
		}
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) throws ApplicationException {
		if (validarPuntosDefensa(defensa)) {
			this.defensa = defensa;
		}
		else {
			throw new ApplicationException("Demasiados puntos de defensa");
		}
	}

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) throws ApplicationException {
		if (validarPuntosEvasion(evasion)) {
			this.evasion = evasion;
		}
		else {
			throw new ApplicationException("Demasiados puntos de evasión");
		}
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

	@Override
	public boolean equals(Object per) {
		return per instanceof Personaje && ((Personaje)per).getCodPersonaje() == this.getCodPersonaje();
	}

	private boolean validarPuntosVida(int vida) {
		return vida >= 0 && getEnergia() + getDefensa() + getEvasion() + vida <= getPuntosTotales();
	}

	private boolean validarPuntosEnergia(int energia) {
		return energia >= 0 && getVida() + getDefensa() + getEvasion() + energia <= getPuntosTotales();
	}

	private boolean validarPuntosDefensa(int defensa) {
		return defensa >= 0 && defensa <= 20 && getVida() + getEnergia() + getEvasion() + defensa <= getPuntosTotales();
	}

	private boolean validarPuntosEvasion(int evasion) {
		return evasion >= 0 && evasion <= 80 && getVida() + getEnergia() + getDefensa() + evasion <= getPuntosTotales();
	}

	/*boolean recibirAtaque(int puntos) {
		if (Math.random() * 100 > getEvasion()) {
			return false;
		}
		if (getVida() >= puntos) {
			this.vida = this.vida - puntos;
		}
		else {
			this.vida = 0;
		}
		return true;
	}*/

	/*public boolean atacar(Personaje oponente, int energiaAUtilizar) throws ApplicationException {
		boolean oponenteAtacado;
		if (energiaAUtilizar > getEnergia()) {
			throw new ApplicationException("intenta utilizar demasiada energía");
		}
		oponenteAtacado = oponente.recibirAtaque(energiaAUtilizar);
		setEnergia(getEnergia() - energiaAUtilizar);
		return oponenteAtacado;
	}*/

	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	/*public void defender() {
		// FIXME implementar método
		int energiaARecuperar = EnergiaAlComenzar * getDefensa() / 100;
		int vidaARecuperar = VidaAlComenzar * getDefensa() / 100;
	}*/
}
