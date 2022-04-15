import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.text.DecimalFormat;

public class View {

    JFrame frame = new JFrame("Ludwig-Emmanuel Dufour 2031990");

    //-------- JLabel déclaration --------//
    JLabel labDA;
    JLabel labEx1;
    JLabel labEx2;
    JLabel labTP1;
    JLabel labTP2;

    //-------- JTextField déclaration --------//
    JTextField txfDA;
    JTextField txfEx1;
    JTextField txfEx2;
    JTextField txfTP1;
    JTextField txfTP2;

    //-------- JButton déclaration --------//
    JButton btnAjouter;
    JButton btnModifier;
    JButton btnSupprimer;
    JButton btnQuitter;

    //-------- JTable déclaration --------//
    JTable tabNotes;
    JTable tabStats;
    DefaultTableModel mdlNotes;
    DefaultTableModel mdlStats;

    //-------- JPanel déclaration --------//
    JPanel panDroite;
    JPanel panGauche;
    JPanel panBas;

    //-------- Dimension --------//
    Dimension dimTxf = new Dimension(200, 30);
    Dimension dimLab = new Dimension(150, 30);
    Dimension dimBtn = new Dimension(120, 30);

    Dimension dimGauche = new Dimension(700, 650);
    Dimension dimDroite = new Dimension(450, 650);
    Dimension dimBas = new Dimension(100, 50);

