package com.cg.blogging.entities;

import java.util.List;
/**
 * <h1>Award Class</h1>
 * <p>
 * This class used to present 
 * awards to a blogger or a post 
 * by using coins.
 * 
 * @author SKSSS
 *
 */
public class Award {
	private List<Coin> coin;

	public List<Coin> getCoin() {
		return coin;
	}

	public void setCoin(List<Coin> coin) {
		this.coin = coin;
	}

}
