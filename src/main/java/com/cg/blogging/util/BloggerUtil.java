package com.cg.blogging.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.blogging.dto.BloggerDetails;
import com.cg.blogging.entities.Blogger;
@Component
public class BloggerUtil {

	public List<BloggerDetails> bloggerListToBloggerDetailsList(List<Blogger> list) {
		List<BloggerDetails> dList = list.stream().map(b -> bloggerToBloggerDetails(b)).collect(Collectors.toList());
		return dList;
	}
	
	public BloggerDetails bloggerToBloggerDetails(Blogger blogger) {
		BloggerDetails bDetail = new BloggerDetails(blogger.getUserId(), blogger.getBloggerName(), blogger.getKarma());
		return bDetail;
	}

}
