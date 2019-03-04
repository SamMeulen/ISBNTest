
public class ISBN {

	private final long nummer;
	
	public ISBN(long isbn) {
		nummer = Controleer(isbn);
	}
	
	private long Controleer(long controleNummer) {
		if(controleNummer <= 0) {
			throw new IllegalArgumentException("Getal moet groter zijn dan 0");
		}
		if (Long.toString(controleNummer).length() != 13) {
			throw new IllegalArgumentException("Aantal getallen moet exact 13 zijn.");
		}
		if (controleNummer / 10000000000L != 978 && controleNummer / 10000000000L != 979) {
			throw new IllegalArgumentException("Getal begint niet met 978 of 979.");
		}
		else{
			int somOneven = 0;
			int somEven = 0;
			int verschil;
			for (int i = 0; i < 12; i = i+2) {
				somOneven = somOneven + Character.getNumericValue(Long.toString(controleNummer).charAt(i));
				somEven = somEven + Character.getNumericValue(Long.toString(controleNummer).charAt(i+1));
			}
			verschil = Character.getNumericValue(Long.toString(controleNummer).charAt(12));
			if (verschil != ((((somOneven + somEven) / 10) + 1) * 10) -  (somOneven + somEven)) {
				throw new IllegalArgumentException("Controlegetal klopt niet.");
			}  
			
		}
		return controleNummer;
	}
	
	@Override
	public String toString() {
	return Long.toString(nummer);
	}
	
}
