package rs.etf.sd060433;

import java.util.List;

import rs.etf.sd060433.oracle.mooc.model.Artist;

public class Chapter3_Question2 {
	
	public int countAllBandMembers(List<Artist> artists){
		return artists.stream()
						.map(artist -> artist.getMembers().count())
						.reduce(0L, Long::sum )
						.intValue();
	}
}
