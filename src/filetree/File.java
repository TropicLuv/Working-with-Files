package filetree;

import java.nio.file.Path;
import java.util.Iterator;

/**
 * Verändern Sie diese Klasse nicht!
 */
public abstract class File implements Iterable<filetree.File> {

    private final Path path;

    public File(Path path) {
        this.path = path;
    }

    public abstract Iterator<filetree.File> iterator();

    public abstract int getHeight();

    public abstract boolean isRegularFile();

    public String toString() {
        return path.toString();
    }

    public Path getPath() {
        return path;
    }

    public String getName() {
        return path.getFileName().toString();
    }

}
