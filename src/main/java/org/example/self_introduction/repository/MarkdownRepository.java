package org.example.self_introduction.repository;

public interface MarkdownRepository {

    String getMarkdown(String fileName);
    void writeMarkdown(String fileName, String markdown);
}
