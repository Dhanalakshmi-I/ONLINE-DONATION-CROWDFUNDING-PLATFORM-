package com.wipro.odcp.service;

import java.util.ArrayList;
import com.wipro.odcp.entity.*;
import com.wipro.odcp.util.*;

public class CrowdfundingService {

    private ArrayList<User> users;
    private ArrayList<Campaign> campaigns;
    private ArrayList<Contribution> contributions;

    public CrowdfundingService(ArrayList<User> users,
                               ArrayList<Campaign> campaigns,
                               ArrayList<Contribution> contributions) {
        this.users = users;
        this.campaigns = campaigns;
        this.contributions = contributions;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User findUser(String userId) throws UserNotFoundException {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return u;
            }
        }
        throw new UserNotFoundException();
    }

    public void createCampaign(Campaign c) throws UserNotFoundException {
        findUser(c.getOwnerId()); 
        c.setCollectedAmount(0);
        c.setActive(true);
        campaigns.add(c);
    }

    public Campaign findCampaign(String campaignId)
            throws CampaignNotFoundException {
        for (Campaign c : campaigns) {
            if (c.getCampaignId().equals(campaignId)) {
                return c;
            }
        }
        throw new CampaignNotFoundException();
    }

    public void contribute(String contributionId, String userId,
                           String campaignId, double amount, String date)
            throws UserNotFoundException,
                   CampaignNotFoundException,
                   InvalidContributionException {

        findUser(userId);
        Campaign campaign = findCampaign(campaignId);

        if (!campaign.isActive() || amount <= 0) {
            throw new InvalidContributionException();
        }

        Contribution con = new Contribution(
                contributionId, userId, campaignId, amount, date);

        contributions.add(con);
        campaign.setCollectedAmount(
                campaign.getCollectedAmount() + amount);
    }

    public ArrayList<Contribution> getContributionsForCampaign(String campaignId) {
        ArrayList<Contribution> list = new ArrayList<>();
        for (Contribution c : contributions) {
            if (c.getCampaignId().equals(campaignId)) {
                list.add(c);
            }
        }
        return list;
    }

    public ArrayList<Contribution> getContributionsByUser(String userId) {
        ArrayList<Contribution> list = new ArrayList<>();
        for (Contribution c : contributions) {
            if (c.getUserId().equals(userId)) {
                list.add(c);
            }
        }
        return list;
    }

    public void closeCampaign(String campaignId)
            throws CampaignNotFoundException {
        Campaign c = findCampaign(campaignId);
        c.setActive(false);
    }

    public String generateCampaignSummary(String campaignId)
            throws CampaignNotFoundException {

        Campaign c = findCampaign(campaignId);
        double percent = (c.getCollectedAmount() / c.getGoalAmount()) * 100;

        return "Campaign ID: " + c.getCampaignId() +
               "\nTitle: " + c.getTitle() +
               "\nGoal Amount: " + c.getGoalAmount() +
               "\nCollected Amount: " + c.getCollectedAmount() +
               "\nProgress: " + String.format("%.2f", percent) + "%" +
               "\nStatus: " + (c.isActive() ? "Active" : "Closed");
    }
}