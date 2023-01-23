package com.example.backend.dto;

import lombok.*;

/**
 * packageName : com.example.backend.dto
 * fileName : ResponseMessageDto
 * author : hyuk
 * date : 2023/01/23
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/23         hyuk          최초 생성
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessageDto {
    private String message;
}
