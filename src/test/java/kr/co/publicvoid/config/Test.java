package kr.co.publicvoid.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import kr.co.publicvoid.util.MybatisUtils;

public class Test {
	public static void main(String[] args) throws IOException {
		Properties properties = new Properties();
		InputStream is = MybatisUtils.class.getResourceAsStream("/config.properties");
		properties.load(is); // 해당 파일로부터 읽어 properties에 넣음
		
		System.out.println(properties);
	}
}
