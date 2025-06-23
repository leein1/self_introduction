package org.example.self_introduction.repository;

import java.util.List;

public interface MarkdownRepository {

    String getMarkdown(String fileName);
    void writeMarkdown(String fileName, String markdown);
    List<String> listMarkdown(String fileName);
    void deleteMarkdown(String fileName);
}
