package org.example.self_introduction.repositoryTests;

import lombok.extern.log4j.Log4j2;
import org.example.self_introduction.dto.ErrorResponseDTO;
import org.example.self_introduction.handler.GlobalExceptionHandler;
import org.example.self_introduction.repository.LocalMarkdownRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Log4j2
@SpringBootTest
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LocalMarkdownRepositoryTests {

//    private LocalMarkdownRepository localMarkdownRepository = new LocalMarkdownRepository();
    @Autowired
    private LocalMarkdownRepository localMarkdownRepository;


    private final String testFileName = "test.md";
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();


    @Test
    public void testGetMarkdown() {
        String markdown = localMarkdownRepository.getMarkdown(testFileName);
        System.out.println("====[마크다운 읽기 결과]====");
        System.out.println(markdown);
        System.out.println("===========================");
    }

    @Test
    public void testWriteMarkdown(){
        
        localMarkdownRepository.writeMarkdown("test2.md", "write test2");
//        throw new IllegalArgumentException("<UNK> <UNK> <UNK>");
    }

    @Test
    public void testHandleBadRequest() {
        // given
        IllegalArgumentException ex = new IllegalArgumentException("테스트 예외 메시지");

        // WebRequest 객체를 만들어야 GlobalExceptionHandler 내부 로직이 정상 동작함
        MockHttpServletRequest servletRequest = new MockHttpServletRequest();
        servletRequest.setRequestURI("/test-uri");
        WebRequest request = new ServletWebRequest(servletRequest);

        // when
        ResponseEntity<ErrorResponseDTO> response = handler.handleBadRequest(ex, request);

        // then
        System.out.println("====[예외 응답 결과]====");
        System.out.println("전체 응답: " + response);
        System.out.println("상태 코드: " + response.getStatusCode());
        System.out.println("예외 메시지: " + response.getBody().getMessage());
        System.out.println("요청 경로: " + response.getBody().getPath());
        System.out.println("=======================");
    }

    @Test
    public void testListMarkdown(){

        List list = localMarkdownRepository.listMarkdown();

        log.info(list.toString());
    }

    @Test
    public void testDeleteMarkdown(){

        String fileName = "test2.md";

        localMarkdownRepository.deleteMarkdown(fileName);
    }

}
