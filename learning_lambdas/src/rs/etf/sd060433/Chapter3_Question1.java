package rs.etf.sd060433;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import rs.etf.sd060433.model.Album;
import rs.etf.sd060433.model.Artist;

public class Chapter3_Question1 {
	
	public int addUp(Stream<Integer> numbers){
		return numbers.reduce(0, (acc, number) -> acc + number);
	}
	
	public List<String> getNamesAndOrigins(List<Artist> artists){
		return artists.stream()
						.flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
						.collect(toList());
		
	}
	
	public List<Album> getAlbumWithAtMostThreeTracks(List<Album> albums){
		return albums.stream()
					.filter(album -> album.getTrackList().size() <= 3)
					.collect(toList());
	}
}	
