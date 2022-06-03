package filetree;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Directory extends filetree.File {

    private final List<filetree.File> files;

    public Directory(Path path, List<filetree.File> files) {
        super(path);
        this.files = files;
    }

    @Override
    public Iterator<filetree.File> iterator() {
        // TODO
        return new IteratorForIterable<filetree.File>(this);
    }


    @Override
    public int getHeight() {
        int returnInt = 1;
        for(filetree.File check : this.getFiles())
            if (Files.isDirectory(check.getPath()) && returnInt < 1 + check.getHeight()) {
                returnInt = 1 + check.getHeight();
            }
        if(this.files.size() == 0 ) return 0;
        return returnInt;
    }


    @Override
    public boolean isRegularFile() {
        return false;
    }

    public List<filetree.File> getFiles() {
        return files;
    }
/////////-//////////////-///////////////-//////////////-//////////////-////////////-//////////////-////////-////////-----------------------
    private class IteratorForIterable<File> implements Iterator<filetree.File>{

        List<filetree.File> returnList = new LinkedList<>();

        private void auxConstructor(List<filetree.File> list){

            for(filetree.File iteratorFiles: list){
                returnList.add(iteratorFiles);
                if (iteratorFiles instanceof Directory){

                    List<filetree.File> x =  ((Directory) iteratorFiles).getFiles().stream().toList();

                    auxConstructor(x);
                }
            }
        }

        public IteratorForIterable(filetree.File temp) {
            returnList.add(temp);
            auxConstructor(getFiles());
        }

        @Override
        public boolean hasNext() {
            return returnList.size() != 0;
        }

        @Override
        public filetree.File next() {
            if (!this.hasNext())
                throw new NoSuchElementException();
            else{
                filetree.File tempReturn = returnList.get(0);
                returnList.remove(0);
                return tempReturn;
            }

        }


    }
}

