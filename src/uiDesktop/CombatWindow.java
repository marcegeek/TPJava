package uiDesktop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import java.awt.Insets;

import javax.swing.JLabel;

import business.entities.Personaje;
import business.logic.CtrlCombate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;

import util.ApplicationException;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CombatWindow {
	Personaje personaje1, personaje2;
	CtrlCombate controlador;

	private JFrame frmCombate;
	private JLabel lblVida2;
	private JLabel lblPersonaje1;
	private JLabel lblPersonaje2;
	private JLabel lblEnergia1;
	private JLabel lblEnergia2;
	private JLabel lblVida1;
	private JLabel lblEnergiaUtilizar;
	private JButton btnComenzar;
	private JButton btnCancelarCombate;
	private JButton btnDefender;
	private JButton btnAtacar;
	private JSlider sldEnergiaUtilizar;
	private JLabel lblPersTurno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CombatWindow window = new CombatWindow();
					window.frmCombate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CombatWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCombate = new JFrame();
		frmCombate.setTitle("Combate");
		frmCombate.setBounds(100, 100, 600, 352);
		frmCombate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombate.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSeleccion = new JPanel();
		frmCombate.getContentPane().add(panelSeleccion, BorderLayout.NORTH);
		GridBagLayout gbl_panelSeleccion = new GridBagLayout();
		gbl_panelSeleccion.columnWidths = new int[]{210, 35, 30, 202, 37, 0, 0};
		gbl_panelSeleccion.rowHeights = new int[]{0, 25, 25, 0};
		gbl_panelSeleccion.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSeleccion.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelSeleccion.setLayout(gbl_panelSeleccion);
		
		lblPersonaje1 = new JLabel("Seleccione personaje");
		GridBagConstraints gbc_lblPersonaje1 = new GridBagConstraints();
		gbc_lblPersonaje1.anchor = GridBagConstraints.EAST;
		gbc_lblPersonaje1.weightx = 1.0;
		gbc_lblPersonaje1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonaje1.gridx = 0;
		gbc_lblPersonaje1.gridy = 0;
		panelSeleccion.add(lblPersonaje1, gbc_lblPersonaje1);
		
		JButton btnSeleccionarPersonaje1 = new JButton("...");
		btnSeleccionarPersonaje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarPersonaje1();
			}
		});
		GridBagConstraints gbc_btnSeleccionarPersonaje1 = new GridBagConstraints();
		gbc_btnSeleccionarPersonaje1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionarPersonaje1.gridx = 1;
		gbc_btnSeleccionarPersonaje1.gridy = 0;
		panelSeleccion.add(btnSeleccionarPersonaje1, gbc_btnSeleccionarPersonaje1);
		
		lblPersonaje2 = new JLabel("Seleccione personaje");
		GridBagConstraints gbc_lblPersonaje2 = new GridBagConstraints();
		gbc_lblPersonaje2.anchor = GridBagConstraints.EAST;
		gbc_lblPersonaje2.weightx = 1.0;
		gbc_lblPersonaje2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersonaje2.gridx = 3;
		gbc_lblPersonaje2.gridy = 0;
		panelSeleccion.add(lblPersonaje2, gbc_lblPersonaje2);
		
		JButton btnSeleccionarPersonaje2 = new JButton("...");
		btnSeleccionarPersonaje2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionarPersonaje2();
			}
		});
		GridBagConstraints gbc_btnSeleccionarPersonaje2 = new GridBagConstraints();
		gbc_btnSeleccionarPersonaje2.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionarPersonaje2.gridx = 4;
		gbc_btnSeleccionarPersonaje2.gridy = 0;
		panelSeleccion.add(btnSeleccionarPersonaje2, gbc_btnSeleccionarPersonaje2);
		
		JLabel lblVida = new JLabel("Vida:");
		GridBagConstraints gbc_lblVida = new GridBagConstraints();
		gbc_lblVida.anchor = GridBagConstraints.EAST;
		gbc_lblVida.insets = new Insets(0, 0, 5, 5);
		gbc_lblVida.gridx = 0;
		gbc_lblVida.gridy = 1;
		panelSeleccion.add(lblVida, gbc_lblVida);
		
		lblVida1 = new JLabel("");
		GridBagConstraints gbc_lblVida1 = new GridBagConstraints();
		gbc_lblVida1.gridwidth = 2;
		gbc_lblVida1.insets = new Insets(0, 0, 5, 5);
		gbc_lblVida1.gridx = 1;
		gbc_lblVida1.gridy = 1;
		panelSeleccion.add(lblVida1, gbc_lblVida1);
		
		JLabel lblVida_1 = new JLabel("Vida:");
		GridBagConstraints gbc_lblVida_1 = new GridBagConstraints();
		gbc_lblVida_1.anchor = GridBagConstraints.EAST;
		gbc_lblVida_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblVida_1.gridx = 3;
		gbc_lblVida_1.gridy = 1;
		panelSeleccion.add(lblVida_1, gbc_lblVida_1);
		
		lblVida2 = new JLabel("");
		GridBagConstraints gbc_lblVida2 = new GridBagConstraints();
		gbc_lblVida2.gridwidth = 2;
		gbc_lblVida2.insets = new Insets(0, 0, 5, 0);
		gbc_lblVida2.gridx = 4;
		gbc_lblVida2.gridy = 1;
		panelSeleccion.add(lblVida2, gbc_lblVida2);
		
		JLabel lblEnergia = new JLabel("Energía:");
		GridBagConstraints gbc_lblEnergia = new GridBagConstraints();
		gbc_lblEnergia.anchor = GridBagConstraints.EAST;
		gbc_lblEnergia.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnergia.gridx = 0;
		gbc_lblEnergia.gridy = 2;
		panelSeleccion.add(lblEnergia, gbc_lblEnergia);
		
		lblEnergia1 = new JLabel("");
		GridBagConstraints gbc_lblEnergia1 = new GridBagConstraints();
		gbc_lblEnergia1.gridwidth = 2;
		gbc_lblEnergia1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnergia1.gridx = 1;
		gbc_lblEnergia1.gridy = 2;
		panelSeleccion.add(lblEnergia1, gbc_lblEnergia1);
		
		JLabel lblEnergia_1 = new JLabel("Energía:");
		GridBagConstraints gbc_lblEnergia_1 = new GridBagConstraints();
		gbc_lblEnergia_1.anchor = GridBagConstraints.EAST;
		gbc_lblEnergia_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEnergia_1.gridx = 3;
		gbc_lblEnergia_1.gridy = 2;
		panelSeleccion.add(lblEnergia_1, gbc_lblEnergia_1);
		
		lblEnergia2 = new JLabel("");
		GridBagConstraints gbc_lblEnergia2 = new GridBagConstraints();
		gbc_lblEnergia2.gridwidth = 2;
		gbc_lblEnergia2.gridx = 4;
		gbc_lblEnergia2.gridy = 2;
		panelSeleccion.add(lblEnergia2, gbc_lblEnergia2);
		
		JPanel panel = new JPanel();
		frmCombate.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlAccionesCombate = new JPanel();
		frmCombate.getContentPane().add(pnlAccionesCombate, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlAccionesCombate = new GridBagLayout();
		gbl_pnlAccionesCombate.columnWidths = new int[]{120, 259, 55, 145, 0};
		gbl_pnlAccionesCombate.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlAccionesCombate.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAccionesCombate.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAccionesCombate.setLayout(gbl_pnlAccionesCombate);
		
		JLabel lblTurno = new JLabel("Turno de:");
		GridBagConstraints gbc_lblTurno = new GridBagConstraints();
		gbc_lblTurno.anchor = GridBagConstraints.EAST;
		gbc_lblTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblTurno.gridx = 0;
		gbc_lblTurno.gridy = 0;
		pnlAccionesCombate.add(lblTurno, gbc_lblTurno);
		
		lblPersTurno = new JLabel("");
		lblPersTurno.setEnabled(false);
		GridBagConstraints gbc_lblPersTurno = new GridBagConstraints();
		gbc_lblPersTurno.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPersTurno.gridwidth = 2;
		gbc_lblPersTurno.insets = new Insets(0, 0, 5, 5);
		gbc_lblPersTurno.gridx = 1;
		gbc_lblPersTurno.gridy = 0;
		pnlAccionesCombate.add(lblPersTurno, gbc_lblPersTurno);
		
		btnAtacar = new JButton("Atacar");
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atacar();
			}
		});
		btnAtacar.setEnabled(false);
		GridBagConstraints gbc_btnAtacar = new GridBagConstraints();
		gbc_btnAtacar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtacar.gridx = 0;
		gbc_btnAtacar.gridy = 1;
		pnlAccionesCombate.add(btnAtacar, gbc_btnAtacar);
		
		sldEnergiaUtilizar = new JSlider();
		sldEnergiaUtilizar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				actualizarEnergiaUtilizar();
			}
		});
		sldEnergiaUtilizar.setEnabled(false);
		GridBagConstraints gbc_sldEnergiaUtilizar = new GridBagConstraints();
		gbc_sldEnergiaUtilizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_sldEnergiaUtilizar.insets = new Insets(0, 0, 5, 5);
		gbc_sldEnergiaUtilizar.gridx = 1;
		gbc_sldEnergiaUtilizar.gridy = 1;
		pnlAccionesCombate.add(sldEnergiaUtilizar, gbc_sldEnergiaUtilizar);
		
		lblEnergiaUtilizar = new JLabel("");
		lblEnergiaUtilizar.setEnabled(false);
		GridBagConstraints gbc_lblEnergiaUtilizar = new GridBagConstraints();
		gbc_lblEnergiaUtilizar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnergiaUtilizar.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergiaUtilizar.gridx = 2;
		gbc_lblEnergiaUtilizar.gridy = 1;
		pnlAccionesCombate.add(lblEnergiaUtilizar, gbc_lblEnergiaUtilizar);
		
		btnComenzar = new JButton("Comenzar combate");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzarCombate();
			}
		});
		btnComenzar.setEnabled(false);
		GridBagConstraints gbc_btnComenzar = new GridBagConstraints();
		gbc_btnComenzar.insets = new Insets(0, 0, 5, 0);
		gbc_btnComenzar.gridx = 3;
		gbc_btnComenzar.gridy = 1;
		pnlAccionesCombate.add(btnComenzar, gbc_btnComenzar);
		
		btnDefender = new JButton("Defender");
		btnDefender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defender();
			}
		});
		btnDefender.setEnabled(false);
		GridBagConstraints gbc_btnDefender = new GridBagConstraints();
		gbc_btnDefender.insets = new Insets(0, 0, 0, 5);
		gbc_btnDefender.gridx = 0;
		gbc_btnDefender.gridy = 2;
		pnlAccionesCombate.add(btnDefender, gbc_btnDefender);
		
		btnCancelarCombate = new JButton("Cancelar combate");
		btnCancelarCombate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarCombate();
			}
		});
		btnCancelarCombate.setEnabled(false);
		GridBagConstraints gbc_btnCancelarCombate = new GridBagConstraints();
		gbc_btnCancelarCombate.gridx = 3;
		gbc_btnCancelarCombate.gridy = 2;
		pnlAccionesCombate.add(btnCancelarCombate, gbc_btnCancelarCombate);

		limpiarCampos();
	}

	protected void actualizarEnergiaUtilizar() {
		lblEnergiaUtilizar.setText(String.valueOf(sldEnergiaUtilizar.getValue()));
	}

	protected void atacar() {
		try {
			Personaje turno = controlador.getTurno();
			Personaje opo = controlador.getOponente();
			JOptionPane.showMessageDialog(null,turno.getNombre() + " atacole a " + opo.getNombre());
			controlador.atacar(sldEnergiaUtilizar.getValue());
			actualizar();
			if (controlador.isCombateFinalizado()) {
				finalizarCombate();
			}
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(frmCombate, e.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void defender() {
		controlador.defender();
		actualizar();
	}

	private void actualizar() {
		String vidaStr1 = puntosDeN(personaje1.getVidaActual(), personaje1.getVida());
		String enerStr1 = puntosDeN(personaje1.getEnergiaActual(), personaje1.getEnergia());
		String vidaStr2 = puntosDeN(personaje2.getVidaActual(), personaje2.getVida());
		String enerStr2 = puntosDeN(personaje2.getEnergiaActual(), personaje2.getEnergia());

		lblVida1.setText(vidaStr1);
		lblEnergia1.setText(enerStr1);
		lblVida2.setText(vidaStr2);
		lblEnergia2.setText(enerStr2);

		lblPersTurno.setText(controlador.getTurno().getNombre());
		sldEnergiaUtilizar.setMaximum(controlador.getTurno().getEnergiaActual());
	}

	private void finalizarCombate() {
		if (controlador.isCombateFinalizado()) {
			Personaje ganador = controlador.getGanador();
			int resp = JOptionPane.showConfirmDialog(frmCombate, "El personaje " + ganador.getNombre() + " ha ganado el combate, ¿asignar los puntos ganados?",
					"Terminó el combate", JOptionPane.YES_NO_OPTION);
			if (resp == JOptionPane.YES_OPTION) {
				// el personaje ganador ya tiene actualizados sus puntos totales
				new EditarCrearPersonajeDialog(ganador).setVisible(true);
			}
		}
		controlador = null;
		personaje1 = personaje2 = null;
		limpiarCampos();
	}

	private void limpiarCampos() {
		lblPersonaje1.setText("Seleccione personaje");
		lblPersonaje2.setText("Seleccione personaje");
		lblVida1.setText("");
		lblVida2.setText("");
		lblEnergia1.setText("");
		lblEnergia2.setText("");
		lblPersTurno.setText("");
		sldEnergiaUtilizar.setValue(0);
		habilitarControles(false);
	}

	protected void comenzarCombate() {
		try {
			controlador = new CtrlCombate(personaje1, personaje2);
			lblPersTurno.setText(controlador.getTurno().getNombre());
			sldEnergiaUtilizar.setMaximum(controlador.getTurno().getEnergiaActual());
			listoParaComenzar(false);
			habilitarControles(true);
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(frmCombate, e.getMessage(), "Error inesperado", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void seleccionarPersonaje1() {
		Personaje per = new ABMCPersonajeDialog().showDialog();
		if (per != null && !per.equals(personaje2)) {
			if (per.getVida() <= 0 || per.getEnergia() <= 0) {
				JOptionPane.showMessageDialog(frmCombate, "El personaje seleccionado no tiene vida o energía suficiente para combatir", "Edite su personaje", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			personaje1 = per;
			lblPersonaje1.setText(personaje1.getNombre());
			String vidaStr = puntosDeN(personaje1.getVida(), personaje1.getVida());
			String enerStr = puntosDeN(personaje1.getEnergia(), personaje1.getEnergia());
			lblVida1.setText(vidaStr);
			lblEnergia1.setText(enerStr);
			if (personaje2 != null) {
				listoParaComenzar(true);
			}
		}
		else {
			if (per != null) {
				JOptionPane.showMessageDialog(frmCombate, "Seleccione un personaje distinto", "Mismo personaje seleccionado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	protected void seleccionarPersonaje2() {
		Personaje per = new ABMCPersonajeDialog().showDialog();
		if (per != null && !per.equals(personaje1)) {
			if (per.getVida() <= 0 || per.getEnergia() <= 0) {
				JOptionPane.showMessageDialog(frmCombate, "El personaje seleccionado no tiene vida o energía suficiente para combatir", "Edite su personaje", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			personaje2 = per;
			lblPersonaje2.setText(personaje2.getNombre());
			String vidaStr = puntosDeN(personaje2.getVida(), personaje2.getVida());
			String enerStr = puntosDeN(personaje2.getEnergia(), personaje2.getEnergia());
			lblVida2.setText(vidaStr);
			lblEnergia2.setText(enerStr);
			if (personaje1 != null) {
				listoParaComenzar(true);
			}
		}
		else {
			if (per != null) {
				JOptionPane.showMessageDialog(frmCombate, "Seleccione un personaje distinto", "Mismo personaje seleccionado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private String puntosDeN(int val1, int val2) {
		return String.valueOf(val1) + " / " + String.valueOf(val2);
	}

	private void listoParaComenzar(boolean listo) {
		btnComenzar.setEnabled(listo);
	}

	private void habilitarControles(boolean habilitado) {
		lblPersTurno.setEnabled(habilitado);
		btnAtacar.setEnabled(habilitado);
		sldEnergiaUtilizar.setEnabled(habilitado);
		lblEnergiaUtilizar.setEnabled(habilitado);
		btnDefender.setEnabled(habilitado);
		btnCancelarCombate.setEnabled(habilitado);
	}
}
