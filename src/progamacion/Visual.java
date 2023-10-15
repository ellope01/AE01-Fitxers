package progamacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class Visual extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomDirectori;
	private JTextField txtNomNou;
	private JTextField txtCoincidencies;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JButton btnSercarDirectori,btnCoincidencies,btnOrdenar,btnFusionar;
	JList list;
	JRadioButton rdbNom,rdbGrandaria,rdbModificacio,rdbAscendent,rdbDescendent;
	
	Operaciones lasOperaciones;

	/**
	 * Create the frame.
	 */
	public Visual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
	}

	/**
	 *Mètode que inizialitza els components
	 *@return void
	 */

	private void iniciarComponentes() {
		setBounds(100, 100, 782, 468);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNomDirectori = new JLabel("Selecciona un directori");
		lblNomDirectori.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		lblNomDirectori.setBounds(34, 32, 176, 13);
		contentPane.add(lblNomDirectori);
		
		txtNomDirectori = new JTextField();
		txtNomDirectori.setBounds(233, 29, 218, 19);
		contentPane.add(txtNomDirectori);
		txtNomDirectori.setColumns(10);
		
		btnSercarDirectori = new JButton("Sercar");
		btnSercarDirectori.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		btnSercarDirectori.setBounds(561, 28, 85, 21);
		btnSercarDirectori.addActionListener(this);
		contentPane.add(btnSercarDirectori);
		
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		btnOrdenar.setBounds(561, 85, 85, 21);
		btnOrdenar.addActionListener(this);
		contentPane.add(btnOrdenar);
		
		btnCoincidencies = new JButton("Coincidencies");
		btnCoincidencies.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		btnCoincidencies.setBounds(552, 253, 133, 21);
		btnCoincidencies.addActionListener(this);
		contentPane.add(btnCoincidencies);
		
		btnFusionar = new JButton("Fusionar");
		btnFusionar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 15));
		btnFusionar.setBounds(565, 337, 99, 21);
		btnFusionar.addActionListener(this);
		contentPane.add(btnFusionar);
		
		rdbNom = new JRadioButton("Nom");
		buttonGroup.add(rdbNom);
		rdbNom.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		rdbNom.setBounds(477, 129, 103, 21);
		contentPane.add(rdbNom);
		
		rdbGrandaria = new JRadioButton("Grandaria");
		buttonGroup.add(rdbGrandaria);
		rdbGrandaria.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		rdbGrandaria.setBounds(477, 174, 103, 21);
		contentPane.add(rdbGrandaria);
		
		rdbModificacio = new JRadioButton("Modificació");
		buttonGroup.add(rdbModificacio);
		rdbModificacio.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		rdbModificacio.setBounds(477, 214, 103, 21);
		contentPane.add(rdbModificacio);
		
		rdbAscendent = new JRadioButton("Ascendent");
		buttonGroup_1.add(rdbAscendent);
		rdbAscendent.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		rdbAscendent.setBounds(618, 157, 103, 21);
		contentPane.add(rdbAscendent);
		
		rdbDescendent = new JRadioButton("Descendent");
		buttonGroup_1.add(rdbDescendent);
		rdbDescendent.setFont(new Font("Mongolian Baiti", Font.PLAIN, 14));
		rdbDescendent.setBounds(618, 202, 103, 21);
		contentPane.add(rdbDescendent);
		
		txtNomNou = new JTextField();
		txtNomNou.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		txtNomNou.setColumns(10);
		txtNomNou.setBounds(503, 368, 218, 19);
		contentPane.add(txtNomNou);
		
		txtCoincidencies = new JTextField();
		txtCoincidencies.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		txtCoincidencies.setColumns(10);
		txtCoincidencies.setBounds(503, 284, 218, 19);
		contentPane.add(txtCoincidencies);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 85, 417, 292);
		contentPane.add(scrollPane);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		list.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		scrollPane.setViewportView(list);
		
		String[] Fitxers=new String[5];
		Fitxers[0]="fichero1";
		Fitxers[1]="fichero2";
		Fitxers[2]="fichero3";
		Fitxers[3]="fichero4";
		Fitxers[4]="fichero5";
		
		JLabel lblInfo = new JLabel("Manten selecionado el control para poder seleccionar mas de un archivo");
		lblInfo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 12));
		lblInfo.setBounds(82, 387, 369, 22);
		contentPane.add(lblInfo);
	}

	
	/**
	 *Mètode per a ejecutar los botos
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnSercarDirectori==e.getSource()) {
			Boolean bol=lasOperaciones.ExisteDirectorio(txtNomDirectori.getText());
			if(bol) {
				list.removeAll();
				JOptionPane.showConfirmDialog(null,"El directorio seleccionado existe");
				
				int lon=lasOperaciones.LonDir();
				DefaultListModel dlm=new DefaultListModel();
				for(int i=0;i<lon;i++) {
					
						dlm.addElement(lasOperaciones.OperacionBusca(txtNomDirectori.getText())[i][0]);
						dlm.addElement(lasOperaciones.OperacionBusca(txtNomDirectori.getText())[i][1]);
						dlm.addElement(lasOperaciones.OperacionBusca(txtNomDirectori.getText())[i][2]);
						dlm.addElement(lasOperaciones.OperacionBusca(txtNomDirectori.getText())[i][3]);
						dlm.addElement(" ");
					
				}
				list.setModel(dlm);
				
			}else {
				JOptionPane.showConfirmDialog(null,"El directorio seleccionado NO existe");
			}

		}
		
		if(btnOrdenar==e.getSource()) {
			try {
				validarRadio();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		if(btnCoincidencies==e.getSource()) {
			String nombre=txtCoincidencies.getText();
			String sol=lasOperaciones.OperacionCoincidencia(nombre,txtNomDirectori.getText());
			JOptionPane.showConfirmDialog(null, sol);
		}
		
		if(btnFusionar==e.getSource()) {
			
			String strFitxers=" ";
			List<String> SelectedFitxer=list.getSelectedValuesList();

			String[] arrayFitxers=new String[SelectedFitxer.size()];
			SelectedFitxer.toArray(arrayFitxers);
			/*
			for(String fit:SelectedFitxer) {
				
				//strFitxers=strFitxers+fit+" ";
			}
			strFitxers=strFitxers.substring(0,strFitxers.length()-1);
			*/
			try {
				lasOperaciones.OperacionSeleccion(txtNomNou.getText(), arrayFitxers, txtNomDirectori.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			JOptionPane.showConfirmDialog(null, strFitxers);

			
		}
		
		
		
	}


	/**
	 *Mètode per a ordenar segon la preferencia del usuari, pasant un numero tipo
	 */
	private void validarRadio() throws IOException {
		if(rdbNom.isSelected() && rdbAscendent.isSelected()) {
			int tipo=1;
			list.removeAll();
			
			int lon=lasOperaciones.LonDir();
			DefaultListModel dlm=new DefaultListModel();
			for(int i=0;i<lon;i++) {
				
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][0]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][1]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][2]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][3]);
					dlm.addElement(" ");
				
			}
			list.setModel(dlm);

		}
		
		if(rdbNom.isSelected() && rdbDescendent.isSelected()) {
			int tipo=2;
			list.removeAll();
			
			int lon=lasOperaciones.LonDir();
			DefaultListModel dlm=new DefaultListModel();
			for(int i=0;i<lon;i++) {
				
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][0]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][1]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][2]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][3]);
					dlm.addElement(" ");
				
			}
			list.setModel(dlm);

		}
		
		if(rdbGrandaria.isSelected() && rdbAscendent.isSelected()) {
			int tipo=3;
			list.removeAll();
			
			int lon=lasOperaciones.LonDir();
			DefaultListModel dlm=new DefaultListModel();
			for(int i=0;i<lon;i++) {
				
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][0]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][1]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][2]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][3]);
					dlm.addElement(" ");
				
			}
			list.setModel(dlm);

		}
		
		if(rdbGrandaria.isSelected() && rdbDescendent.isSelected()) {
			int tipo=4;
			list.removeAll();
			
			int lon=lasOperaciones.LonDir();
			DefaultListModel dlm=new DefaultListModel();
			for(int i=0;i<lon;i++) {
				
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][0]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][1]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][2]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][3]);
					dlm.addElement(" ");
				
			}
			list.setModel(dlm);
		}
		if(rdbModificacio.isSelected() && rdbDescendent.isSelected()) {
			int tipo=6;
			list.removeAll();
			
			int lon=lasOperaciones.LonDir();
			DefaultListModel dlm=new DefaultListModel();
			for(int i=0;i<lon;i++) {
				
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][0]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][1]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][2]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][3]);
					dlm.addElement(" ");
				
			}
			list.setModel(dlm);

		}
		if(rdbModificacio.isSelected() && rdbAscendent.isSelected()) {
			int tipo=5;
			list.removeAll();
			
			int lon=lasOperaciones.LonDir();
			DefaultListModel dlm=new DefaultListModel();
			for(int i=0;i<lon;i++) {
				
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][0]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][1]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][2]);
					dlm.addElement(lasOperaciones.OperacionOrden(tipo,txtNomDirectori.getText())[i][3]);
					dlm.addElement(" ");
				
			}
			list.setModel(dlm);

		}
		
	}



	public void asignaOperaciones(Operaciones lasOperaciones) {
		this.lasOperaciones=lasOperaciones;
	}
}
