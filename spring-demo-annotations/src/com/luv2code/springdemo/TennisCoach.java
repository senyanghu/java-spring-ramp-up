package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component("thatSillyCoach")
// the default bean id is tennisCoach
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	// @Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	// default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
	
	/**
	 * // define a setter method
	 * 
	 * @Autowired public void setFortuneService(FortuneService
	 *            theFortuneService) { System.out.println(">> TennisCoach:
	 *            inside setFortuneService() method"); fortuneService =
	 *            theFortuneService; }
	 */

	/**
	 * // define any method with auto wire
	 * 
	 * @Autowired public void doCrazyStuff(FortuneService theFortuneService) {
	 *            System.out.println(">> TennisCoach: inside doCrazyStuff()
	 *            method"); fortuneService = theFortuneService; }
	 */

	/**
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 *            fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley - tennis coach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
