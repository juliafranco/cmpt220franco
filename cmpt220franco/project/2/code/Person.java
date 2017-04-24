package code;

import java.util.ArrayList;

/**Person class holds all data related to people within the game including the player.*/
public class Person {
		int locationIndex; //the current location is referenced by its index in the locations list. This holds that index.
		boolean renderLocation = true; //determines if you can fully render the location because THINGS HAPPEN
//		String name; //disabled for now because you don't need it at the moment and it annoys me.
		ArrayList<Item> inventory = new ArrayList<>(); //holds a list of item objects in your inventory, can hold five items [can change if I want...].
		final int MAX_INVENTORY = 5;
		boolean inventoryEnabled = false; //determines if you can hold things. Starts out you can't.
		double moneyHad;//and money.
		
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
			System.out.println("Enter your name.");
			String yourName = MainFile.getSecondaryInput();
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
		void renderLocation (){
			System.out.println("\nYour location is " + Location.places[this.locationIndex].locationName);
			System.out.println("");
			if (this.locationIndex == 8)
				//if you're on the green, run the getMauled. If you get mauled, print the quit. Otherwise, carry on.
				if (Location.getMauled()){
					MainFile.displayQuit(9);
					return;}
			//if you've been there, prints the alternate description. Otherwise prints the original.
			System.out.println((Location.places[this.locationIndex].isVisited) ? Location.places[this.locationIndex].altDescription 
					: Location.places[this.locationIndex].locationDescription );
			//if this is the first time you're there, changes it so it knows you have.
			if (!Location.places[this.locationIndex].isVisited)
				Location.places[this.locationIndex].changeVisited();
			if (this.locationIndex == 5){//if you're in the abandoned Staples
				MainFile.displayQuit(1);
				return;}
			}
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
	    /**allows the player to hop to locations*/
	    void driveThere (){
	    	//add relevant error messages.
	    	//check to see if you're in the location with the car. Add car to inventory? Or it's "there"
	      	if (this.inventory.contains(Item.car) || Location.places[this.locationIndex].items.contains(Item.car)){ 
	      		if (this.inventory.contains(Item.keys)){ //if you've found the keys
	      			if (Location.places[this.locationIndex].drivable){ //since you can pick up the car and deposit it somewhere else.
	      				 //print a list of locations you can drive to. Don't include your current.
	      				Location.places[this.locationIndex].getDrivableLocations();
	      				System.out.println("Where do you want to drive to? ");
	      			    //get/pass the location name. Make sure it's real and you can drive there.
	      				int locationToDriveTo = Location.determineLocationExistence(MainFile.getSecondaryInput());
	      				if (locationToDriveTo >= 0){
	      				    //set your current location and render it. add it to the stack for back function. 
	      					this.locationIndex = locationToDriveTo;
	      					beenTo.push(this.locationIndex); //adds the index to the list of places the player's been to.
	      					renderLocation();//prints the details of the location.
	      					return;
	      				} else 
	      					System.out.println("\nThat location does not exist");
	      			} else
	      				System.out.println("\n...you can't drive anywhere from here...");
	      		} else
	      			System.out.println("\nYou can't drive anywhere if you don't have the keys to start the car...");
	      	} else
	      		System.out.println("\nYou can't drive anywhere without a car...");
	    	//as of now, can only drive to the parking lot, lola's and Wawa.
	    }//end of method.
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
				System.out.println("\nThere is nothing in your inventory." + this.displayMoney());
			else{
				System.out.println("\nYour inventory is: ");
				for (int i = 0; i < this.inventory.size(); i++)//lloop through all the items in inventory
					System.out.print(this.inventory.get(i).itemName + ", "); //and print them.
				System.out.print(this.displayMoney());
				System.out.println("");
			}
		}
		/**prints the combined items in your inventory*/
		void displayCombinedItems(){
			int count = 0;
			if (!this.inventory.isEmpty()){//if there's actually stuff there.
				for (int i = 0; i < this.inventory.size(); i++){
					if (this.inventory.get(i) instanceof CombinedItem){
						System.out.print(this.inventory.get(i).itemName + ", ");
						count++;}
				}
				if (count == 0){
					System.out.println("You don't have any combined items.");}
			}
		}
		/**prints the money you have*/
		String displayMoney(){
			 if (this.moneyHad != 0)
				 return " You have $" + this.moneyHad;
			 return "";}
		/**determines if you can add an item to the inventory*/
		void determineAddItem (String itemToAdd){
			if (this.inventory.size() >= MAX_INVENTORY) //checks if it's full
				System.out.println("\nYour bag is full. Maybe try transferring a few things to a secure location... a box in the lightbooth perhaps?");
			else Item.takeItem(itemToAdd); //determines if the item is where the player is
		}
		/**adds an item to the inventory*/
		void addItem(Item itemToAdd){
			if (itemToAdd != Item.bookbag){//if it's not the bookbag which doesn't show up in your inventory
				if (!this.CheckWrench(itemToAdd))//check to see if you're adding a wrench to your inventory.
					return;//if you are, it's done everything in that method and just needs to break.
				if (itemToAdd.montaryValue > 0){
					this.moneyHad += itemToAdd.montaryValue;
					System.out.println("\nYou shove the money in your pocket.");}
				else {
					this.inventory.add(itemToAdd);
					System.out.println("\nYou add the item to your inventory");}
				displayInventory();}
		}
		/**drops an item from inventory*/
		void dropItem(String itemToCheck){
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
		void stealItem(String itemToSteal){
			Item itemToFind = Item.determineItemsExistance(itemToSteal);//saves what the method returns as an item object
			if (itemToFind != null){
				Object [] returnedArgs = itemToFind.determineSamePlace();
				if ((boolean) returnedArgs[0]){
					System.out.println("\nAre you you sure you want to steal " + itemToSteal + "? y/n" );
					if (MainFile.getSecondaryInput().equalsIgnoreCase("y")){
						if (itemToFind.montaryValue == 0){
							System.out.println("You dummy. It's free. Just take it like a normal person.");} 
						else {
							MainFile.displayQuit(10);}
					} else
						System.out.println("\nYou put the item back where it came from go about your life, grateful you didn't make that dumb mistake.");
				}
			 }	 
		}
		boolean spendMoney(Item itemToBuy){
			if (this.moneyHad >= (itemToBuy.montaryValue * -1)){
				this.moneyHad += itemToBuy.montaryValue;
				this.inventory.add(itemToBuy);
				System.out.println("You buy the item.");
				this.displayInventory();
				this.CheckWrench(itemToBuy);
				return true;}
			else {
				System.out.println("You don't have enough money to buy " + itemToBuy.itemName + " for " + (itemToBuy.montaryValue * -1) + 
						this.displayMoney());
				return false;}
		}
		/**Adds combined item to your inventory.*/
		void AddCombinedItem(String itemsToCombine) {
			CombinedItem itemToAdd = CombinedItem.combineItems(itemsToCombine);
			if (itemToAdd != null){//if you've successfully created a combined item.
				this.inventory.add(itemToAdd);//puts the item in your inventory.
				Item.listOfItems.add(itemToAdd);//adds the item to the list of items that exist
				System.out.println(".\n");//this is for formatting purposes.
				System.out.println("You have created a " +itemToAdd.itemName);
				this.displayInventory();
				}
		}
		/**if you've got some kind of wrench, it askes you if you want to just quit.*/
		boolean CheckWrench(Item maybeWrench){
				if (maybeWrench.equals(Item.otherWrench)){
					System.out.println("\nThis isn't the wrench you dropped, but it's a wrench. "
				+ "Technically, you did what you set out to do. So you can \nput it back and go "
				+ "about your life or keep trying to get the one you dropped. Keep trying y/n? ");
					String input = MainFile.getSecondaryInput();
					if (input.substring(0, 1).equalsIgnoreCase("y")){
						return true;} 
					else if (input.substring(0, 1).equalsIgnoreCase("n")){
						MainFile.displayQuit(5);
						return false;} //breaks out of game
				}
				if (maybeWrench.equals(Item.purchasedWrench)){
					System.out.println("\nYou bought a wrench. You're $" +(Item.purchasedWrench.montaryValue *-1)
				+ " poorer now. You bought the thing so you might as well just put it \nback and go on with your "
				+ "life, but you can keep trying if you want. Keep trying y/n? ");
					String input = MainFile.getSecondaryInput();
					if (input.equalsIgnoreCase("y")){
						return true;}
					else if (input.equalsIgnoreCase("n")){
						MainFile.displayQuit(6);
						return false;}
				}
				if (maybeWrench.equals(Item.wrench)){
					MainFile.displayQuit(2);
					return false;}
//			}
			return true;
		}
		/**resets the player object when the game is restarted*/
		void playerReset(){
//			this.renderLocation = true;
			this.locationIndex = 0;
			this.inventory.clear();
			this.inventoryEnabled = false;
			this.moneyHad = 0;
			//don't have to reset name.
			for (int i = this.beenTo.getSize(); i != 0 ; i--){
				//wipes the interger stack so there's nothing else in the back function.
				this.beenTo.pop();}
			}

}//closes out person class.
