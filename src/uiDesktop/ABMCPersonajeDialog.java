package uiDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.ApplicationException;
import business.entities.BusinessEntity.States;
import business.entities.Personaje;
import business.logic.CtrlABMCPersonaje;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCPersonajeDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	CtrlABMCPersonaje controlador;
	Personaje personaje;

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Create the dialog.
	 */
	public ABMCPersonajeDialog() {
		setTitle("Selección de personaje");
		initialize();
		controlador = new CtrlABMCPersonaje();
		traerPersonajes();
	}

	/**
	 * Initialize the contents of the dialog.
	 */
	private void initialize() {
		setModal(true);
		setBounds(100, 100, 615, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton btnNuevo = new JButton("Nuevo");
				btnNuevo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nuevoPersonaje();
					}
				});
				buttonPane.add(btnNuevo);
			}
			{
				JButton btnEditar = new JButton("Editar");
				btnEditar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						editarPersonaje();
					}
				});
				buttonPane.add(btnEditar);
			}
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eliminarPersonaje();
					}
				});
				buttonPane.add(btnEliminar);
			}
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						aceptar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void aceptar() {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un personaje primero");
			return;
		}
		personaje = mapearDeTabla(fila);
		setVisible(false);
		dispose();
	}

	protected void eliminarPersonaje() {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un personaje primero");
			return;
		}
		Personaje per = mapearDeTabla(fila);
		int resp = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar al personaje \"" + per.getNombre() + "\"?",
				"Eliminar personaje", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			try {
				per.setState(States.DELETED);
				controlador.save(per);
				traerPersonajes();
			} catch (ApplicationException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public Personaje showDialog() {
		setVisible(true);
		return personaje;
	}

	protected void editarPersonaje() {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un personaje primero");
			return;
		}
		new EditarCrearPersonajeDialog(mapearDeTabla(fila)).setVisible(true);
		traerPersonajes();
	}

	private Personaje mapearDeTabla(int fila) {
		Personaje per = new Personaje();
		TableModel model = table.getModel();
		per.setCodPersonaje((int)model.getValueAt(fila, 0));
		per.setNombre((String)model.getValueAt(fila, 1));
		per.setPuntosTotales((int)model.getValueAt(fila, 2));
		per.setVida((int)model.getValueAt(fila, 3));
		per.setEnergia((int)model.getValueAt(fila, 4));
		per.setDefensa((int)model.getValueAt(fila, 5));
		per.setEvasion((int)model.getValueAt(fila, 6));
		return per;
	}

	protected void nuevoPersonaje() {
		new EditarCrearPersonajeDialog().setVisible(true);
		traerPersonajes();
	}

	private void traerPersonajes() {
		DefaultTableModel model = createTableModel();
		try {
			for (Personaje per : controlador.getAll()) {
				Object[] arr = {
						per.getCodPersonaje(), per.getNombre(), per.getPuntosTotales(),
						per.getVida(), per.getEnergia(), per.getDefensa(), per.getEvasion()};
				model.addRow(arr);
			}
			table.setModel(model);
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private DefaultTableModel createTableModel() {
		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		model.addColumn("Código");
		model.addColumn("Nombre");
		model.addColumn("Puntos totales");
		model.addColumn("Vida");
		model.addColumn("Energía");
		model.addColumn("Defensa");
		model.addColumn("Evasión");
		return model;
	}
}
