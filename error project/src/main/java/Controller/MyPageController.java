package Controller;

import org.springframework.web.bind.annotation.RequestMapping;


public class MyPageController<UserDetail> {
	@RequestMapping(value="/mypage")
	public String mypage(@AuthenticationPrincipal UserDetail userDetail) throws CustomAuthException{
		if(userDetail==null) {
			throw new CustomAuthException("---");
		}
	}	
}

