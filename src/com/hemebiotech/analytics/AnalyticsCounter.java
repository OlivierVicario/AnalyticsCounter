package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {

	
	public static void main(String args[]) throws IOException {	
		//Instantiation du constructeur vide
		AnalyticsCounter analyticsCounter=new AnalyticsCounter();
		//Appel de la fonction qui renvoie la map des sympt�mes
		Map<String, Long> outputMap=analyticsCounter.findOutputMapFromFile();
		//Affichage de la map des sympt�mes
		analyticsCounter.createResultOut(outputMap);
	}
	
	/**
	 * Cette m�thode construit une map � partir d'un fichier
	 * @return
	 * @throws IOException
	 */
	public Map<String, Long> findOutputMapFromFile() throws IOException{
		ISymptomReader iSymptomReader=new ReadSymptomDataFromFile("symptoms.txt");
		//Appel de la fonction getSymptoms � partir de l'interface
		List<String> items=iSymptomReader.getSymptoms();
		//java 8 : grouper le contenu du fichier
		Map<String, Long> itemsGroupedMap =items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//d�clarer une map
		Map<String, Long> outputMap = new LinkedHashMap<>();
        //Trier itemsGroupedMap et l'affecter � outputMap		
		itemsGroupedMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> outputMap.put(x.getKey(), x.getValue()));
        return outputMap;
	}
	
	public void createResultOut(Map<String, Long> mapFileItems) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("result.out");
			//parcourir la map et afficher la cl� et la valeur
			for (Map.Entry entry : mapFileItems.entrySet()) {
				writer.write(entry.getKey() + " : " + entry.getValue()+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	
	}
}
