package alanbear.sample.spring.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
	
	@RequestMapping(value={"","/","index"},method = RequestMethod.GET )
    @ApiOperation(
            value = "首頁", notes = "首頁"
    )
	public String home(Model model,HttpServletRequest request, HttpServletResponse response){
		return "index/index";
	}
	
}
