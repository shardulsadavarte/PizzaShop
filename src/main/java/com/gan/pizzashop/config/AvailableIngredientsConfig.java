package com.gan.pizzashop.config;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.gan.pizzashop.util.PizzashopConstants;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Configuration
public class AvailableIngredientsConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(AvailableIngredientsConfig.class);
	
	@Bean(name = "ingredientsMap")
	public HashMap<String, Integer> loadAvailableIngredients() {
		
		HashMap<String, Integer> ingredientsMap = new HashMap<String, Integer>();
		
		try {
		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();
		  try(CSVReader reader = new CSVReaderBuilder(
		          new FileReader(new ClassPathResource(PizzashopConstants.INGREDIENTS_FILE).getFile()))
		          .withCSVParser(csvParser) 
		          .withSkipLines(1)          
		          .build()){
		      List<String[]> r = reader.readAll();
		      r.forEach(x -> ingredientsMap.put(x[0],Integer.parseInt(x[1])));
		  }
		} catch (Exception e) {
			logger.error(PizzashopConstants.ERROR_INGREDIENTS,e);			
		}
		
		return ingredientsMap;
	}
	

}
