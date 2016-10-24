package uiDesktop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.ApplicationException;
import business.entities.Personaje;
import business.logic.CtrlABMCPersonaje;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCPersonajeDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	CtrlABMCPersonaje controlador;

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ABMCPersonajeDialog dialog = new ABMCPersonajeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ABMCPersonajeDialog() {
		setModal(true);
		setBounds(100, 100, 546, 300);
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
				JButton btnNuevoPersonaje = new JButton("Nuevo personaje");
				btnNuevoPersonaje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nuevoPersonaje();
					}
				});
				buttonPane.add(btnNuevoPersonaje);
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
				JButton okButton = new JButton("Aceptar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		inicializar();
	}

	protected void editarPersonaje() {
		int fila = table.getSelectedRow();
		if (fila == -1) {
			return;
		}
		//table.getModel().getValueAt(fila, columna);
		//new EditarCrearPersonajeDialog(personaje);
	}

	protected void nuevoPersonaje() {
		new EditarCrearPersonajeDialog().setVisible(true);
		traerPersonajes();
	}

	private void inicializar() {
		controlador = new CtrlABMCPersonaje();
		traerPersonajes();
	}

	private void traerPersonajes() {
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
		model.addColumn("Evasión");
		model.addColumn("Defensa");

		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);

		try {
			for (Personaje per : controlador.getAll()) {
				model.addRow(new Object[]{per.getCodPersonaje(), per.getNombre(), per.getPuntosTotales(),
						per.getVida(), per.getEnergia(), per.getEvasion(), per.getDefensa()});
			}
			table.setModel(model);
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
