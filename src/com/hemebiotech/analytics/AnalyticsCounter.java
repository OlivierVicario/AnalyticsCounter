package com.hemebiotech.analytics;


import java.util.List;

public class AnalyticsCounter {

	
	/**
	 * @return result.out file from symptom.txt. file contains byline symptom name and occurences number.
	 * @param args
	 */
	public static void main(String args[]) {
		ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> stringSymptoms = readSymptoms.GetSymptoms();
		Symptoms symptoms = new Symptoms(stringSymptoms);
		symptoms.createResultOut();
	}
}
