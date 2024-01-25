package kr.co.publicvoid.controller.member;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.co.publicvoid.dto.UploadDTO;
import kr.co.publicvoid.service.MemberImageService;
import kr.co.publicvoid.service.MemberService;
import kr.co.publicvoid.util.UploadUtils;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.MemberImageVO;
import kr.co.publicvoid.vo.MemberVO;
import lombok.extern.log4j.Log4j;


@WebServlet("/member/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 11 // 11MB
)
@Log4j
public class MemberUploadController extends HttpServlet {
	
	private MemberService memberService = MemberService.getInstance();
	private MemberImageService memberImageService = MemberImageService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVO loginMember = WebUtils.getLoginMember(req);
		
		if(loginMember == null) {
	    	WebUtils.jsonPrintREST(resp, false, 0, "잘못된 접근입니다", null);
		}
		
		Part filePart = req.getPart("file");
		String originFileName = getFileName(filePart); // 원본 파일명
		
		String fileExtension = getFileExtension(originFileName); // 원본 파일 확장자
		// 파일명은 uuid로 만들 것임
		String storedFileName = UUID.randomUUID().toString() + "." + fileExtension; // 저장 파일명

        try {
            // 파일 업로드를 위한 유틸리티 클래스 사용
            UploadDTO uploadDTO = UploadUtils.uploadFile(filePart, storedFileName, getServletContext());
            
            if(uploadDTO.isSuccess() == false) {
            	WebUtils.jsonPrintREST(resp, false, 0, uploadDTO.getMessage(), null);
            	return;
            }
            
            // 파일이 성공적으로 업로드됐다면 회원 이미지 테이블에 등록한다
            // DB에서 삭제 후 등록하도록 한다
            
            MemberImageVO memberImageVO = MemberImageVO.builder().memberNo(loginMember.getMemberNo()).originFileName(originFileName).storedFileName(storedFileName).build();
            
            boolean result = memberImageService.updateMemberImage(memberImageVO);
            
            if(result) {
            	WebUtils.jsonPrintREST(resp, true, 0, "파일이 성공적으로 업로드되었습니다. 로컬 경로: " + uploadDTO.getLocalFilePath(), uploadDTO);
            	return;
            }else {
            	WebUtils.jsonPrintREST(resp, false, 1, "파일 업로드에 실패했습니다", null);
            	return;
            }
            
        } catch (Exception e) {
        	WebUtils.jsonPrintREST(resp, false, 0, "파일 업로드 에러", e.getMessage());
        	return;
        }

    }
	
	// 파일에서 확장자 구함
	private String getFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return ""; // 파일 이름이 비어있거나 null이면 빈 문자열 반환
        }

        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return ""; // 파일 이름에 점이 없으면 빈 문자열 반환
        }

        return fileName.substring(lastDotIndex + 1).toLowerCase();
    }
	
	// 업로드할 때의 파일명 구함
	private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        int beginIndex = contentDisposition.indexOf("filename=") + 10;
        int endIndex = contentDisposition.length() - 1;

        return contentDisposition.substring(beginIndex, endIndex);
    }
	
	

}














