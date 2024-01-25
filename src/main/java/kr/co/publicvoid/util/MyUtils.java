package kr.co.publicvoid.util;

// 내 유틸
public class MyUtils {
	// 파일명에서 확장자 추출
	public static String extractFileExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}
}
