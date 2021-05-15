package com.cg.blogging.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.blogging.dto.CommunityDetails;
import com.cg.blogging.entities.Community;

@Component
public class CommunityUtil {

	public CommunityDetails communityToCommunityDetails(Community community) {
		CommunityDetails cDetails = new CommunityDetails(community.getCommunityId(), community.getCommunityName(), community.getCommunityDescription(),
				community.getTotalMembers(), community.getOnlineMembers(), community.getCreatedOn(),
				community.getPostRulesAllowed(), community.getPostRulesDisAllowed(), community.getBanningPolicy(),
				community.getFlairs());
		return cDetails;
	}

	public List<CommunityDetails> communityListToCommunityDetailsList(List<Community> communities){
		List<CommunityDetails> list = communities.stream().map(c -> communityToCommunityDetails(c))
				.collect(Collectors.toList());
		return list;
	}

}
