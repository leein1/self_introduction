package org.example.self_introduction.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.self_introduction.exception.FileNotFoundException;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Log4j2
@Repository
public class LocalMarkdownRepository implements MarkdownRepository {

    private final Path localDir = Paths.get(System.getProperty("user.dir"), "markdown");

    @Override
    public String getMarkdown(String fileName) {

        try{
            Path file = localDir.resolve(fileName);

            if(!Files.exists(file)){
                log.warn("Markdown file does not exist");
                return "";
            }

            return Files.readString(file);

        }catch (Exception e){
            throw new FileNotFoundException(fileName);
//            log.error("Error reading markdown file", e);
//            return "";
        }
    }

    @Override
    public void writeMarkdown(String markdown) {

    }
}
