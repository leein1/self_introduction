package org.example.self_introduction.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MarkdownDTO extends TimeMetadataDTO{

    String fileName;
    String content;

    private MarkdownDTO(String fileName, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {

        super(createdAt,updatedAt);
        this.fileName = fileName;
        this.content = content;
    }

    // 내가 직접 생성한 파일 -> 시간이 무조건 now()
    public static MarkdownDTO of(String fileName, String content) {

        if(fileName == null || fileName.isBlank()){
            throw new IllegalArgumentException("파일 이름은 없거나 공백일수 없음");
        }

        return new MarkdownDTO(fileName, content,LocalDateTime.now(),LocalDateTime.now());
    }

    // 외부에서 가져온 파일 -> 시간 데이터를 읽어와야 함
    public static MarkdownDTO of(String fileName, String content, TimeMetadataDTO time) {
        // 서비스 계층에서 TimeMetadata.of()로 생성후 매개변수로 따로 전달
        return new MarkdownDTO(fileName, content, time.getCreatedAt(), time.getUpdatedAt());
    }

}
