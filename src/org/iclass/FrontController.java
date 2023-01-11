package org.iclass;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*  MVC 패턴 : model(데이터) - view(jsp) - controller(요청처리하는 서블릿)   
 *  spring 프레임워크은 mvc 패턴이 잘 구현된 프레임워크
 */

@WebServlet(urlPatterns = {"/"})  // 모든 요청을 받아 처리하는 서블릿
public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger 
	= LoggerFactory.getLogger(FrontController.class);
	
	@Override   //init() 메소드는 서블릿이 컨테이너에서 실행되기 시작할때 호출
	public void init() throws ServletException {
		RequestControllerMapping.init();   //매핑 초기화 메소드 호출
	}

	@Override
	protected void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		String method = request.getMethod();
		
		RequestKeyValue key = new RequestKeyValue(url, method);
		Controller controller 
		= RequestControllerMapping.getController(key);
		if(controller !=null) {
			logger.info(":::::::::::{}-{}:::::::::",key,controller.getClass());
			controller.handle(request, response);
		}else {
			logger.info("::::::::{} 잘못된 요청입니다. :::::::",key);
			//response.sendRedirect("./");    //상대경로 오류 발생 가능성 있습니다.
			response.sendRedirect(request.getContextPath());
		}
	}
}
