package Aplicacion;


import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Persona> lista = new ArrayList<Persona>();
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
	public Vista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "Nombre", "Apellido1", "Apellido2", "Edad" }));
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.setToolTipText("");

		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Tablas.data"));
					objectOutputStream.writeObject(table.getModel());
					objectOutputStream.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

		JButton btnNewButton_1 = new JButton("Cargar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ObjectInputStream ObjectInputStream = new ObjectInputStream(new FileInputStream("Tablas.data"));
					table.setModel((TableModel) ObjectInputStream.readObject());
					ObjectInputStream.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		textNombre = new JTextField();
		textNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");

		JLabel lblNewLabel_1_1 = new JLabel("Apellido1");

		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido2");

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Edad");

		textApellido1 = new JTextField();
		textApellido1.setColumns(10);

		textApellido2 = new JTextField();
		textApellido2.setColumns(10);

		textEdad = new JTextField();
		textEdad.setColumns(10);

		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persona persona = new Persona(textNombre.getText(), textApellido1.getText(), textApellido2.getText(),
						textEdad.getText());
				lista.add(persona);
				

				mostrar();
				
				textNombre.setText("");
				textApellido1.setText("");
				textApellido2.setText("");
				textEdad.setText("");
			}

			public void mostrar() {
				String matriz[][] = new String[lista.size()][4];
				for (int i = 0; i < lista.size(); i++) {
					matriz[i][0] = lista.get(i).getNombre();
					matriz[i][1] = lista.get(i).getApellido1();
					matriz[i][2] = lista.get(i).getApellido2();
					matriz[i][3] = lista.get(i).getEdad();
				}

				table.setModel(
						new DefaultTableModel(matriz, new String[] { "Nombre", "Apellido1", "Apellido2", "Edad" }));
				

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(19)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 75,
										Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 75,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textApellido2, GroupLayout.PREFERRED_SIZE, 217,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textApellido1, GroupLayout.PREFERRED_SIZE, 217,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 217,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 80,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 75,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textEdad, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(26)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAnadir))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1_1)
								.addComponent(textApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1_1_1)
								.addComponent(textApellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1).addComponent(textEdad, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(18)
										.addComponent(btnNewButton_1))
								.addComponent(table, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
