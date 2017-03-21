package code;

/**Location Class, holds all the location related data.*/ 
public class Location {
	
		String locationName;
		String locationDescription;
		String altDescription; //what it shows if you've been there.
		Boolean isVisited = false; //tracks if you've been somewhere before.
		Item[] items = new Item[1]; //holds a list of item objects present in the location. Default size is 1, can increase
		Container[] receptacle = new Container[1]; //holds a list of containers present in the location. Default size is 1, can increase
		
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
					+ "build new \ndorms in front of you, and Lower New Townhouse K1 behind you. But around you? Geese. SO. MANY. GEESE. "
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
					+ "street to campus.", "alt Lot I"),//TODO write Parking Lot Alt Description
			/**11*/ new Location("The other end of the parking lot", "You stand in the middle of the other end of the parking lot. It's kinda "
					+ "spooky down here... To your \nleft is the friendly looking Rite Aid. In front of you, is the decrepid and creepy looking abandoned "
					+ "\nStaples. The other end of the lot is behind you." , "other end of Lot II"), //parking lot II //TODO: write alt description Parking Lot II.
			/**12*/ new Location("The Depths of the Hudson" , "You jump out the kitchen window and right into the Hudson... somehow. This "
					+ "probably wasn't a \ngood idea, but whatever. It's fine. The water's nice.", "You jump back into the Hudson for..."
					+ " some... reason...??"), //Depths of the Hudson
			/**13*/ new Location("The Backstage Bathroom", "You are in a small bathroom off of the green room. Not much to look at, nothing posh. "
					+ "Just standard \nbathroom stuff. Behind you is the Green Room. Next to you is... a cabinet?", "You're back in the bathroom. "
					+ "Green Room's behind you, cabinet's to your left. At least it doesn't smell."), //the bathroom off the green room
			/**14*/ new Location ("The Green Room", "it's not green.", "it's still not green.") //TODO: Write real descriptions for Green Room
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
	/**6*/   {-1, -1,  2, -1,  8, -1}, //the lounge with couches//forward is theatre, left is green, right is security  
	/**7*/   {-1, -1, -1,  4, -1, -1}, //the shop //back is the stage
	/**8*/   {-1, -1, -1, -1, 10,  6}, //the green //left is parking lot, back is K1, right is back inside, forward is construction site. 
	/**9*/   {-1, -1, -1, -1,  1, -1}, //the roof //left is the light booth
	/**10*/  {-1, -1, 11, -1, -1,  8}, //Parking Lot I // forward is Lot II, back is Job Lot, Right is home depot
	/**11*/  {-1, -1,  5, 10, -1, -1}, //Parking Lot II //back is Lot 1, forward is Staples , left is Rite Aid
	/**12*/  {-1,  9, -1, -1, -1, -1}, //Depths of the Hudson //right is the kitchen. //FIXME- down won't be location 9 forever.
	/**13*/  {-1, -1, -1, 14, -1, -1}, //Green Room bathroom //back is Green Room
	/**14*/  {-1, -1, 13,  6,  4, -1} //Green room. Forward is bathroom, backward is lounge, left is stage
				};
		/**changes isVisited from false to true when the player goes there.*/
		void changeVisited(){
	 		this.isVisited = true;}
		/**increase number of elements in receptacle list to hold more containers*/
		void increaseReceptacle (){
			Container[] temp = new Container[this.receptacle.length * 2];
			System.arraycopy(this.receptacle, 0, temp, 0, this.receptacle.length);
			this.receptacle = temp;	
		}
		/**adds container to location*/
		void addContainer (Container toAdd){
			if (this.receptacle[this.receptacle.length -1]!= null)//ie, if there's something there. Hopefully.
				this.increaseReceptacle();
			//need to find the first open index. 
			for (int i = 0; i < this.receptacle.length; i++)
				if (this.receptacle[i] == null){
					this.receptacle[i] = toAdd;
					break;		
				}
		}
		/**increase number of elements in items list to hold more items*/
		void increaseItems (){
			Item[] temp = new Item[this.items.length * 2];
			System.arraycopy(this.items, 0, temp, 0, this.items.length);
			this.items = temp;	
		}
		/**adds item to location*/ //used to add things initially and when you drop them.
		void addItem (Item toAdd){
			//see if you need to increase the size of the array.
			if (this.items[this.items.length -1]!= null)//ie, if there's something there. Hopefully.
				this.increaseItems();
			//need to find the first open index. 
			for (int i = 0; i < this.items.length; i++)
				if (this.items[i] == null){
					this.items[i] = toAdd;
					break;
					}
		}
		/**subtracts item from location*/ //when you pick up an item.
		/**prints the names of the item(s) in that location.*/
		void examine() {
			System.out.println("\nWhat's in " + this.locationName + ": ");
			examineItems(); //calls the examine items method.
			examineContainers(); //calls the examine containers method.
			System.out.println("");
			if (this.items[0] == null && this.receptacle[0] == null)
				System.out.println("There's nothing here to examine.");
		}
		/**prints the names of the items in that location*/
		void examineItems(){
			if (this.items[0] != null)
				for (int i = 0; i < this.items.length; i++){
					System.out.print(this.items[i].itemName + ", ");
			}
		}
		/**prints the names of the containers in that location*/
		void examineContainers(){
			if (this.receptacle[0] != null)
				for (int j = 0; j < this.receptacle.length; j++)
					System.out.print(this.receptacle[j].contName + ", ");
		}
		/**Do you get mauled by a goose on the green?*/
		static boolean getMauled(){
			//if repellent in inventory
				//return false;
			return (MainFile.getRandomNumber(20) == 12);//generates a random number, and if it's 12 you get mauled
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
		    Location.places[1].addItem(Item.bookbag);
		    
		    /**test purposes*/
		    Location.places[0].addItem(Item.otherWrench);
		    Location.places[0].addItem(Item.repellant);
		    Location.places[0].addItem(Item.parcans);
		    Location.places[7].addItem(Item.repellant);
		    
		    /**Adds items in containers*/
		    Container.setItemsInContainers();
		    }
        /**method to wipe all of the items and containers in places.*/
	    static void wipeLocations(){
	    	for (int i= 0; i < places.length; i++){
				for (int j = 0; j < places[i].items.length; j++)
					places[i].items[j] = null;
				for (int k = 0; k < places[i].receptacle.length; k++)
					places[i].receptacle[k] = null;
	    	}
	    	Container.emptyContainer();
	    }
} //closes out the location class.
