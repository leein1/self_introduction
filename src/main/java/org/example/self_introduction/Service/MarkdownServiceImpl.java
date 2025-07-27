package org.example.self_introduction.Service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.example.self_introduction.repository.MarkdownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class MarkdownServiceImpl implements MarkdownService {

    private final MarkdownRepository markdownRepository;

    @Override
    public List<String> listMarkdown(String fileName) {
        log.info("마크다운 목록 조회 요청");
        return markdownRepository.listMarkdown();
    }

    @Override
    public String getMarkdown(String fileName) {
        log.info("마크다운 조회 요청: {}", fileName);
        return markdownRepository.getMarkdown(fileName);

    }

    @Override
    public void writeMarkdown(String fileName, String content) {
        log.info("마크다운 저장 요청: {}", fileName);
        markdownRepository.writeMarkdown(fileName, content);
    }

    @Override
    public void deleteMarkdown(String fileName) {
        log.info("마크다운 삭제 요청: {}", fileName);
        markdownRepository.deleteMarkdown(fileName);
    }
}
