package pl.webcache.petfactory;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pl.webcache.petfactory.bufferedinstances.model.PetBox;

public class PetBoxUpdateServiceTest {

	@Test
	public void testBoxType1() {
		PetBox petBox = new PetBox("1");
		PetBoxUpdateService.updatePetBox(petBox);

		assertTrue("Green".equals(petBox.getColour()));
		assertTrue("WebCache".equals(petBox.getLogo()));
	}

	@Test
	public void testBoxType2() {
		PetBox petBox = new PetBox("2");
		PetBoxUpdateService.updatePetBox(petBox);

		assertTrue("Green".equals(petBox.getColour()));
		assertTrue(petBox.getLogo() == null);
	}

	@Test
	public void testBoxType3() {
		PetBox petBox = new PetBox("3");
		PetBoxUpdateService.updatePetBox(petBox);

		assertTrue("Green".equals(petBox.getColour()));
		assertTrue("WebCache".equals(petBox.getLogo()));
	}

	@Test
	public void testBoxType4() {
		PetBox petBox = new PetBox("4");
		PetBoxUpdateService.updatePetBox(petBox);

		assertTrue("WebCache".equals(petBox.getLogo()));
		assertTrue(petBox.getColour() == null);
	}

	@Test
	public void testBoxType5() {
		PetBox petBox = new PetBox("5");
		PetBoxUpdateService.updatePetBox(petBox);

		assertTrue("WebCache".equals(petBox.getLogo()));
		assertTrue(petBox.getColour() == null);
	}

	@Test
	public void testBoxType6() {
		PetBox petBox = new PetBox("6");
		PetBoxUpdateService.updatePetBox(petBox);

		assertTrue(petBox.getLogo() == null);
		assertTrue(petBox.getColour() == null);
	}

}
