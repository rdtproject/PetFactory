package pl.webcache.petfactory;

import java.util.List;

import pl.webcache.petfactory.bufferedinstances.IPetBoxUpdater;
import pl.webcache.petfactory.bufferedinstances.PetBoxUpdatersFactory;
import pl.webcache.petfactory.bufferedinstances.model.PetBox;

public class PetBoxUpdateService {

	public static void updatePetBox(PetBox petBox) {
		List<IPetBoxUpdater> updaters = PetBoxUpdatersFactory.getPetBoxUpdaters(petBox.getId());
		if (updaters != null) {
			for (IPetBoxUpdater updater : updaters) {
				updater.update(petBox);
			}
		}
	}

}
