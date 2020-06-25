import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File root = new File("C:\\Dossier1");

        List<File> files = new ArrayList<>(getAllFilesAndFoldersFromFolder(root));

        files.stream().map(File::getAbsolutePath).sorted().forEach(System.out::println);

    }

    private static Collection<File> getAllFilesAndFoldersFromFolder(File dir) {
        Set<File> fileTree = new HashSet<File>();
        if(dir==null||dir.listFiles()==null){
            return fileTree;
        }
        for (File currentFile : Objects.requireNonNull(dir.listFiles())) {
            if (currentFile.isFile()) {
                fileTree.add(currentFile);
            }
            else {
                fileTree.add(currentFile);
                fileTree.addAll(getAllFilesAndFoldersFromFolder(currentFile));
            }
        }
        return fileTree;
    }
}
