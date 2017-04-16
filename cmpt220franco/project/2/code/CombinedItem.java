package code;

public class CombinedItem extends Item {
	boolean capture = false;
	Item part1;
	Item part2;
	/**no args constructor*/
	CombinedItem(){}
	/**constructor called when items get combined.*/
	CombinedItem(Item item1, Item item2){
		itemName = item1.combineKey + "-" + item2.combineKey;
		combineKey = itemName; //for numbers, add them.
		itemDescript = "A combination of " + item1.itemName + " and " + item2.itemName;
		length = item1.length + item2.length;
		//for the true false atrributes, do an "or" so if one has it, the combination has it.
		if (item1.type == 1 || item2.type == 1){//1 is the capture type
			capture = true;}
		if (item1.type == 0  || item2.type == 0){//0 is the "uncombinable" type
			System.out.print(" but it just makes something horrifying");//adds on when it prints out.
		}
		//save the original pieces in case it gets split. 
		part1 = item1;
		part2 = item2;
		
	}

	/**combines the two items into one.*/
	static CombinedItem combineItems(String itemsToCombine) {
		try {
			String[] itemNames = MainFile.splitInput(itemsToCombine, " with ");
			Item item1 = Item.determineItemsExistance(itemNames[0]);//saves what the method returns as an item object
			if (item1 != null){// if the first item exists...
				Item item2 = Item.determineItemsExistance(itemNames[1]); //see if the second one exists.
				if (item2 != null){ //if the second item exists....
					if (Person.player.inventory.contains(item1) && Person.player.inventory.contains(item2)){//if the player has both items.
						if (!(item1.equals(item2))){//if item 1 and item 2 aren't the same item.
							System.out.print("\nYou combine the items together");
							determineRemoveItems(item1, item2);
							return (new CombinedItem (item1, item2));//calls the constructor to put these two items together
							} else {
								System.out.println("\nYou can't combine an item with itself.");}
						} else { System.out.println("\nYou can't combine an item you don't have.");}//closes if the player has the item or not.
					}//closes the item 2 existing
				}//closes item 1 existing.
			} catch (ArrayIndexOutOfBoundsException ex){ //this is the outermost layer of these statements and closes if the player put in two items or not.
				System.out.println("\nPlease enter the names of the two items you'd like to combine, separated by 'with'" );}
		return null;
	}//closes the method
    /**determines how combined items get removed from your inventory*/
	static void determineRemoveItems(Item item1, Item item2) {
		if (!(item1.uses > 0))//if the item has multiple uses, leave it.
			Person.player.inventory.remove(item1);//takes the first item out
		if (!(item2.uses > 0))//if the item has multiple uses, leave it.
			Person.player.inventory.remove(item2);//takes the second item out
		}
}//end of class
