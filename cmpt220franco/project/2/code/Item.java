package code;

import java.util.ArrayList;
import java.util.Arrays;

public class Item {
	String itemName;
	String combineKey; //used for combining things so the name actually makes sense.
	String itemDescript; //description of the item itself. 
	String inLocationDescript; //when you examine the location/container for items, this is what it says [need this??]
	int type; 
	//if it's gonna grab it or provide the length (0 is nothing, 1 is if it grabs it, 2 if it provides length, 3 if it's food, 4 doesn't go in inventory.)
	/**attribute that don't need to be set for all items.*/
	double montaryValue;//how much the item costs or how much value it has.
	int uses; //this also doubles as the quantity.
	EmptyItem emptyCounterPart; //what it gets swapped out with when the uses hit zero.
	
	int length; //how long the item is. 
	
	/**no arg constructor for inheritance purposes*/
	Item(){}
	/**Constructor for Item Object*/
	Item(String name, String shortName, String description, String examineMessage, int whatKind){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
		type = whatKind;
	}
	/**Constructor for Item Object that has a price*/
	Item(String name, String shortName, String description, String examineMessage, int whatKind, double faceValue){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
		type = whatKind;
		montaryValue = faceValue;
	}
	/**Constructor for Item Object that has certain amounts of use*/
	Item(String name, String shortName, String description, String examineMessage, int whatKind, int useAmount, EmptyItem whenEmpty){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
		type = whatKind;
		uses = useAmount;
		emptyCounterPart = whenEmpty;
	}
	/**Constructor for Item Object that has a length*/
	Item(String name, String shortName, String description, String examineMessage, int whatKind, int howLong){
		itemName = name;
		combineKey = shortName;
		itemDescript = description;
		inLocationDescript = examineMessage;
		type = whatKind;
		length = howLong;
	}
	
