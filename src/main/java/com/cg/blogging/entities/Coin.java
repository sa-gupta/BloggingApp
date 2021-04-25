package com.cg.blogging.entities;
/**
 * 
 * <p>
 * This tells the values that each
 * coin consists. These coins are used as
 * awards for the users and posts.
 * 
 * @author SKSSS
 *
 */
public enum Coin {

	SILVER(200), GOLD(500), PLATINUM(700), REGULAR(100);

	private int value;

	Coin(int i) {
		this.value = i;

	}
}
