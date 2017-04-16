package code;

import java.util.ArrayList;
import java.util.Arrays;

public class Item {
	String itemName;
	String combineKey; //used for combining things so the name actually makes sense.
	String itemDescript; //description of the item itself. 
	String inLocationDescript; //when you examine the location/container for items, this is what it says [need this??]
	double montaryValue;//how much the item costs or how much value it has.
	int uses; //this also doubles as the quantity.
	EmptyItem emptyCounterPart; //what it gets swapped out with when the uses hit zero.
	int type; //if it's gonna grab it or provide the length (0 is nothing, 1 is if it grabs it.)
	double length; //how long the item is. 
	
	/**no arg constructor for inheritance purposes*/
	Item(){}
	/**Constructor for Item Object*/
	Item(String name, String shortName, String description, String examineMessage){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
	}
	/**Constructor for Item Object that has a price*/
	Item( String name, String shortName, String description, String examineMessage, double faceValue){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
		montaryValue = faceValue;
	}
	/**Constructor for Item Object that has certain amounts of use*/
	Item( String name, String shortName, String description, String examineMessage, int useAmount, EmptyItem whenEmpty){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
		uses = useAmount;
		emptyCounterPart = whenEmpty;
	}
	
	/**Method to remove uses from item*/ //this is going to hang out here until I'm ready for it.
	void removeItemUses(){
		this.uses -= 1;
		this.SwitchWithEmpty();}//checks to see if it needs to be swapped with the empty v			
	/**switches the item with its empty version*/
	void SwitchWithEmpty(){
		if (this.uses <= 0){
			for (int i = 0; i < Person.player.inventory.size(); i++){
				if (Person.player.inventory.get(i).equals(this)){
					System.out.println("\n" + this.itemName + " is now empty.");
					Person.player.inventory.remove(this);
					Person.player.inventory.add(i, this.emptyCounterPart);
					}
			}
			Container.bb.addItemToContainer(this);//I don't know why I think this is a good idea, but it's funny.
		}
	}
	/**Method to print the item/container description... or not...*/
	static void printItemDescription(String nameToCheck){
		//looks to see if the name to check belongs to an item
		Item itemfound = determineItemsExistance(nameToCheck);
		if (itemfound != null){
			System.out.print("\n" + itemfound.itemDescript);
			//prints the length, if it has one of note.
			if (itemfound.length != 0)
				System.out.print(" Lenght: " + itemfound.length);
			System.out.println("");
			return;}
		//looks to see if name belongs to a container. 
		Container containerFound = Container.determineContainerValid(nameToCheck);
		if (containerFound != null){
			System.out.println("\n" + containerFound.contDescription);
			return;}
	}
	/**method to determine if the item you're trying to manipulate exists.*/
	static Item determineItemsExistance(String itemToCheck){
		for (int i = 0; i < listOfItems.size(); i++ ){
			if (itemToCheck.equals(listOfItems.get(i).itemName)){//loops through the items in the list of items
				return listOfItems.get(i);//returns the item it finds
			}
		} //if you get through the loop and don't find the container.
		System.out.println("\nThat item does not exist.");
		return null;}//if there is no item with that name.
	/**method to determine in the container's in the same place as you are.*/
	Object[] determineSamePlace(){
		//if there's nothing there, the item can't be there. 
		Location placeToCheck = Location.places[Person.player.locationIndex];
		if (placeToCheck.items.isEmpty() &&  placeToCheck.receptacle.isEmpty()){
			System.out.print("");}
			//determines if an item is in the location directly.
		else if  (placeToCheck.items.contains(this)){
			Object[] output = new Object[] {true, 0}; //the zero is a marker of where it comes from- item or container
			return output;} //no reason to look at anything else.
		//determines if an item is in a container in that location.
		else if  (!placeToCheck.receptacle.isEmpty()){//if the location has containers.
			for (int k = 0; k < placeToCheck.receptacle.size(); k++){//loops through the containers in the location
				if (placeToCheck.receptacle.get(k).contents.contains(this)){//checks to see if the item name matches something in the container
					if (!(placeToCheck.receptacle.get(k) instanceof SpecialtyContainer)){//some containers are hidden, like the depths of the cove. 
						Object[] output = new Object[] {true, 1, placeToCheck.receptacle.get(k)};//the one is a marker of where it comes from- item or container
						return output;}
					}
				}
			//if you get through everything with out finding it and returning...
			System.out.println("\nYou can't take something that's somewhere completely different from where you are.");
		}
		Object[] output = new Object[] {false};
		return output;
	}
	/**determines if an item can be taken or needs to be paid for.*/
	boolean takeItemWithCost (){
		if (this.montaryValue < 0){
			System.out.println("\n...yeah, you should probably pay for that... It costs $" + (this.montaryValue * -1)
					+ ". Unless, you know, you're going to steal it.");
			return true;}
		return false;
	}
	/**adds the item to your inventory*/
	static void takeItem (String itemToCheck){
		Item itemToFind = determineItemsExistance(itemToCheck);//saves what the method returns as an item object
		if (itemToFind != null){
			Object [] returnedArgs = itemToFind.determineSamePlace();
			if ((boolean) returnedArgs[0]){
				if(itemToFind.takeItemWithCost()){return;} //this just prints the message and then nothing else.
				else if ((int)returnedArgs[1] == 0){//taking the item  directly out of the location
					Location.places[Person.player.locationIndex].items.remove(itemToFind);}
				else if ((int)returnedArgs[1] == 1){//taking the item out of a container
					((Container) returnedArgs[2]).removeItem(itemToFind);} //removes the item from the container.
				Person.player.addItem(itemToFind);//adds the item to inventory
				}
			}
	}
	/**goes through and determines if you can buy the item.*/
	static void buyItem(String itemToCheck) {
		Item itemToFind = determineItemsExistance(itemToCheck);//saves what the method returns as an item object
		if (itemToFind != null){//if it found one. 
			Object [] returnedArgs = itemToFind.determineSamePlace();
			if ((boolean) returnedArgs[0]){//this should be true, the item exists and is in that location
				System.out.println("\nThis item costs $" + (itemToFind.montaryValue * -1) + ". Proceed? (y/n)");
				if (MainFile.getSecondaryInput().equals("y")){
					Person.player.spendMoney(itemToFind);}
					//don't need anything to pull item out containers/locations since there's more items there theoretically.
				else 
					System.out.println("You put down the item and go about your business.");
				}
			}		
	}
	/**transfers item from inventory to the box in the lightbooth.*/
	static void TransferItem(String itemToCheck){
		if (itemToCheck.equals("all")){
			transferAll();
			return;}
		Item itemToFind = determineItemsExistance(itemToCheck);//saves what the method returns as an item object
		if (itemToFind != null){//if the item you entered exists
			if (Location.places[Person.player.locationIndex].receptacle.contains(Container.secondaryInv)){//sees if you're in the booth with the box
				System.out.println("\nYou transfer the item to the box.");
				Container.secondaryInv.addItemToContainer(itemToFind);//puts the item in the box
				Person.player.inventory.remove(itemToFind);//takes the item out of your inventory
				Person.player.displayInventory();}//prints out what's left
			else{
				System.out.println("\nYou can't transfer items to a box if the box isn't where you are.");}
			}
		}
	static void transferAll() {
		for (int i= (Person.player.inventory.size() -1); Person.player.inventory.size() != 0; i--){
			Container.secondaryInv.addItemToContainer(Person.player.inventory.get(i));//puts the item in the box
			Person.player.inventory.remove(Person.player.inventory.get(i));//takes the item out of your inventory
		}
		System.out.println("\nYou transfer all the items to the box.");
		Person.player.displayInventory();//prints out what's left
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
    	
    	else
    		System.out.println ("\nTrying picking up a map before you try to look at it.");
        }

