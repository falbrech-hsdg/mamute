package br.com.caelum.brutal.ads;

import java.util.Random;

import br.com.caelum.brutal.model.LoggedUser;
import br.com.caelum.brutal.model.User;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class BrutalAds {
	
	private final LoggedUser loggedUser;

	public BrutalAds(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public boolean shouldShowAds() {
		if(!loggedUser.isLoggedIn()) return true;
		User current = loggedUser.getCurrent();
		if(current.getKarma() <= 50) return true;
		if(current.getKarma() <= 1000) return shouldShowWithPercentage(20);
		return shouldShowWithPercentage(10);
	}

	private boolean shouldShowWithPercentage(int percentage) {
		return new Random().nextInt(101) <= percentage;
	}
	
	
}