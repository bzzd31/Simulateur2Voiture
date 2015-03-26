package AppliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;
	private CommandeVoiture maCommandeVoiture;

	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture) {
		super();
		this.maVoiture = maVoiture;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}

	public int calculerPositionPixels(int metres) {
        return (int) (paramatreConversionMetresPixels * metres);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
        this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);
		dessinerVoiture(contexteGraphique);
	}

	private void dessinerVoiture(Graphics contexteGraphique) {
		int xMetres = maVoiture.getPositionEnX();
        int yMetres = maVoiture.getPositionEnY();
		int xPixel = calculerPositionPixels(xMetres);
        int yPixel = calculerPositionPixels(yMetres);
		contexteGraphique.fillOval(xPixel, yPixel, 15, 15);
	}
	
}
