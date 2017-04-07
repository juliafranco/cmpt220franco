package code;

import java.util.ArrayList;

public class Container {
	String contName; //container name ie couch, depths of the cove, etc.
	String contDescription; //description of the container
	int capacity; //how much it can hold. -1 is for unlimited
	ArrayList<Item> contents = new ArrayList<>(); //what's in the container
	boolean hidden;

	
	//for the Depths, can't print description, have egg boolean property. (when you try to grab stuff, lessens the probability of getting anything.)
	/**no args constructor*/
	Container(){
		
	}
	/**Constructor for new container object*/
	Container (String name, String description, int canHold){
		contName = name;
		contDescription = description;
		capacity = canHold;
	}
	/**Constructor for hidden container*/
	Container (String name, String description, int canHold, boolean hideme){
		contName = name;
		contDescription = description;
		capacity = canHold;
		hidden = hideme;
	}
	
	/**Containers*/
	static Container couch1 = new Container ("Couch #1", "It's a couch. The one closest to you.", 2);
	static Container couch2 = new Container ("Couch #2", "It's a couch. The one second closest to you.", 2);
	static Container couch3 = new Container ("Couch #3", "It's a couch. The one second furtherst from you.", 2);
	static Container couch4 = new Container ("Couch #4", "It's a couch. The one furtherst from you.", 2);
	static Container depths = new Container ("The Depths of the Cove", "Where all the stuff you've dropped goes", -1, true);
	static Container closetBathroom = new Container ("The Bathroom cabinet", "There is a cabinet in the bathroom. It's wide open for the "
			+ "rummaging, but who puts a cabinet in the bathroom?", 4);
	static Container secondaryInv = new Container ("The Box", "A box sitting in the lightbooth. A good spot to put the stuff you don't want "
			+ "to carry around anymore. \n[This is your secondary inventory]",-1 ); //this should be unlimited.
	static Container K1Couch = new Container ("The Living Room Couch", "The couch sitting under the window on the wall at your right. It's"
			+ "seen things...", 2);
	static Container fridge = new Container ("The Refridgerator.", "It keeps food cold. And holds food. And hopefully doesn't smell bad.", -1);
	
	/**Array to hold container objects*/
	static Container[] listOfContainers = {couch1, couch2, couch3, couch4, depths, closetBathroom, secondaryInv, K1Couch};
	
	/**method to determine if the containers exists*/
	static Container determineContainerValid(String nameToCheck){
		for (int i = 0; i < listOfContainers.length; i++ )
			if (nameToCheck.equals(listOfContainers[i].contName))
				if (listOfContainers[i].hidden != true)
					return listOfContainers[i];
		 //if you get through the loop and don't find the container.
		System.out.println("\nThat container does not exist.");
		return null;}
	/**method to determine in the container's in the same place as you are.*/
	static void determineSamePlace(String nameToCheck){
		Container containerToFind = determineContainerValid (nameToCheck);
		if (containerToFind != null){
			if (Location.places[Person.player.locationIndex].receptacle.contains(containerToFind))
				containerToFind.printContainerContents();}
		else
			System.out.println("\nYou can't rummage through something that's somewhere completely different from where you are.");
	}
	/**method to print contents of container*/  //can't evoke on depths, need to specify with couches.//invoked with rummage function 
	void printContainerContents(){
		//looks to see if the name to check belongs to an item
		if (this.contents.isEmpty())//checks to see if it's empty.
				System.out.print("\nThis container is empty.");
		else{
			System.out.print("\nThe Contents of " + this.contName + ": ");
			for (int i = 0; i < this.contents.size(); i++ )
				System.out.print( this.contents.get(i).itemName + ", ");
			}
		System.out.println("");
		}
	/**method to take items out of container*/ //Invoked with take function <--uses default methods with ArrayList
	/**method to add items to container*/ //Invoked with deposit?? can you put something back?? used at beginning of game to set things. 
	void addItemToContainer (Item toAdd){
		//see if the container is full and not unlimited capacity,
		if (this.contents.size() >= this.capacity && !(this.capacity == -1))
			System.out.println("That container is full.");
		else//add the item to it.
			this.contents.add(toAdd);
	}
	/**method to remove item from container*/
	public void removeItem(Item thisItem) {
		this.contents.remove(thisItem);
	}
	
	/**Sets items in containers*/
	static void setItemsInContainers(){
    Container.depths.addItemToContainer(Item.otherWrench);
    Container.depths.addItemToContainer(Item.wrench);
    Container.depths.addItemToContainer(Item.keys);
    Container.couch4.addItemToContainer(Item.repellent);
    Container.closetBathroom.addItemToContainer(Item.gafftape);
   
    /**things that are there for test purposes.*/
//    Container.secondaryInv.addItemToContainer(Item.bottle);
 //   Container.secondaryInv.addItemToContainer(Item.map);
 //   Container.secondaryInv.addItemToContainer(Item.drill);
	}
	/**empties out the container*/
	static void emptyContainer() {
		for (int i = 0; i < listOfContainers.length; i++)
			listOfContainers[i].contents.clear();
	}
}//closes container class
