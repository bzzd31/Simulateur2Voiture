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
        Double angle = Math.toRadians(directionEnDegres);
        positionEnX +=(int)(vitesseMetreSeconde * Math.cos(angle));
        if (positionEnX > 1000) {
            positionEnX = 1000;
        } else if (positionEnX < 0) {
            positionEnX = 0;
        }
    }

    private void miseAJourPositionY() {
        Double angle =  Math.toRadians(directionEnDegres);
        positionEnY -= (int) (vitesseMetreSeconde * Math.sin(angle));
        if (positionEnY > 1000) {
            positionEnY = 1000;
        } else if (positionEnY < 0) {
            positionEnY = 0;
        }
    }

	private void notificationObservateur() {
		this.setChanged();
		this.notifyObservers();
	}

	public void accelerer() {
		if (vitesseMetreSeconde < 100) {
            vitesseMetreSeconde += 10;
        }
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
        if (directionEnDegres < 0) {
            directionEnDegres = 350;
        }
        directionEnDegres = directionEnDegres % 360;
    }

    public int getPositionEnX() {
        return positionEnX;
    }

    public int getPositionEnY() {
        return positionEnY;
    }

    public int getVitesseMetreSeconde() {
        return vitesseMetreSeconde;
    }

    public int getDirection() {
        return directionEnDegres;
    }

    public void setVitesse(int vitesse) {
        this.vitesseMetreSeconde = vitesse;
    }

    public void setDirection(int direction) {
        this.directionEnDegres = direction;
    }
}
