package code;

import java.util.Scanner;

public class MainFile {
	public static void main (String[] args){
		Location.setItemsAndContainers();//calls the function location class to put items and containers where they belong.
		printOpening(); //calls the function to print the introduction of the game.
		Person.player.beenTo.push(Person.player.locationIndex);//adds the initial location to the stack of integers
		Person.player.renderLocation();//prints the description of the default location.
		
		/**game loop driving the whole thing.*/
		while (true){
			
			/**functions that need to run or conditions that need to be checked
			 * before it can ask for input.*/
			
			if (!Person.player.renderLocation)
				//There's certain conditions where rendering a location or set of circumstances causes the game to end. This finishes that- breaking 
				//out of the game loop. 
				break;
			
			/**get the input!*/
			String[] command = getInput();//calls the function for user input and saves the first word and the rest of the line
			String todo = command[0]; //saves the first word of the command as to do, these are most of the commands
			String nameOfThing = command [1]; //saves the rest of the line, usually a name of container or object, into nameOfThing.
			//can't combine these without calling the function twice. So don't try it. Again.
			
			/**basic game functions*/
			if (todo.equals("quit")){//if the user wants to get out of the game.
				if (Person.player.locationIndex == 12)//this is the ending if you quit out of the Depths of the Hudson.
					displayQuit(8);
				else 
					displayQuit(0);//calls the quit function with the correct ending (quit code, tells switch ending to print)
				break;
			} else if (todo.equals("Nirvana?")){//this is a random ending used to test if switch cases had to be sequential and left because it's funny.
				displayQuit(4);
				break;
			} else if (todo.equals("help"))//prints help message.
				displayHelp();//calls the function that prints the help message. 
			
			else if (todo.equals("maul")) //I don't need  this. but it's here.
				for (int i =0; i < 30; i++)
					System.out.println(getRandomNumber(30));
			else if (todo.equals("test")){//framework for test command
				System.out.println(nameOfThing);
			}
				
			/**navigation commands*/
			else if (todo.equals("up")) //executes the up command
				Person.player.moveLocation(0); //0 is the column for up
			else if (todo.equals("down"))//executes the down command.
				Person.player.moveLocation(1);//1 is the column for down.
			else if (todo.equals("forward"))//execute the command
				Person.player.moveLocation(2);//2 is the column for forward
			else if (todo.equals("backward"))//executes the backward command
				Person.player.moveLocation(3);//3 is the column for backward.
			else if (todo.equals("left"))//executes the left command
				Person.player.moveLocation(4);//4 is the column for left.
			else if (todo.equals("right"))//executes the right command
				Person.player.moveLocation(5);//5 is the column for right.
			else if (todo.equals("back"))//takes the player back to the previous location.
				Person.player.goBack(); //calls the go back function.
			else if (todo.equals("current"))//renders the current location. 
				Person.player.renderCurrentLocation();
			else if (todo.equals("jump")){ //jump to a specific location, to be removed before final product is finished.
				Person.player.locationIndex = Integer.parseInt(nameOfThing);
				Person.beenTo.push(Person.player.locationIndex);
				Person.player.renderLocation();}
			
			/**Item Commands*/
			else if (todo.equals("examine")){ 
				if (!nameOfThing.equals("")) //if you've specified an item/container
					Item.printItemDescription(nameOfThing);
				else
					Location.places[Person.player.locationIndex].examine();}//prints out list of containers and items in location.
			else if (todo.equals("rummage")){ //displays a list of all the things in the container.
				if (!nameOfThing.equals("")) //if you've specified an container
					Container.determineContainerValid(nameOfThing);
				else if (Location.places[Person.player.locationIndex].receptacle[0] == null){//if there's nothing in there.
					System.out.println("\nThere's nothing here to rummage through.");
				}
				else { //if you don't specify a container.
					System.out.println("\nPlease specify a container to rummage through.\n");
					Location.places[Person.player.locationIndex].examineContainers();//prints out list of containers in location.
					Scanner inputModifier = new Scanner(System.in);
					String modifier = inputModifier.nextLine();
					Container.determineContainerValid(modifier);
				}
			}//closes rummage else if
//			else if (todo.equals("take")){
//				if (!nameOfThing.equals("")) //if you've specified an container
	//				Container.takeItem(nameOfThing);
		//		else if (Location.places[Person.player.locationIndex].receptacle[0] == null || 
			//			Location.places[Person.player.locationIndex].items[0] == null){//if there's nothing in there.
				//	System.out.println("\nThere's nothing here to take.");
//				}
	///			else { //if you don't specify a container.
		//			System.out.println("\nPlease specify an item to take.\n");
			//		Location.places[Person.player.locationIndex].examineContainers();//prints out list of containers in location.
				//	Scanner inputModifier = new Scanner(System.in);
	//				String modifier = inputModifier.nextLine();
		//			Item.determineItemValid(modifier);
//			}
//		}
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
	public static void displayHelp(){
		System.out.println("\nYour goal: retrieve your dropped wrench.");
		System.out.println("-------------------------------------------");
		System.out.println("Basic Commands:\n");
		System.out.println("Navigational Commands:");
		System.out.println("up, down, left, right, forward, backwards [acts as an about face and go forward.],"
				+ " \nback [goes back to previous location]\n");
		System.out.println("Commands Related to Items:");
		System.out.print("examine");
//		if (itemHelp){ //this is a boolean value that will flip when you pick up your first item.
//			System.out.println(" [the location for items or add an item to name to examine the item itself],");//this line is full.
//		    System.out.println("discard [followed by name to put down an item], \ntransfer [followed by name, to secondary storage],");
//		    System.out.println("combine [followed by the items you wish to combine], \ninventory [displays inventory],");
//		    System.out.println("descend [followed by name, use an item to attempt to get the wrench.]");}
//		if(combineHelp)
//			 System.out.println("separate [followed by the items you wish to seperate],");			
		System.out.println("\nGeneral Commands:");
		System.out.println("help, quit, current (to display location.)");
//		if (itemHelp)
//			System.out.println("points [displays score]");
	}
	public static void displayQuit(int quitCode) {//displays the proper ending of the game
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
		case 3: System.out.println("\nAlly's wrench is certainly a good enough replacement for the one you dropped. "
				+ "You slip back \ninto the shop and put the wrench where it would belong. No one will ever know..."); break; //might take this out...
		case 4: System.out.println("\nCheeseman you lose. Kurt Colbain is disappointed."); break; //this is a random ending used to
				      //test if switch cases had to be sequential and left because it's funny.
		case 5: System.out.println("\nYou put the other wrench back and go on with your life. You retrieved "
				+ "one wrench. \nNo one needs to know there's a second one down there..."); break; //this is the "other wrench" ending. 
		case 6: System.out.println("You take the wrench you bought with your hard earned...er... found... "
				+ "cash and put it back \nwith the rest of the tools. No one will know what happened, but you "
				+ "could have used that \nmoney for other things..."); break; //ending where you decide to buy another wrench
		case 7: System.out.println("[ending where you are dramatic and leave theatre.... for like a week.]"); break; //ending where you admit your guilt.
		case 8: System.out.println("\nYeah... swimming around in the Hudson is definitely a better idea than "
				+ "dealing with this \nwrench situation. Time to change your mailing adress to the bottom of "
				+ "the Hudson, grow a third \narm, and live out your days, occasionally wondering what might have been."); break; 
					//ending where you quit from the depths of the Hudson
		case 9: System.out.println("Surprise! You get mauled by a goose. You definitely lose."); //break; 
					//obviously, this is what happens if you get mauled by a goose on the green.
		} //closes the switch statement
	}//closes the displayQuit method
    public static void displayCredits() {
    	System.out.println("-------------------------------------------------\n");
    	System.out.println("Thank you for playing Cove Wrench Drop: The Game.\n");
    	System.out.println("Copyright Julia Franco, March 2017.");
	}//closes display credits method.
    public static void promptForRestart(){
    	Scanner yesno = new Scanner(System.in);//creates a scanner object for general commands.
    	System.out.println("-------------------------------------------------");
		System.out.println("Restart? (y/n)");
		String restart = yesno.next();
		if (restart.equals("y")){
			Location.wipeLocations();
			System.out.println("-------------------------------------------------");
			//need to wipe all the items from locations.
			main(null); //calls main function to run game again.
		}
		else if (restart.equals("n"))
			displayCredits();
		else
			promptForRestart();
    }
    
    /**Generates random numbers for various game functions*/
    public static int getRandomNumber (int multFactor){//used to manipulate probability of events.
    	return (int)(Math.random() * multFactor);
    }
}//closes the MainFile class.