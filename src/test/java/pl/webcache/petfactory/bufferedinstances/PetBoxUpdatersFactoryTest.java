package pl.webcache.petfactory.bufferedinstances;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import pl.webcache.petfactory.bufferedinstances.PetBoxUpdatersFactory;
import pl.webcache.petfactory.bufferedinstances.updaters.AddLogo;
import pl.webcache.petfactory.bufferedinstances.updaters.DoNothing;
import pl.webcache.petfactory.bufferedinstances.updaters.IPetBoxUpdater;
import pl.webcache.petfactory.bufferedinstances.updaters.PaintOnGreen;

public class PetBoxUpdatersFactoryTest {

	@Test
	public void testBoxType1() {
		Set<Class<?>> description = describe(PetBoxUpdatersFactory.getPetBoxUpdaters("1"));
		assertThat(description.isEmpty(), not(true));
		assertTrue(description.containsAll(Arrays.asList(PaintOnGreen.class, AddLogo.class)));
	}

	@Test
	public void testBoxType2() {
		Set<Class<?>> description = describe(PetBoxUpdatersFactory.getPetBoxUpdaters("2"));
		assertThat(description.isEmpty(), not(true));
		assertTrue(description.containsAll(Arrays.asList(PaintOnGreen.class)));
	}

	@Test
	public void testBoxType3() {
		Set<Class<?>> description = describe(PetBoxUpdatersFactory.getPetBoxUpdaters("3"));
		assertThat(description.isEmpty(), not(true));
		assertTrue(description.containsAll(Arrays.asList(PaintOnGreen.class, AddLogo.class, DoNothing.class)));
	}

	@Test
	public void testBoxType4() {
		Set<Class<?>> description = describe(PetBoxUpdatersFactory.getPetBoxUpdaters("4"));
		assertThat(description.isEmpty(), not(true));
		assertTrue(description.containsAll(Arrays.asList(AddLogo.class, DoNothing.class)));
	}

	@Test
	public void testBoxType5() {
		Set<Class<?>> description = describe(PetBoxUpdatersFactory.getPetBoxUpdaters("5"));
		assertThat(description.isEmpty(), not(true));
		assertTrue(description.containsAll(Arrays.asList(AddLogo.class)));
	}

	@Test
	public void testBoxType6() {
		Set<Class<?>> description = describe(PetBoxUpdatersFactory.getPetBoxUpdaters("6"));
		assertThat(description.isEmpty(), not(true));
		assertTrue(description.containsAll(Arrays.asList(DoNothing.class)));
	}

	private static Set<Class<?>> describe(List<IPetBoxUpdater> updaters) {
		Set<Class<?>> description = new HashSet<>();
		if (updaters != null) {
			for (IPetBoxUpdater updater : updaters) {
				if (updater instanceof DoNothing) {
					description.add(DoNothing.class);
				}
				if (updater instanceof PaintOnGreen) {
					description.add(PaintOnGreen.class);
				}
				if (updater instanceof AddLogo) {
					description.add(AddLogo.class);
				}
			}
		}
		return description;
	}
}
