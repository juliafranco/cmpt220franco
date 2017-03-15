package code;

public class Person {
	//Person class holds all data related to people within the game including the player.
		int locationIndex; //the current location is referenced by its index in the locations list. This holds that index.
		boolean renderLocation; //determines  if you can fully render the location because THINGS HAPPEN
		//will have at least a name. 
		
		//the player probably will inherent other things {inventory}, and the others will have a separate things.
			//2 subclasses
		Person (){//no args  constructor with the default location
			locationIndex = 0; //the default location for a person.
		}	
		Person(int intLocation){//Constructor to set opening location.
			locationIndex = intLocation;
		}
		
		StackOfIntegers beenTo = new StackOfIntegers(); //creates a new StackOfIntegers to be used for back function.
		
		void moveLocation (int direction){//used to move player around the map
			if (Location.navMatrix[this.locationIndex][direction] >= 0){
				this.locationIndex = Location.navMatrix[this.locationIndex][direction];
				beenTo.push(this.locationIndex); //adds the index to the list of places the player's been to.
				renderLocation();//prints the details of the location.
			} else
				nothingThere();//prints out a message there's  nothing there.
		}
		boolean renderLocation (){//prints out the details of your location
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
	    void nothingThere (){//prints an error message if you try to go in a direction without a defined location.
	    	System.out.println("\nThere is nothing in that direction of " + Location.places[this.locationIndex].locationName);
	    }
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
	    void renderCurrentLocation(){//prints the name of your current location.
	    	System.out.println("\nYour current location is "+ Location.places[this.locationIndex].locationName);
	    	//maybe add the initial description of the place?
	    }
}
