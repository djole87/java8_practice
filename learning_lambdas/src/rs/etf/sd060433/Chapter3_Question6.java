package rs.etf.sd060433;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Chapter3_Question6 {
	
	public static int countLowercaseLetters(String string){
		//chars method makes char stream from the string
		return (int) string.chars()
				.filter(Character::isLowerCase)
				.count();
	}
	
	public static Optional<String> getLongestWord(List<String> words){
		return words.stream()
				.max(Comparator.comparing(Chapter3_Question6::countLowercaseLetters));
		
	}
	
	public static void main(String[] args) {
		System.out.println(countLowercaseLetters("Zivotic Aleksandar"));
	}
	
}
