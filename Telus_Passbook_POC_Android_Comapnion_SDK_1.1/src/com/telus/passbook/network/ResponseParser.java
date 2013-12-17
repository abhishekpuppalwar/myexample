package com.telus.passbook.network;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.telus.passbook.constant.PassConstants;
import com.telus.passbook.model.Deal;
import com.telus.passbook.model.IssueField;
import com.telus.passbook.model.IssueField.TYPE;
import com.telus.passbook.model.LoyaltyCard;

/**
 * This class is responsible to parse the data got from the server.
 * 
 * @author abhishek.puppalwar
 */
public class ResponseParser {

	/**
	 * This method parse the response data from the server.
	 * 
	 * @param jsonResponse
	 *            response data
	 * @return ArrayList of issue model class
	 */
	public ArrayList<LoyaltyCard> parseIssues(String jsonResponse) {

		// jsonResponse =
		// "{\"results\":[{\"IssueTitle\":\"ABC\",\"IssueDescription\":\"ABC...\"},{\"IssueTitle\":\"XYZ\",\"IssueDescription\":\"XYZ...\"}]}";

		ArrayList<LoyaltyCard> issuesArrayList = new ArrayList<LoyaltyCard>();

		JSONObject json;
		try {
			json = new JSONObject(jsonResponse);
			JSONArray jsonArray = json.getJSONArray("results");
			for (int count = 0; count < jsonArray.length(); count++) {
				String title = null;
				String description = null;
				JSONObject jsonObject = jsonArray.getJSONObject(count);

				title = jsonObject.getString(PassConstants.ISSUE_TITLE);
				description = jsonObject
						.getString(PassConstants.ISSUE_DESCRIPTION);
				if (title != null || description != null) {
					LoyaltyCard issue = new LoyaltyCard();
					// issue.setIssueTitle( title );
					// issue.setIssueDescription( description );
					issuesArrayList.add(issue);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return issuesArrayList;

	}

	/*public ArrayList<Deal> parseCategories(String jsonResponse) {

		// jsonResponse =
		// "{\"results\":[{\"IssueTitle\":\"ABC\",\"IssueDescription\":\"ABC...\"},{\"IssueTitle\":\"XYZ\",\"IssueDescription\":\"XYZ...\"}]}";

		ArrayList<Deal> categoriesArrayList = new ArrayList<Deal>();

		JSONObject json;
		try {
			json = new JSONObject(jsonResponse);
			JSONArray jsonArray = json.getJSONArray("results");
			for (int count = 0; count < jsonArray.length(); count++) {
				String title = null;
				String description = null;
				JSONObject jsonObject = jsonArray.getJSONObject(count);

				title = jsonObject.getString(PassServerConstants.CATEGORY_TITLE);
				if (title != null || description != null) {
					Deal category = new Deal();
					category.setCategoryName(title);
					categoriesArrayList.add(category);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return categoriesArrayList;

	}*/
	
	public ArrayList<Deal> parseDeals(String jsonResponse) {

		// jsonResponse =
		// "{\"results\":[{\"IssueTitle\":\"ABC\",\"IssueDescription\":\"ABC...\"},{\"IssueTitle\":\"XYZ\",\"IssueDescription\":\"XYZ...\"}]}";

		ArrayList<Deal> dealsArrayList = new ArrayList<Deal>();

		JSONObject json;
		try {
//			json = new JSONObject(jsonResponse);
			JSONArray jsonArray = new JSONArray(jsonResponse);
//			JSONArray jsonArray = json.getJSONArray("results");
			for (int count = 0; count < jsonArray.length(); count++) {
				String title = null;
				String description = null;
				JSONObject jsonObject = jsonArray.getJSONObject(count);

				title = jsonObject.getString(PassConstants.DEALS_TITLE);
				description = jsonObject.getString(PassConstants.DEALS_DESCRIPTION);
				
				if (title != null || description != null) {
					Deal deal = new Deal();
					deal.setDealTitle(title);
					deal.setDescription(description);
					dealsArrayList.add(deal);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return dealsArrayList;

	}

	/*public ArrayList<Project> parseProjects(String jsonResponse) {

		// jsonResponse =
		// " {"results":[{"ProjectName":"abc","CategoryId":{"__type":"Pointer","className":"ProjectCategories","objectId":"S3c1CnvAqA"},"createdAt":"2013-10-04T07:10:43.112Z","updatedAt":"2013-10-04T07:10:43.112Z","objectId":"B2gasXczUc"},{"ProjectName":"a1","CategoryId":{"__type":"Pointer","className":"ProjectCategories","objectId":"adkwcmJsuM"},"createdAt":"2013-10-04T07:23:33.129Z","updatedAt":"2013-10-04T07:23:33.129Z","objectId":"Qes5bNATWD"},{"ProjectName":"a2","CategoryId":{"__type":"Pointer","className":"ProjectCategories","objectId":"adkwcmJsuM"},"createdAt":"2013-10-04T07:24:21.913Z","updatedAt":"2013-10-04T07:24:21.913Z","objectId":"2s0zZFTcls"},{"ProjectName":"a3","CategoryId":{"__type":"Pointer","className":"ProjectCategories","objectId":"adkwcmJsuM"},"createdAt":"2013-10-04T07:25:22.516Z","updatedAt":"2013-10-04T07:25:22.516Z","objectId":"tj4CJ1hs5d"}]}"
		ArrayList<Project> projectsArrayList = new ArrayList<Project>();

		JSONObject json;
		try {
			json = new JSONObject(jsonResponse);
			JSONArray jsonArray = json.getJSONArray("results");
			for (int count = 0; count < jsonArray.length(); count++) {
				String title = null;
				String description = null;
				JSONObject jsonObject = jsonArray.getJSONObject(count);

				title = jsonObject.getString(PassServerConstants.PROJECT_TITLE);
				if (title != null || description != null) {
					Project project = new Project();
					project.setProjectName(title);
					projectsArrayList.add(project);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return projectsArrayList;
	}*/

	public ArrayList<IssueField> parseIssueFields(String jsonResponse) {

		// jsonResponse =
		//  {"results":[{"FieldId":1,"ProjectId":1,"label":"Breif","languageCode":1,"mandatory":true,"position":1,"type":"text","createdAt":"2013-09-30T11:04:34.473Z","updatedAt":"2013-09-30T11:06:00.939Z","objectId":"fTr4ysKu0c"},{"FieldId":2,"ProjectId":1,"label":"Category","languageCode":1,"mandatory":true,"options":["A","B","C"],"position":2,"type":"dropdown","createdAt":"2013-09-30T11:04:34.513Z","updatedAt":"2013-09-30T11:06:03.742Z","objectId":"Yf6bFN7HA1"},{"FieldId":3,"ProjectId":1,"label":"Frequency","languageCode":1,"mandatory":true,"options":["X","Y","Z"],"position":3,"type":"dropdown","createdAt":"2013-09-30T11:04:34.529Z","updatedAt":"2013-09-30T11:06:07.396Z","objectId":"Nz2zHUEfwS"},{"FieldId":4,"ProjectId":1,"label":"Notes","languageCode":1,"mandatory":true,"position":4,"type":"text","createdAt":"2013-09-30T11:04:34.545Z","updatedAt":"2013-09-30T11:05:59.136Z","objectId":"4dQuTdCFZC"}]}
		ArrayList<IssueField> issueFieldsArrayList = new ArrayList<IssueField>();

		JSONObject json;
		try {
			json = new JSONObject(jsonResponse);
			JSONArray jsonArray = json.getJSONArray("results");
			for (int count = 0; count < jsonArray.length(); count++) {
				String label = null;
				String type = null;
				String[] options = null;
				IssueField issueField = null;
				JSONObject jsonObject = jsonArray.getJSONObject(count);

				label = jsonObject.getString(PassConstants.ISSUEFIELD_LABEL);
				type = jsonObject.getString(PassConstants.ISSUEFIELD_TYPE);
				if (label != null || type != null) {
					issueField = new IssueField();
					issueField.setLabel(label);
					if(type.equalsIgnoreCase("text"))
						issueField.setType(TYPE.TEXT);
					else if(type.equalsIgnoreCase("dropdown"))
						issueField.setType(TYPE.DROPDOWN);
					else if(type.equalsIgnoreCase("textarea"))
						issueField.setType(TYPE.TEXTAREA);
					
					issueFieldsArrayList.add(issueField);
				}
				
				if (jsonObject.has(PassConstants.ISSUEFIELD_OPTIONS)) {
					JSONArray optionsArray = jsonObject
							.getJSONArray(PassConstants.ISSUEFIELD_OPTIONS);
					if (optionsArray != null && optionsArray.length() > 0) {
						options = new String[optionsArray.length()];
						for (int i = 0; i < optionsArray.length(); i++) {
							String jsObject = optionsArray.getString(i);
							options[i] = jsObject;
						}
						if (options != null && issueField != null) {
							issueField.setOptions(options);
						}
					}
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return issueFieldsArrayList;
	}
}
