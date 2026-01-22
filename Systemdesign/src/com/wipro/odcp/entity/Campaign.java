package com.wipro.odcp.entity;

public class Campaign {
	private String campaignId;
	private String ownerId;
	private String title;
	private String description;
	private double goalAmount;
	private double collectedAmount;
	private boolean active;
	public Campaign(String campaignId, String ownerId, String title, String description, double goalAmount,
			double collectedAmount, boolean active) {
		super();
		this.campaignId = campaignId;
		this.ownerId = ownerId;
		this.title = title;
		this.description = description;
		this.goalAmount = goalAmount;
		this.collectedAmount = collectedAmount;
		this.active = active;
	}
	public String getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getGoalAmount() {
		return goalAmount;
	}
	public void setGoalAmount(double goalAmount) {
		this.goalAmount = goalAmount;
	}
	public double getCollectedAmount() {
		return collectedAmount;
	}
	public void setCollectedAmount(double collectedAmount) {
		this.collectedAmount = collectedAmount;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
