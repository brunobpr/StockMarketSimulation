package data;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;

public class FakeData {
	private static final Random random = new Random();
	UUID uniqueID;
	
	//Part of this Class is reused from my DoublyLinkedList CA
	//https://github.com/brunobpr/DoublyList
	
	public FakeData() {
	}

	/**
	 * @return a random first name out of 200
	 */
	public String firstName() {
		String[] firstName = { "Randolph", "Benedikta", "Helen", "Derril", "Lanie", "Morgun", "Claudina", "Terrill",
				"Liam", "Pavel", "Gert", "Rasla", "Georas", "Maximilianus", "Lauren", "Randy", "Audrey", "Aleece",
				"Portie", "Cori", "Chandal", "Teddy", "Delphinia", "Tamqrah", "Kearney", "Dicky", "Jordanna", "Ethe",
				"Jami", "Livia", "Maxwell", "Kris", "Cele", "Chrisy", "Creighton", "Lynnet", "Noby", "Patrizius",
				"Meghan", "Gorden", "Filia", "Fey", "Nanice", "Cayla", "Cally", "Gennifer", "Hart", "Jacquelyn",
				"Giles", "Lula", "Moshe", "Agace", "Augusto", "Zeb", "Benedetto", "Angil", "Jerrine", "Field", "Paulie",
				"Cherrita", "Mabelle", "Sly", "Friedrick", "Barnaby", "Novelia", "Royce", "Felecia", "Shaun", "Arch",
				"Onida", "Brandice", "Opalina", "Mord", "Ketti", "Guthrey", "Vania", "Lucine", "Arabel", "Si",
				"Chrystel", "Norri", "Guillema", "Lonna", "Abe", "Radcliffe", "Lavina", "Modesty", "Thomasa", "Taite",
				"Roseanna", "Tannie", "Torrie", "Isidora", "Harley", "Giana", "Marion", "Opaline", "Jock", "Drucie",
				"Oralia", "Oralle", "Jaquelyn", "Corrinne", "Crissy", "Herrick", "Evelina", "Teodoor", "Aubry",
				"Aubert", "Evangelin", "Gualterio", "Eldin", "Ezmeralda", "Mandie", "Matthias", "Ted", "Antonia",
				"Farley", "Kerstin", "Gerianne", "Zonnya", "Burnard", "Bibbie", "Berny", "Carce", "Corinna", "Carlin",
				"Nanni", "Cris", "Gael", "Reynolds", "Nilson", "Sonnie", "Giles", "Ansel", "Arther", "Farand", "Travus",
				"Latisha", "Yvon", "Khalil", "Malvina", "Jae", "Debbi", "Kristo", "Rodolphe", "Melania", "Cathee",
				"Delila", "Corena", "Bron", "Stevy", "Belia", "Claus", "Mord", "Helaine", "Florance", "Aluino", "Mort",
				"Had", "Darby", "Lydon", "Julietta", "Kristin", "Franchot", "Felicity", "Thomas", "Bibbie", "Vanda",
				"Spencer", "Corey", "Pren", "Ysabel", "Corella", "Mace", "Kermit", "Son", "Fredric", "Alaster",
				"Winonah", "Ignacio", "Gavrielle", "Evey", "Curtice", "Marline", "Craggy", "Donnie", "Perceval",
				"Emmye", "Salomi", "Khalil", "Lenka", "Viviana", "Karilynn", "Randi", "Haze", "Christian", "Arielle",
				"Teador", "Whittaker" };
		return firstName[random.nextInt(199)];
	}

