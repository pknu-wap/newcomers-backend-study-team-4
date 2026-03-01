package org.example.backendstudy.global.apiPayload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiMeta {
    private int totalPage; //전체 페이지 수
    private Long totalCount; //전체 데이터 수
}
