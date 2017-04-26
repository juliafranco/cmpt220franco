package code;

import java.util.Scanner;

public class MainFile {
	/**main method, contains the massive 200 lines of code of game loop.*/
	public static void main (String[] args){
		Location.setItemsAndContainers();//calls the function location class to put items and containers where they belong.
		printOpening(); //calls the function to print the introduction of the game.
		Person.player.beenTo.push(Person.player.locationIndex);//adds the initial location to the stack of integers
		Person.player.renderLocation();//prints the description of the default location.
		
		/**game loop driving the whole thing.*/
		while (true){
			
			/**functions that need to run or conditions that need to be checked before it can ask for input.*/
			if (!Person.player.renderLocation)
				//There's certain conditions where rendering a location or set of circumstances causes the game to end. This finishes that- breaking 
				//out of the game loop. 
				break;
			
			/**get the input!*/
			String[] command = getInput();//calls the function for user input and saves the first word and the rest of the line
			String todo = command[0]; //saves the first word of the command as to do, these are most of the commands
			String nameOfThing = command[1]; //saves the rest of the line, usually a name of container or object, into nameOfThing.
			//can't combine these without calling the function twice. So don't try it. Again.
			
			/**basic game functions*/
			if (todo.equalsIgnoreCase("quit")){//if the user wants to get out of the game.
				displayQuit(((Person.player.locationIndex == 12))? 8 :0); //if you're in location 12, print ending 8. else print ending 0.
				break;
			} else if (todo.equalsIgnoreCase("Nirvana?")){//this is a random ending used to test if switch cases had to be sequential and left because it's funny.
				displayQuit(4);
				break;
			} else if (todo.equalsIgnoreCase("help"))//prints help message.
				displayHelp();//calls the function that prints the help message. 
			
			/**Bypass Commands*/ //used to bypass stuff in the game to make testing less annoying
			else if (todo.equalsIgnoreCase("jump")){ //jump to a specific location, to be removed before final product is finished.
				if (Integer.parseInt(nameOfThing) < Location.places.length){
					Person.player.locationIndex = Integer.parseInt(nameOfThing);
					Person.player.beenTo.push(Person.player.locationIndex);
					Person.player.renderLocation();}
				}
			else if (todo.equalsIgnoreCase("bookbag"))
				Person.player.enableInventory();
			
			else if (todo.equalsIgnoreCase("maul")){ //I don't need  this. but it's here.
				for (int i =0; i < 30; i++){
					System.out.println(getRandomNumber(30));}
				Person.player.moneyHad += 15.09;}
			
			else if (todo.equalsIgnoreCase("test")){//framework for test command
				Person.player.enableInventory();
				Person.player.inventory.add(Item.workLight);
				Person.player.inventory.add(Item.ladder);
				System.out.println(Item.listOfItems);
			}
			else if (todo.equalsIgnoreCase("dropit")){
				SpecialtyContainer.depths.GetFoundItem();
			}
			
			else if (todo.equalsIgnoreCase("Shia")){
				System.out.println("\nHollywood Superstar...");
			}
//			else if (todo.length() == 8){ //this kept making my code not work so out it goes.
//				if (todo.substring(0, 3).equals("200")){
//					System.out.println("\n...did you just try to enter someone's id number?");
//					continue;}
//				return; //this makes it ignore it if it's less than 8 characters. Otherwise, it won't keep going.
//			}//this totally didn't happen. Why would I do a thing like that?
				
			/**navigation commands*/
			else if (todo.equalsIgnoreCase("up")) //executes the up command
				Person.player.moveLocation(0); //0 is the column for up
			else if (todo.equalsIgnoreCase("down"))//executes the down command.
				Person.player.moveLocation(1);//1 is the column for down.
			else if (todo.equalsIgnoreCase("forward"))//execute the command
				Person.player.moveLocation(2);//2 is the column for forward
			else if (todo.equalsIgnoreCase("backward"))//executes the backward command
				Person.player.moveLocation(3);//3 is the column for backward.
			else if (todo.equalsIgnoreCase("left"))//executes the left command
				Person.player.moveLocation(4);//4 is the column for left.
			else if (todo.equalsIgnoreCase("right"))//executes the right command
				Person.player.moveLocation(5);//5 is the column for right.
			else if (todo.equalsIgnoreCase("back"))//takes the player back to the previous location.
				Person.player.goBack(); //calls the go back function.
			else if (todo.equalsIgnoreCase("current"))//renders the current location. 
				Person.player.renderCurrentLocation();
			
			/**Item Commands*/
			else if (todo.equalsIgnoreCase("examine")){ 
				if (!nameOfThing.equals("")) //if you've specified an item/container
					Item.printItemDescription(nameOfThing);
				else
					Location.places[Person.player.locationIndex].examine();}//prints out list of containers and items in location.
			
			else if (todo.equalsIgnoreCase("rummage")){ //displays a list of all the things in the container.
				if (Location.places[Person.player.locationIndex].receptacle.isEmpty() || 
						Location.places[Person.player.locationIndex].findSpecialtyContainers()){//if there's nothing in there.
					System.out.println("\nThere's nothing here to rummage through.");
					continue;}
				else if (nameOfThing.equals("")){ //if you don't specify a container.
					System.out.println("\nPlease specify a container to rummage through or hit enter to continue.\n");
					Location.places[Person.player.locationIndex].examineContainers();//prints out list of containers in location.
					nameOfThing = getSecondaryInput();
					if (nameOfThing.equals(""))
						continue;}
				Container.printContainerContents(nameOfThing);
			}//closes rummage else if
			
			else if (todo.equalsIgnoreCase("take")){
				if (!Person.player.inventoryEnabled){
					if (nameOfThing.equalsIgnoreCase(Item.bookbag.itemName) || nameOfThing.equalsIgnoreCase(Item.bookbag.combineKey))
						Person.player.determineAddItem(nameOfThing);
					else {
						System.out.println("\nYou don't take the item because you have no way of holding it other than in your hands, "
								+ "which \nwould just be annoying. Maybe find something to put it in?");
						} continue;
				} else if (!(Location.places[Person.player.locationIndex].isItEmpty())){//if there's something there.
					if (nameOfThing.equals("")){ //if you don't specify an item.
						System.out.print("\nPlease specify an item to take or hit enter to continue.\n");
						if (!Location.places[Person.player.locationIndex].receptacle.isEmpty()){
							System.out.println("(There may be items hiding inside of something else... try rummaging for them. You can't"
									+ " take containers.)\n");}
						Location.places[Person.player.locationIndex].examineItems();//prints out list of the items in the location, 
						nameOfThing = getSecondaryInput();
						if (nameOfThing.equals(""))
							continue;}
					Person.player.determineAddItem(nameOfThing);}
				}//closes take function
			
			else if (todo.equalsIgnoreCase("steal")){
				if (!(Location.places[Person.player.locationIndex].isItEmpty())){//if there's something there.
					if (nameOfThing.equals("")){ //if you don't specify an item.
						System.out.print("\nPlease specify an item to steal or hit enter to continue.\n");
						if (!Location.places[Person.player.locationIndex].receptacle.isEmpty()){
							System.out.println("(There may be items hiding inside of something else... try rummaging for them.)\n");}
						if (!Location.places[Person.player.locationIndex].examinePaidItems()){//prints out the items there you can buy.
							continue;}
						else {
							nameOfThing = getSecondaryInput();
							if (nameOfThing.equals(""))
								continue;}
						}
					Person.player.stealItem(nameOfThing);}
				}//closes take function
			
			else if (todo.equalsIgnoreCase("buy")){
				if (!(Location.places[Person.player.locationIndex].isItEmpty())){
					if (nameOfThing.equals("")){ //if you don't specify an item.
						System.out.print("\nPlease specify an item to buy.\n");
						if (!Location.places[Person.player.locationIndex].examinePaidItems()){
							//prints out list of the items in the location, if there are any.
							continue;}
						nameOfThing = getSecondaryInput();
						if (nameOfThing.equals(""))
							continue;}
					Item.buyItem(nameOfThing);}
				}//closes take function
			
			else if (todo.equalsIgnoreCase("drop")){
				if (!Person.player.inventoryEnabled){
						System.out.println("\nYou can't drop something from an inventory you don't have.");
						continue;}
				if (nameOfThing.equals("")){ //if you haven't specified an item
					System.out.print("\nPlease specify an item to drop.\n");
					Person.player.displayPersonalInventory();//prints out list of the items in your inventory you can drop
					nameOfThing = getSecondaryInput();
					if (nameOfThing.equals(""))
						continue;}
				Person.player.dropItem(nameOfThing);//if you have specified an item, it drops to here.
				}//closes take function
			
			else if (todo.equalsIgnoreCase("transfer")){//move an item from inventory to the box in the light booth
				if (!Person.player.inventoryEnabled){
					System.out.println("You don't have an inventory to be able to have anything to transfer anywhere.");
					continue;}
				if (nameOfThing.equals("")){ //if you haven't specified an item to transfer
					System.out.println("\nPlease specify an item to transfer to secondary storage.");
				    Person.player.displayPersonalInventory();
				    nameOfThing = getSecondaryInput();
				    if (nameOfThing.equals(""))
						continue;}
				Item.TransferItem(nameOfThing);}
			
			else if (todo.equalsIgnoreCase("inventory")) //displays your inventory				
				if (Person.player.inventoryEnabled)
					Person.player.displayInventory();
				else 
					System.out.println("\nYou have no inventory, nor anything to hold it with.");
			
			else if (todo.equalsIgnoreCase("show")){//displays the map
				if( nameOfThing.equalsIgnoreCase("map")){
					Item.displayMap();
				} else {
					System.out.println("\n Nothing to display... move along...");}
			}

			else if (todo.equalsIgnoreCase("deploy")){//to send an item into the depth of the Cove in hopes of getting the wrench
				if (!Person.player.inventoryEnabled){
						System.out.println("\nYou can't deploy anything from an inventory you don't have.");
						continue;}
				if (nameOfThing.equals("")){ //if you haven't specified an item
					System.out.print("\nPlease specify an item to deploy.\n");
					Person.player.displayPersonalInventory();//prints out list of the items in your inventory you can d
					nameOfThing = getSecondaryInput();
					if (nameOfThing.equals(""))
						continue;}
				SpecialtyContainer.depths.deployItem(nameOfThing);//if you have specified an item, it drops to here.
				}//closes deploy function
			
			else if (todo.equalsIgnoreCase("combine")){//move an item from inventory to the box in the light booth
				if (!Person.player.inventoryEnabled){
					System.out.println("\nYou don't have an inventory to be able to have anything to combine.");
					continue;}
				if (nameOfThing.equals("")){ //if you haven't specified anything to combine
					System.out.println("\nPlease specify two items to combine [item1 with item2].");
				    Person.player.displayPersonalInventory();
				    nameOfThing = getSecondaryInput();
				    if (nameOfThing.equals(""))
						continue;}
				Person.player.AddCombinedItem(nameOfThing);}
			
			else if (todo.equalsIgnoreCase("split")){//move an item from inventory to the box in the light booth
				if (!Person.player.inventoryEnabled){
					System.out.println("\nYou don't have an inventory to be able to have anything to split.");
					continue;}
				if (nameOfThing.equals("")){ //if you haven't specified anything to combine
					System.out.println("\nPlease specify a combined item to split.");
				    Person.player.displayCombinedItems(); //swtich this out with something that only shows combined items
				    nameOfThing = getSecondaryInput();
				    if (nameOfThing.equals(""))
						continue;}
				CombinedItem.splitItem(nameOfThing);}
			
			else if (todo.equalsIgnoreCase("eat")){//to send an item into the depth of the Cove in hopes of getting the wrench
				if (!Person.player.inventoryEnabled){
						System.out.println("\nYou can't eat anything from an inventory you don't have.");
						continue;}
				if (nameOfThing.equals("")){ //if you haven't specified an item
					System.out.print("\nPlease specify an item to eat.\n");
					Person.player.displayPersonalInventory();//prints out list of the items in your inventory you can d
					nameOfThing = getSecondaryInput();
					if (nameOfThing.equals(""))
						continue;}
				Item.determineEatFood(nameOfThing);//if you have specified an item, it drops to here.
				}//closes deploy function
			
			else if (todo.equalsIgnoreCase("get")){
				if( nameOfThing.equalsIgnoreCase("rekt")){
					if (Person.player.inventory.contains(Item.bottle)){
						displayQuit(14);
						break;}
				} System.out.println("\nget... what??");}

			else if (todo.equalsIgnoreCase("drive")){//allows you to drive somewhere
				if (!Person.player.inventoryEnabled){
					System.out.println("\nYou don't have an inventory to be able to have anything to drive anywhere with.");
					continue;}
				Person.player.driveThere();}
			
			else //this is the else for the whole loop.
				System.out.println("\nYou have entered an invalid command.");//because if you did, you wouldn't be here.
		}// this one closes out the loop
		promptForRestart();
	}//this one closes out the main function
	
