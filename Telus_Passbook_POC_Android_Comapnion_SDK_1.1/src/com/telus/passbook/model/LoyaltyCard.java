package com.telus.passbook.model;

import java.util.Date;

import android.os.Message;

/**
 * This is the model class of Issue
 * 
 * @author abhishek.puppalwar
 */
public class LoyaltyCard {

	private String id;
	private String classId;
	private long version;
	private String state;
	
	
	// issuer data information
//	private IssuerData issuerData;
//	private Uri mUri;
	
	// barcode data information
//	private Barcode barcode;
	
	//message data information
	private Message message;
	
	//valid time interval data
	private Date start;
	private Date end;
	
	//locations information
	private double lattitude;
	private double longitude;
	
	//holder count value
	private int holderCount;
	
	/*//info module data details
	private InfoModuleData infoModuleData;
	
	//image module data
	private ImageModuleData imageModuleData;
	
	//text module data inforamtion
	private TextModuleData textModuleData;
	
	//links module data information
	private LinksModuleData linksMouleData;
	
	//class references
	private LoyaltyClass resourceLoyaltyClass;
	
	//account name
	private String accountName;
	
	//account id
	private String accountId;
	
	//loyalty points
	private LoyaltyPoints loyaltyPoints;*/
	
	
	/*private String status;
	private String[] geopoints;
	private ArrayList<IssueField> issueFields;
	private String deviceData;
	private String comments;
	private String[] attachments;*/

	/*void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getProjectId() {
		return projectId;
	}

	void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	void setGeopoints(String[] geopoints) {
		this.geopoints = geopoints;
	}

	public String[] getGeopoints() {
		return geopoints;
	}

	public void setIssueFields(ArrayList<IssueField> issueFields) {
		this.issueFields = issueFields;
	}

	public ArrayList<IssueField> getIssueFields() {
		return issueFields;
	}

	void setDeviceData(String deviceData) {
		this.deviceData = deviceData;
	}

	String getDeviceData() {
		return deviceData;
	}

	void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments() {
		return comments;
	}

	public void setAttachments(String[] attachments) {
		this.attachments = attachments;
	}

	public String[] getAttachments() {
		return attachments;
	}*/

}
