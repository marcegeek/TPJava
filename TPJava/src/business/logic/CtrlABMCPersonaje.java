package business.logic;

import util.ApplicationException;
import business.entities.Personaje;
import nonpersistentData.DataPersonaje;

public class CtrlABMCPersonaje {
	private DataPersonaje dataPer;

	public CtrlABMCPersonaje() {
		dataPer = new DataPersonaje();
	}

	public void add(Personaje per) throws ApplicationException {
		dataPer.add(per);
	}

	public void update(Personaje per) throws ApplicationException {
		dataPer.update(per);
	}

	public void delete(Personaje per) throws ApplicationException {
		dataPer.delete(per);
	}

	public void getPersonaje(Personaje per) throws ApplicationException {
		dataPer.getByCod(per);
	}
}
