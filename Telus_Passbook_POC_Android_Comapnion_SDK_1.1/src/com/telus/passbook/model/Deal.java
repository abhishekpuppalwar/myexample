package com.telus.passbook.model;



public class Deal {
	private String passCode;
	private String passCodeUA;
	private String dealTitle;
	private String description;
//	private ArrayList<Project> projects;
//	private ArrayList<LoyaltyClass> loyaltyClasses;
//	private ArrayList<LoyaltyCard> loyaltyCards;

	void setPasscode(String passCode) {

		this.passCode = passCode;
	}

	public String getPasscode() {

		return passCode;
	}
	
	void setPasscodeUA(String passCodeUA) {

		this.passCodeUA = passCodeUA;
	}

	public String getPasscodeUA() {

		return passCodeUA;
	}

	public void setDealTitle(String categoryName) {

		this.dealTitle = categoryName;
	}

	public String getDealTitle() {

		return dealTitle;
	}


	public void setDescription(String description) {

		this.description = description;
	}

	public String getDescription() {

		return description;
	}
	
	/*public ArrayList<LoyaltyClass> getLoyaltyClasses() {
		return loyaltyClasses;
	}
	
	public ArrayList<LoyaltyCard> getLoyaltyCards() {
		return loyaltyCards;
	}*/

	/*void setProjectList(ArrayList<Project> projects) {

		this.projects = projects;
	}*/

	/*public ArrayList<Project> getProjectList() {

		if (projects == null || false) // false means 3 mins time elapses
		{
			String response = Utils.getRequest(ParseConstants.CLASS_PROJECTS,null, null);
			ResponseParser responseParser = new ResponseParser();
        	projects = responseParser.parseProjects(response);
        	if(projects != null)
        		System.out.println(" **************** Category.getProjectList() size = "+projects.size() + " **************** ");
		}
		return projects;
	}*/

}
