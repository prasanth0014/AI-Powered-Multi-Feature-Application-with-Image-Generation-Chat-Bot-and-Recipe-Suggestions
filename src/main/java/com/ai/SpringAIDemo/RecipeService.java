package com.ai.SpringAIDemo;

import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
	
	private org.springframework.ai.chat.model.ChatModel chatModel;
	//private final org.springframework.ai.chat.model.ChatModel;
	public RecipeService(org.springframework.ai.chat.model.ChatModel cm)
	{
		this.chatModel=cm;
	}
	
	String CreateRecipe(String ingredients,String cuisine,String dietaryRestrictions)
	{
		var template ="""
				I want to create a recipe using the following ingerdients :{ingredients},
				The cuisine type i prefer is {cuisine}.
				Please consider the following dietary restrictions :{dietaryRestrictions}.
				Please provide me with a detailed recipe includeing title,list of ingredients , and cooking instructions
				
				""";
		PromptTemplate pt=new PromptTemplate(template);
		Map<String,Object> paams=Map.of("ingredients",ingredients,"cuisine",cuisine,"dietaryRestrictions",dietaryRestrictions);
		Prompt prompt=pt.create(paams);
		/*ChatResponse cr= chatModel.call( new Prompt(
		        req,
		        OpenAiChatOptions.builder()
		            .withModel("gpt-4o")
		            .withTemperature(0.4)
		        .build()
		    ));*/
		return chatModel.call(prompt).getResult().getOutput().getContent(); 
	}

}
