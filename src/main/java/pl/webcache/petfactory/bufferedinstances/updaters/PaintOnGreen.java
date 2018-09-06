package pl.webcache.petfactory.bufferedinstances.updaters;

import pl.webcache.petfactory.bufferedinstances.model.PetBox;

public class PaintOnGreen extends BoxUpdaterBase {

	@Override
	protected void updateBox(PetBox petBox) {
		petBox.setColour("Green");
	}

}
