package projectpao;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {

    
    GridBagConstraints constraints;
    JTextField username = new JTextField(); 
    JPasswordField password = new JPasswordField();
    JLabel user = new JLabel("Username: ", SwingConstants.RIGHT);
    JLabel parola = new JLabel("Parola: ", SwingConstants.RIGHT);
    JButton buton = new JButton("Login");

    public Login() {
        super("Platforma concedii");

        super.setBounds(450, 200, 300, 350); // x=100, y=100, fata de coltul ferestrei, 200-latime, 250-inaltime
        super.setMinimumSize(new Dimension(300, 200));
        super.setLayout(new GridBagLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        constraints = new GridBagConstraints();
        constraints.gridx = 1; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 40;
        constraints.ipadx = 40; 
        super.add(user, constraints); 
        //configurez textfiled user
        constraints = new GridBagConstraints();
        constraints.gridx = 2; // pe coloana 
        constraints.gridy = 1; //pe linia 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5, 0, 0, 50);
        constraints.weightx = 0.5; //ocupa tot, 100%
        super.add(username, constraints);

        //configurez Parola
        constraints = new GridBagConstraints();
        constraints.gridx = 1; //
        constraints.gridy = 2; //
        constraints.fill = GridBagConstraints.BOTH;
        super.add(parola, constraints);
        //configurez textfiled parola
        constraints = new GridBagConstraints();
        constraints.gridx = 2;  
        constraints.gridy = 2; 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5, 0, 0, 50);
        super.add(password, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3; 
        constraints.gridwidth = 2;
        constraints.gridheight = 2;
        constraints.ipadx = 40;  
        constraints.ipady = 20;  
        constraints.insets = new Insets(40, 0, 0, 0);  //top padding
        super.add(buton, constraints);

        buton.addActionListener(new AscultatorButon(username, password, this));
    }

}
