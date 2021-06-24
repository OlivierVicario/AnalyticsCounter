package com.hemebiotech.analytics;

/**
 * 
 * Symptom container of name and occurences number for each distinct symptom in symptoms.txt
 * Symptom is create when a first occurence is encoutered in symptoms.txt.
 */
public class Symptom {
	private String name;
	int occurences;

	Symptom(String _name) {
		name = _name;
		occurences = 1;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.occurences+ "\n";
	}
}
