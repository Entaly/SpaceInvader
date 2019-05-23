package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class Vaisseau extends Sprite {

   public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
		super(positionOrigine,dimension, vitesse);
	}

   public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {
		if(dimensionMissile.longueur()>dimension.lon gueur()) {
			throw new MissileException(
					"la longueur du missile est supérieure à celle du vaisseau.");
			}
		Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);
		return new Missile(positionOrigineMissile, dimensionMissile, vitesseMissile);
	}

   
   
private Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
	int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.longueur() / 2);
	int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.longueur() / 2);

	int ordonneeeOrigineMissile = this.ordonneeLaPlusBasse() - 1;
	Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(abscisseOrigineMissile, ordonneeeOrigineMissile);
	return positionOrigineMissile;
}

private Position calculerLaPositionDeTirDuMissile(int abscisseOrigineMissile, int ordonneeeOrigineMissile) {
	return new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
}
}
