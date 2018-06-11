package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = { "Beware of the wolf in sheep's clothing", "Diligence is teh mother of good luck",
			"The hourney is the reward" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		return data[myRandom.nextInt(data.length)];
	}

}
