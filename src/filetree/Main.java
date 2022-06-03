package filetree;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, AWTException {


        List<Integer> a = new LinkedList();
        a.add(1);
        a.add(1);
        a.add(1);
        List<Integer> b = new LinkedList<>(a);

        Path g = Paths.get("C:\\Users\\ASus\\OneDrive\\Рабочий стол\\Check FOP");
        System.out.println(Files.isDirectory(g));
//        FileUtil a = new FileUtil();
        File temp = FileUtil.toFileRepresentation(g);
        Iterator<File> ggg = temp.iterator();
//        File suckMyDick = ggg.next();
//        System.out.println(suckMyDick.iterator().hasNext());
//        System.out.println(suckMyDick.iterator().next());
//
//        System.out.println(suckMyDick.iterator().hasNext());
//        System.out.println(suckMyDick.iterator().next());


        System.out.println(temp.getHeight());
        System.out.println(Files.size(g));

        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());
        System.out.println(ggg.next());








//        Iterator<File> sss = ggg.next().iterator();
//        System.out.println(sss.next());
//        System.out.println(sss.next());










//        File a = new RegularFile(g);
//        List<File> listoffiles = new LinkedList<>();
//        listoffiles.add(a);
//        File b = new Directory(g, listoffiles);


    }
}
