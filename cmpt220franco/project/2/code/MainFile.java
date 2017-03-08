package code;

import java.util.Scanner;

public class MainFile {
	public static void main (String[] args){
		Person player = new Person (0); //creates the object of the player.
		printOpening(); //calls the function to print the introduction of the game.
		Person.renderLocation(player.locationIndex);//prints the description of the default location.
		
		/**game loop driving the whole thing.*/
		while (true){
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
				player.moveLocation(0, player); //0 is the column for up
			else if (todo.equals("down"))//executes the down command.
				player.moveLocation(1, player);//1 is the column for down.
			else if (todo.equals("forward"))
				player.moveLocation(2, player);
			else if (todo.equals("backward"))
				player.moveLocation(3, player);
			else if (todo.equals("current"))
				player.renderCurrentLocation(player);
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
		System.out.println("up, down, left, right, forward, backwards [acts as an about face and go forward.]\n");
		System.out.println("General Commands:");
		System.out.println("Help, Quit");
//		if (itemHelp) //this is a boolean value that will flip when you pick up your first item.
//			System.out.println("Stuff for the items.");
		
	}
	public static void displayQuit(int quitCode) {//displays the proper ending of the game
		switch (quitCode){//there will be different quit messages for different endings of the game.
		case 0: System.out.println ("\nYou decide this whole thing isn't worth it and go hide in your friend's "
				+ "\nhouse and maybe you'll deal with this tomorrow. Or never. Never is an option."); break; //ending you hit quit.
		case 4: System.out.println("\nCheeseman you lose. Kurt Colbain is dissappointed."); //break; //this is a random ending used to test if switch cases had to be sequentail and left because it's funny.
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
				+ "\nThere's the ladder to go up to the cove, and at the other end are the stairs to go down to the theatre." 
				, "insert alt description here"),
		/**2*/  new Location("The Theatre", "theatre description", "alt description"),
		/**3*/  new Location("The Area of the Cove where the Lights Hang", "You duck under the pipe and sit on the ground, " 
		        +"between the lights, looking down at the theatre below.\n This is where people run the spot lights from "
				+"-and someone left some stuff here. Maybe it's useful...." , "Alt description")};
	static int[][] navMatrix = //used to determine where to go based on the player's location (row) and inputed command (column). 
			//(locations noted by index in locations list)
	//    up down for*back                                      *forward
/**0*/	{{-1,  1,  3, -1}, //cove walkway //foeward will be out to the spot op area. 
/**1*/	 { 0,  2, -1, -1}, //light booth //left will be out to the roof.
/**2*/   { 1, -1, -1, -1}, //theatre //forward will be the stage, backward will be out to the couches. 
/**3*/   {-1, -1, -1,  0}  //spot op area
			};
	public static boolean changeVisited(int i){//changes isVisited from false to true when the player goes there.
 		return places[i].isVisited = true;
	}
	
	//gonna need methods to add and subtract items from the place but I'll deal with this later.
} //closes out the location class.
//Person class holds all data related to people within the game including the player.
class Person{
	int locationIndex; //the current location is referenced by its index in the locations list. This holds that index.
	//will have at least a name. 
	
	//the player probably will inherent other things {inventory}, and the others will have a separate things.
		//2 subclasses
	
	Person ( int currLoc){
		locationIndex = currLoc;
	}	
	public void moveLocation (int direction, Person you){//used to move player around the map
		if (Location.navMatrix[you.locationIndex][direction] >= 0){
			you.locationIndex = Location.navMatrix[you.locationIndex][direction];
			renderLocation(you.locationIndex);
		} else
			nothingThere(you.locationIndex);
	}
	public static void renderLocation (int i){//prints out the details of your location
		System.out.println("");
		System.out.println("Your location is " + Location.places[i].locationName);
		System.out.println("");
		if (Location.places[i].isVisited) //if you've been here.
			System.out.println(Location.places[i].altDescription);
		else {//if you haven't.
			System.out.println(Location.places[i].locationDescription);
			Location.changeVisited(i);
		}
	}
    public static void nothingThere (int i){//prints an error message if you try to go in a direction without defined location.
    	System.out.println("");
    	System.out.println("There is nothing in that direction of " + Location.places[i].locationName);
    }
    public void renderCurrentLocation(Person you){//prints the name of your current location.
    	System.out.println("\nYour current location is "+ Location.places[you.locationIndex].locationName);
    	//maybe add the initial description of the place?
    }
}//closes out the person class. 