	/**looks to see if certain conditions with the item being deployed are met.*/
	boolean checkConditions (){
//		return true;
		//looks to see if everything's met. Otherwise, it'll return false.
			if (this.length >= 15 && (((CombinedItem)this).capture == true || this.type == 1)){
				return true;				
			} else {
				System.out.println("Try making sure your item is long enough to reach into the depths and/or "
						+ "can grasp the wrench.");
				return false;}
	}
	/**Items*/
	static Item otherWrench = new Item ("The Other Wrench", "Other Wrench", "It's another wrench. Who knew there was another wrench in the depths of "
			+ "the Cove.", "\nYou find the other wrench. Nice." );
	static Item grabber = new Item ("Grabber" , "Grabber", "Used to reach things out of your grasp. Squeeze the end to close it.", 
			"\nYou see the grabber leaning against the railing. This looks useful.");
	static Item repellent = new Item ("Goose Repellent" , "Goose Repellent", "A pendant on a chain, stamped 'Goose Repellent'. It smells weird "
			+ "and might not work,\n but hopefully it'll keep the geese away." , "You see a pendant on a chain, stamped 'goose repellent'. "
			+ "This looks useful.");
	static Item parcans = new Item ("A BUNCH OF PARCANS", "Parcan", "A bunch of can-shaped stagelights (hence the name), as a collective unit." 
			, "\nYou see a bunch of parcans sitting on the floor next to the door to the roof. You can take them, but do you really want ALL of them?");
	static Item bookbag = new Item ("Bookbag" , "Bookbag", "It holds things. Very useful. [this is your inventory]" , "\nYou see a book bag sitting "
			+ "under the the lights to your left. Someone must have left it up here. It \nwould probably be useful for carrying things around.");
	        //this isn't supposed to show up in inventory because it IS your inventory.	
	static Item gafftape = new Item ("The Gaff Tape", "Gaff Tape", "A clothlike tape they use in theatre for everything. Infinite uses, limited quantity." 
			, "\nYou see a roll of tape sitting on the shelf. Probably going to be useful.", 7, EmptyItem.emptyRollOfTape);
	static Item drill = new Item ("A drill", "Drill", "It is a drill. Also known as a powertool. Useful for combining items. It's not like someone "
			+ "\ndropped a wrench into the depths of the Cove and needs to cobble together something to get it back..." , "\nJust a powertool, "
			+ "sitting on a table.");
    static Item plunger = new Item ("A Plunger", "Plunger", "What a nice plunger you have. What suction. The better to plunge toilets with... or "
    		+ "hold things?", "\nYou see a plunger behind the toilet. Good for plunging toilets, yes, but other things? Quite possibly.");
    static Item map = new Item ("A map", "Map", "A laminated map of the campus. useful, yes. Detailed, not really. ['show map' will display the map.]"
        , "\nIn a bin, there are maps. It's probably a smart idea to snag one."); 
    static Item bottle = new Item ("Jillian's Smirnoff", "Vodka", "TIME TO GET REKT", "\nA bottle. Of vodka. Left on a desk. In front of open curtains."
    		+ " Where the RA can see it. For two days. My roommate is dumb."); //FIXME: Probably ought to take this out,,,
    static Item wrench = new Item ("The Wrench", "Wrench",  "The whole reason you're in this mess to be begin with." , "Your contraption has latched "
    		+ "onto the wrench and it's coming back to daylight now.");
    static Item keys = new Item ("Some Car Keys", "Car Keys", "A set of car keys to a Honda Civic... with a sticker with the VIN number of the car it "
    		+ "belongs to \non it. No one ever said that was smart.", "\nYou pull a set of car keys out of the Cove. You feel bad for the person who "
    		+ "dropped their keys \nin the Cove...");
    static Item avocados = new Item ("A Bin of Avocados", "Avocado Bin" , "A bin of avocados. Full of avocados. What are you going to do with them? "
    		+ "What if they're sentient?", "\nAvocados? You didn't know Job Lot sells avocados. No... they definitely don't. Since they don't "
    		+ "\nbelong here, who's going to miss them if you swipe them. But god, they're just sitting there \nlike the mastermind of some horrid trap.");
    static Item fiveBucks = new Item ("A crumpled 5 dollar bill", "Five Dollars", "It's a crumpled five dollar bill. It's crumpled, but it's still worth "
    		+ "five bucks.", "Score! In rummaging through the couch, you've found 5 bucks. This is a great plan.", 5.);
    static Item purchasedWrench = new Item ("A wrench", "Wrench" , "Just a normal wrench with a pricetag reading $17.99, plus tax", "You see a wrench "
    		+ "on the pegboard in the aisle with the rest of the hand tools. The pricetage reads $17.99, plus tax", -19.43 );
    static Item Unibrow = new Item ("The Unibrow" ," Unibrow", "It's Squilliam Fancyson's Unibrow.", "It's Moves on its own. You shouldn't be able "
    		+ "to achieve this item.");
    static Item noodles = new Item ("Some peanut noodles" , "Peanut Noodles", "Are they noodles or are they heaven? God, they look delicious." 
    		, "It's a container of peanut noodles that make your mouth water just looking at them." , -3.69);
    static Item eggs = new Item ("A carton of eggs" ," Eggs" , "A carton. Of eggs. From a chicken. Really nothing fancy.", "You see a carton of eggs "
    		+ "in the fridge. Anyone want an omelette?", 12, EmptyItem.eggCarton);
    static Item workLight = new Item ("A worklight", "Worklight", "And the power cord said: let there be light. See into the blackness... the depths?",
    		"You see a worklight, minding its own business. That looks useful...");
    
	/**Array to hold Item objects*/
    static ArrayList<Item> listOfItems = new ArrayList<>(Arrays.asList(otherWrench, grabber, repellent, parcans, bookbag, gafftape, 
    		EmptyItem.emptyRollOfTape, drill, plunger, map, bottle, wrench, keys, avocados, fiveBucks, purchasedWrench, Unibrow, 
    		noodles, eggs, EmptyItem.eggCarton, workLight));//this is an arraylist so I can add the combined items to it.	
}//end of item class.
