package code;

/**replaces an item with its empty counterpart*/
public class EmptyItem extends Item {
	/**no args constructor*/
	EmptyItem(){}
	/**"main" constructor for an empty item*/
	EmptyItem (String name, String shortName, String description, String examineMessage, int whatKind){
		super(name, shortName, description, examineMessage, whatKind);
	}
	
	static EmptyItem eggCarton = new EmptyItem ("The Egg Carton", "Empty Carton",  "An empty carton that once held eggs.",
			"You see an empty carton of eggs. Where those eggs ended up the world may never know.", 0);
	static EmptyItem emptyRollOfTape = new EmptyItem ("An empty roll of gaff tape." , "Tape Roll", "An empty roll of the clothlike "
			+ "tape they use in theatre for everything. Infinite uses, zero quanity." , "You find an empty roll of "
			+ "gaff tape. How useful.", 0);
	static EmptyItem gumPack = new EmptyItem ("An empty package of gum" , "Gum package" , "An empty package of disappointment.", 
			"You find an empty package that once held gum. But no more...", 0);
}