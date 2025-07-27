package org.example.self_introduction.Service;

import java.util.List;

public interface MarkdownService {

    List<String> listMarkdown(String fileName);
    String getMarkdown(String fileName);
    void writeMarkdown(String fileName, String content);
    void deleteMarkdown(String fileName);
}
