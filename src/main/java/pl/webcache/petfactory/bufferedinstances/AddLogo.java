package pl.webcache.petfactory.bufferedinstances;

import pl.webcache.petfactory.bufferedinstances.model.PetBox;

public class AddLogo extends BoxUpdaterBase {

	@Override
	protected void updateBox(PetBox petBox) {
		petBox.setLogo("WebCache");
	}

}
