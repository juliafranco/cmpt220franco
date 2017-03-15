package code;

public class Location {
	//Location Class, holds all the location related data. 
		String locationName;
		String locationDescription;
		String altDescription; //what it shows if you've been there.
		Boolean isVisited = false; //tracks if you've been somewhere before.
//		Item[] items; //holds a list of item objects present in the location.
//		Container[] receptacle; //holds a list of containers present in the location
		
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
			/**11*/ new Location("The other end of the parking lot", "parking lot II" , "other end of Lot II"), //parking lot II //TODO: write descriptions.
			/**12*/ new Location("The Depths of the Hudson" , "You jump out the kitchen window and right into the Hudson... somehow. This "
					+ "probably wasn't a \ngood idea, but whatever. It's fine. The water's nice.", "You jump back into the Hudson for... some... reason...??")
			}; 
		static int[][] navMatrix = //used to determine where to go based on the player's location (row) and inputed command (column). 
				//(locations noted by index in locations list)
				//"-1" denotes nothing in that direction
		//    up down for*back L   R         *forward L = left R = right
	/**0*/	{{12,  1,  3, -1, -1, -1}, //cove walkway //FIXME //the "12" is temporary until it can go where it belongs.(really -1)
	/**1*/	 { 0,  2, -1, -1, -1,  9}, //light booth //right will be out to the roof.
	/**2*/   { 1, -1,  4,  6, -1, -1}, //theatre
	/**3*/   {-1, -1, -1,  0, -1, -1}, //spot op area
	/**4*/   {-1, -1,  7,  2, -1, -1}, //stage //forward is shop, right is green room
	/**5*/   {-1, -1, -1, 11, -1, -1}, //the abandoned Staples. //backwards to Parking Lot II
	/**6*/   {-1, -1,  2, -1,  8, -1}, //the lounge with couches 
	/**7*/   {-1, -1, -1,  4, -1, -1}, //the shop
	/**8*/   {-1, -1, -1, -1, 10,  6}, //the green //left is parking lot, back is K1, right is back inside, forward is construction site. 
	/**9*/   {-1, -1, -1, -1,  1, -1}, //the roof //left is the light booth
	/**10*/  {-1, -1, 11, -1, -1,  8}, //Parking Lot I // forward is Lot II, back is Job Lot, Right is home depot
	/**11*/  {-1, -1,  5, 10, -1, -1}, //Parking Lot II //back is Lot 1, forward is Staples , left is Rite Aid
	/**12*/  {-1, -1, -1, -1, -1, -1} //Depths of the Hudson
				};
		void changeVisited(){//changes isVisited from false to true when the player goes there.
	 		this.isVisited = true;
		}
		static boolean getMauled(){
			//if repellent in inventory
				//return false;
			return (MainFile.getRandomNumber(20) == 12);//generates a random number, and if it's 12 you get mauled
		}
		//gonna need methods to add and subtract items from the place but I'll deal with this later.
} //closes out the location class.
