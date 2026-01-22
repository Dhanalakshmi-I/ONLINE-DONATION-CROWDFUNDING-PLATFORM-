package com.wipro.odcp.main; 
 
import java.util.ArrayList; import com.wipro.odcp.entity.*; import com.wipro.odcp.service.CrowdfundingService; import com.wipro.odcp.util.*; 
 
public class Main {     public static void main(String[] args) { 
 
        ArrayList<User> users = new ArrayList<>();         users.add(new User("U001", "Ravi Kumar", "ravi@gmail.com")); 
 
        ArrayList<Campaign> campaigns = new ArrayList<>(); 
        ArrayList<Contribution> contributions = new ArrayList<>(); 
 
        CrowdfundingService service = new CrowdfundingService(users, campaigns, contributions); 
 
        try { 
            // Create campaign 
            Campaign c1 = new Campaign("C001", "U001", "Flood Relief Fund",  
                                       "Raising money for families affected by floods",  
                                       50000, 0, true); 
            service.createCampaign(c1); 
 
            // Make contributions             service.contribute("CN001", "U001", "C001", 5000, "2025-08-11"); 
 
            // Summary 
            System.out.println("\n--- Campaign Summary ---"); 
            System.out.println(service.generateCampaignSummary("C001")); 
 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
} 
