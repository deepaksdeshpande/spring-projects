
package org.iitb.exam.main.dao;


import java.util.ArrayList;

import org.iitb.exam.main.dto.Advertisements;

public interface AdvertisementService {
	Advertisements fetchAdvertisements(int advtId);
	ArrayList<Advertisements> getAllAdvertisementNames();
	
	public void createAdvertisements(Advertisements advertisements);
	public ArrayList<Advertisements> updateAdvertisements(Integer advtId);
	
}

