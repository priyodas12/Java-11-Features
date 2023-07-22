package io.priyotech;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAsString {
    public static void main(String[] args) throws IOException {
        Path filePath= Path.of("src/main/resources/test.txt");
        String stringContent= new String(Files.readAllBytes(Paths.get(filePath.toUri())));
        System.out.println(stringContent);

        String stringDirectContent=Files.readString(filePath);
        System.out.println("\n\n"+stringDirectContent);

        Files.writeString(filePath,stringDirectContent+"\n--------", StandardCharsets.UTF_8 );
        System.out.println("\n"+Files.readString(filePath));
    }
}
