package org.example.self_introduction.repositoryTests;

import lombok.extern.log4j.Log4j2;
import org.example.self_introduction.repository.LocalMarkdownRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
public class LocalMarkdownRepositoryTests {

    private LocalMarkdownRepository localMarkdownRepository = new LocalMarkdownRepository();

    private final String testFileName = "test.md";


    @Test
    void testGetMarkdown() {
        String markdown = localMarkdownRepository.getMarkdown(testFileName);
        System.out.println("====[마크다운 읽기 결과]====");
        System.out.println(markdown);
        System.out.println("===========================");
    }

    @Test
    void testWriteMarkdown(){
        
        localMarkdownRepository.writeMarkdown("test.md", "write test");
    }

}
