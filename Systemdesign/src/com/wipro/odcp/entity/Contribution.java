package com.wipro.odcp.entity;

public class Contribution {
	private String contributionId;
	private String userId ;
	private String campaignId;
	private double amount;
	private String date;
	public Contribution(String contributionId, String userId, String campaignId, double amount, String date) {
		super();
		this.contributionId = contributionId;
		this.userId = userId;
		this.campaignId = campaignId;
		this.amount = amount;
		this.date = date;
	}
	public String getContributionId() {
		return contributionId;
	}
	public void setContributionId(String contributionId) {
		this.contributionId = contributionId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
