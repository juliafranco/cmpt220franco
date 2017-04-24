package code;

public class SpecialtyContainer extends Container {
	//this is really the subclass of the depths of the cove.
	boolean egg = false; //if you'd dropped an egg down there.
		
	/**no agrs constructor*/
	SpecialtyContainer() {}

	/**Constructor for SpecialtyContainer container*/
	SpecialtyContainer (String name, String description, int canHold){
		super(name, description, canHold);
	}
	/**flips the boolean to know if it's dropped an egg doen there.*/
	void ChangeEgg(){
		egg = true;}

	void printContainerContents(){
		System.out.print("\nThe Contents of " + this.contName + ": ");
		for (int i = 0; i < this.contents.size(); i++)
			System.out.print(this.contents.get(i).itemName + ", ");
		System.out.println("");
	}
	/**goes through the conditions to deploy the item.*/
	void deployItem(String itemToCheck) {
		Item itemToFind = Item.determineItemsExistance(itemToCheck);//saves what the method returns as an item object
		if (itemToFind != null){//if the item you're trying to deploy actually exists.
			if (Person.player.inventory.contains(itemToFind)){//if you have the item
				if (Location.places[Person.player.locationIndex].receptacle.contains(this)){//if the depths are where you are
					if ((alternateDeploy(itemToFind))){//if you've attempted to deploy an item that might not be meant to be deployed.
						return;
						} else { 
							if (itemToFind.checkConditions()){//insert checking for conditions here, like lenght >= 15, something grabby on the end. 
							//but I haven't done that yet...
								depths.GetFoundItem();//if everything meets the conditions, go see what you can grab.
							}
						}
					} else { 
						System.out.println("\nYou can't deploy an item if you're nowhere worth deploying it.");}
				}else{
					System.out.println("\nYou can't deploy an item you don't have.");}
			}
	}
	/**looks at some conditions to determine the probablity of getting the wrench.*/
	int getMultFactor(){
		if (this.egg)//makes it harder to get anything
			return 173;
		else if (Person.player.inventory.contains(Item.workLight) || Location.places[Person.player.locationIndex].items.contains(Item.workLight))
			//if you have the worklight which allows you to see things.
			return 52;
		else if ((Person.player.inventory.contains(Item.workLight) || Location.places[Person.player.locationIndex].items.contains(Item.workLight))
				&& this.egg)
			//if you have both the worklight and have dropped an egg down there.
			return 138;
		else// this is the default case.
			return 87;
	}
	/**figures out what you've retrieved from the depths...*/
	Item determineReturn(){
		int retrievalnum = MainFile.getRandomNumber(this.getMultFactor());
		if (retrievalnum == 12 && this.contents.contains(Item.wrench)){//if the item is still down here. 
			return Item.wrench;}
		else if (retrievalnum == 50 && this.contents.contains(Item.otherWrench)){//if the item is still down here. 
			return Item.otherWrench;}
		else if ((retrievalnum == 27 || retrievalnum == 43) && this.contents.contains(Item.keys)){//if the item is still down here. )
			return Item.keys;}
		return null;
	}
	/**figures out what to do with what you've gotten from the depths*/
	/**adds the item to inventory and pulls it out of container.*/
	void GetFoundItem(){
	Item itemFound = depths.determineReturn();
	if (itemFound != null){
		System.out.println("\nYou have retrieved " + itemFound.itemName + " from " + this.contName + ".");
		System.out.println(itemFound.inLocationDescript);
		Person.player.addItem(itemFound);
		this.removeItem(itemFound);}
	else
		System.out.println("\nYour attempt to retrieve anything from " + this.contName + " was unsuccessful.");
	}
	/**if you've deployed some items that alter game play.*/
	boolean alternateDeploy(Item itemDeployed){//returns true if it does anything so it does nothing else.
		if (itemDeployed.equals(Item.eggs)){
			System.out.println("\nYou drop an egg into "+ this.contName + ". Great. Now whatever's down "
					+ "there is covered in egg. \nGood luck getting anything down there now....");
			if (!this.egg) //if you haven't dropped one down there before...
				this.ChangeEgg();//note that you
			Item.eggs.removeItemUses();//removes uses from the eggs
			return true;}
		if(itemDeployed.equals(Item.avocados)){
			MainFile.displayQuit(11);
			return true;}
		if(itemDeployed.equals(Item.car)){
			MainFile.displayQuit(15);
			return true;}
		if(itemDeployed.equals(Item.ladder)){
			System.out.println("\nYou drop the ladder into " + this.contName +". The top is about 6 feet below"
					+ " where you're standing. \nDo you lower yourself carefully over the edge and go down there yourself? (y/n)");
			String input = MainFile.getSecondaryInput();
			if (input.equalsIgnoreCase("y")){
				this.navigate();}
			else if (input.equalsIgnoreCase("n")){
				System.out.println("\nYou decide against it, and go about your attempts to get that wrench back from the walkway.");}
			return true;
		}
		return false;
	}
	/**if you've used the ladder to go into the depths of the cove*/
	void navigate() {
		if (Person.player.inventory.contains(Item.workLight)){//if you can see everything in the depths
			System.out.print("\nYou shine the worklight around " + this.contName + ". You see everything "
					+ "down here....");  
			this.printContainerContents();//prints what's here
			if (this.contents.contains(Item.wrench)){//if the wrench is there
				System.out.println("\nDo you take the wrench? (y/n)");
				int ceiling = MainFile.getRandomNumber(2);
				String input = MainFile.getSecondaryInput();//prompts for user input
				if (ceiling == 1){
					//this determines if you fall through the ceiling in trying to walk to the wrench
					MainFile.displayQuit(13);
					return;}
				//since you're taking the wrench anyways, only need the "no" answer hard coded
				if (input.equalsIgnoreCase("n")){
					System.out.println("\nYou realize that you're dumb for not taking the wrench, and therefore take "
					+ "it anyway.");}
				MainFile.displayQuit(12);//breaks out of the game
				return;}
		} else {
			System.out.println("\nYou go down into the blackness. It's very, very dark. You nope out and go back up "
			+ "because you're never \ngoing to find anything in this darkness and your foot's probably gonna go "
			+ "through the ceiling.");
			return;}
	}
		
}//end of this class.