	/**Method to remove uses from item*/ //this is going to hang out here until I'm ready for it.
	void removeItemUses(){
		this.uses -= 1;
		this.SwitchWithEmpty();}//checks to see if it needs to be swapped with the empty v			
	/**switches the item with its empty version*/
	void SwitchWithEmpty(){
		if (this.uses <= 0){
			for (int i = 0; i < Person.player.inventory.size(); i++){//so it has the index of the item to swap out.
				if (Person.player.inventory.get(i).equals(this)){
					System.out.println("\n" + this.itemName + " is now empty.");
					Person.player.inventory.remove(this);
					if (this.emptyCounterPart != null)//if it has an empty counterpart.
						Person.player.inventory.add(i, this.emptyCounterPart);//so it can add the now empty item into that index
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
				System.out.print(" Lenght: " + itemfound.length + "ft.");
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
			if (itemToCheck.equalsIgnoreCase(listOfItems.get(i).itemName) ||itemToCheck.equalsIgnoreCase(listOfItems.get(i).combineKey)){
				//loops through the items in the list of items, looks to see if the string matches the name or combine key (a one or two word version
				//of the name.
				return listOfItems.get(i);//returns the item it finds
			}
		} //if you get through the loop and don't find the container.
		System.out.println("\nThat item does not exist.");
		return null;}//if there is no item with that name.
	/**method to determine in the container's in the same place as you are.*/
	Object[] determineSamePlace(){
		//if there's nothing there, the item can't be there. 
		Location placeToCheck = Location.places[Person.player.locationIndex];
		if (placeToCheck.isItEmpty()){
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
		System.out.println ((Person.player.inventory.contains(map))? 		//if it has the map, print the map
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
           + "                                          Mid-Hudson Plaza [across Route 9]\n" +
    		"That's useful, but you know it's just a simplification of reality. And probably missing a lot of stuff." :
    			"\nTrying picking up a map before you try to look at it."); //this is the else. 
        }
	/**looks to see if certain conditions with the item being deployed are met.*/
	boolean checkConditions (){
		//looks to see if everything's met. Otherwise, it'll return false.
			if (this.length >= 15 && (((CombinedItem)this).capture == true || this.type == 1)){
				return true;				
			} else {
				System.out.println("\nTry making sure your item is long enough to reach into the depths and/or "
						+ "can grasp the wrench. \nThis item currently has a length of " + this.length + "ft and " + 
						((this.type == 1) ? "can" : "cannot" ) +" grasp the wrench");
				return false;}
	}
	/**"eat" an item*/
	static void determineEatFood(String itemToEat){
		Item itemToFind = determineItemsExistance(itemToEat);//saves what the method returns as an item object
		if (itemToFind != null){
			if (Person.player.inventory.contains(itemToFind)){
				itemToFind.eatFood();
			} else {
				System.out.println("You can't eat something you don't have");}
		}
	}
	void eatFood(){
		if (this.type == 3){ //this is the food type
			if (this.uses > 0){
				this.removeItemUses();
				System.out.println("\nYou eat a piece from " + this.itemName);}
			else{
				Person.player.inventory.remove(this);
				System.out.println("\nYou eat " + this.itemName);}
			}
		else {
			System.out.println("\nYou really don't want to eat " + this.itemName + "...");}
	}
	
	/**Items*/
	static Item otherWrench = new Item ("The Other Wrench", "Other Wrench", "It's another wrench. Who knew there was another wrench in the depths of "
			+ "the Cove.", "\nYou find the other wrench. Nice." ,0 );
	static Item grabber = new Item ("The Grabber" , "Grabber", "Used to reach things out of your grasp. Squeeze the end to close it.", 
			"\nYou see the grabber leaning against the railing. This looks useful.", 1 ,1);//has a capture attribute, also has a length of a foot
	static Item repellent = new Item ("Some Goose Repellent" , "Goose Repellent", "A pendant on a chain, stamped 'Goose Repellent'. It smells weird "
			+ "and might not work,\n but hopefully it'll keep the geese away." , "You see a pendant on a chain, stamped 'goose repellent'. "
			+ "This looks useful." ,0);
	static Item parcans = new Item ("A BUNCH OF PARCANS", "Parcans", "A bunch of can-shaped stagelights (hence the name), as a collective unit." 
			, "\nYou see a bunch of parcans sitting on the floor next to the door to the roof. You can take them, but do you really want ALL of them?"
			, 0);
	static Item bookbag = new Item ("A Bookbag" , "Bookbag", "It holds things. Very useful. [this is your inventory]" , "\nYou see a book bag sitting "
			+ "under the the lights to your left. Someone must have left it up here. It \nwould probably be useful for carrying things around.", 4);
	        //this isn't supposed to show up in inventory because it IS your inventory.	
	static Item gafftape = new Item ("The Gaff Tape", "Gaff Tape", "A clothlike tape they use in theatre for everything. Infinite uses, limited "
			+ "quantity." , "\nYou see a roll of tape sitting on the shelf. Probably going to be useful.", 0, 7, EmptyItem.emptyRollOfTape);
	static Item drill = new Item ("A drill", "Drill", "It is a drill. Also known as a powertool. Useful for combining items. It's not like someone "
			+ "\ndropped a wrench into the depths of the Cove and needs to cobble together something to get it back..." , "\nJust a powertool, "
			+ "sitting on a table.", 0);
    static Item plunger = new Item ("A Plunger", "Plunger", "What a nice plunger you have. What suction. The better to plunge toilets with... or "
    		+ "hold things?", "\nYou see a plunger behind the toilet. Good for plunging toilets, yes, but other things? Quite possibly.", 1 , 1);
    static Item map = new Item ("A map", "Map", "A laminated map of the campus. useful, yes. Detailed, not really. ['show map' will display the map.]"
        , "\nIn a bin, there are maps. It's probably a smart idea to snag one.", 0); 
    static Item bottle = new Item ("Jillian's Smirnoff", "Vodka", "TIME TO GET REKT", "\nA bottle. Of vodka. Left on a desk. In front of open curtains."
    		+ " Where the RA can see it. For two days. My roommate is dumb.", 0); //FIXME: Probably ought to take this out,,,
    static Item wrench = new Item ("The Wrench", "Wrench",  "The whole reason you're in this mess to be begin with." , "\nYour contraption has latched "
    		+ "onto the wrench and it's coming back to daylight now.", 0);
    static Item keys = new Item ("Some Car Keys", "Car Keys", "A set of car keys to a Honda Civic... with a sticker with the VIN number of the car it "
    		+ "belongs to \non it. No one ever said that was smart.", "\nYou pull a set of car keys out of the Cove. You feel bad for the person who "
    		+ "dropped their keys \nin the Cove...", 0);
    static Item avocados = new Item ("A Bin of Avocados", "Avocado Bin" , "A bin of avocados. Full of avocados. What are you going to do with them? "
    		+ "What if they're sentient?", "\nAvocados? You didn't know Job Lot sells avocados. No... they definitely don't. Since they don't "
    		+ "\nbelong here, who's going to miss them if you swipe them. But god, they're just sitting there \nlike the mastermind of some horrid trap.",
    		0);
    static Item fiveBucks = new Item ("A crumpled 5 dollar bill", "5 Dollars", "It's a crumpled five dollar bill. It's crumpled, but it's still "
    		+ "worth five bucks.", "Score! In rummaging through the couch, you've found 5 bucks. This is a great plan.", 4, 5.);
    static Item purchasedWrench = new Item ("A wrench", "Wrench" , "Just a normal wrench with a pricetag reading $17.99, plus tax", "You see a wrench "
    		+ "on the pegboard in the aisle with the rest of the hand tools. The pricetag reads $17.99, plus tax", 0, -19.43 );
    static Item Unibrow = new Item ("The Unibrow" ,"Unibrow", "It's Squilliam Fancyson's Unibrow.", "It's Moves on its own. You shouldn't be able "
    		+ "to achieve this item.", 0 );
    static Item noodles = new Item ("Some peanut noodles" , "Peanut Noodles", "Are they noodles or are they heaven? God, they look delicious." 
    		, "\nIt's a container of peanut noodles that make your mouth water just looking at them." , 3, -3.69);
    static Item eggs = new Item ("A carton of eggs" ,"Eggs" , "A carton. Of eggs. From a chicken. Really nothing fancy.", "You see a carton of eggs "
    		+ "in the fridge. Anyone want an omelette?", 0, 12, EmptyItem.eggCarton);
    static Item workLight = new Item ("A worklight", "Worklight", "And the battery pack said: let there be light. See into the blackness... the depths?",
    		"You see a worklight, minding its own business. That looks useful...", 0);
    static Item extCord = new Item ("An extension cord" , "Extension Cord" , "A long cord that plugs into an outlet at one end, anything you want at "
    		+ "the other.", "You find an extension cord, sitting around, minding its own business", 2, 15);//has a length of 15
    static Item screws = new Item ("A few 1 5/8 inch screws" , "Screw" , "Screws. That are 1 5/8 inches long. And there are four of them", "\nYou find "
    		+ "four screws next to the saw. Maybe you can use them to put things together" , 0, 4, null);
    static Item gum = new Item ("A package of gum" , "Gum" , "A package of gum. I think it's mint??" , "You find a package of gum. Might as well chew "
    		+ "it...." , 3, 12, EmptyItem.gumPack);
	static Item tupperware = new Item ("A TupperWare Container" , "Tupperware" , "A tupperware container. Perfect for holding food." , "You find a "
			+ "tupperware container sitting on the counter. Not sure how this is gonna help, but you never know." , 0);
    static Item ladder = new Item ("A Ladder" , "Ladder" ,"A ten foot ladder. And bright orange." , "\nYou see a ladder leaned up against the wall on "
    		+ "stage left. It's orange and 10 feet tall. You can \ngrab it easily if you can carry a 10 foot ladder." , 2, 10);
	static Item change = new Item ("Some change", "Change" , "An assortment of dimes, nickles, pennies, and quarters. And is that a euro??", "\nYou pull "
			+ "up a handful of change from the depths of the Cove. Well, it's something.", 4, ((double)MainFile.getRandomNumber(100))/100);
	static Item moreChange = new Item ("Some change", "Change" , "An assortment of dimes, nickles, pennies, and quarters. And is that a euro??", 
			"\nYou feel a bunch of coins in the couch. Well, it's something.", 4, ((double)MainFile.getRandomNumber(100))/100);
    static Item rope = new Item ("A rope" , "Rope" , "22 feet of braided rope, acquired from someone, here now. Probably pretty strong." , "\nYou see a "
    		+ "rope draped over one of the lamp posts. It's very long and very ropey. What does 'ropey' even mean..." , 2, 22);
	static Item magnet = new Item ("A Magnet" , "Magnet" , "An extremely powerful magnet. Strong enough that it can attract anything metal. With great "
			+ "power comes great \nresponsibly. Don't do something dumb." , "\nSitting next to a pile of I-beams you find a magnet with a label reading '"
			+ "This is a huge ass magnet. Can attract \nmetal from up to 30 feet away. Use with caution'", 1);
	static Item pipe = new Item ("A PVC Pipe" , "Pipe" , "It is a pipe. Made of PVC. 3/4 of an inch wide, 7 feet long. What else are you expecting?" ,
			"\nIn the back corner amoungst building materials, you find a PVC pipe. You're not sure how it's \ngoing to fit in your bag, but it's probably "
			+ "going to be useful in getting back that damn wrench" , 2 , 7);
	static Item twobyfour = new Item ("A 2X4" , "2X4" , "A 2x4 is a piece of wood that's two inches thick by four inches wide and how long it ends up "
			+ "being, \nexcept it's smaller because of the way wood is made.","\nYou find a 2X4 in the back corner with a bunch of other building materials. "
			+ "A long piece of wood \nis definitely useful." , 2, 8);
	static Item bunny = new Item ("A big pink stuffed bunny" , "Bunny" , "A large pink stuffed bunny. Half your height, but adorable." , "Sitting on the "
			+ "bottom shelf of the automotive aisle, you find a misplaced stuffed pink bunny. It cost 4.99. Job Lot is weird." , 0, -5.40);
	static Item twentyDollars = new Item ("A soggy 20 dollar bill" , "20 Dollars" , "An extremely soggy 20 dollars. You hope you don't rip it to "
			+ "shreds." , "In the deep, dark, toxic depths of the Hudson River, you find a 20 dollar bill." , 4, 20.);
	static Item car = new Item ("A Honda Civic" , "Car" , "A blue, 2009, Honda Civic. It's in good condition despite the fact it's been sitting "
			+ "for an untold amount of time. If you had the keys. you could probably use it to go somewhere." , "You see a blue Honda Civic sitting "
			+ "parked in front of Rite Aid. It looks like it hasn't gone anywhere for a while. Maybe the owner lost the keys..." , 0);
	
	/**Array to hold Item objects*///it checks this list to see if an item exists...
    static ArrayList<Item> listOfItems = new ArrayList<>(Arrays.asList(otherWrench, grabber, repellent, parcans, bookbag, gafftape, 
    		EmptyItem.emptyRollOfTape, drill, plunger, map, bottle, wrench, keys, avocados, fiveBucks, purchasedWrench, Unibrow, 
    		noodles, eggs, EmptyItem.eggCarton, workLight, extCord, screws, gum, EmptyItem.gumPack, tupperware, ladder, change, moreChange, rope,
    		magnet, pipe, twobyfour, bunny, twentyDollars, car));
    //this is an arraylist so I can add the combined items to it.	
}//end of item class.
