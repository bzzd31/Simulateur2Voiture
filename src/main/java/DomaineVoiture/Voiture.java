package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

	private int positionEnX;
	private int positionEnY;
	private int vitesseMetreSeconde;
	private int directionEnDegres;

	public Voiture(int positionEnX, int positionEnY, int vitesse) {
		this.positionEnX = positionEnX;
		this.positionEnY = positionEnY;
		this.vitesseMetreSeconde = vitesse;
		this.directionEnDegres = 0;
	}

	public void miseAJourPosition() {
		miseAJourPositionX();
        miseAJourPositionY();
		notificationObservateur();
	}

	private void miseAJourPositionX() {
		if (directionEnDegres <= 90)
			positionEnX += (vitesseMetreSeconde * (1-(directionEnDegres/90.0)));
		else if (directionEnDegres <= 180)
            positionEnX -= (vitesseMetreSeconde * ((directionEnDegres - 90.0)/90.0));
        else if (directionEnDegres <= 270)
            positionEnX -= (vitesseMetreSeconde * (1-((directionEnDegres - 180.0)/90.0)));
        else
            positionEnX += vitesseMetreSeconde * ((directionEnDegres - 270.0) / 90.0);
		if (positionEnX > 1000)
			positionEnX = 1000;
		else if (positionEnX < 0)
			positionEnX = 0;
	}

    private void miseAJourPositionY() {
        if (directionEnDegres <= 90)
            positionEnY -= (vitesseMetreSeconde * (directionEnDegres/90.0));
        else if (directionEnDegres <= 180)
            positionEnY -= (vitesseMetreSeconde * (1-(directionEnDegres - 90.0)/90.0));
        else if (directionEnDegres <= 270)
            positionEnY += (vitesseMetreSeconde * ((directionEnDegres - 180.0)/90.0));
        else
            positionEnY += (vitesseMetreSeconde * (1-(directionEnDegres - 270.0)/90.0));
        if (positionEnY > 1000)
            positionEnY = 1000;
        else if (positionEnY < 0)
            positionEnY = 0;
    }

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public void accelerer() {
		if (vitesseMetreSeconde < 100)
			vitesseMetreSeconde += 10;	
	}

    public void inverserDirection() {
        directionEnDegres +=180 ;
        directionEnDegres = directionEnDegres % 360;

    }

    public void tournerGauche() {
        directionEnDegres += 10;
        directionEnDegres = directionEnDegres % 360;
    }

    public void tournerDroite() {
        directionEnDegres -= 10;
        if (directionEnDegres < 0)
            directionEnDegres = 350;
        directionEnDegres = directionEnDegres % 360;
    }

    public int getPositionEnX() {
        return positionEnX;
    }

    public int getPositionEnY() {
        return positionEnY;
    }

    public Object getVitesse() {
		return vitesseMetreSeconde;
	}

	public void setVitesse(int vitesse) {
		vitesseMetreSeconde = vitesse;
	}

	public Object getDirection() {
	    return directionEnDegres;
	}

    public void setDirection(int angleDirection) {
        this.directionEnDegres = angleDirection;
    }
}
