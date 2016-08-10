package com.codependent.spring4.sse.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountsController {
	
	@RequestMapping("/index")
	public String accountsIndex() {
		return "index";
	}
	
}
