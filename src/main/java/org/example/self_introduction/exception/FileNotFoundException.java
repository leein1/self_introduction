package org.example.self_introduction.exception;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String filename) {

        super(filename + " 파일을 찾을 수 없습니다.");
    }
}
