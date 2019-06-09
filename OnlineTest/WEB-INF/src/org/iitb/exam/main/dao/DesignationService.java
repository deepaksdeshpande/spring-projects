package org.iitb.exam.main.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.iitb.exam.main.dto.Designation;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationService {
	ArrayList<Designation> fetchDesignation(int advtId);
	ArrayList<Designation> getDesignationsByAdvtId(int advtId);
	List<Designation> getDesignationDetails(Set<String> desgNameList);
}