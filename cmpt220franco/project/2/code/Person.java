package code;

import java.util.Scanner;

/**Person class holds all data related to people within the game including the player.*/
public class Person {
		int locationIndex; //the current location is referenced by its index in the locations list. This holds that index.
		boolean renderLocation; //determines  if you can fully render the location because THINGS HAPPEN
//		String name;
		Item[] inventory; //holds a list of item objects in your inventory
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
		
		static StackOfIntegers beenTo = new StackOfIntegers(); //creates a new StackOfIntegers to be used for back function.
		/**Get player's name*/
		String getName(){
			Scanner inputName = new Scanner(System.in);//creates a scanner object.
			System.out.println("Enter your name.");
			String yourName = inputName.next();
			System.out.println("-------------------------------------------------\n");
			return yourName;
			
			
		}
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
	    	this.inventoryEnabled = true;
	    }
}
