package code;

public class Item {
	String itemName;
	String itemDescript; //description of the item itself. 
	String inLocationDescript; //when you examine the location/container for items, this is what it says [need this??]
	
	//price for some items.
	//number of uses for some items
	//money is a subclass with a  montary value field, when you pick it up, add to your money, doesn't show in inventory.

	/**no arg constructor for inheritance purposes*/
	Item(){
		
	}
	/**Constructor for Item Object*/
	Item( String name, String description, String examineMessage){
		itemName = name;
		itemDescript = description;
		inLocationDescript = examineMessage;
	}
	
	/**Method to remove uses from item*/ //this is going to hang out here until I'm ready for it.
	static void removeItemUses(String nameToCheck){
		return;
	}
	
	/**Method to print the item/container description... or not...*/
	static void printItemDescription(String nameToCheck){
		//looks to see if the name to check belongs to an item
		Item itemfound = determineItemsExistance(nameToCheck);
		if (itemfound != null){
			System.out.println("\n" + itemfound.itemDescript);
			return;}
		//looks to see if name belongs to a container. 
		Container containerFound = Container.determineContainerValid(nameToCheck);
		if (containerFound != null){
			System.out.println("\n" + containerFound.contDescription);
			return;}
	}
	/**method to determine if the item you're trying to manipulate exists.*/
	static Item determineItemsExistance(String itemToCheck){
		for (int i = 0; i < listOfItems.length; i++ ){
			if (itemToCheck.equals(listOfItems[i].itemName)){//loops through the items in the list of items
				return listOfItems[i];//returns the item it finds
			}
		} //if you get through the loop and don't find the container.
		System.out.println("\nThat item does not exist.");
		return null;}//if there is no item with that name.
	/**method to determine in the container's in the same place as you are.*/
	static void determineSamePlace(String itemToCheck){
		//if there's nothing there, the item can't be there. 
		Item itemToFind = determineItemsExistance(itemToCheck);//saves what the method returns as an item object
		if (itemToFind != null){
			if (Location.places[Person.player.locationIndex].items.isEmpty() && 
					Location.places[Person.player.locationIndex].receptacle.isEmpty()){
			System.out.print("");}
			else {
			//determines if an item is in the location directly.
				if  (Location.places[Person.player.locationIndex].items.contains(itemToFind)){
					Location.places[Person.player.locationIndex].items.remove(itemToFind);
					Person.player.addItem(itemToFind);
					return;} //no reason to look at anything else.
				//determines if an item is in a container in that location.
				if  (!Location.places[Person.player.locationIndex].receptacle.isEmpty()){//if the location has containers.
					for (int k = 0; k < Location.places[Person.player.locationIndex].receptacle.size(); k++){//loops through the containers in the location
						if (Location.places[Person.player.locationIndex].receptacle.get(k).contents.contains(itemToFind)){//checks to see if the item name matches something in the container
							Location.places[Person.player.locationIndex].receptacle.get(k).removeItem(itemToFind); //removes the item from the container.
							Person.player.addItem(itemToFind);//adds the item to inventory
							return;}
						}
					}
				}
			//if you get through everything with out finding it and returning...
			System.out.println("\nYou can't take something that's somewhere completely different from where you are.");
		}
	}
	/**transfers item from inventory to the box in the lightbooth.*/
	static void TransferItem(String itemToCheck){
		Item itemToFind = determineItemsExistance(itemToCheck);//saves what the method returns as an item object
		if (itemToFind != null){//if the item you entered exists
			if (Person.player.locationIndex == 1){//sees if you're in the booth with the box
				System.out.println("\nYou transfer the item to the box.");
				Container.secondaryInv.addItemToContainer(itemToFind);//puts the item in the box
				Person.player.inventory.remove(itemToFind);//takes the item out of your inventory
				Person.player.displayInventory();}//prints out what's left
			else{
				System.out.println("\nYou can't transfer items to a box if the box isn't where you are.");}
			}
		}
	/**prints out a map of the world... not an exact one though*/
	static void displayMap(){
    	if (Person.player.inventory.contains(map)){
    		System.out.println (		
             "                                           Office of Campus Security\n"
           + "                                                       ^\n"
           + "                                                       |\n"
           + "                                                       v\n"
           + "             Nelly Golletti Theatre       <--->  Student Lounge\n"
           + "                                                       ^\n"
           + "                                                       |\n"
           + "                                                       v\n"
           + " Future Site of North End Housing Complex <--->   Campus Green   <--->   Lower New Townhouses\n"
           + "                                                       ^\n"
           + "                                                       |\n"
           + "                                                       v\n"
           + "                                          Mid-Hudson Plaza [across Route 9]\n");
    		System.out.println("That's useful, but you know it's just a simplification of reality. And probably missing a lot of stuff.");}
    	
    	
    	else{
    		System.out.println ("\nTrying picking up a map before you try to look at it.");}
        }

