package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Symptoms{
	List<Symptom> items;

	Symptoms(List<String> _symptoms) {
		items = new ArrayList<Symptom>();
		for (String s : _symptoms) {
			// si !(symptom.name) crée le symptom sinon incremente occurence
			boolean isSymptomAlready = false;
			for (Symptom symptom : items) {
				if (s.equals(symptom.name)) {
					symptom.occurences++;
					isSymptomAlready = true;
					break;
				}
			}
			if (!isSymptomAlready) {
				Symptom symptom = new Symptom(s);
				this.items.add(symptom);
			}
		}
		Collections.sort(items, new Sortbyname());
	}
	
	public void createResultOut() {
		FileWriter writer = null;
		try {
				writer = new FileWriter ("result.out");
				for(Symptom symptom:this.items) {
					writer.write(symptom.toString());
					System.out.println(symptom.toString());
				} 
				writer.close();
			}
		catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				
	
	}

}

class Sortbyname implements Comparator<Symptom> {
    public int compare(Symptom a, Symptom b)
    {
        return a.name.compareTo(b.name);
    }
}
