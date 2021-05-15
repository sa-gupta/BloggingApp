package com.cg.blogging.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CommunityDetails {
	private int communityId;
	private String communityName;
	

	private String communityDescription;
	private int totalMembers;
	private int onlineMembers;
	private LocalDateTime createdOn;
	private List<String> postRulesAllowed;
	private List<String> postRulesDisAllowed;
	private List<String> banningPolicy;
	private List<String> flairs;
	
	public CommunityDetails() {}

	
	
	public CommunityDetails(int communityId, String communityName, String communityDescription, int totalMembers,
			int onlineMembers, LocalDateTime createdOn, List<String> postRulesAllowed, List<String> postRulesDisAllowed,
			List<String> banningPolicy, List<String> flairs) {
		this.communityId = communityId;
		this.communityName = communityName;
		this.communityDescription = communityDescription;
		this.totalMembers = totalMembers;
		this.onlineMembers = onlineMembers;
		this.createdOn = createdOn;
		this.postRulesAllowed = postRulesAllowed;
		this.postRulesDisAllowed = postRulesDisAllowed;
		this.banningPolicy = banningPolicy;
		this.flairs = flairs;
	}



	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	
	
	public String getCommunityName() {
		return communityName;
	}



	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}



	public String getCommunityDescription() {
		return communityDescription;
	}

	public void setCommunityDescription(String communityDescription) {
		this.communityDescription = communityDescription;
	}

	public int getTotalMembers() {
		return totalMembers;
	}

	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}

	public int getOnlineMembers() {
		return onlineMembers;
	}

	public void setOnlineMembers(int onlineMembers) {
		this.onlineMembers = onlineMembers;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public List<String> getPostRulesAllowed() {
		return postRulesAllowed;
	}

	public void setPostRulesAllowed(List<String> postRulesAllowed) {
		this.postRulesAllowed = postRulesAllowed;
	}

	public List<String> getPostRulesDisAllowed() {
		return postRulesDisAllowed;
	}

	public void setPostRulesDisAllowed(List<String> postRulesDisAllowed) {
		this.postRulesDisAllowed = postRulesDisAllowed;
	}

	public List<String> getBanningPolicy() {
		return banningPolicy;
	}

	public void setBanningPolicy(List<String> banningPolicy) {
		this.banningPolicy = banningPolicy;
	}

	public List<String> getFlairs() {
		return flairs;
	}

	public void setFlairs(List<String> flairs) {
		this.flairs = flairs;
	}
	
	
}
