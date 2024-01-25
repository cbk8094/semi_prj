package kr.co.publicvoid.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// API 결과값 반환용 클래스

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestResponseDTO {
	private boolean success; // 성공 여부
	private int errorType; // 에러 타입
	private String message; // 메시지
	private Object data; // 데이터
}