	/**
	 * @return a random last name out of 200
	 */
	public String lastName() {
		String[] lastName = { "Pakenham", "Storr", "Sink", "Huc", "Potes", "Graith", "Pentycost", "Elliott", "MacVay",
				"Bavage", "Thurborn", "Stonhouse", "Treharne", "Nemchinov", "Beretta", "Leverson", "Goddard",
				"Houdmont", "Lurriman", "Hanalan", "Duffy", "Osborn", "Gowling", "Lowde", "Croughan", "Kynoch",
				"Tommasetti", "Pinchback", "Verity", "McMillan", "Aldersey", "Scarlon", "Pordall", "Goymer", "Conville",
				"Darbyshire", "Rosterne", "Cason", "Pegram", "Shilburne", "Tyndall", "Giannazzi", "Morrott", "Cambell",
				"Maharry", "Seiller", "Reuss", "L'oiseau", "Lipson", "Blundan", "Jerger", "Bengtsen", "MacCallion",
				"Inde", "Andriessen", "Oager", "Billes", "Valois", "Beatens", "Jaycox", "Dawber", "Sempill", "Daynter",
				"Dommett", "Renyard", "Caffin", "Mattessen", "Quinton", "Piechnik", "Emilien", "McDermot", "Osmund",
				"Kanter", "de Guise", "Rosenstock", "Storm", "Gytesham", "Snoxill", "Capon", "Willshere", "Stockwell",
				"Manford", "Cristofori", "Denver", "Pretti", "Griffey", "Kattenhorn", "Binnie", "Vassano", "Giacovazzo",
				"Ropkins", "Wort", "Weldon", "Plewman", "Sinton", "Krzyzowski", "Gilbeart", "Osbaldeston", "Instone",
				"Gillio", "Dohrmann", "Van", "Songer", "Duiguid", "Fidler", "Underwood", "Dechelette", "Gerler",
				"Jukubczak", "Janes", "Cometson", "Ridd", "Morrell", "Green", "Mabb", "Skoggins", "O'Bradden",
				"Shetliff", "Ferraro", "Kenworthey", "Jandourek", "Dowsett", "Matuschek", "Gwilym", "McCulloch",
				"Ballendine", "Barsham", "Duncanson", "Budgen", "Guiot", "Eady", "Cornwell", "Cogswell", "Giocannoni",
				"Oppy", "Vandenhoff", "Velden", "Stucke", "Decaze", "Ching", "Jelphs", "Rymell", "Wesgate", "Klaves",
				"Oxteby", "Mordey", "Blakes", "Colqueran", "Blakeman", "Hambelton", "Lezemere", "Jorry", "McCarver",
				"Stivers", "O'Spellissey", "Dailly", "Grenfell", "Brenstuhl", "Mattiassi", "Domone", "Crabbe",
				"Seedman", "Saltmarsh", "Ledingham", "Domenici", "Whitham", "Welsh", "Soper", "Nelligan", "Tart",
				"Aldis", "Medeway", "Rhymes", "Polin", "Varney", "Frarey", "Keeler", "Applegate", "Whiffen", "Kervin",
				"Bramford", "Derisly", "Cochern", "Kensy", "Praton", "Lanyon", "Corbin", "Dudek", "Jurisch", "McCabe",
				"Lesmonde", "Wannes", "Benediktovich", "Monument", "Delacroux", "Quenby", "Lackinton", "Midlane",
				"Bohlin", "Tolworth"

		};
		return lastName[random.nextInt(199)];
	}
	
	
	
	/**
	 * @return A random budget between 1000 and 10000 with two decimal value
	 */
	public double budget() {
		return  Double.valueOf((new DecimalFormat("#.00")).format(1000 + (random.nextDouble() * 9000)));
	}
	
	/**
	 * @return A unique ID using the UUID library. Used for companies and investors
	 */
	public String uniqueID() {
		uniqueID = UUID.randomUUID();
		return uniqueID.toString();
	}
	
	
	/**
	 * @return a company name contaning one surname + some of the... things below. For eg: Tolworth Inc
	 */
	public String companyName() {
		String [] company = {"Inc", "Enterprise", "and Sons", "Corporation", "Corp", "Investments", "Systems", "Industries", 
				"Technologies", "Factory", "Services", "Global", "International", "Consortium", "Org"};
		return lastName() + " " + company[random.nextInt(13)];
	}
	
	
	/**
	 * @return A random share price (between 10 and 100) with two decimaal value
	 */
	public double sharePrice() {
		return  Double.valueOf((new DecimalFormat("#.00")).format(10 + (random.nextDouble() * 100)));
	}
	
	/**
	 * @return A random number of shares (between 500 and 1000)
	 */
	public int numOfShare() {
		return random.nextInt(500) + 500;
	}
}