	/**Items*/
	static Item otherWrench = new Item ("The Other Wrench" , "It's another wrench. Who knew there was another wrench in the depths of the Cove.",
			"\nYou find the other wrench. Nice." );
	static Item grabber = new Item ("Grabber" , "Used to reach things out of your grasp. Squeeze the end to close it.", 
			"\nYou see the grabber leaning against the railing. This looks useful.");
	static Item repellent = new Item ("Goose Repellent" , "A pendant on a chain, stamped 'Goose Repellent'. It smells weird and might not work,"
			+ "\n but hopefully it'll keep the geese away." , "You see a pendant on a chain, stamped 'goose repellent'. This looks useful.");
	static Item parcans = new Item ("A BUNCH OF PARCANS", "A bunch of can-shaped stagelights (hence the name), as a collective unit." , "\nYou see a "
			+ "bunch of parcans sitting on the floor next to the door to the roof. You can take them, but do you really want ALL of them?");
	static Item bookbag = new Item ("Bookbag" , "It holds things. Very useful. [this is your inventory]" , "\nYou see a book bag sitting under"
			+ " the the lights to your left. Someone must have left it up here. It \nwould probably be useful for carrying things around.");
	        //this isn't supposed to show up in inventory because it IS your inventory.	
	static Item gafftape = new Item ("The Gaff Tape", "A clothlike tape they use in theatre for everything. Infinite uses, limited quantity." 
			, "\nYou see a roll of tape sitting on the shelf. Probably going to be useful." );
	static Item drill = new Item ("A drill", "It is a drill. Also known as a powertool. Useful for combining items. It's not like someone \ndropped "
			+ "a wrench into the depths of the Cove and needs to cobble together something to get it back..." , "\nJust a powertool, sitting on a table.");
    static Item plunger = new Item ("A Plunger", "What a nice plunger you have. What suction. The better to plunge toilets with... or hold things?"
        , "\nYou see a plunger behind the toilet. Good for plunging toilets, yes, but other things? Quite possibly.");
    static Item map = new Item ("A map", "A laminated map of the campus. useful, yes. Detailed, not really. ['show map' will display the map.]"
        , "\nIn a bin, there are maps. It's probably a smart idea to snag one."); 
    static Item bottle = new Item ("Jillian's Smirnoff", "TIME TO GET REKT", "\nA bottle. Of vodka. Left on a desk. In front of open curtains. Where "
    		+ "the RA can see it. For two days. My roommate is dumb."); //FIXME: Probably ought to take this out,,,
    static Item wrench = new Item ("The Wrench", "The whole reason you're in this mess to be begin with." , "Your contraption has latched onto the "
    		+ "wrench and it's coming back to daylight now.");
    static Item keys = new Item ("Some Car Keys", "A set of car keys to a Honda Civic... with a sticker with the VIN number of the car it belongs to "
                + "on it. No one ever said that was smart.", "You pull a set of car keys out of the Cove. You feel bad for the person who dropped "
                + "their keys in the Cove...");
    static Item avocados = new Item ("A Bin of Avocados.", "A bin of avocados. Full of avocados. What are you going to do with them? What if they're"
                + "sentient?", "Avocados? You didn't know Job Lot sells avocados. No... they definitely don't. Since they don't belong here, who's"
                + "going to miss them if you swipe them. But god, they're just sitting there like the mastermind of some horrid trap.");

	/**Array to hold Item objects*/
	static Item[] listOfItems = {otherWrench, grabber, repellent, parcans, bookbag, gafftape, drill, plunger, map, bottle,
			wrench, keys, avocados};
}//end of item class.
