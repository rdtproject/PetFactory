package pl.webcache.petfactory.bufferedinstances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.webcache.petfactory.bufferedinstances.updaters.AddLogo;
import pl.webcache.petfactory.bufferedinstances.updaters.DoNothing;
import pl.webcache.petfactory.bufferedinstances.updaters.IPetBoxUpdater;
import pl.webcache.petfactory.bufferedinstances.updaters.PaintOnGreen;

/**
 * Depending on the box type (id) we should do always some specific updates
 * before providing the box to the users
 */
public final class PetBoxUpdatersFactory {

	@SuppressWarnings("unchecked")
	private static final Map<String, List<Class<? extends IPetBoxUpdater>>> factoryMap = Collections
			.unmodifiableMap(new HashMap<String, List<Class<? extends IPetBoxUpdater>>>() {
				private static final long serialVersionUID = 1L;
				{
					put("1", updates(PaintOnGreen.class, AddLogo.class));
					put("2", updates(PaintOnGreen.class));
					put("3", updates(PaintOnGreen.class, AddLogo.class, DoNothing.class));
					put("4", updates(AddLogo.class, DoNothing.class));
					put("5", updates(AddLogo.class));
					put("6", updates(DoNothing.class));
				}
			});

	private static Map<Class<? extends IPetBoxUpdater>, IPetBoxUpdater> instances;

	public static List<IPetBoxUpdater> getPetBoxUpdaters(String petBoxId) {
		List<Class<? extends IPetBoxUpdater>> clazzList = factoryMap.get(petBoxId);
		if (clazzList != null) {
			List<IPetBoxUpdater> updaters = new ArrayList<IPetBoxUpdater>();
			for (Class<? extends IPetBoxUpdater> clazz : clazzList) {
				updaters.add(instances.get(clazz));
			}
			return updaters;
		}
		return null;
	}

	private static List<Class<? extends IPetBoxUpdater>> updates(Class<? extends IPetBoxUpdater>... classes) {
		List<Class<? extends IPetBoxUpdater>> clazzList = Arrays.asList(classes);
		bufferInstances(clazzList);
		return clazzList;
	}

	private static void bufferInstances(List<Class<? extends IPetBoxUpdater>> clazzList) {
		if (instances == null) {
			instances = new HashMap<Class<? extends IPetBoxUpdater>, IPetBoxUpdater>();
		}
		for (Class<? extends IPetBoxUpdater> clazz : clazzList) {
			if (instances.get(clazz) == null) {
				try {
					instances.put(clazz, clazz.newInstance());
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
