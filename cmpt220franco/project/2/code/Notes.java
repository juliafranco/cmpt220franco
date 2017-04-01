package code;

public class Notes {
	/**TODO:
		//*               
		 *Write more items 
		 *Write more locations
		 *Probably should draw up UMLs.
		 *make the input easier to work with.
		 *Figure out how to hide Depths of Cove.    
		 */
    /**FIXME: [to remove]: bypass command, maul command, bottle of Vodka 
     * */	
	//Cove Wrench Drop: The Game.
/**I.  */ void Story(){
		//You have dropped the last wrench through the grating. Run around and try to get things to get the wrench back.
			//alternate ending where you decide to just buy more wrenches?
}
/**II. */ void CombineItems_GetTheWrench(){ 
			//there's also other things down there that you can grab
				//car keys(??), the wrong wrench (can end the game.)[item 28]
					//"This isn't the wrench you dropped, but it's a wrench. Technically,
						// you did what you set out to do. So you can put it back and go about 
						//your life or keep trying to get the one you dropped. Keep trying y/n? [pass quit code probably.]
							//y: It it a matter of honor. You need that wrench.
							//n: you put the other wrench back and go on with your life. No one needs to know.
								//this quits you out of the game.
			//get points for finding things and combining items
			//can you uncombine items?? Probably. [Can't reuse gaff tape]
			//define how far down the wrench is, define lengths of items.
			//store item combinations- can you combine everything? [probably, some are" why would you want to?]
				//can you combine combined items??
					//yes.
			//command to combine items, gives you a list of things to combine. 
				//can only combine what you have
				//some way to check if you're combining the same item
				//some combinations need three items
					//tell you it didn't work or what you need?		
/**II.V	//What you need to get the wrench.
			//needs to be long enough to reach the wrench
			//need some way of attracting/capturing the wrench
				//if you have those, randomly determine if you grab the wrench
				// if you can see the wrench, that increases the chance of getting the thing.
			//determine what combinations of items can get the wrench.
			//once you get the wrench, it automatically ends the game.*/
}		
/**III.*/ void Locations(){ 
			//places around school, maybe across the street. 
/**Done*/	//a	//the shop (7)
					//Contains cabinets and/or drawers to rummage through
/**Done*/	//b	//the stage (4)
/**Done*/	//c	//the green room (14)
/**Done*/	//d	//the bathroom [only the one with the closet.] (13)
				/**the cove*/
/**Done*/	//e		//the walkway (0)
/**Done*/	//f		//under the lights/spot op area. (3)
					//the depths? Can you go down there??
						//this might not be somewhere you can go, but somewhere that holds the items down there.
						//this is a container which contains some items. You "reach" into the container but it's a special class?
		    //g     //Campus security.[20]
/**Done*/	//h	//the light booth (1)
/**Done*/	//i	//the roof (9)
/**Done*/	//j	//the couches (6)
					//can rummage through the couch for things.
					//specific couches hold specific items, pick a number of the couch to rummage in.
/**Done*/	//k	//the theatre itself (2)
/**Done*/	//l	//the green (8)
				/**K1*/
		    //m-q			//living room[15], kitchen[16], upstairs landing[17], bathrooom[19],bedroom B[18]
		    //r	//the construction site[21]
				//need to worry about people finding you.
				//go over there, have to decide to go inside. 
		    //s	//Home depot
		    //t	//rite aid
		    //u	//job lot
		    //v	//Lola's
					//has a few items that you could buy and eat. (like a sandwich or two and peanut noodles.)
					//you'd probably need the car to get there.
/**Done*/	//w    //Abandoned Staples which leads to a dimension of infinite wrenches. (5)
					//"glitch" where you end up with a hundred trillion wrenches in the cove 
						//does not actually put a hundred trillion wrench objects in the cove. 
						//game ends by you getting smothered by wrenches. 
/**Done*/	//x&y  //the parking lot where Home Depot & etc are (10 & 11)
/**Done*/	//z    //the depths of the hudson (12)
		
			//Ability to go up and down places
			//also open cabinets and drawers 
			//This would be a class
			//remembers where you've been
			//hold items. 
}
/**IV. */ void Commands(){
		//tied to methods/functions-
			//up, down, left, right, forwards, about face & backwards, go back [fully functioning][DONE.], use [for you item]
			//pick up & put down [items]
			//combine for items
				//see early labs with indefinite numbers of integers inputed.
			//can buy items- places that sell them will have prices attached to them [subclass of buyable item]
				//obviously can only buy if you have the money.
			//help- displays some useful commands- more as it goes forward and things are "unlocked"
				//when you pick up your first item, shows the drop, when you have two tells you about the combine	
				//maybe the first time you run into someone, gives you the talk.
				//when you've found money, tells you about buying things. 
}
/**V.  */ void Items(){
			//start out with nothing, including money....
			//different items will have different amounts of points. They're for the fun of it.
			//have a name, point value, some will have a number of uses or a quantity, depending on how I want to work it. 
			//items you can buy will have a cost attached to them.
			//need to store items in inventory
				//do you need to find a bag or something before you can hold anything?
					//use a boolean to mark if you've found the bag, can't pick up anything before. (prints error message.)
						//same command as taking an item, but doesn't go in your inventory, just trips the boolean to allow you to hold stuff. 
					//put one in the spot op area.
				//is there a limit to how many you can have?
					//if there is, then there's a box in the lightbooth or cove walkway to hold other things, counts as secondary inventory.
						//use boolean and if there's anything there, prints what's there. 
			//can you drop items through the grating? [I'm thinking no, unless you randomly lose your grip in retrieval.]
			//four?? subclasses- attract/capture, length, secure, [ the main one does nothing.], items found in sotres [have cost attached] 
		
		 //1	//a crumpled $5 bill
					//breaks and makes change- you then have a dollar eighty one. or something. 
					//if you find more money, it'll update. 
						//can you find more money??
					//money is its own separate data field. 
/**Done*///2	//the grabber [cove walkway]
		 //3	//a worklight
		 //		//an extension cord [stage]
		 //5	//rope
		 //6	//pvc pipe
		 //7	//2 x 4
/**Done*///8	//gaff tape [start with a whole roll, when it's gone it's gone] [found in bathroom closet]
					// when you use it, does it come off in random amounts?? Set amounts? Do you set it?
					//can theoretically buy more but it's 35 dollars. 
						//you can't afford it.
		 //9    //chewing gum
		 //10   //eggs [a carton of a dozen.][kitchen]
					//if you're going to drop it, it would have the same mechanics as trying to retrieve something.
					//"Great. Now whatever's down there is covered in egg."
						//the code remember that there's egg down there and affects game play.
							//makes it harder to get the wrench.
						//you can drop as many eggs as you want, won't make a difference.
						//count how many eggs you have-  changes to empty carton when empty.
		 //11	//a copy of Hamlet
/**Done*///12	//a drill
		 //13	//4 1 5/8" screws. [use them wisely]
/**Done*///14	//A BUNCH OF PAR CANS [as a collective unit]
		 //15	//a 10 foot ladder [found on stage]
		 //16	//some tuperware
		 //17	//a really powerful magnet
		 //18	//a crane [found at construction site]
		 //19	//a plunger, found in the upstairs bathroom of K1
		 //20	//a car??
		 //21		//would need to also find car keys before it's any use. 
						//you retrieve the car keys from the cove.
					//use a drive function, have a list of places and you "warp" to them.
		 //22	//a goblet
		 //23    //a bin of avocados [found at Job Lot]
					//"avocados? You didn't know Job Lot sells avocados. No... they definitely don't.
					//since they don't belong here, who's going to miss them if you swipe them. 
					//But god, they're just sitting there like the mastermind of some horrid trap.
						//if you attempt to combine the avocados into anything, you invoke their wrath and you die???
/**Done*///24    //a bookbag.
					//used to hold a couple items.... some won't fit?? *coughparcanscough* or TARDIS baG??<--- probably, maybe some funny comment.
						//attach a number to the pick up, use a switch to read pick up code and print the right message. 
							//"you pick up the item.name and put it in your bag. How the heck it fits is beyond you.
/**Done*///25	//a map
					//you totally have to find this- it's on the ground but only shows major locations, not everything. 
	 	 //26	//either Ally's keys, Michael's keys, or his wallet.
					//if it's Ally's keys and you find Ally, and give them back, she gives you a wrench you can replace and you're home free??
						//gives you a y/n option. 
/**Done*///27	//Goose Repellent
					//if you have the goose repellent, it disables your ability to get mauled. The minute you don't have it....
						//even if it's in your secondary inventory...
/**Done*///28	//The Other Wrench
}
/**VI. */ void People(){	
			//avoid people like Matt, Marc, and Jim because SHAME. Also custodian, Gus, who hears the clinking and clanking
			//throw in Matthew Johnson, the "God Amoungst Men"?
			//a house mate?
			//this would be a class
			//be able to talk to them, have conversations, cover guilt. 
			//randomly generate their locations/movements?
				//they will have a range of places. You won't find Marc in K1.
					//an array storing the indexes of all the places they could be
						//cashier would just have their place of employment unless they were a student or something....
				//ending where they find out and get kicked out of MCCTA??
					//"Hey do you have a wrench?" "I totally didn't just drop one through the grating..."
					//but this isn't realistic..... unless you kick yourself out because you're too dramatic.
				//if Gus catches you, you get reported to campus security, who you admit it to and go from there. 
			//if you're in the same location as someone, it'll give you a message.
		//there could also be cashiers at the stores you can buy things from??
			//Obviously they stay in the same location. 
				//and are not a threat.
}
/**VII */ void ContainerClass(){
			//examples:
/**Done*///A		//couches
		 //B		//drawers
		 //C		//cabinets
	   	 //D		//store shelves. 
/**Done*///E		//the box in the lightbooth
/**Done*///F		//the depths of the Cove??
			//holds items
			//the location hold containers as an object.
			//accessed by the "rummage" command.
			//show up when you examine the location for things. 
				//but seperately from the items.
}
/**VIII*/ void Implementation(){ 
			/** DONE: start with locations and navigation writing functions and methods and objects*/
			//introduce items and what happens when you use them as well as containers. 
				//determine solution[s] to getting the wrench
				//introduce item retrieval.
			//write in people
}
}
