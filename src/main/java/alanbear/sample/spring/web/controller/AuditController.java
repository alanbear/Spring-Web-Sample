package alanbear.sample.spring.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuditController {
	
	@RequestMapping(value={"login"},method = RequestMethod.GET )
    @ApiOperation(value = "登入頁")
	public String login(){
		return "audit/login";
	}
	
}
