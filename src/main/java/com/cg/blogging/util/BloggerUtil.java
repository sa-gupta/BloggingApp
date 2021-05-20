package com.cg.blogging.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.blogging.dto.BloggerDetails;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
@Component
public class BloggerUtil {

	public List<BloggerDetails> bloggerListToBloggerDetailsList(List<Blogger> list) {
		List<BloggerDetails> dList = list.stream().map(b -> bloggerToBloggerDetails(b)).collect(Collectors.toList());
		return dList;
	}
	
	public BloggerDetails bloggerToBloggerDetails(Blogger blogger) {
		BloggerDetails bDetail = new BloggerDetails(blogger.getUserId(), blogger.getBloggerName(), blogger.getKarma(),
				listOfCommunityName(blogger.getCommunities()));
//		blogger.getCommunities().stream().forEach(c -> System.out.println(c.get));
		return bDetail;
	}
	
	public List<String> listOfCommunityName(List<Community> list){
		List<String> res = list.stream().map(c -> c.getCommunityName()).collect(Collectors.toList());
		return res;
	}

}
