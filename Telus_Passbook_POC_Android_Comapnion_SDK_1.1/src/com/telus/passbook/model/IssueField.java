package com.telus.passbook.model;

public class IssueField {

	private int fieldId;
	private int projectId;
	private String label;
	private int languageCode;
	private boolean mandatory;
	private String[] options;
	private int position;
	private TYPE type;
	private String value;

	public enum TYPE {
		TEXT, DROPDOWN, TEXTAREA
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLanguageCode(int languageCode) {
		this.languageCode = languageCode;
	}

	public int getLanguageCode() {
		return languageCode;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String[] getOptions() {
		return options;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public TYPE getType() {
		return type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	};

}
