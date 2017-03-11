import java.util.Scanner;

public class MainFile {
	public static void main (String[] args){
		Person player = new Person (); //creates the object of the player.
		printOpening(); //calls the function to print the introduction of the game.
		Person.renderLocation(player.locationIndex);//prints the description of the default location.
		player.beenTo.push(player.locationIndex);//adds the initial location to the stack of integers
		
		/**game loop driving the whole thing.*/
		while (true){
			
			/**functions that need to run or conditions that need to be checked
			 * before it can ask for input.*/
			
			if (player.locationIndex == 5){// causes game to kick out after rending the location details, 5 being the Abandoned Staples,
				MainFile.displayQuit(1);
				break;}
			
			String todo = getInput();//calls the function for user input and saves it as a string variable.
			
			/**basic game functions*/
			if (todo.equals("quit")){//if the user wants to get out of the game.
				displayQuit(0);//calls the quit function with the correct ending (quit code, tells switch ending to print)
				break;
			} else if (todo.equals("Nirvana?")){//this is a random ending used to test if switch cases had to be sequential and left because it's funny.
				displayQuit(4);
				break;
			} else if (todo.equals("help"))//prints help message.
				displayHelp();//calls the function that prints the help message. 
			
			/**navigation commands*/
			else if (todo.equals("up")) //executes the up command
				player.moveLocation(0); //0 is the column for up
			else if (todo.equals("down"))//executes the down command.
				player.moveLocation(1);//1 is the column for down.
			else if (todo.equals("forward"))//execute the command
				player.moveLocation(2);//2 is the column for forward
			else if (todo.equals("backward"))//executes the backward command
				player.moveLocation(3);//3 is the column for backward.
			else if (todo.equals("back"))
				player.goBack();
			else if (todo.equals("current"))
				player.renderCurrentLocation();
			else //this is the else for the whole loop.
				System.out.println("\nYou have entered an invalid command.");//because if you did, you wouldn't be here.
		}// this one closes out the loop
		displayCredits();
	}//this one closes out the main function
	
	/**game functions*/
	public static void printOpening(){//part of the story of the game
		System.out.println("Cove Wrench Drop: The Game.");//title of game
		System.out.println("-----------------------------");
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
	public static String getInput() {//how the user enters commands of places to go or things to do.
		Scanner input = new Scanner(System.in);//creates a scanner object.
		System.out.println("");
		System.out.print("Where or what do you want to go or do? ");
		String command = input.next();
		return command;//to be used in game loop to use the player's input to do what they want. 
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
//		if (itemHelp) //this is a boolean value that will flip when you pick up your first item.
//			System.out.println(" [the location for items or add an item to name to examine the item itself],");//this line is full.
//		    System.out.println("discard [followed by name to put down an item], \ntransfer [followed by name, to secondary storage],");
//		    System.out.println("combine [followed by the items you wish to combine], \ninventory [displays inventory],");
//		    System.out.println("seperate [followed by the items you wish to seperate],");
//		    System.out.println("descend [followed by name, use an item to attempt to get the wrench.]");
		System.out.println("\nGeneral Commands:");
		System.out.println("help, quit, current (to display location.)");

		
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
				+ "one wrench. \nNo one needs to know there's a second one down there..."); //break //this is the "other wrench" ending. 
		case 6: System.out.println("You take the wrench you bought with your hard earned...er... found... "
				+ "cash and put it back \nwith the rest of the tools. No one will know what happened, but you "
				+ "could have used that \nmoney for other things..."); //break; //ending where you decide to buy another wrench
		case 7: System.out.println("[ending where you are dramatic and leave theatre.... for like a week.]");
		} //closes the switch statement
		
	}//closes the displayQuit method
    public static void displayCredits() {
    	System.out.println("-------------------------------------------------");
    	System.out.println("");
    	System.out.println("Thank you for playing Cove Wrench Drop: The Game.");
    	System.out.println("");
    	System.out.println("Copyright Julia Franco, March 2017.");
	}//closes display credits method.
}//closes the MainFile class. 

/**Classes, probably will split to own files.*/
//Location Class, holds all the location related data. 
class Location{
	String locationName;
	String locationDescription;
	String altDescription; //what it shows if you've been there.
	Boolean isVisited = false; //tracks if you've been somewhere before.
//	Item[] items; //holds a list of item objects present in the location.
//	Container[] receptacle; //holds a list of containers present in the location//...make this an inherited item??
	
