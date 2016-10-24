package uiDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;

import business.entities.Personaje;
import business.logic.CtrlABMCPersonaje;

import java.awt.Color;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import util.ApplicationException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarCrearPersonajeDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private CtrlABMCPersonaje controlador;
	private Personaje personajeCreandoEditando;
	private boolean personajeNuevo;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodPersonaje;
	private JTextField txtNombrePersonaje;
	private JLabel lblPuntosRestantes;
	private JLabel lblVida;
	private JLabel lblEnergia;
	private JSlider sldVida;
	private JLabel lblDefensa;
	private JLabel lblEvasion;
	private JSlider sldEnergia;
	private JSlider sldDefensa;
	private JSlider sldEvasion;

	/**
	 * Create the dialog.
	 */
	public EditarCrearPersonajeDialog() {
		controlador = new CtrlABMCPersonaje();
		personajeCreandoEditando = new Personaje();
		personajeNuevo = true;
		initialize();
	}

	public EditarCrearPersonajeDialog(Personaje per) {
		this();
		personajeCreandoEditando = per;
		personajeNuevo = false;
		mapearAFormulario(per);
	}

	/**
	 * Initialize the contents of the dialog.
	 */
	private void initialize() {
		setModal(true);
		setBounds(100, 100, 602, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 238, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label = new JLabel("Código del personaje:");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 0;
				panel.add(label, gbc_label);
			}
			{
				txtCodPersonaje = new JTextField();
				txtCodPersonaje.setEnabled(false);
				GridBagConstraints gbc_txtCodPersonaje = new GridBagConstraints();
				gbc_txtCodPersonaje.anchor = GridBagConstraints.WEST;
				gbc_txtCodPersonaje.insets = new Insets(0, 0, 5, 0);
				gbc_txtCodPersonaje.gridx = 2;
				gbc_txtCodPersonaje.gridy = 0;
				panel.add(txtCodPersonaje, gbc_txtCodPersonaje);
				txtCodPersonaje.setColumns(10);
			}
			{
				JLabel lblNombreDelPersonaje = new JLabel("Nombre del personaje:");
				GridBagConstraints gbc_lblNombreDelPersonaje = new GridBagConstraints();
				gbc_lblNombreDelPersonaje.anchor = GridBagConstraints.EAST;
				gbc_lblNombreDelPersonaje.insets = new Insets(0, 0, 0, 5);
				gbc_lblNombreDelPersonaje.gridx = 1;
				gbc_lblNombreDelPersonaje.gridy = 1;
				panel.add(lblNombreDelPersonaje, gbc_lblNombreDelPersonaje);
			}
			{
				txtNombrePersonaje = new JTextField();
				GridBagConstraints gbc_txtNombrePersonaje = new GridBagConstraints();
				gbc_txtNombrePersonaje.anchor = GridBagConstraints.WEST;
				gbc_txtNombrePersonaje.gridx = 2;
				gbc_txtNombrePersonaje.gridy = 1;
				panel.add(txtNombrePersonaje, gbc_txtNombrePersonaje);
				txtNombrePersonaje.setColumns(10);
			}
		}
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{183, 336, 107, 0};
		gbl_contentPanel.rowHeights = new int[]{22, 24, 24, 23, 24, 24, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel label = new JLabel("Puntos restantes:");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 1;
			contentPanel.add(label, gbc_label);
		}
		{
			lblPuntosRestantes = new JLabel();
			GridBagConstraints gbc_lblPuntosRestantes = new GridBagConstraints();
			gbc_lblPuntosRestantes.insets = new Insets(0, 0, 5, 5);
			gbc_lblPuntosRestantes.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblPuntosRestantes.gridx = 1;
			gbc_lblPuntosRestantes.gridy = 1;
			contentPanel.add(lblPuntosRestantes, gbc_lblPuntosRestantes);
		}
		{
			JLabel label = new JLabel("Vida:");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.fill = GridBagConstraints.VERTICAL;
			gbc_label.gridx = 0;
			gbc_label.gridy = 2;
			contentPanel.add(label, gbc_label);
		}
		{
			sldVida = new JSlider();
			sldVida.setMaximum(Personaje.PUNTOS_INICIALES);
			sldVida.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					actualizarPuntosRestantes(sldVida);
					lblVida.setText(String.valueOf(sldVida.getValue()));
				}
			});
			GridBagConstraints gbc_sldVida = new GridBagConstraints();
			gbc_sldVida.fill = GridBagConstraints.BOTH;
			gbc_sldVida.insets = new Insets(0, 0, 5, 5);
			gbc_sldVida.gridx = 1;
			gbc_sldVida.gridy = 2;
			contentPanel.add(sldVida, gbc_sldVida);
		}
		{
			lblVida = new JLabel();
			GridBagConstraints gbc_lblVida = new GridBagConstraints();
			gbc_lblVida.insets = new Insets(0, 0, 5, 0);
			gbc_lblVida.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblVida.gridx = 2;
			gbc_lblVida.gridy = 2;
			contentPanel.add(lblVida, gbc_lblVida);
		}
		{
			JLabel lblEnerga = new JLabel("Energía:");
			GridBagConstraints gbc_lblEnerga = new GridBagConstraints();
			gbc_lblEnerga.anchor = GridBagConstraints.EAST;
			gbc_lblEnerga.insets = new Insets(0, 0, 5, 5);
			gbc_lblEnerga.gridx = 0;
			gbc_lblEnerga.gridy = 3;
			contentPanel.add(lblEnerga, gbc_lblEnerga);
		}
		{
			sldEnergia = new JSlider();
			sldEnergia.setMaximum(Personaje.PUNTOS_INICIALES);
			sldEnergia.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					actualizarPuntosRestantes(sldEnergia);
					lblEnergia.setText(String.valueOf(sldEnergia.getValue()));
				}
			});
			GridBagConstraints gbc_sldEnergia = new GridBagConstraints();
			gbc_sldEnergia.fill = GridBagConstraints.HORIZONTAL;
			gbc_sldEnergia.insets = new Insets(0, 0, 5, 5);
			gbc_sldEnergia.gridx = 1;
			gbc_sldEnergia.gridy = 3;
			contentPanel.add(sldEnergia, gbc_sldEnergia);
		}
		{
			lblEnergia = new JLabel();
			GridBagConstraints gbc_lblEnergia = new GridBagConstraints();
			gbc_lblEnergia.insets = new Insets(0, 0, 5, 0);
			gbc_lblEnergia.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblEnergia.gridx = 2;
			gbc_lblEnergia.gridy = 3;
			contentPanel.add(lblEnergia, gbc_lblEnergia);
		}
		{
			JLabel label = new JLabel("Defensa:");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 4;
			contentPanel.add(label, gbc_label);
		}
		{
			sldDefensa = new JSlider();
			sldDefensa.setMaximum(Personaje.MAX_DEFENSA);
			sldDefensa.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					actualizarPuntosRestantes(sldDefensa);
					lblDefensa.setText(String.valueOf(sldDefensa.getValue()));
				}
			});
			GridBagConstraints gbc_sldDefensa = new GridBagConstraints();
			gbc_sldDefensa.fill = GridBagConstraints.HORIZONTAL;
			gbc_sldDefensa.insets = new Insets(0, 0, 5, 5);
			gbc_sldDefensa.gridx = 1;
			gbc_sldDefensa.gridy = 4;
			contentPanel.add(sldDefensa, gbc_sldDefensa);
		}
		{
			lblDefensa = new JLabel();
			GridBagConstraints gbc_lblDefensa = new GridBagConstraints();
			gbc_lblDefensa.insets = new Insets(0, 0, 5, 0);
			gbc_lblDefensa.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblDefensa.gridx = 2;
			gbc_lblDefensa.gridy = 4;
			contentPanel.add(lblDefensa, gbc_lblDefensa);
		}
		{
			JLabel label = new JLabel("Evasión:");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 5;
			contentPanel.add(label, gbc_label);
		}
		{
			sldEvasion = new JSlider();
			sldEvasion.setMaximum(Personaje.MAX_EVASION);
			sldEvasion.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					actualizarPuntosRestantes(sldEvasion);
					lblEvasion.setText(String.valueOf(sldEvasion.getValue()));
				}
			});
			GridBagConstraints gbc_sldEvasion = new GridBagConstraints();
			gbc_sldEvasion.fill = GridBagConstraints.HORIZONTAL;
			gbc_sldEvasion.insets = new Insets(0, 0, 0, 5);
			gbc_sldEvasion.gridx = 1;
			gbc_sldEvasion.gridy = 5;
			contentPanel.add(sldEvasion, gbc_sldEvasion);
		}
		{
			lblEvasion = new JLabel();
			GridBagConstraints gbc_lblEvasion = new GridBagConstraints();
			gbc_lblEvasion.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblEvasion.gridx = 2;
			gbc_lblEvasion.gridy = 5;
			contentPanel.add(lblEvasion, gbc_lblEvasion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnLimpiarPuntos = new JButton("Limpiar puntos asignados");
				btnLimpiarPuntos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						limpiarPuntosAsignados();
					}
				});
				{
					JButton btnLimpiarTodo = new JButton("Limpiar todo");
					btnLimpiarTodo.setToolTipText("Limpia los puntos asignados y el nombre");
					btnLimpiarTodo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							limpiarCampos();
						}
					});
					buttonPane.add(btnLimpiarTodo);
				}
				buttonPane.add(btnLimpiarPuntos);
			}
			{
				JButton btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						guardar();
					}
				});
				btnGuardar.setActionCommand("OK");
				buttonPane.add(btnGuardar);
				getRootPane().setDefaultButton(btnGuardar);
			}
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cerrar();
					}
				});
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}

		limpiarCampos();
	}

	protected void cerrar() {
		dispose();
	}

	protected void guardar() {
		mapearDeFormulario();
		try {
			if (personajeNuevo) {
				controlador.add(personajeCreandoEditando);
			}
			else {
				controlador.update(personajeCreandoEditando);
			}
			cerrar();
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void mapearDeFormulario() {
		personajeCreandoEditando.setNombre(txtNombrePersonaje.getText());
		personajeCreandoEditando.setVida(sldVida.getValue());
		personajeCreandoEditando.setDefensa(sldDefensa.getValue());
		personajeCreandoEditando.setEnergia(sldEnergia.getValue());
		personajeCreandoEditando.setEvasion(sldEvasion.getValue());
	}

	protected void limpiarCampos() {
		limpiarPuntosAsignados();
		txtNombrePersonaje.setText("");
	}

	protected void actualizarPuntosRestantes(JSlider slider) {
		int puntosTotales = personajeCreandoEditando.getPuntosTotales();
		int puntosRestantes = puntosTotales - calcularPuntosAsignados();
		if (puntosRestantes >= 0) {
			lblPuntosRestantes.setText(String.valueOf(puntosRestantes));
		}
		else {
			// el valor del slider que cambió es mayor al permitido, ajustarlo
			// al máximo permitido (que haga que sólo queden 0 puntos)
			int maximoPermitido = slider.getValue() + puntosRestantes;
			slider.setValue(maximoPermitido); //esto hará que se este método sea llamado nuevamente
		}
	}

	private int calcularPuntosAsignados() {
		return sldVida.getValue() + sldEnergia.getValue() +
				sldDefensa.getValue() + sldEvasion.getValue();
	}

	private void limpiarPuntosAsignados() {
		sldDefensa.setValue(0);
		sldEvasion.setValue(0);
		sldEnergia.setValue(0);
		sldVida.setValue(0);
	}

	private void mapearAFormulario(Personaje per) {
		sldVida.setMaximum(personajeCreandoEditando.getPuntosTotales());
		sldEnergia.setMaximum(personajeCreandoEditando.getPuntosTotales());
		txtCodPersonaje.setText(String.valueOf(per.getCodPersonaje()));
		txtNombrePersonaje.setText(per.getNombre());
		sldVida.setValue(per.getVida());
		sldEnergia.setValue(per.getEnergia());
		sldDefensa.setValue(per.getDefensa());
		sldEvasion.setValue(per.getEvasion());
	}
}
