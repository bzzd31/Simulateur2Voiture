package AppliSimu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DomaineVoiture.Voiture;

public class CommandeVoiture extends JPanel implements ActionListener{
	
	private JButton boutonAccelerer;
	private JButton boutonInverserDirection;
    private JButton boutonTournerGauche;
    private JButton boutonTournerDroite;
	private Voiture maVoiture;
	
	
	public CommandeVoiture (JFrame fenetre, Voiture maVoiture) {
		super();
		this.setLayout(new FlowLayout());
        creationBoutonAccelerer();
        creationBoutonInverserDirection();
        creationBoutonTournerGauche();
        creationBoutonTournerDroite();
		fenetre.add(this);
		this.maVoiture = maVoiture;
	}

    public void creationBoutonAccelerer() {
        boutonAccelerer = new JButton("Accelerer");
        boutonAccelerer.addActionListener(this);
        this.add(boutonAccelerer);
    }

    public void creationBoutonInverserDirection() {
        boutonInverserDirection = new JButton("Changer direction");
        boutonInverserDirection.addActionListener(this);
        this.add(boutonInverserDirection);
    }

    public void creationBoutonTournerGauche() {
        boutonTournerGauche = new JButton("Tourner gauche");
        boutonTournerGauche.addActionListener(this);
        this.add(boutonTournerGauche);
    }

    public void creationBoutonTournerDroite() {
        boutonTournerDroite = new JButton("Tourner droite");
        boutonTournerDroite.addActionListener(this);
        this.add(boutonTournerDroite);
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		Object bouton = event.getSource();
		if (bouton == boutonAccelerer)
			maVoiture.accelerer();
		else if (bouton == boutonInverserDirection)
			maVoiture.inverserDirection();
        else if (bouton == boutonTournerGauche)
            maVoiture.tournerGauche();
        else
            maVoiture.tournerDroite();
	}
	

}