	/**game functions*/
	public static void printOpening(){//part of the story of the game
		System.out.println("Cove Wrench Drop: The Game.");//title of game
		System.out.println("-------------------------------------------------");
		System.out.println("The Scene: The Cove [Marist College's Nelly Goletti Theatre's Cat Walks]");
		System.out.println("The Time: 4pm.");
		System.out.println("");
		System.out.println("You are descending from the cove after doing some lighting work. But, before you leave, \n"
				+ "you accidently drop your wrench through the grating you are standing on- the grating that suspends \n"
				+ "you above the ceiling of the theatre below. Your wrench has fallen into the blackness below you, \n"
				+ "with no means of retrieving it. So you think. It turns out this is the last wrench- the rest vanished \n"
				+ "or met a similar fate. You are a broke, shameful college student, so you can't tell anyone what happened. \n"
				+ "You also have no money to silently replace the wrench. You have one option- retrieve the wrench. \n"
				+ "How? Acquire the things a college campus can offer, and assemble them to reach into the blackness. \n"
				+ "Maybe, just maybe, you will retrieve the last wrench and pretend nothing ever happened.");	
	}
	public static String[] getInput() {//how the user enters commands of places to go or things to do.
		Scanner input = new Scanner(System.in);//creates a scanner object for general commands.
		System.out.print("\nWhere or what do you want to go or do? ");
		String command = input.next();
		String modifier = input.nextLine().trim();
		String[] userInput = new String[] {command, modifier};//to be used in game loop to use the player's input to do what they want. 
		return userInput;
	}
	public static String getSecondaryInput(){//used to get the secondary input for examining items, rummage in containers, etc.
		Scanner inputModifier = new Scanner(System.in);
		return inputModifier.nextLine();
	}
	public static void displayHelp(){
		System.out.println("\nYour goal: retrieve your dropped wrench.");
		System.out.println("-------------------------------------------");
		System.out.println("Basic Commands:\n");
		System.out.println("Navigational Commands:");
		System.out.println("up, down, left, right, forward, backwards [acts as an about face and go forward.],"
				+ " \nback [goes back to previous location]\n");
		System.out.println("Commands Related to Items:");
		System.out.print("examine");
		if (Person.player.inventoryEnabled){ //once you can pick up items, this stuff becomes relevent. 
			System.out.println(" [the location for items or add an item to name to examine the item itself],");//this line is full.
		    System.out.println("drop [followed by name to put down an item], transfer [followed by name, to secondary storage],");
		    System.out.println("Eat [followed by an item name, player can eat it if it's a food item.]" );
		    System.out.println("inventory [displays inventory], deploy [followed by name, send an item though the grating to attempt to get the wrench]");
		    System.out.println("steal [followed by the item name. Note, this is a crime.], combine [followed by the items you wish to combine],");}
		for (int i = 0; i < Item.listOfItems.size(); i++){
			if (Item.listOfItems.get(i) instanceof CombinedItem){
				System.out.println("split [followed by the items you wish to seperate],");
				break;}
		}			
		System.out.println("\nGeneral Commands:");
		System.out.println("help, quit, current (to display location.)");
//		if (itemHelp)
//			System.out.println("points [displays score]");
	}
	public static void displayQuit(int quitCode) {//displays the proper ending of the game
		Person.player.renderLocation = false;
		switch (quitCode){//there will be different quit messages for different endings of the game.
		case 0: System.out.println ("\nYou decide this whole thing isn't worth it and go hide in your friend's "
				+ "\nhouse and maybe you'll deal with this tomorrow. Or never. Never is an option."); break; //ending you hit quit.
		case 1: System.out.println("grab one but as you do, you are transported back to the Cove walkway as wrenches "
				+ "rain down upon you. The \nCove fills up with wrenches as you are smothered under the tide. "
				+ "This is the way the world ends. This is the \nway the world ends. Not with a bang but a "
				+ "hundred trillion wrenches in the Cove."); break; //ending from the abandoned Staples where the Cove is
				      //filled with a hundred trillion wrenches.
		case 2: System.out.println("\nSuccess! You have retrieved the wrench! Sweet, sweet victory. You put "
				+ "it back where it belongs \nand go about your life like nothing ever happened. You vow not "
				+ "to tell anyone for a while, at \nwhich point it'll just be a funny story. You're just grateful "
				+ "it's over and you can get back \nto procrastinating that mountain of schoolwork that awaits you."); break;
				      //the ending where you get the wrench.
		/**this one isn't being used*/
		case 3: System.out.println("\nAlly's wrench is certainly a good enough replacement for the one you dropped. "
				+ "You slip back \ninto the shop and put the wrench where it would belong. No one will ever know..."); break; 
		case 4: System.out.println("\nCheeseman you lose. Kurt Colbain is disappointed."); break; //this is a random ending used to
				      //test if switch cases had to be sequential and left because it's funny.
		case 5: System.out.println("\nYou put the other wrench back and go on with your life. You retrieved "
				+ "one wrench. \nNo one needs to know there's a second one down there..."); break; //this is the "other wrench" ending. 
		case 6: System.out.println("You take the wrench you bought with your hard earned...er... found... "
				+ "cash and put it back \nwith the rest of the tools. No one will know what happened, but you "
				+ "could have used that \nmoney for other things..."); break; //ending where you decide to buy another wrench
		/**this one's not getting used either*/
		case 7: System.out.println("[ending where you are dramatic and leave theatre.... for like a week.]"); break; //ending where you admit your guilt.
		case 8: System.out.println("\nYeah... swimming around in the Hudson is definitely a better idea than "
				+ "dealing with this \nwrench situation. Time to change your mailing adress to the bottom of "
				+ "the Hudson, grow a third \narm, and live out your days, occasionally wondering what might have been."); break; 
					//ending where you quit from the depths of the Hudson
		case 9: System.out.println("Surprise! You get mauled by a goose. You definitely lose."); break; 
		            //obviously, this is what happens if you get mauled by a goose on the green.
		case 10: System.out.println("You get caught 0.2 seconds after leaving the store. You now have far bigger problems than "
				+ "your dropped wrench. Great job."); break;//this is what happens if you try to steal an item.
		case 11: System.out.println("\nOh no. The avocados ARE sentient. And angry. And they smite you instantly for dumping "
				+ "them into the \ndepths of the Cove. Maybe you don't want to do that again."); break;//ending where you dump the avocados.
		case 12: System.out.println("\nYou walk over to the wrench and grab it. You climb back up the ladder and back onto the walkway and "
				+ "take \nboth the wrench and the ladder and return them and finally go about your life, grateful that the ceiling didn't "
				+ "collapse \nwhile you were down there."); break; //ending from you physically going into the depths of the cove  
		case 13: System.out.println("\nThe ceiling of theatre that you're standing on top of collaspes under your weight and you fall though. "
				+ "\nAlthough you fall 17 feet, you are physically unhurt. However, you're completely panicking and leave \nas fast as your legs "
				+ "can carry you. You're never going back there until after that hole's been fixed, \nand even then... This makes that wrench "
				+ "seem absolutely trivial and you cower on the couch, still \nprocessing the shock of what you've done. Your horoscope was right- "
				+ "today was going to be a bad, bad day."); break; //if you do fall through the ceiling.
		case 14: System.out.println("\nYou chug the bottle of vodka. But before you can get back to trying to get that wrench, you feel it "
				+ "\nkicking in. Completely drunk, you stagger outside and away from the townhouse and fall flat on your \nface on the Hancock "
				+ "hill, dead asleep. You're going to be in for a hell of a time when you wake up."); break;
		case 15: System.out.println("\nYou attempt to deploy the car, which you're not even sure how you managed to get it this far. However, since it "
				+ "weighs 2700 pounds, it crashes through the ceiling into the theatre and then through the theatre floor into the dining hall below. "
				+ "Much screaming and fleeing ensues, including you. Oh man. Put THAT on the top of the list of terrible life choices.");
		} //closes the switch statement
	}//closes the displayQuit method
    public static void displayCredits() {
    	System.out.println("-------------------------------------------------\n");
    	System.out.println("Thank you for playing Cove Wrench Drop: The Game.\n");
    	System.out.println("Copyright Julia Franco, April 2017.");
	}//closes display credits method.
    public static void promptForRestart(){ //asks the player if they want to restart the game.
    	System.out.println("-------------------------------------------------");
		System.out.print("Restart? (y/n) ");
		String restart = getSecondaryInput();
		if (restart.substring(0, 1).equalsIgnoreCase("y")){//reset everything
			resetGame();
			System.out.println("-------------------------------------------------");
			main(null); //calls main function to run game again.
		}
		else if (restart.substring(0, 1).equalsIgnoreCase("n"))
			displayCredits();
		else
			promptForRestart();
    }
    public static void resetGame(){ //resets all of the attributes in the game that don't reset themselves*/
    	//need to wipe all the items from locations.
		Location.wipeLocations();
		for (int i = 0; i < Location.places.length; i++)
			Location.places[i].isVisited = false;//resets it so you haven't been anywhere.
		for (int j = ( Item.listOfItems.size() -1); j != 0; j--) //wipes the combined items.
			if (Item.listOfItems.get(j) instanceof CombinedItem)
				Item.listOfItems.remove(Item.listOfItems.get(j));
		//need to reset the attributes of the player.
		Person.player.playerReset();
    }
    public static String[] splitInput(String StringToSplit, String splitKey){ //splits a string based on a key
    	String[] splits = StringToSplit.split(splitKey); //this key is what it's looking for, keeping what's on each side of it
    	return splits; //the list of pieces that the code is looking for
    }
    
    /**Generates random numbers for various game functions*/
    public static int getRandomNumber (int multFactor){//used to manipulate probability of events.
    	return (int)(Math.random() * multFactor);
    }
}//closes the MainFile class.