import static org.junit.Assert.*;

import org.junit.Test;


public class IsbnTest {

	ISBN isbn;

	@Test(expected = IllegalArgumentException.class)
	public void nummermet12CijfersKloptNiet() {
		isbn = new ISBN(978902743964L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummermet14CijfersKloptNiet() {
		isbn = new ISBN(97890274396433L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummermet13CijfersBegintNietMet978Of979KloptNiet() {
		isbn = new ISBN(9779027439642L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummermet13CijfersControleMislukt() {
		isbn = new ISBN(9789027439641L);
	}

	@Test(expected = NullPointerException.class)
	public void nummerMagNietNullZijn() {
		Long getal = null;
		isbn = new ISBN(getal);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummerMagNietLeegZijn() {
		long getal = Long.parseLong("");
		isbn = new ISBN(getal);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenNegatiefNummerIsVerkeerd() {
		new ISBN(-9789027439642L);
	}

	@Test
	public void nummerMet13CijfersNummerKloptBegintMet978() {
		isbn = new ISBN(9789027439642L); // dit mag geen exception veroorzaken
	}

	@Test
	public void nummerMet13CijfersNummerKloptBegintMet979() {
		isbn = new ISBN(9791090636071L); // dit mag geen exception veroorzaken
	}

	@Test
	public void toStringMoetGetalTeruggeven() {
		String nummer = Long.toString(9789027439642L);
		assertEquals(nummer, new ISBN(9789027439642L).toString());
	}

}
