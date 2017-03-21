package code;

public class Item {
	String itemName;
	String itemDescript; //description of the item itself. 
	String inLocationDescript; //when you examine the location/container for items, this is what it says [need this??]
	
	//price for some items.
	//number of uses for some items
	//money is a subclass with a  montary value field, when you pick it up, add to your money, doesn't show in inventory.
	//so is the bag- doesn't add to inventory, instead allows you to hold things.
	
	/**Constructor for Item Object*/
	Item( String name, String description, String examineMessage){
		itemName = name;
		itemDescript = description;
		inLocationDescript = examineMessage;
	}
	
	/**Method to remove uses from item*/
	/**Method to print the item/container description... or not...*/
	static void printItemDescription(String nameToCheck){
		//looks to see if the name to check belongs to an item
		for (int i = 0; i < listOfItems.length; i++ ){
			if (nameToCheck.equals(listOfItems[i].itemName)){
				System.out.println("\n" + listOfItems[i].itemDescript);
			return;}
		}
		//looks to see if name belongs to a container. Might have a way to merge these loops but for now....
		for (int j = 0; j < Container.listOfContainers.length; j++ ){
			if (nameToCheck.equals(Container.listOfContainers[j].contName)){
				System.out.println("\n" + Container.listOfContainers[j].contDescription);
			return;}
		}
		//if you get through everything and nothing's popped out.
		System.out.println("\nThat item or container does not exist.");
			
	}
	
	/**List of items*/
	static Item otherWrench = new Item ("The Other Wrench" , "It's another wrench. Who knew there was another wrench in the depths of the Cove.",
			"You find the other wrench. Nice." );
	static Item grabber = new Item ("Grabber" , "Used to reach things out of your grasp. Squeeze the end to close it.", 
			"You see the grabber leaning against the railing. This looks useful.");
	static Item repellant  = new Item ("Goose Repellent" , "A pendant on a chain, stamped goose repellant. It smells weird and might not work,"
			+ " but hopefully it'll keep the geese away" , "You see a  pendant on a chain, stamped 'goose repellant'. This looks useful");
	static Item parcans = new Item ("A BUNCH OF PARCANS", "A bunch of can-shaped stagelights (hence the name), as a collective unit." , "You see a "
			+ "bunch of parcans sitting on the floor next to the door to the roof. You can take them, but do you really want ALL of them?");
	static Item bookbag = new Item ("A bookbag" , "It holds things. Very useful. [this is your inventory]" , "You see a book bag sitting under"
			+ " the the lights to your left. Someone must have left it up here. It would probably be useful for carrying things around.");
	        //this isn't supposed to show up in inventory because it IS your inventory.			

	/**Array to hold Item objects*/
	static Item[] listOfItems = {otherWrench, grabber, repellant, parcans, bookbag};
}
