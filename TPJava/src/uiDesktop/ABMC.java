package uiDesktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ABMC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMC frame = new ABMC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABMC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{74, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblCodPersonajeText = new JLabel("Cod personaje:");
		GridBagConstraints gbc_lblCodPersonajeText = new GridBagConstraints();
		gbc_lblCodPersonajeText.insets = new Insets(0, 0, 0, 5);
		gbc_lblCodPersonajeText.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCodPersonajeText.gridx = 0;
		gbc_lblCodPersonajeText.gridy = 0;
		panel.add(lblCodPersonajeText, gbc_lblCodPersonajeText);
		
		JLabel lblCodPersonaje = new JLabel("");
		GridBagConstraints gbc_lblCodPersonaje = new GridBagConstraints();
		gbc_lblCodPersonaje.gridx = 1;
		gbc_lblCodPersonaje.gridy = 0;
		panel.add(lblCodPersonaje, gbc_lblCodPersonaje);
	}

}
