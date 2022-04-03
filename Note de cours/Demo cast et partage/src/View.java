import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class View {
    JFrame frame;
    JButton btn1, btn2, btn3;
    JButton btnVider;


    public View(){
        frame = new JFrame("démo cast et partage");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(300,300));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());


        btn1 = new JButton("un");
        btn1.addActionListener(e -> btnsAction(e));
        btn2 = new JButton("deux");
        btn2.addActionListener(e -> btnsAction(e));
        btn3 = new JButton("trois");
        btn3.addActionListener(e -> btnsAction(e));

        //Créer 20 JTextField
        for (int i =1; i<=20; i++){
            JTextField txf = new JTextField("Joyeux matin!");
            txf.setPreferredSize(new Dimension(100,30));
            frame.add(txf);
        }

        btnVider = new JButton("Vider");
        btnVider.addActionListener(e -> btnViderAction());


        frame.add(btnVider);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.setVisible(true);
    }

    /**
     * Vide le texte des JTextField du frame
     */
    private void btnViderAction() {
        //Component[] comp = frame.getContentPane().getComponents();
        //System.out.println(comp[0] instanceof JTextField);
        for (Component comp: frame.getContentPane().getComponents())
            if (comp instanceof JTextField)
                ((JTextField)comp).setText("");
    }

    private void btnsAction(ActionEvent e) {
        JButton ref = (JButton)e.getSource();
        System.out.println(ref.getText());
        //ou
        //System.out.println(((JButton)e.getSource()).getText());
    }

    public static void main(String[] args) {
        View v = new View();
    }
}
