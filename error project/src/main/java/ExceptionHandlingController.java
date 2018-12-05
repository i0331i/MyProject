import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import Controller.CustomAuthException;


@RequestMapping("/error")
@Controller
public class ExceptionHandlingController {

	@ExceptionHandler(CustomAuthException.class)
	public ModelAndView LoginAuthError(HttpServletRequest req,  CustomAuthException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
		
	}	

	@ExceptionHandler(value = {TTTTtemp.class})
	@ResponseStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR)
	@ResponseBody()
	public String ajaxException2(TTTTtemp exception, Webrequest request)throws UnsuppertedEncodingException{
		String resultData = URLEncoder.encode(exception.getMessage(), "UTF-8");
        String alertMsg = URLEncoder.encode(exception.getTitle(), "UTF-8");
        return alertMsg;		
		
		/*ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;*/
		
//      return new AjaxResponeData()
//      .setStatus(false)
//      .setAlertFlag(true)
//      .setAlertMsg(alertMsg)
//      .setResponseData(resultData)
//      .parserJsonStr();
	}	
	
	public void test() {
		try {
			UserVO userVO = null;
			UserVO.setAccepAddr1("");
		}catch(Exception e){
	  	 UserVO userVO = new UserVO();
	  	 throws
	  	 .SetMsg("입력하신 데이터가 일치하지 않습니다.");
	  	 SetTitle("숫자를 입력하시오.");
		}
	}		
}

