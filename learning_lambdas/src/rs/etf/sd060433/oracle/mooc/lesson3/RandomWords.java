package rs.etf.sd060433.oracle.mooc.lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class to generate a list of random words
 *
 * @author Djordje
 */
public class RandomWords {
	
	private final List<String> sourceWords;

	  /**
	   * Constructor
	   * 
	   * @throws IOException If the source words file cannot be read
	   */
	  public RandomWords() throws IOException {
		  try(BufferedReader reader = Files.newBufferedReader(Paths.get("learning_lambdas/resources/words.txt"))){
			  sourceWords = reader.lines()
					  				.collect(Collectors.toList());
		  }
		  
		  System.out.println("Loaded " + sourceWords.size() + " words");
	  }
	  
	  /**
	   * Create a list of a given size containing random words
	   *
	   * @param listSize The size of the list to create
	   * @return The created list
	   */
	  public List<String> createList(int listSize) {
		  Random random = new Random();
		  
		  return random.ints(listSize, 0, sourceWords.size())
		  			.mapToObj(sourceWords::get)
		  			.collect(Collectors.toList());
		  			
	  }
	  
	  /**
	   * Return the list of all source words, which cannot be modified
	   *
	   * @return The unmodifiable list of all source words
	   */
	  public List<String> allWords() {
		  return Collections.unmodifiableList(sourceWords);
	  }
	  
	  
}
