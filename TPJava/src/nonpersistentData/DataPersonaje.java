package nonpersistentData;

import java.util.ArrayList;

import util.ApplicationException;
import business.entities.Personaje;

public class DataPersonaje {
	ArrayList<Personaje> personajes;

	public DataPersonaje() {
		personajes = new ArrayList<>();
	}

	public void add(Personaje per) throws ApplicationException {
		if (!personajes.contains(per)) {
			personajes.add(per);
		}
		else {
			throw new ApplicationException("El personaje ya existe");
		}
	}

	public void update(Personaje per) throws ApplicationException {
		if (personajes.contains(per)) {
			Personaje perEnc = this.getByCod(per);
			perEnc.setNombre(per.getNombre());
			perEnc.setPuntosTotales(per.getPuntosTotales());
			perEnc.setDefensa(per.getDefensa());
			perEnc.setEnergia(per.getEnergia());
			perEnc.setEvasion(per.getEvasion());
			perEnc.setVida(per.getVida());
		}
	}

	public void delete(Personaje per) throws ApplicationException {
		if (personajes.contains(per)) {
			personajes.remove(per);
		}
		else {
			throw new ApplicationException("El personaje no existe");
		}
	}

	public Personaje getByCod(Personaje per) {
		Personaje p = null;
		int i = personajes.indexOf(per);
		if (i >= 0) {
			p = personajes.get(i);
		}
		return p;
	}
}
