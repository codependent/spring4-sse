package com.codependent.spring4.sse.web;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.ClientAbortException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.codependent.spring4.sse.dto.Alert;

@RestController
public class AccountsRestController {

	@RequestMapping("/accounts/alerts")
	public SseEmitter getAccountAlertsNoPathVariable(HttpSession session) {
		
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

		Thread t1 = new Thread(() ->{
			try {
				int i = 0;
				while(++i<=10000){
					Thread.sleep(1000);
					System.out.println("Sending");
					try{
						emitter.send(new Alert((long)i, "Alert message"+i));
					}catch(ClientAbortException cae){
						cae.printStackTrace();
						i = 10000;
					}
				}
				emitter.complete();
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		
		return emitter;
	}
	
	public void sendWhileActiveSession(HttpSession session){
		
	}
}
