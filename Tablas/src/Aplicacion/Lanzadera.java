package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lanzadera extends JFrame {

	private JPanel contentPane;
	private AlumnosVista alumnosVista;
	private ProfesoresVista profesoresVista;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadera frame = new Lanzadera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void goBack(){
		alumnosVista.setVisible(false);
		profesoresVista.setVisible(false);
		setVisible(true);
	}
	
	
	/**
	 * Create the frame.
	 */
	public Lanzadera() {
		
		alumnosVista = new AlumnosVista();
		profesoresVista = new ProfesoresVista();
		alumnosVista.setLanzadera(this);
		profesoresVista.setLanzadera(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTablaAlumnos = new JButton("Tabla Alumnos");
		btnTablaAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alumnosVista.setVisible(true);
				setVisible(false);
			}
		});
		btnTablaAlumnos.setBounds(40, 121, 89, 23);
		contentPane.add(btnTablaAlumnos);
		
		JButton btnTablaProfesores = new JButton("Tabla Profesores");
		btnTablaProfesores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profesoresVista.setVisible(true);
				setVisible(false);
			}
		});
		btnTablaProfesores.setBounds(250, 121, 89, 23);
		contentPane.add(btnTablaProfesores);
	}

}
