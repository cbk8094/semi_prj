package kr.co.publicvoid.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.imageio.spi.IIORegistry;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.twelvemonkeys.imageio.plugins.webp.WebPImageReaderSpi;

import kr.co.publicvoid.dto.UploadDTO;
import lombok.extern.log4j.Log4j;

@Log4j
public class UploadUtils {
	
	// 로컬 파일 저장 경로를 상수로 지정
	public static final String LOCAL_REPOSITORY = "/resources/upload";
	
	// 파일 업로드에 사용할 문자셋 지정
	public static final String CHARSET = "utf-8";
	
	// 파일 업로드 시 초기 사이즈 임계값 설정
	public static final int INIT_SIZE_THRESHOLD = 1024 * 1024;
	
	// 파일 아이템을 처리하는데 사용할 DiskFileItemFactory 초기화
	private static DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	static {
		// 로컬 저장소 디렉토리 설정
		File file = new File(LOCAL_REPOSITORY);
		diskFileItemFactory.setRepository(file);
		
		// 문자셋 및 초기 사이즈 임계값 설정
		diskFileItemFactory.setDefaultCharset(CHARSET);
		diskFileItemFactory.setSizeThreshold(INIT_SIZE_THRESHOLD);
	}

	// 파일 업로드를 처리하는데 사용할 ServletFileUpload 초기화
	public static ServletFileUpload init() {
		return new ServletFileUpload(diskFileItemFactory);
	}

	// 로컬에 있는 파일을 업로드하는 메서드
	public static void uploadLocalFile(String fileName, String localFilePath, ServletContext servletContext) throws IOException {
		
		// 원본 파일과 대상 파일 경로 생성
		String realPath = servletContext.getRealPath(LOCAL_REPOSITORY);
        Path sourcePath = new File(localFilePath).toPath(); // 원본 파일 경로 생성
        Path destinationPath = new File(realPath, fileName).toPath(); // 업로드 대상 파일 경로 생성

        // 파일 복사 (로컬에서 서버로 파일 업로드), REPLACE_EXISTING은 기존 파일이 있으면 덮어쓰기
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
	
	// 아래와 같은 파일 전송은 HTML <form> 태그에서 enctype="multipart/form-data"를 사용하거나
	// Ajax에서 FormData 객체를 사용하여 파일을 서버로 전송할 때 주로 발생함
	// Part를 직접 처리하여 파일을 로컬에 업로드하는 메서드
	// 일단 이미지만 업로드 가능하게 할 것임
	public static UploadDTO uploadFile(Part filePart, String fileName, ServletContext servletContext) throws IOException {
	    // 로컬 저장소에 저장할 파일 경로 생성
		String realPath = servletContext.getRealPath(LOCAL_REPOSITORY);
	    String filePath = realPath + File.separator + fileName;
	    File file = new File(filePath);
	    
	    UploadDTO uploadDTO = new UploadDTO();
	    
	    // 서버 워크스페이스(웹 어플리케이션에서 바로 접근 가능)와 SVN에 올리기 위한 이클립스 워크스페이스 양쪽에 저장하자

	    // Part에서 입력 스트림을 획득하여 파일을 로컬에 복사
	    try (InputStream input = filePart.getInputStream()) {
	        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    }catch(Exception e) {
	    	uploadDTO.setSuccess(false);
	    	uploadDTO.setMessage(e.getMessage());
	    	return uploadDTO;
	    }

	    // 이미지가 아니라면
	    if(isImageFile(file) == false) {
	    	uploadDTO.setSuccess(false);
	    	uploadDTO.setMessage("이미지 파일이 아닙니다");
	    	return uploadDTO;
	    }

	    uploadDTO.setSuccess(true);
	    uploadDTO.setLocalFilePath(filePath);
	    uploadDTO.setUuid(fileName);
	    // 로컬에 저장된 파일의 경로 반환
	    return uploadDTO;
	}
	
	// 이미지 파일인지 체크함
	public static boolean isImageFile(File file) {
        try {
        	IIORegistry registry = IIORegistry.getDefaultInstance();
            registry.registerServiceProvider(new WebPImageReaderSpi());
            
            // 이미지를 읽어옵니다.
            BufferedImage bufferedImage = ImageIO.read(file);

            if (bufferedImage == null) {
                // 이미지가 null인 경우 WebP 이미지를 지원하는지 다시 확인함.
                return isWebPImage(file);
            }

            // 이미지가 null이 아니면 이미지 파일로 간주함
            return true;

        } catch (IOException e) {
            return false;
        }
    }

	// WebP 파일인지 확인함
	private static boolean isWebPImage(File file) {
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            return bufferedImage != null;

        } catch (IOException e) {
            return false;
        }
    }
}













