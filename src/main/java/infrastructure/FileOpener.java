package infrastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileOpener {

    public List<String> readFile(String fileName) throws UnreadableFile {
        List<String> mapLines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                mapLines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " could not be found");
            throw new UnreadableFile();
        } catch (IOException exception) {
            System.out.println("An issue occurred while reading the file : ");
            exception.printStackTrace();
            throw new UnreadableFile();
        }
        return mapLines;
    }

    public List<String> readResource(String defaultFileName) {
        List<String> mapLines = new ArrayList<>();
        try {
            URI filePath = Objects.requireNonNull(getClass().getResource(defaultFileName)).toURI();
            Stream<String> lines = Files.lines(Paths.get(filePath));
            mapLines = lines.toList();
            lines.close();
        } catch (IOException exception) {
            System.out.println("An issue occured while reading the file : ");
            exception.printStackTrace();
        } catch (URISyntaxException exception) {
            System.out.println("An issue occured while opening the file : ");
            exception.printStackTrace();
        }
        return mapLines;
    }
}
