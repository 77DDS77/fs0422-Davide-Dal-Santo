
public class Esercizio {

	public static void main(String[] args) {

		Studente s1 = new Studente("Mario", "Rossi", new byte[] { 10, 10, 10, 10, 10 });
		Studente s2 = new Studente("Davide", "Dal Santo", new byte[] { 10, 8, 7, 6, 7 });
		Studente s3 = new Studente("Davide", "Dal Santo", new byte[] { 10, 8, 7, 6, 7 });
		s1.sayHi();
		s2.sayHi();
		s3.sayHi();
		System.out.println("s1 equals s2: " + s1.equals(s2));
		System.out.println("s2 equals s3: " + s2.equals(s3));

		System.out.println("Is s1 better than s2: " + s1.isBetter(s2));

		whosBetter(new Studente[] { s1, s2, s3 });
	}

	// get the best student
	public static void whosBetter(Studente[] arr) {
		String nomeMi = "";
		float mediaMi = 0;

		for (Studente s : arr) {
			if (s.media > mediaMi) {
				mediaMi = s.media;
				nomeMi = s.name + " " + s.lastname;
			}
		}

		System.out.printf("Il miglior studente e' %s, con media %f %n", nomeMi, mediaMi);
	}

}

class Studente {
	int IdMatricola;
	String name;
	String lastname;
	byte[] votes;
	float media;

	private static int internalId = 0;

	Studente(String name, String lastname, byte[] votes) {
		this.setId();

		if (name.length() > 2) {
			this.name = name;
		} else {
			System.out.println("Errore, nome troppo corto");
		}

		if (lastname.length() > 2) {
			this.lastname = lastname;
		} else {
			System.out.println("Errore, cognome troppo lungo");
		}

		this.votes = votes;
		this.stampaMedia();

	}

	// set the id
	private void setId() {
		this.IdMatricola = internalId++;
	}

	// print info
	public void sayHi() {
		System.out.printf("Hi, my name is %s %s, mat #%d. Media: %f %n", this.name, this.lastname, this.IdMatricola,
				this.media);
	}

	// check if a student == another student
	@Override
	public boolean equals(Object obj) {
		Studente hold = (Studente) obj;
		return (this.name.equals(hold.name) && this.lastname.equals(hold.lastname) && this.media == hold.media) ? true
				: false;
	}

	// get the media of votes
	private void stampaMedia() {
		float sum = 0;
		for (float value : this.votes) {
			sum += value;
		}

		float media = sum / this.votes.length;

		this.media = media;

	}

	// check if a student is better than another
	public boolean isBetter(Studente check) {
		return (this.media > check.media) ? true : false;
	}

	// get the best student
	public static void whosBetter(Studente[] arr) {
		String nomeMi = "";
		float mediaMi = 0;

		for (Studente s : arr) {
			if (s.media > mediaMi) {
				mediaMi = s.media;
				nomeMi = s.name + " " + s.lastname;
			}
		}

		System.out.printf("Il miglior studente e' %s, con media %f %n", nomeMi, mediaMi);
	}

}
