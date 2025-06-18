package org.example.self_introduction.repositoryTests;

import lombok.extern.log4j.Log4j2;
import org.example.self_introduction.repository.LocalMarkdownRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Log4j2
@SpringBootTest
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class LocalMarkdownRepositoryTests {

//    private LocalMarkdownRepository localMarkdownRepository = new LocalMarkdownRepository();
    @Autowired
    private LocalMarkdownRepository localMarkdownRepository;


    private final String testFileName = "test.md";


    @Test
    public void testGetMarkdown() {
        String markdown = localMarkdownRepository.getMarkdown(testFileName);
        System.out.println("====[마크다운 읽기 결과]====");
        System.out.println(markdown);
        System.out.println("===========================");
    }

    @Test
    public void testWriteMarkdown(){
        
        localMarkdownRepository.writeMarkdown("test.md", "write test");
    }

}
