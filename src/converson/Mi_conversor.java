package converson;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import converson.Mi_conversor.Moneda;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Mi_conversor {

	private JFrame frame;
	private JTextField txt;
	private JButton btn;
	private JComboBox<Moneda> cmb;
	private JLabel lbl;
	
	public enum Moneda{
		pesos_dolar,
		pesos_euro,
		pesos_libra,
		pesos_won,
		pesos_yen,
		dolar_pesos,
		euro_pesos,
		libra_pesos,
		won_pesos,
		yen_pesos
	}
	
	public double dolar = 4100.00;
	public double euro = 4466.00;
	public double libra = 5220.50;
	public double won = 3.06;
	public double yen = 28.20;
	
	public double valorInput = 0.00;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mi_conversor window = new Mi_conversor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mi_conversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt = new JTextField();
		txt.setBounds(28, 72, 143, 24);
		frame.getContentPane().add(txt);
		txt.setColumns(10);
		
		cmb = new JComboBox<Moneda>();
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(28, 107, 144, 21);
		frame.getContentPane().add(cmb);
		
		//Evento botón
		btn = new JButton("Convertir");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		btn.setBounds(190, 103, 105, 28);
		frame.getContentPane().add(btn);
		
		lbl = new JLabel("0");
		lbl.setBounds(190, 72, 122, 24);
		frame.getContentPane().add(lbl);
		
		lblNewLabel = new JLabel("Converson de Monedas");
		lblNewLabel.setBounds(28, 11, 212, 24);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ingrese el valor:");
		lblNewLabel_1.setBounds(28, 46, 143, 24);
		frame.getContentPane().add(lblNewLabel_1);
	}
	public void Convertir() {
		if (Validar(txt.getText())) {
			Moneda moneda = (Moneda)cmb.getSelectedItem();
			switch (moneda) {
			case pesos_dolar:
				PesosAMoneda(dolar);
				break;
			case pesos_euro:
				PesosAMoneda(euro);
				break;
			case pesos_libra:
				PesosAMoneda(libra);
				break;
			case pesos_won:
				PesosAMoneda(won);
				break;
			case pesos_yen:
				PesosAMoneda(yen);
				break;
			case dolar_pesos:
				MonedaAPesos(dolar);
				break;
			case euro_pesos:
				MonedaAPesos(euro);
				break;
			case libra_pesos:
				MonedaAPesos(libra);
				break;
			case won_pesos:
				MonedaAPesos(won);
				break;
			case yen_pesos:
				MonedaAPesos(yen);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			}
		}
		
	}
	 public void PesosAMoneda(double moneda) {
		 double res = valorInput/ moneda;
		 lbl.setText(Redondear(res));
	 }
	 public void MonedaAPesos(double moneda) {
		 double res = valorInput*moneda;
		 lbl.setText(Redondear(res));
	 }
	 
	 public String Redondear(double valor) {
		 DecimalFormat df = new DecimalFormat("0.00");
		 df.setRoundingMode(RoundingMode.HALF_UP);
		 return df.format(valor);
	 }
	 public boolean Validar(String texto) {
		 try {
			 double x = Double.parseDouble(texto);
			 if (x<0);
			valorInput=x;
			return true;
		 } catch (NumberFormatException e) {
			 lbl.setText("Solo se aceptan números");
			 return false;
		 }
	 }
}
