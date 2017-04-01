package code;

import java.util.ArrayList;

/**Location Class, holds all the location related data.*/ 
public class Location {
	
		String locationName;
		String locationDescription;
		String altDescription; //what it shows if you've been there.
		Boolean isVisited = false; //tracks if you've been somewhere before.
		ArrayList<Item> items = new ArrayList<>(); //holds an array list of item objects present in the location. 
		ArrayList<Container> receptacle = new ArrayList<>(); //holds a list of containers present in the location. 
		
		Location( String placeName, String placeDescript, String altDescript){
			locationName = placeName;
			locationDescription = placeDescript;
			altDescription = altDescript;
		}	
		/**list of locations in the game.*/
		static Location[] places = 
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
					+ "\nTo your right, a door marked 'No exit, roof access only.'" 
					, "You return to the light booth. A box sits at the base of the ladder up to the cove. "
					+ "\nNow that you look, there's a bunch of other things that maybe you could use here. "
					+ "\nAnd there's always the stairs down to the theatre and the door to the roof on your right."),
			/**2*/  new Location("The Theatre", "You are now in the empty theatre. You're surprised no one's in here, "
					+ "but that's actually a really lucky \nthing because you don't want to answer anyone's questions. "
					+ "The stage is in front of you, the green room out \nto your right. Behind you is the door to go "
					+ "out to the lounge outside and there's the stairs to go up to the \nlight booth.", "You're back "
					+ "in the theatre. The stage is in front of you, the green room is to your right, the \nlounge is "
					+ "out the door behind you and there's always the stairs to go back to the lightbooth. It \ndoesn't "
					+ "seem like there's anything useful here, but you never know until you look..."),
			/**3*/  new Location("The Area of the Cove where the Lights Hang", "You duck under the pipe and sit on the ground, " 
			        + "between the lights, looking down at the theatre below. \nThis is where people run the spot lights from "
					+ "-and someone left some stuff here. Maybe it's useful...." , "You pop back under the pipe and position "
			        + "yourself between the lights, on top the pillows that \nsomeone left up here. It's actually a really nice "
					+ "view, despite being small, dark, and hot. "),
			/**4*/  new Location("The Stage", "You find yourself standing on the stage, basking in the glory of finally getting "
					+ "your moment in \nthe spotlight.... except there's no spotlight on and your back is to the empty theatre "
					+ "but whatever. \nIn front of you is the backstage scene shop, to your right is out to the green room off stage.",
					"You stand on the empty stage once more, the shop before you, the theatre behind you and \nthe green room to your " 
					+ "right. You really are just hoping that the stories about the theatre \nbeing haunted aren't true because you "
					+ "didn't wake up this morning and think 'I hope I get attacked \nby a ghost today.' Then again, you didn't think "
					+ "'I hope I'll drop my wrench through the grating' \nbut that happened, so...."),
			/**5*/  new Location("The Abandoned Staples", "You break into the abandoned Staples at the far end of the shopping center. There's "
					+ "a swirling, glowing light. \nAnd then wrenches as far as the eye can see. This is the dimension of infinite "
					+ "wrenches. You reach out to ", "You actually managed to get back here. You're not supposed to be able to do that. "
					+ "I hope you enjoyed hacking my game."),
			/**6*/  new Location("The Lounge", "You are now in the lounge outside the theatre and the green room. There's four "
					+ "couches, all of \nthem unoccupied. To your right is the office of Campus Security while to your left is the "
					+ "door \nto go outside to the campus green. Outside. The horror.", "You're back in the lounge. The couches look "
					+ "nice. Maybe someone dropped a wrench in one. Or, \ncheck the theatre in front of you, the campus green to your "
					+ "left, or campus security to your right."), 
			/**7*/  new Location("The Scene Shop", "SAWS EVERYWHERE", "SAWS EVERYWHERE AND A DRILL TOO."),//TODO: Write real shop descriptions damn it.
			/**8*/  new Location("The Campus Green", "You find yourself outside on the campus green, the student center on your "
					+ "right, the parking lot \nof the shopping center across the street on your left, the site of the contruction to "
					+ "build new \ndorms in front of you, and the Lower New Townhouses behind you. But around you? Geese. SO. MANY. GEESE. "
					+ "\nYour first concern: getting mauled." , "You're back on the green with the construction site in front of you, "
					+ "the Lower New Townhouses behind you, \nthe parking lot of the shopping center across the street to your left, and the "
					+ "door to get back inside \nto your right. It's a beautiful day, but it'd be better if there weren't a whole bunch of damn "
					+ "geese out here."),
			/**9*/  new Location("The Roof", "You pop out onto the roof. A cool wind ruffles your hair as you survey the world from the " 
					+ "student center \nroof. You can see everything from up here- the view of the river and the rest of campus is breathtaking.",
					"You're back out on the roof. It's still pretty, but also chilly out here. Maybe you should use the door on your "
					+ "\nleft to go back inside."),
			/**10*/ new Location("The Parking Lot" , "You stand in the middle of the parking lot of the shopping center across the street "
					+ "from school. \nThere has to be something useful over here, whether bought or free. To your left is Home Depot, behind "
					+ "\nyou is Job Lot, and the other end of the parking lot is in front of you. Or you can go left to go \nback across the "
					+ "street to campus.", "You find yourself back in the parking lot across the street. Nothing's changed. Job Lot is still "
					+ "behind you with Home Depot to your left, the other end of the parking lot, and the green on campus across the street "
					+ "is on your left."),
			/**11*/ new Location("The other end of the parking lot", "You stand in the middle of the other end of the parking lot. It's kinda "
					+ "spooky down here... To your \nleft is the friendly looking Rite Aid. In front of you, is the decrepid and creepy looking abandoned "
					+ "\nStaples. The other end of the lot is behind you." , "other end of Lot II"), //parking lot II //TODO: write alt description Parking Lot II.
			/**12*/ new Location("The Depths of the Hudson" , "You jump out the kitchen window and right into the Hudson... somehow. This "
					+ "probably wasn't a \ngood idea, but whatever. It's fine. The water's nice.", "You jump back into the Hudson for..."
					+ " some... reason...??"), //Depths of the Hudson
			/**13*/ new Location("The Backstage Bathroom", "You are in a small bathroom off of the green room. Not much to look at, nothing posh. "
					+ "Just standard \nbathroom stuff. Behind you is the Green Room. Next to you is... a cabinet?", "You're back in the bathroom. "
					+ "Green Room's behind you, cabinet's to your left. At least it doesn't smell."), //the bathroom off the green room
			/**14*/ new Location ("The Green Room", "it's not green.", "it's still not green."), //TODO: Write real descriptions for Green Room
            /**15*/ new Location ("The Living Room of K1","You practically barge into the nearest townhouse in Lower New- K1. It's a cozy living "
            		+ "room of a town \nhouse inhabited by 8 sophomore girls, none of which appear to be home. You wonder why the door was \neven open..."
            		+ "or what kind of useful things could be here. The kitchen is behind you, or you can go forward to go back outside.","You're "
            		+ "back in the living room"), //TODO: finish this description.
            /**16*/ new Location ("The K1 Kitchen","",""),
            /**17*/ new Location ("The Upstairs Landing","",""),
            /**18*/ new Location ("Bedroom B","An innocent bedroom in a townhouse. It's a little messy and definitly don't have bottles of Smirnoff "
            		+ "\nhiding in it. The landing is to your left.","You're back in the bedroom. It's quaint, still kinda messy, and why is there a horde "
            		+ "of crocheted Daleks \nstaring at you from one of the beds. You can always retreat to the landing on your left."),
            /**19*/ new Location ("The Upstairs bathroom","",""),
            /**20*/ new Location ("The Office of Campus Security","","")
			}; 
		/**used to determine where to go based on the player's location (row) and inputed command (column).*/
		static int[][] navMatrix =  
				//(locations noted by index in locations list)
				//"-1" denotes nothing in that direction
		//    up down for*back L   R         *forward L = left R = right
	/**0*/	{{-1,  1,  3, -1, -1, -1}, //cove walkway //down is light booth, forward is spot op area.//
	/**1*/	 { 0,  2, -1, -1, -1,  9}, //light booth //right will be out to the roof, down is theatre, up is walkway
	/**2*/   { 1, -1,  4,  6, -1, 14}, //theatre //forward is stage, backward is lounge, left is green room
	/**3*/   {-1, -1, -1,  0, -1, -1}, //spot op area //backward is walkway
	/**4*/   {-1, -1,  7,  2, -1, 14}, //stage //forward is shop, right is green room
	/**5*/   {-1, -1, -1, 11, -1, -1}, //the abandoned Staples. //backwards to Parking Lot II
	/**6*/   {-1, -1,  2, -1,  8, 20}, //the lounge with couches//forward is theatre, left is green, right is security  
	/**7*/   {-1, -1, -1,  4, -1, -1}, //the shop //back is the stage
	/**8*/   {-1, -1, -1, 15, 10,  6}, //the green //left is parking lot, back is K1, right is back inside, forward is construction site. 
	/**9*/   {-1, -1, -1, -1,  1, -1}, //the roof //left is the light booth
	/**10*/  {-1, -1, 11, -1, -1,  8}, //Parking Lot I // forward is Lot II, back is Job Lot, Right is home depot
	/**11*/  {-1, -1,  5, 10, -1, -1}, //Parking Lot II //back is Lot 1, forward is Staples , left is Rite Aid
	/**12*/  {-1, -1, -1, -1, -1, 16}, //Depths of the Hudson //right is the kitchen. 
	/**13*/  {-1, -1, -1, 14, -1, -1}, //Green Room bathroom //back is Green Room
	/**14*/  {-1, -1, 13,  6,  4, -1}, //Green room. Forward is bathroom, backward is lounge, left is stage
    /**15*/  {17, -1,  8, 16, 17, -1}, //The K1 Living Room //forward is the green, backward is the kitchen, up is the upstairs landing
    /**16*/  {-1, -1, 15, -1, 12, -1}, //K1 Kitchen //back is livingroom, left is depths of the Hudson
    /**17*/  {-1, 15, -1, 19, -1, 18}, //K1 Upstairs landing. down is living room, right is Bedroom B, backward is the bathroom.
    /**18*/  {-1, -1, -1, -1, 17, -1}, //K1 Bedroom B, backward is the landing.
    /**19*/  {-1, -1, 17, -1, -1, -1}, //The K1 upstairs bathroom, forward is the landing
    /**20*/  {-1, -1, -1, -1,  6, -1}, //Campus Security, left is the lounge.
				};
		/**changes isVisited from false to true when the player goes there.*/
		void changeVisited(){
	 		this.isVisited = true;}
		/**adds container to location*/
		void addContainer (Container toAdd){
			receptacle.add(toAdd);
		}
		/**adds item to location*/ //used to add things initially and when you drop them.
		void addItem (Item toAdd){
			items.add(toAdd);
		}
		/**subtracts item from location*/ //when you pick up an item.-- replaced by default arraylist.remove list. 
		/**prints the names of the item(s) in that location.*/
		void examine() {
			printItemDescriptions();
			System.out.println("\nWhat's in " + this.locationName + ": ");
			examineItems(); //calls the examine items method.
			examineContainers(); //calls the examine containers method.
			System.out.println("");
			if (this.items.isEmpty() && this.receptacle.isEmpty())
				System.out.println("There's nothing here to examine.");
		}
		/**prints the names of the items in that location*/
		void examineItems(){
			if (!this.items.isEmpty())
				for (int i = 0; i < this.items.size(); i++){
					System.out.print(this.items.get(i).itemName + ", ");
			}
		}
		void printItemDescriptions(){
			if (!this.items.isEmpty()){
				for (int i = 0; i < this.items.size(); i++){
					System.out.print(this.items.get(i).inLocationDescript + "\n");}
			}
		}
		/**prints the names of the containers in that location*/
		void examineContainers(){
			if (this.receptacle != null)//checks and sees if there's any containers in the location.
				for (int i = 0; i < this.receptacle.size(); i++)
					if (this.receptacle.get(i).hidden != true)//if it's a hidden container, you don't know it's there, but it is...
						System.out.print(this.receptacle.get(i).contName + ", ");
		}
		/**Do you get mauled by a goose on the green?*/
		static boolean getMauled(){
			if ( Person.player.inventory.contains(Item.repellent)) //if you have the goose repellent...
				return (MainFile.getRandomNumber(240) == 12); //drastically lowers your chance of being mauled.
			return (MainFile.getRandomNumber(20) == 12);//generates a random number for if you don't have it, and if it's 12 you get mauled
		}
		
	    /**method to run methods to add things to locations and containers for beginning of game.*/	
	    static void setItemsAndContainers (){
	    	/**Add containers to places*/
	    	Location.places[0].addContainer(Container.depths);
	    	Location.places[1].addContainer(Container.secondaryInv);
	    	Location.places[6].addContainer(Container.couch1);
		    Location.places[6].addContainer(Container.couch2);
		    Location.places[6].addContainer(Container.couch3);
		    Location.places[6].addContainer(Container.couch4);
		    Location.places[13].addContainer(Container.closetBathroom);
		    
		    /**Add items to places*/
		    Location.places[0].addItem(Item.grabber);
		    Location.places[1].addItem(Item.parcans);
		    Location.places[3].addItem(Item.bookbag);
		    Location.places[7].addItem(Item.drill);
		    Location.places[18].addItem(Item.bottle);
            Location.places[19].addItem(Item.plunger);
            Location.places[20].addItem(Item.map);
		    
		    /**test purposes*/
//		    Location.places[0].addItem(Item.otherWrench);
//		    Location.places[0].addItem(Item.repellent);
//		    Location.places[7].addItem(Item.repellent);
		    
		    /**Adds items in containers*/
		    Container.setItemsInContainers();
		    }
        /**method to wipe all of the items and containers in places.*/
	    static void wipeLocations(){
	    	for (int i= 0; i < places.length; i++){
				for (int j = 0; j < places[i].items.size(); j++)
					places[i].items.clear();
				for (int k = 0; k < places[i].receptacle.size(); k++)
					places[i].receptacle.clear();
	    	}
	    	Container.emptyContainer();
	    }
} //closes out the location class.
