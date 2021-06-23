package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (EOFException e) {
				//e.printStackTrace();
				System.out.println("Erreur de fin de fichier : " + e.getMessage());
			}catch (FileNotFoundException e) {
				//e.printStackTrace();
				System.out.println("Fichier non trouv� : " + e.getMessage());
			}catch (IOException e) {
				//e.printStackTrace();
				System.out.println("Erreur d'entr�e-sortie : " + e.getMessage());
			}
			
		}
		
		return result;
	}

}
