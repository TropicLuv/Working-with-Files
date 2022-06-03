package filetree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class RegularFile extends filetree.File {

    public RegularFile(Path path) {
        super(path);
    }

    @Override
    public Iterator<filetree.File> iterator() {

        return new IteratorForIterable<>(new RegularFile(getPath()));
    }
    private class IteratorForIterable<File> implements Iterator<File>{


        private final File returnFile;
        private int index = 0;

        public IteratorForIterable(File temp) {
            this.returnFile = temp;
        }

        @Override
        public boolean hasNext() {
            return index == 0;
        }

        @Override
        public File next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }else {
                index = 1;
                return returnFile;
            }
        }
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean isRegularFile() {
        return true;
    }

}