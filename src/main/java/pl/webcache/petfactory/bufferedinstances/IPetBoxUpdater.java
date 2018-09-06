package pl.webcache.petfactory.bufferedinstances;

import pl.webcache.petfactory.bufferedinstances.model.PetBox;

/**
 * Definition on how can we update boxes before providing it to the client
 */
public interface IPetBoxUpdater {
	void update(PetBox petBox);
}
