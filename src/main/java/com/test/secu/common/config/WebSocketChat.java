package com.test.secu.common.config;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.secu.common.vo.ChatVO;

import lombok.extern.slf4j.Slf4j;

@Component
@ServerEndpoint("/chat/{name}")
@Slf4j
public class WebSocketChat {	
	private static Map<String,Session> sessionMap=
			Collections.synchronizedMap(new HashMap<>());
	private static Set<String> names=
			Collections.synchronizedSet(new HashSet<>());
	
	
	private ObjectMapper om = new ObjectMapper(); 
	
	@OnOpen 
	public void open(Session session, EndpointConfig ec, @PathParam("name")String name) throws IOException {
		if(!names.add(name)) {	//중복이라면
			ChatVO chat=new ChatVO();
			chat.setErrMsg(name+"은 이미 중복된 이름입니다.");
			sendMsg(session,chat);
			session.close();
		}
		sessionMap.put(session.getId(), session);
		log.info("open sessionMap=>{}",sessionMap);
	}
	
	private void sendMsg(Session session,ChatVO chat) throws IOException {
		String json=om.writeValueAsString(chat);
		session.getBasicRemote().sendText(json);
	}
	
	private void sendMsg(Session session,String msg) throws IOException {
		session.getBasicRemote().sendText(msg);
	}

	
	@OnMessage
	public void msg(String msg, Session session) throws IOException {
		Iterator<String> it=sessionMap.keySet().iterator();
		while(it.hasNext()) {
			String key=it.next();
			if(!key.equals(session.getId())) {
				Session targetSession=sessionMap.get(key);
				targetSession.getBasicRemote().sendText(msg); //exception 강요로 에러 발생
			}
		}
	}
	
	@OnClose
	public void close(Session session) {
		sessionMap.remove(session.getId());
		log.info("close sessionMap=>{}",sessionMap);
	}
}
