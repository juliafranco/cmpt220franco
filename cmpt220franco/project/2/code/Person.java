package code;

import java.util.ArrayList;
import java.util.Scanner;

/**Person class holds all data related to people within the game including the player.*/
public class Person {
		int locationIndex; //the current location is referenced by its index in the locations list. This holds that index.
		boolean renderLocation; //determines if you can fully render the location because THINGS HAPPEN
//		String name; //disabled for now because you don't need it at the moment and it annoys me.
		ArrayList<Item> inventory = new ArrayList<>(); //holds a list of item objects in your inventory, can hold five items [can change if I want...].
		final int MAX_INVENTORY = 5;
		boolean inventoryEnabled = false; //determines if you can hold things. Starts out you can't.
		//and money.
		
		//the player probably will inherent other things {inventory}, and the others will have a separate things.
			//2 subclasses
		Person (){//no args  constructor with the default location
			locationIndex = 0; //the default location for a person.
//			name = getName();
		}	
		Person(int intLocation){//Constructor to set opening location.
			locationIndex = intLocation;
		}
		
		static Person player = new Person (); //creates the object of the player
		
		StackOfIntegers beenTo = new StackOfIntegers(); //creates a new StackOfIntegers to be used for back function.
		/**Get player's name*/
		String getName(){
			Scanner inputName = new Scanner(System.in);//creates a scanner object.
			System.out.println("Enter your name.");
			String yourName = inputName.next();
			System.out.println("-------------------------------------------------\n");
			return yourName;}
		/**used to move player around the map*/
		void moveLocation (int direction){
			if (Location.navMatrix[this.locationIndex][direction] >= 0){
				this.locationIndex = Location.navMatrix[this.locationIndex][direction];
				beenTo.push(this.locationIndex); //adds the index to the list of places the player's been to.
				renderLocation();//prints the details of the location.
			} else
				nothingThere();//prints out a message there's  nothing there.
		}
		/**prints out the details of your location*/
		boolean renderLocation (){
			System.out.println("\nYour location is " + Location.places[this.locationIndex].locationName);
			System.out.println("");
			if (this.locationIndex == 8)
				//if you're on the green, run the getMauled. If you get mauled, print the quit. Otherwise, carry on.
				if (Location.getMauled()){
					MainFile.displayQuit(9);
					return this.renderLocation = false;}
			//if you've been there, prints the alternate description. Otherwise prints the original.
			System.out.println((Location.places[this.locationIndex].isVisited) ? Location.places[this.locationIndex].altDescription 
					: Location.places[this.locationIndex].locationDescription );
			//if this is the first time you're there, changes it so it knows you have.
			if (!Location.places[this.locationIndex].isVisited)
				Location.places[this.locationIndex].changeVisited();
			if (this.locationIndex == 5){//if you're in the abandoned Staples
				MainFile.displayQuit(1);
				return this.renderLocation = false;}
			return this.renderLocation = true;}
		/**prints an error message if you try to go in a direction without a defined location.*/
	    void nothingThere (){
	    	System.out.println("\nThere is nothing in that direction of " + Location.places[this.locationIndex].locationName);}
	    /**Takes the player back to their previous location.*/
	    void goBack (){
	    	if (beenTo.getSize() == 1)//the only item in the list is the zero. If it wasn't there, it would throw exceptions.
	    		System.out.println("\nYou can't go back any further.");
	    	else {
	    		beenTo.pop();//remove last item in stack
	    		/**returns the top index in the stack, sets it as the player's 
	    		 * current location and renders the location */
	    		this.locationIndex = beenTo.peek();
	    		renderLocation();
	    	}    	
	    }
	    /**prints the name of your current location.*/
	    void renderCurrentLocation(){
	    	System.out.println("\nYour current location is "+ Location.places[this.locationIndex].locationName);}
	    /**Flips the inventory boolean so you can hold items. Flips after you pick up the book bag*/
	    void enableInventory (){
	    	this.inventoryEnabled = true;}
		void displayInventory(){
			this.displayPersonalInventory();
			//displays secondary inventory, if anything. 
			if (!Container.secondaryInv.contents.isEmpty()){//if there's something in there or not...
				System.out.println("\nItems in Secondary Inventory:");
				for (int j = 0; j < Container.secondaryInv.contents.size(); j++ )//loop through the elements in the list
					System.out.print(Container.secondaryInv.contents.get(j).itemName + ", ");//print the list of items.
			 System.out.print("\n");}//this is for formating purposes.
		}
		/**prints the contents of personal inventory*/
		void displayPersonalInventory(){
			//prints everything in personal inventory
			if (this.inventory.isEmpty())//if it;s empty.
				System.out.println("\nThere is nothing in your inventory.");
			else{
				System.out.println("\nYour inventory is: ");
				for (int i = 0; i < this.inventory.size(); i++)//lloop through all the items in inventory
					System.out.print(this.inventory.get(i).itemName + ", "); //and print them.
				System.out.println("");
			}
	//		System.out.print("\n"); //this is for formating purposes.
		}
		/**determines if you can add an item to the inventory*/
		void determineAddItem (String itemToAdd){
			if (this.inventory.size() >= MAX_INVENTORY) //checks if it's full
				System.out.println("\nYour bag is full. Maybe try transferring a few things to a secure location... a box in the lightbooth perhaps?");
			else Item.determineSamePlace(itemToAdd); //determines if the item is where the player is
		}
		/**adds an item to the inventory*/
		void addItem(Item itemToAdd){
			if (itemToAdd != Item.bookbag){//if it's not the bookbag which doesn't show up in your inventory
				this.inventory.add(itemToAdd);
				System.out.println("\nYou add the item to your inventory");
				displayInventory();}
		}
		/**drops an item from inventory*/
		void dropItem(String itemToCheck) {
			Item itemToFind = Item.determineItemsExistance(itemToCheck);//saves what the method returns as an item object
			if (itemToFind != null){
				if (this.inventory.contains(itemToFind)){
					this.inventory.remove(itemToFind);
					Location.places[this.locationIndex].addItem(itemToFind);
					System.out.println("\nYou set the item down in " + Location.places[this.locationIndex].locationName);
					displayInventory();}
				else{
					System.out.println("\nYou can't drop an item you don't have.");}
				}
		}
		
}//closes out person class.
