package com.ai.SpringAIDemo;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
@RestController
public class GenAIController {
	@Autowired
	ChatService cs;
	
	@Autowired
	imageService is;
	@Autowired
	RecipeService rs;
	
	public GenAIController(ChatService cs)
	{
		this.cs=cs;
	}
	@GetMapping("/ask-ai")
	public String getResponse(@RequestParam String prompt)
	{
		return cs.response(prompt);
	}
	
	@GetMapping("/ask-aioptions")
	public String getResponseOptions(@RequestParam String prompt)
	{
		return cs.responseOptions(prompt);
	}
	
//	@GetMapping("/ask-aiimage")
//	public void generateImage(HttpServletResponse res, @RequestParam String prompt) throws IOException
//	{
//		ImageResponse ir= is.generateImage(prompt);
//		String url= ir.getResult().getOutput().getUrl();
//		res.sendRedirect(url);
//	}
	
	@GetMapping("/ask-aiimage")
	public List<String> generateImage(HttpServletResponse res, @RequestParam String prompt) throws IOException
	{
		ImageResponse ir= is.generateImage(prompt);
		//String url= ir.getResult().getOutput().getUrl();
		List<String> l=ir.getResults().stream().map(r->r.getOutput().getUrl()).toList();
		//res.sendRedirect(url);
		return l;
	}
	
	@GetMapping("/ask-aiimagewithparam")
	public List<String> generateImagewithParam(HttpServletResponse res, @RequestParam String prompt, @RequestParam(defaultValue = "hd") String Quality,@RequestParam(defaultValue = "1") String N,@RequestParam(defaultValue = "512") String Height,@RequestParam(defaultValue = "512") String width) throws IOException
	{
		ImageResponse ir= is.generateImage(prompt,Quality,N,Height,width);
		//String url= ir.getResult().getOutput().getUrl();
		List<String> l=ir.getResults().stream().map(r->r.getOutput().getUrl()).toList();
		//res.sendRedirect(url);
		return l;
	}
	@GetMapping("/ask-recipe")
	public String generateRecipe(@RequestParam String ingredients,@RequestParam String cuisine,@RequestParam String dietaryRestrictions )
	{
		return rs.CreateRecipe(ingredients, cuisine, dietaryRestrictions);
	}
	

}