    public View() throws IOException {

        //-------- Paramètre du frame --------//
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(1280, 720));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);


        //-------- Ajout des panneaux au frame --------//

        creationPanDroite();
        creationPanGauche();
        creationPanBas();

        frame.setVisible(true);
    }
    /**
     * Création du panneau de droite avec tout ses composants et méthodes
     */
    public void creationPanDroite() {

        panDroite = new JPanel();
        panDroite.setLayout(new FlowLayout(FlowLayout.LEFT));
        panDroite.setPreferredSize(dimDroite);

        //--------Jlabel--------//
        labDA = new JLabel("DA");
        labDA.setPreferredSize(dimLab);

        labEx1 = new JLabel("Examen 1");
        labEx1.setPreferredSize(dimLab);

        labEx2 = new JLabel("Examen 2");
        labEx2.setPreferredSize(dimLab);

        labTP1 = new JLabel("TP 1");
        labTP1.setPreferredSize(dimLab);

        labTP2 = new JLabel("TP 2");
        labTP2.setPreferredSize(dimLab);

        //----------JTextField---------//
        txfDA = new JTextField("");
        txfDA.setPreferredSize(dimTxf);

        txfEx1 = new JTextField("");
        txfEx1.setPreferredSize(dimTxf);

        txfEx2 = new JTextField("");
        txfEx2.setPreferredSize(dimTxf);

        txfTP1 = new JTextField("");
        txfTP1.setPreferredSize(dimTxf);

        txfTP2 = new JTextField("");
        txfTP2.setPreferredSize(dimTxf);

        //-----JButton-----//
        btnModifier = new JButton("Modifier");
        btnModifier.setPreferredSize(dimBtn);
        btnModifier.addActionListener(e -> btnModifierAction());

        btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setPreferredSize(dimBtn);
        btnSupprimer.addActionListener(e -> btnSupprimerAction());

        btnAjouter = new JButton("Ajouter");
        btnAjouter.setPreferredSize(dimBtn);
        btnAjouter.addActionListener(e -> {
            try {
                btnAjouterAction();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //----- Ajouter les composants au panneau -----//

        panDroite.add(labDA);
        panDroite.add(txfDA);
        panDroite.add(labEx1);
        panDroite.add(txfEx1);
        panDroite.add(labEx2);
        panDroite.add(txfEx2);
        panDroite.add(labTP1);
        panDroite.add(txfTP1);
        panDroite.add(labTP2);
        panDroite.add(txfTP2);
        panDroite.add(btnAjouter);
        panDroite.add(btnModifier);
        panDroite.add(btnSupprimer);

        frame.add(panDroite, BorderLayout.EAST);
    }

    /**
     * Création du panneau de gauche avec tout ses composants et méthodes
     */
    public void creationPanGauche() throws IOException {

        String[] colNotes = {
                "DA", "Examen 1", "Examen 2", "TP 1", "TP 2", "Total %"}; //Noms des colonnes du tableau Note
        String[] colStats = {"","","","","",""}; //noms des colonne du tableau Stats

        panGauche = new JPanel();
        panGauche.setLayout(new FlowLayout(FlowLayout.CENTER));
        panGauche.setPreferredSize(dimGauche);

        //Tableau de notes//
        mdlNotes = new DefaultTableModel(colNotes,0){
            @Override
            public boolean isCellEditable(int ligne, int col){
                return false;
            }
        };

        tabNotes = new JTable(mdlNotes);
        tabNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabNotes.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting())
                tabNotesSelectionChange();
        });
        tabNotes.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()== KeyEvent.VK_DOWN)
                tabNotesSelectionChange();
                }
        });
        ChargementDonnee();


        JScrollPane scroll = new JScrollPane(tabNotes);
        scroll.setPreferredSize(new Dimension(600,500));

        //Génération tab Sats//

        mdlStats = new DefaultTableModel(colStats,4){
            @Override
            public boolean isCellEditable(int ligne, int col){
                return false;
            }
        };
        tabStats = new JTable(mdlStats);
        tabStats.setFocusable(false);
        tabStats.setRowSelectionAllowed(false);

        mdlStats.setValueAt("Moyenne", 0, 0);
        mdlStats.setValueAt("Note minimum", 1, 0);
        mdlStats.setValueAt("Note maximum", 2, 0);
        mdlStats.setValueAt("Nombre d'élèves", 3, 0);
        majStats();

        JScrollPane scrollStats = new JScrollPane(tabStats);
        scrollStats.setPreferredSize(new Dimension(600,70));

        //Sélection de la premiere entrée
        try{
            tabNotes.setRowSelectionInterval(0,0);
            tabNotesSelectionChange();
        }catch (IllegalArgumentException ignored){
        }

        panGauche.add(scroll);
        panGauche.add(scrollStats);
        frame.add(panGauche, BorderLayout.WEST);
    }

    /**
     * Création du panneau bas avec tout ses composants et méthodes
     */
    public void creationPanBas() {

        panBas = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panBas.setPreferredSize(dimBas);

        //------JButton-------//
        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(dimBtn);
        btnQuitter.addActionListener(e -> {
            try {
                btnQuitterAction();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        //btnQuitterAction();

        panBas.add(btnQuitter);
        frame.add(panBas,BorderLayout.SOUTH);
    }

    //---------- Action Listener ---------//

    //Ne pas oublier de rajouter les desc.//

    /**
     * Modifie la colonne de totaux et le tableau tabStats avec les nouvelles informations
     */
    private void majStats() {
        DecimalFormat df = new DecimalFormat("0.00"); // Format des pourcentages
        int[][] tab; // Tableau des notes
        int moyenne; // Moyenne pour total

        // Calcul du total
        for (int i = 0; i < mdlNotes.getRowCount(); i++) {
            moyenne = 0;
            for (int j = 1; j <= 4; j++)
                moyenne += Integer.parseInt(mdlNotes.getValueAt(i, j).toString());

            moyenne = moyenne / 4;
            mdlNotes.setValueAt(moyenne, i, 5);
        }

        // Calcul des statistiques
        tab = Utils.convertT2D(mdlNotes);

        // Si le tableau est vide, on envoie un nouveau tableau avec que des 0 pour les statistiques
        if (mdlNotes.getRowCount() == 0)
            tab = new int[][]{{0, 0, 0, 0, 0, 0}};

        for (int i = 1; i < tab[0].length; i++) {
            mdlStats.setValueAt(df.format(Utils.moyenneEval(tab, i)), 0, i);
            mdlStats.setValueAt(Utils.minEval(tab, i), 1, i);
            mdlStats.setValueAt(Utils.maxEval(tab, i), 2, i);
        }
        mdlStats.setValueAt(mdlNotes.getRowCount(), 3, 1);
    }

    private void ChargementDonnee() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
        String[] tab; // tableau contenant les données
        String ligne; // ligne présentement en lecture

        while ((ligne = reader.readLine()) != null) {
            tab = ligne.split(" ");
            mdlNotes.addRow(tab);
        }

        reader.close();
    }

    private void sauvegardeData() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("notes.txt", false));
        String data; // String à enregistrer dans le fichier

        for (int i  = 0; i < mdlNotes.getRowCount(); i++) {
            for (int j = 0; j < 5; j++) {
                data = valueToString(mdlNotes, i, j);
                writer.write(data);
                if (j < 4)
                    writer.write(" ");
                else if (i < mdlNotes.getRowCount() - 1)
                    writer.newLine();
            }
        }

        writer.close();
    }

    /**
     * Mise à jour des JTextFields dans le panneau de droite
     */
    public void tabNotesSelectionChange() {
        int ligne = tabNotes.getSelectedRow();
        txfDA.setText(valueToString(mdlNotes, ligne, 0));
        txfEx1.setText(valueToString(mdlNotes, ligne, 1));
        txfEx2.setText(valueToString(mdlNotes, ligne, 2));
        txfTP1.setText(valueToString(mdlNotes, ligne, 3));
        txfTP2.setText(valueToString(mdlNotes, ligne, 4));
    }

    /**
     *
     * @throws IOException
     */
    private void btnQuitterAction() throws IOException {
        int rep = JOptionPane.showConfirmDialog(frame,"Voulez-vous sauvegarder?",
                "Confirmation fermeture",JOptionPane.YES_NO_CANCEL_OPTION);
        switch (rep){
            case JOptionPane.YES_OPTION -> {
                sauvegardeData();
                System.exit(0);
            }
            case JOptionPane.NO_OPTION ->
                System.exit(0);
            }
        }

    private void btnSupprimerAction() {
        int ligne = tabNotes.getSelectedRow();

        // Aucune sélection
        if (ligne == -1)
            JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une ligne",
                    "Message d'erreur", JOptionPane.ERROR_MESSAGE);
        else {
            mdlNotes.removeRow(ligne);
            txfDA.setText(null);
            txfEx1.setText(null);
            txfEx2.setText(null);
            txfTP1.setText(null);
            txfTP2.setText(null);
            majStats();
        }

    }

    private void btnModifierAction() {
        int[][] tab = Utils.convertT2D(mdlNotes);
        int ligne= tabNotes.getSelectedRow(); //ligne selectionnée
        int da;
        String[] tabString = new String[]{ //tableau d'information

                txfDA.getText(),
                txfEx1.getText(),
                txfEx2.getText(),
                txfTP1.getText(),
                txfTP2.getText(),
        };
        // Aucune sélection
        if (ligne == -1)
            JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une ligne");
            // Entrée invalide
        else if (donneeInvalide(tabString))
            JOptionPane.showMessageDialog(frame, "Entrée invalide. \n les notes doivent être entre " +
                    "0 et 100. De plus le DA est un nombre positif");
        else {
            da = Integer.parseInt(tabString[0]);

            // DA existant dans une autre entrée
            if (Utils.isPresentCol(tab, da, 0) && tab[ligne][0] != da)
                JOptionPane.showMessageDialog(frame, "Le DA" + da + " existe déjà");
            else {
                for (int i = 0; i < tabString.length; i++)
                    mdlNotes.setValueAt(tabString[i], ligne, i);

                majStats();

            }
        }

    }

    public static boolean donneeInvalide(String[] tab) {
        boolean invalide = false; // si l'entrée est invalide
        int i = 0; // int pour la boucle

        while (i < tab.length && !invalide) {
            try {
                // Vérifier si c'est un nombre
                int test = Integer.parseInt(tab[i]);

                // Vérifier si le nombre n'est pas positif
                if (test < 0)
                    invalide = true;

                // Vérifier si le nombre n'est pas entre 0 et 100 (seulement si c'est pas la 1e entrée)
                if (i != 0 && test > 100)
                    invalide = true;

                i++;
            } catch (NumberFormatException e) {
                invalide = true;
            }
        }

        return invalide;
    }

    public static String valueToString(DefaultTableModel model, int ligne, int col) {
        return model.getValueAt(ligne, col).toString();
    }

    private void btnAjouterAction() throws IOException {
        int[][] tab = Utils.convertT2D(mdlNotes); // tableau 2d des notes
        String[] tabch = new String[]{ // tableau de l'information
                txfDA.getText(),
                txfEx1.getText(),
                txfEx2.getText(),
                txfTP1.getText(),
                txfTP2.getText()
        };
        // Entrée invalide
        if (donneeInvalide(tabch))
            JOptionPane.showMessageDialog(frame, "Entrée invalide.\nAssurer que les notes sont entre 0 et 100");
        else {
            int da = Integer.parseInt(tabch[0]);

            // DA existant dans une autre entrée
            if (Utils.isPresentCol(tab, da, 0)) {
                JOptionPane.showMessageDialog(frame, "Le DA" + da + " existe déjà");
            } else {
                mdlNotes.addRow(tabch);
                tabNotes.setRowSelectionInterval(mdlNotes.getRowCount() - 1, mdlNotes.getRowCount() - 1);
                majStats();
            }
        }
    }


    public static void main(String[] args) throws IOException {

        View v = new View();

    }

}