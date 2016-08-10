package com.codependent.spring4.sse.web;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.codependent.spring4.sse.dto.Alert;

@RestController
public class AccountController {

	@RequestMapping("/accounts/alerts")
	public SseEmitter getAccountAlertsNoPathVariable() {
		
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

		Thread t1 = new Thread(() ->{
			try {
				int i = 0;
				while(++i<=3){
					Thread.sleep(1000);
					emitter.send(new Alert((long)i, "Alert message"+i));
				}
				emitter.complete();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		
		return emitter;
	}
	
}
