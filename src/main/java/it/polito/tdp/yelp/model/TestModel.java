package it.polito.tdp.yelp.model;

import java.util.Map;

import it.polito.tdp.yelp.db.YelpDao;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		YelpDao dao = new YelpDao();
		
		Map<String, Business> idMap = dao.getAllBusiness();
		
		model.creaGrafo(idMap.get("kM7mfXS8LgBPjRrqGb6i6g"));
		
//		 LocalDate a = LocalDate.of(2012, 5, 30);
//		 LocalDate b = LocalDate.of(2012, 7, 1);
//		  
//		 System.out.println(a.isBefore(b));
//		 System.out.println(b.isBefore(a));
//		 System.out.println(a.isAfter(b));
//		 System.out.println(b.isAfter(a));
		 
	}

}
