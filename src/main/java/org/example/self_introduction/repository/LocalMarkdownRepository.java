package org.example.self_introduction.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.self_introduction.exception.FileNotFoundException;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Log4j2
@Repository
public class LocalMarkdownRepository implements MarkdownRepository {

    private final Path localDir = Paths.get(System.getProperty("user.dir"), "markdown");

    @Override
    public String getMarkdown(String fileName) {

        try{
            Path file = localDir.resolve(fileName);

            if(!Files.exists(file)){
                log.warn("마크다운 파일이 존재하지 않습니다");
                return "";
            }

            return Files.readString(file);

        }catch (Exception e) {
            throw new FileNotFoundException(fileName);
//            log.error("Error reading markdown file", e);
//            return "";
        }
    }

    @Override
    public void writeMarkdown(String fileName, String markdown) {

        Path file = localDir.resolve(fileName);

        try{
            // 없으면 생성, 있으면 덮어쓰기
            Files.writeString(file,markdown, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            log.info("Markdown을 저장했습니다");

            // 로깅 테스트
            log.info("writeMarkdown() 레파지토리 실행");
            log.debug("writeMarkdown() 실행 전 fileName = {}", fileName);

        }catch (Exception e){

            log.error("마크다운 저장 실패 예외 발생");
            throw new FileNotFoundException(fileName);
        }
    }

    @Override
    public List<String> listMarkdown(String fileName) {

        if(!Files.exists(localDir)){

            log.warn("마크다운 디렉토리가 존재하지 않음");
            return Collections.emptyList();
        }

        try (Stream<Path> stream = Files.list(localDir)){

        }catch (Exception e){

            log.error("<UNK> <UNK> <UNK> <UNK> <UNK>");
        }


        return List.of();
    }

    @Override
    public void deleteMarkdown(String fileName) {

    }
}
