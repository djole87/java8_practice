package rs.etf.sd060433.oracle.mooc.model;

import static java.util.stream.Stream.concat;

import java.util.stream.Stream;

public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    public default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> {
            return concat(Stream.of(artist), artist.getMembers());
        });
    }

}
