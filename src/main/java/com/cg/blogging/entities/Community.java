package com.cg.blogging.entities;

import java.time.LocalDateTime;
//import java.io.File;
//import java.time.LocalDate;
//import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

//import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.cg.blogging.util.StringListConverter;

/**
 * <h1>Community Class</h1>
 * <p>
 * This class provides details regarding the 
 * communities that are present for the user:blogger 
 * to be a part of it.
 * The guidelines which are used by 
 * moderator for post/comment shadowing. 
 * 
 * @author SKSSS
 *
 */
@Entity
@Table
public class Community {
	@Id
	@SequenceGenerator(allocationSize=1, name="seq1", sequenceName="community_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private int communityId;
	@Size(min = 5, max = 40, message = "Comment description should be between 5 to 40 characters long")
	private String communityDescription;
	private int totalMembers;
	private int onlineMembers;
//	private File image;
//	@Temporal(TemporalType.DATE)
//	@CreationTimestamp
	@UpdateTimestamp
	private LocalDateTime createdOn;
	@Convert(converter = StringListConverter.class)
	private List<String> postRulesAllowed;
	@Convert(converter = StringListConverter.class)
	private List<String> postRulesDisAllowed;
	@Convert(converter = StringListConverter.class)
	private List<String> banningPolicy;
	@Convert(converter = StringListConverter.class)
    private List<String> flairs;
	/**
	 * Community class constructor.
	 */
	public Community() {}
	/**
	 * 
	 * <p>
	 * Community class constructor
	 * to create a community 
	 * by passing one argument.
	 * 
	 * @param communityId
	 */
	public Community(int communityId) {
		this.communityId = communityId;
	}
	
	/**
	 * <p>
	 * Community class constructor
	 * to create a community 
	 * by passing these arguments.
	 * 
	 * @param communityDescription
	 * @param totalMembers
	 * @param onlineMembers
	 * @param createdOn
	 * @param postRulesAllowed
	 * @param postRulesDisAllowed
	 * @param banningPolicy
	 * @param flairs
	 */
	public Community(String communityDescription, int totalMembers, int onlineMembers,
			LocalDateTime createdOn, List<String> postRulesAllowed, List<String> postRulesDisAllowed,
			List<String> banningPolicy, List<String> flairs) {
		this.communityDescription = communityDescription;
		this.totalMembers = totalMembers;
		this.onlineMembers = onlineMembers;
		this.createdOn = createdOn;
		this.postRulesAllowed = postRulesAllowed;
		this.postRulesDisAllowed = postRulesDisAllowed;
		this.banningPolicy = banningPolicy;
		this.flairs = flairs;
	}
	
	/**
	 * <p>
	 * Community class constructor
	 * to create a community 
	 * by passing these arguments.
	 * 
	 * @param communityId
	 * @param communityDescription
	 * @param totalMembers
	 * @param onlineMembers
	 * @param createdOn
	 * @param postRulesAllowed
	 * @param postRulesDisAllowed
	 * @param banningPolicy
	 * @param flairs
	 */
	public Community(int communityId,String communityDescription, int totalMembers, int onlineMembers,
			LocalDateTime createdOn, List<String> postRulesAllowed, List<String> postRulesDisAllowed,
			List<String> banningPolicy, List<String> flairs) {
		this.communityId = communityId;
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

	@Override
	public String toString() {
		return "Community [communityId=" + communityId + ", communityDescription=" + communityDescription
				+ ", totalMembers=" + totalMembers + ", onlineMembers=" + onlineMembers + ", createdOn=" + createdOn
				+ ", postRulesAllowed=" + postRulesAllowed + ", postRulesDisAllowed=" + postRulesDisAllowed
				+ ", banningPolicy=" + banningPolicy + ", flairs=" + flairs + "]";
	}
    
	
	
	
}
