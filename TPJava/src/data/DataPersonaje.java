package data;

import java.sql.*;

import util.ApplicationException;
import business.entities.Personaje;

public class DataPersonaje {

	public DataPersonaje() {
		
	}

	public void add(Personaje per) {
		
	}

	public void update(Personaje per) {
		
	}

	public void delete(Personaje per) {
		
	}

	public Personaje getByCod(Personaje per) throws ApplicationException {
		Personaje p = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ConnectionFactory.getInstancia().getConn().prepareStatement(
					"select id, nombre, vida, energia, defensa, evasion, puntos_totales from personajes where id = ?");
			stmt.setInt(1, per.getCodPersonaje());
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				p = new Personaje();
				p.setCodPersonaje(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPuntosTotales(rs.getInt("puntos_totales"));
			}
		}
		catch (SQLException e) {
			throw new ApplicationException("Error obteniendo personaje", e);
		}
		finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				ConnectionFactory.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw new ApplicationException("Error cerrando", e);
			}
		}

		return p;
	}
}
