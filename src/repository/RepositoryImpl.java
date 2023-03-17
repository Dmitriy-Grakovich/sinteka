package repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Grakovich 17.03.2023
 */
public class RepositoryImpl implements Repository {
    private final Set<String> library;

    public RepositoryImpl() {
        library = new HashSet<>(Arrays.asList("бетон", "цемент", "гипс", "известь","песок", "алебастр"));
    }

    @Override
    public Set<String> getLibrary() {
        return library;
    }
}
