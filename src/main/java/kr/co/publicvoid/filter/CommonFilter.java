package kr.co.publicvoid.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import kr.co.publicvoid.service.MemberImageService;
import kr.co.publicvoid.util.WebUtils;
import kr.co.publicvoid.vo.MemberImageVO;
import kr.co.publicvoid.vo.MemberVO;

@WebFilter(urlPatterns = "*", initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class CommonFilter implements Filter{
	private MemberImageService memberImageService = MemberImageService.getInstance();
	
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
		
		// 컨텍스트 패스 편하게 접근하기 설정
		filterConfig.getServletContext().setAttribute("cp", filterConfig.getServletContext().getContextPath());
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		
		// 요청 인코딩을 utf-8로 지정
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
	}
}


