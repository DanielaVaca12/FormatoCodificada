package codificadita;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Codificadita extends JFrame implements ActionListener {
    JLabel L1;
    JLabel LperG;
    JLabel LperM;
    JLabel LperP;
    JLabel Lh;
    JTextField T1;
    JTextField T2;
    JTextField T3;
    JTextField T4;
    JButton B1;

    public static void main(String[] args) {
        Codificadita codificadita = new Codificadita();
        
    }

    public Codificadita() {
        setBounds(500, 500, 269, 500);
        setLayout(new FlowLayout());

        L1 = new JLabel("FORMATO PARA PASEAR A TUS PERROS");
        L1.setForeground(Color.red);
        LperG = new JLabel("¿Cuantos perros grandes son:? ");
        T1 = new JTextField(10);
        LperG.setForeground(Color.GRAY);
        LperM = new JLabel("¿Cuantos perros medianos son:? ");
        T2 = new JTextField(10);
        LperM.setForeground(Color.GRAY);
        LperP = new JLabel("¿Cuantos perros pequeños son:? ");
        T3 = new JTextField(10);
        LperP.setForeground(Color.GRAY);
        Lh = new JLabel("¿Cuantas horas son:?       "); 
        T4 = new JTextField(10);
        Lh.setForeground(Color.GRAY);
        B1 = new JButton(               "Calcular el total              ");
        B1.addActionListener(this);
        B1.setForeground(Color.RED);

        add(L1);
        add(LperG);
        add(T1);
        add(LperM);
        add(T2);
        add(LperP);
        add(T3);
        add(Lh);
        add(T4);
        add(B1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int perrosG = Integer.parseInt(T1.getText());
        int perrosM = Integer.parseInt(T2.getText());
        int perrosP = Integer.parseInt(T3.getText());
        int horas = Integer.parseInt(T4.getText());

        double costo = calculo(perrosG, perrosM, perrosP, horas);
        B1.setText(Integer.toString((int) costo));

        JOptionPane.showMessageDialog(this, "El costo Total es: " + costo);
    }

    private double calculo(int perrosG, int perrosM, int perrosP, int horas) {
        double tarifaG = 10000;
        double tarifaM = 5000;
        double tarifaP = 3000;

        double costo = tarifaG * perrosG + tarifaM * perrosM + tarifaP * perrosP;

        int numeroPerros = perrosG + perrosM + perrosP;

        if (numeroPerros > 1) {
            costo *= 0.9;
        }
        costo *= horas;
        return costo;
    }
}
