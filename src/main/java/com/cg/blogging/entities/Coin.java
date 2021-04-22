package com.cg.blogging.entities;

public enum Coin {

	SILVER(200), GOLD(500), PLATINUM(700), REGULAR(100);

	private int value;

	Coin(int i) {
		this.value = i;

	}
}
