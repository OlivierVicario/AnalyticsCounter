package com.hemebiotech.analytics;

public class Symptom {
	String name;
	int occurences;

	Symptom(String _name) {
		name = _name;
		occurences = 1;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.occurences+ "\n";
	}
}
