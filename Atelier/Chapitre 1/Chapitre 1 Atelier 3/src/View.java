import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * @author Ludwig-Emmanuel Dufour
 * 2031990
 * 2022-02-15
 */

public class View {
    JFrame frame;
    JPanel panSup;
    JPanel panInf;
    JPanel panCentre;

    JButton btnQuitter;

    JLabel labInfo;

    Random r = new Random();
    int nbGenere = r.nextInt(101);



    public View(){
        frame = new JFrame("démo cast et partage");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setLocationRelativeTo(null);
        System.out.println(nbGenere);

        //-----------Centre-----------//
        panCentre = new JPanel(new GridLayout(0,10,2,0));

        for (int i = 1; i<=100;i++){
            JButton btnNombre = new JButton(String.valueOf(i));
            btnNombre.addActionListener(e -> btnNombresAction(e));

            panCentre.add(btnNombre);
        }
        //-----------Haut-----------//
        panSup = new JPanel(new FlowLayout());
        labInfo = new JLabel("TEST UwU");
        panSup.add(Box.createRigidArea(new Dimension(25, 25)));

        panSup.add(labInfo);

        //-----------Bas-----------//
        panInf = new JPanel(new FlowLayout());
        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(new Dimension(600,30));
        btnQuitter.addActionListener(e -> btnQuitterAction());

        panInf.add(btnQuitter);

        //-----------Ajout frame-----------//
        frame.add(panSup, BorderLayout.NORTH);
        frame.add(panCentre, BorderLayout.CENTER);
        frame.add(panInf, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void btnNombresAction(ActionEvent e) {
        JButton ref = (JButton)e.getSource();
        System.out.println(((JButton)e.getSource()).getText());
        String resultS = ref.getText();
        int result;
        result = Integer.parseInt(resultS);
        if (result == nbGenere){
            System.out.println("bravo el grand");
        }
    }

    private void btnQuitterAction() {
        int rep;

        rep = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?",
                "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (rep == 0) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        View v = new View();


    }
}
