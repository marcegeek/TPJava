package business.logic;

import util.ApplicationException;
import data.DataPersonaje;
import business.entities.BusinessEntity.States;
import business.entities.Personaje;

public class CtrlCombate {
	DataPersonaje dataPers;
	Personaje pers1, pers2;
	Personaje turno;
	Personaje ganador;
	private boolean combateFinalizado;

	public CtrlCombate(Personaje pers1, Personaje pers2) throws ApplicationException {
		dataPers = new DataPersonaje();
		combateFinalizado = false;
		if (pers1 == null || pers2 == null) {
			throw new ApplicationException("Se requieren dos personajes");
		}
		if (pers1.equals(pers2)) {
			throw new ApplicationException("Los personajes deben ser distintos");
		}
		if (pers1.getVida() <= 0 || pers2.getVida() <= 0 ||
				pers1.getEnergia() <= 0 || pers2.getEnergia() <= 0) {
			throw new ApplicationException("Los personajes deben tener vida y energía suficiente");
		}
		this.pers1 = pers1;
		this.pers2 = pers2;
		this.pers1.setUsoEnergia(0);
		this.pers2.setUsoEnergia(0);
		this.pers1.setDanio(0);
		this.pers2.setDanio(0);
		if (Math.random() < 0.5) {
			turno = this.pers1;
		}
		else {
			turno = this.pers2;
		}
	}

	public Personaje getTurno() {
		return turno;
	}

	public Personaje getOponente() {
		if (turno == pers1) {
			return pers2;
		}
		else {
			return pers1;
		}
	}

	public boolean atacar(int energia) throws ApplicationException {
		Personaje per = getTurno();
		Personaje oponente = getOponente();
		boolean atacado = per.atacar(oponente,energia);
		if (oponente.getVidaActual() <= 0) {
			finalizarCombate();
		}
		else {
			cambiarTurno();
		}
		return atacado;
	}

	private void finalizarCombate() throws ApplicationException {
		ganador = getTurno();
		ganador.setPuntosTotales(ganador.getPuntosTotales() + 10);
		ganador.setState(States.MODIFIED);
		dataPers.save(ganador);
		combateFinalizado = true;
	}

	private void cambiarTurno() {
		turno = getOponente();
	}

	public void defender() {
		getTurno().defender();
		cambiarTurno();
	}

	public boolean isCombateFinalizado() {
		return combateFinalizado;
	}

	public Personaje getGanador() {
		return ganador;
	}
}
