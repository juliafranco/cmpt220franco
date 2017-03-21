package code;

public class Container {
	String contName; //container name ie couch, depths of the cove, etc.
	String contDescription; //description of the container
	int capacity; //how much it can hold.
	Item[] contents; //what's in the container
	//if some of the containers have unlimited capacity, maybe add a boolean, and if it's at "capacity", make it bigger. Inherit??
	
	//for the Depths, can't print description, have egg boolean property. (when you try to grab stuff, lessens the probability of getting anything.)
	/**Constructor for new container object*/
	Container (String name, String description, int canHold){
		contName = name;
		contDescription = description;
		capacity = canHold;
		contents = new Item[canHold];
	}
	
	/**Containers*/
	static Container couch1 = new Container ("Couch #1" , "It's a couch. The one closest to you.", 2);
	static Container couch2 = new Container ("Couch #2" , "It's a couch. The one second closest to you.", 2);
	static Container couch3 = new Container ("Couch #3" , "It's a couch. The one second furtherst from you.", 2);
	static Container couch4 = new Container ("Couch #4" , "It's a couch. The one furtherst from you.", 2);
	static Container depths = new Container ("The Depths of the Cove" , "Where all the stuff you've dropped goes", 3);
	static Container closetBathroom = new Container ("The Bathroom cabinet", "There is a cabinet in the bathroom. It's wide open for the "
			+ "rummaging, but who puts a cabinet in the bathroom?", 4);
	static Container secondaryInv = new Container ("The Box", "A box sitting in the lightbooth. A good spot to put the stuff you don't want "
			+ "to carry around anymore. \n[This is your secondary inventory]", Item.listOfItems.length ); //this should be unlimited.
	
	/**Array to hold container objects*/
	static Container[] listOfContainers = {couch1, couch2, couch3, couch4, depths, closetBathroom, secondaryInv};
	
	/**method to determine if examine container input is valid*/
	static void determineContainerValid(String nameToCheck){
		for (int i = 0; i < listOfContainers.length; i++ ){
			if (nameToCheck.equals(listOfContainers[i].contName)){
				listOfContainers[i].determineSamePlace(nameToCheck);
				return;
			}
		} //if you get through the loop and don't find the container.
		System.out.println("\nThat container does not exist.");}
	/**method to determine in the container's in the same place as you are.*/
	void determineSamePlace(String nameToCheck){
		if (Location.places[Person.player.locationIndex].receptacle[0] == null){
			System.out.print("");
		}else {
			for (int j = 0; j < Location.places[Person.player.locationIndex].receptacle.length; j++){
				if (nameToCheck.equals(Location.places[Person.player.locationIndex].receptacle[j].contName)){
					Location.places[Person.player.locationIndex].receptacle[j].printContainerContents();
					return;}
			}
		}
		System.out.println("\nYou can't rummage through something that's somewhere completely different from where you are.");
	}
	/**method to print contents of container*/  //can't evoke on depths, need to specify with couches.//invoked with rummage function 
	void printContainerContents(){
		//looks to see if the name to check belongs to an item
		if (this.contents[0] == null)
				System.out.print("\nThis container is empty.");
		else{
			System.out.print("\nThe Contents of " + this.contName + ": ");
			for (int i = 0; i < this.contents.length; i++ ){
				if (this.contents[i] == null){
					System.out.println("");
					return;}
				System.out.print( this.contents[i].itemName + ", ");}
		}
		System.out.println("");
		}
	/**method to take items out of container*/ //Invoked with take function
	//will need to shift item indexes down 1. (1 becomes 0, 3 becomes 2, etc)
	
	/**method to add items to container*/ //Invoked with deposit?? can you put something back?? used at beginning of game to set things. 
	void addItemToContainer (Item toAdd){
		//see if you need to increase the size of the array.
		if (this.contents.length > 0)
				if (this.contents[(this.contents.length- 1)]!= null){//ie, if there's something there. Hopefully.
					System.out.println("That container is full.");
					return;}
		//need to find the first open index. 
		for (int i = 0; i < this.contents.length; i++)
			if (this.contents[i] == null){
				this.contents[i] = toAdd;
				break;
				}
	}
	
	/**Sets items in containers*/
	static void setItemsInContainers(){
    Container.depths.addItemToContainer(Item.otherWrench);
    Container.couch4.addItemToContainer(Item.repellant);
   
    /**things that are there for test purposes.*/
    Container.couch1.addItemToContainer(Item.otherWrench); 
    Container.couch1.addItemToContainer(Item.grabber);
    
	}
	/**empties out the container*/
	static void emptyContainer() {
		for (int i = 0; i < listOfContainers.length; i++)
			for (int j = 0; j < listOfContainers[i].contents.length; j++)
				listOfContainers[i].contents[j] = null;
		
	}
}