	Location( String placeName, String placeDescript, String altDescript){
		locationName = placeName;
		locationDescription = placeDescript;
		altDescription = altDescript;
		//do I need to do the items? I'm going to hold off on it for now. especially because this needs to hold a list of indeterminate size.
	}
	static Location[] places = //list of locations in the game.
		/**0*/{ new Location ( "The Cove Walkway" , "You are standing on the walkway in the cove, at the "
	            + "scene of your crime, next to the ladder to go \ndown. The walkway extends forward to where "
				+ "the lights hang from. Past the walkway and its railings \nis the top of the ceiling of the theatre "
	            + "below you. And under the walkway is the deepest depth of \nthe cove where your wrench lies." 
				, "You're back on the walkway, the area with the lights in front of you, with the ladder to go "
				+ "down right \nthere. And god, why is it so hot up here??"),
		/**1*/  new Location ("The Light Booth", "It's cold down here. The light board sits on the counter "
				+ "in front of the window overlooking the empty \ntheatre. There's a bunch of different stage "
				+ "lights just sitting around as well as a bunch of other things. "
				+ "\nThere's the ladder to go up to the cove, and at the other end are the stairs to go down to the theatre. "
				+ "\nTo your left, a door marked 'No exit, roof access only.'" 
				, "You return to the light booth. A box sits at the base of the ladder up to the cove. "
				+ "\nNow that you look, there's a bunch of other things that maybe you could use here. "
				+ "\nAnd there's always the stairs down to the theatre and the door to the roof on your right."),
		/**2*/  new Location("The Theatre", "theatre description", "alt description"),
		/**3*/  new Location("The Area of the Cove where the Lights Hang", "You duck under the pipe and sit on the ground, " 
		        + "between the lights, looking down at the theatre below.\n This is where people run the spot lights from "
				+ "-and someone left some stuff here. Maybe it's useful...." , "Alt description"),
		/**4*/  new Location("The Stage", "You find yourself standing on the stage, basking in the glory of finally getting "
				+ "your moment in \nthe spotlight.... except there's no spotlight on and your back is to the empty theatre "
				+ "but whatever. \nIn front of you is the backstage scene shop, to your left is out to the green room off stage.",
				"[alt here]"),
		/**5*/  new Location("The Abandoned Staples", "You break into the abandoned Staples next to the Home Depot. There's "
				+ "a swirling, glowing light. \nAnd then wrenches as far as the eye can see. This is the dimension of infinite "
				+ "wrenches. You reach out to ", "You actually managed to get back here. You're not supposed to be able to do that.")};
	static int[][] navMatrix = //used to determine where to go based on the player's location (row) and inputed command (column). 
			//(locations noted by index in locations list)
			//"-1" denotes nothing in that direction
	//    up down for*back                                      *forward
/**0*/	{{ 5,  1,  3, -1}, //cove walkway //the "5" is temporary until it can go where it belongs.
/**1*/	 { 0,  2, -1, -1}, //light booth //right will be out to the roof.
/**2*/   { 1, -1,  4, -1}, //theatre //backward will be out to the couches. 
/**3*/   {-1, -1, -1,  0}, //spot op area
/**4*/   {-1, -1, -1,  2}, //stage //forward is shop, right is green room
/**5*/   {-1, -1, -1, -1} //the abandoned Staples. //backwards to Parking Lot II
			};
	public static void changeVisited(int i){//changes isVisited from false to true when the player goes there.
 		places[i].isVisited = true;
	}
	
	//gonna need methods to add and subtract items from the place but I'll deal with this later.
} //closes out the location class.
//Person class holds all data related to people within the game including the player.
class Person{
	int locationIndex; //the current location is referenced by its index in the locations list. This holds that index.
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
	
	public void moveLocation (int direction){//used to move player around the map
		if (Location.navMatrix[this.locationIndex][direction] >= 0){
			this.locationIndex = Location.navMatrix[this.locationIndex][direction];
			beenTo.push(this.locationIndex); //adds the index to the list of places the player's been to.
			renderLocation(this.locationIndex);//prints the details of the location.
		} else
			nothingThere(this.locationIndex);//prints out a message there's  nothing there.
	}
	public static void renderLocation (int i){//prints out the details of your location
		System.out.println("");
		System.out.println("Your location is " + Location.places[i].locationName);
		System.out.println("");
		if (Location.places[i].isVisited) //if you've been here.
			System.out.println(Location.places[i].altDescription);
		else {//if you haven't.
			System.out.println(Location.places[i].locationDescription);
			Location.changeVisited(i);//changes it so it knows that now you have been here.
		}
	}
    public void nothingThere (int i){//prints an error message if you try to go in a direction without a defined location.
    	System.out.println("");
    	System.out.println("There is nothing in that direction of " + Location.places[i].locationName);
    }
    public void goBack (){
    	if (beenTo.getSize() == 1)//the only item in the list is the zero. If it wasn't there, it would throw exceptions.
    		System.out.println("\nYou can't go back any further.");
    	else {
    		beenTo.pop();//remove last item in stack
    		/**returns the top index in the stack, sets it as the player's 
    		 * current location and renders the location */
    		renderLocation(this.locationIndex = beenTo.peek());
    	}    	
    }
    public void renderCurrentLocation(){//prints the name of your current location.
    	System.out.println("\nYour current location is "+ Location.places[this.locationIndex].locationName);
    	//maybe add the initial description of the place?
    }
}//closes out the person class. 
