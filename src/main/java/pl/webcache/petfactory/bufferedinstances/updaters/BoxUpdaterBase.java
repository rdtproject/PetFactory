package pl.webcache.petfactory.bufferedinstances.updaters;

import pl.webcache.petfactory.bufferedinstances.model.PetBox;

public abstract class BoxUpdaterBase implements IPetBoxUpdater {

	@Override
	public void update(PetBox petBox) {
		try {
			updateBox(petBox);
		} catch (RuntimeException e) {
			// handle exception
		}
	}

	protected abstract void updateBox(PetBox petBox);

}
