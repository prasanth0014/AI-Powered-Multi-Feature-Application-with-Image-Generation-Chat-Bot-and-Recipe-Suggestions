package com.ai.SpringAIDemo;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class imageService {
	@Autowired
	private OpenAiImageModel model;
	
	public ImageResponse generateImage(String prompt)
	{
		return model.call(new ImagePrompt(prompt,OpenAiImageOptions.builder()
				.withModel("dall-e-2")
                .withQuality("hd")
                .withN(2)
                .withHeight(512)
                .withWidth(512).build()));
	}
	public ImageResponse generateImage(String prompt,String Quality,String N,String Height,String Width)
	{
		return model.call(new ImagePrompt(prompt,OpenAiImageOptions.builder()
				.withModel("dall-e-2")
                .withQuality(Quality)
                .withN(Integer.parseInt(N))
                .withHeight(Integer.parseInt(Height))
                .withWidth(Integer.parseInt(Width)).build()));
	}

}
