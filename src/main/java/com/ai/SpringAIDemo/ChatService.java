package com.ai.SpringAIDemo;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.*;
import org.springframework.ai.openai.OpenAiChatOptions;
//import org.springframework.ai.openai.api.OpenAiApi.ChatModel;
import org.springframework.stereotype.Service;
@Service


public class ChatService {
	private org.springframework.ai.chat.model.ChatModel chatModel;
	//private final org.springframework.ai.chat.model.ChatModel;
	public ChatService(org.springframework.ai.chat.model.ChatModel cm)
	{
		this.chatModel=cm;
	}
	String response(String req)
	{
		return chatModel.call(req);
	}
	
	String responseOptions(String req)
	{
		ChatResponse cr= chatModel.call( new Prompt(
		        req,
		        OpenAiChatOptions.builder()
		            .withModel("gpt-4o")
		            .withTemperature(0.4)
		        .build()
		    ));
		return cr.getResult().getOutput().getContent(); 
	}
	
	

}
