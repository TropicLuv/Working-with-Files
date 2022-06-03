package filetree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtil {

    private static List<filetree.File> auxMethod(Path path) throws IOException {
        List<filetree.File> returnList = new LinkedList<>();
        List<Path> temp = Files.walk(path, 1).collect(Collectors.toList());
        temp.remove(path);

        for(Path p : temp){
            if (Files.isRegularFile(p))
                returnList.add(new RegularFile(p));
            else if (Files.isDirectory(p)){
                filetree.File toAdd = new Directory(p, auxMethod(p));
                returnList.add(toAdd);
            }
        }
        return returnList;
    }

    public static filetree.File toFileRepresentation(Path path) throws IOException {
        if (Files.isRegularFile(path))
            return new RegularFile(path);
        else{

            return new Directory(path, auxMethod(path));
        }
    }
}
