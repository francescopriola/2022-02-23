package it.polito.tdp.yelp.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	private Graph<Review, DefaultWeightedEdge> graph;
	Map<String, Business> idBMap;
	Map<String, Review> idRMap;
	private YelpDao dao;
	private int max;
	
	public Model() {
		dao = new YelpDao();
		max = 0;
		idBMap = dao.getAllBusiness();
		idRMap = dao.getAllReviews();
	}
	
	public List<String> getAllCities(){
		return dao.getAllCities();
	}
	
	public List<Business> getAllBusinessByCity(String city){
		return dao.getAllBusinessByCity(city);
	}
	
	public List<Review> getAllReviewsByBusiness(Business b){
		return dao.getAllReviewsByBusiness(b);
	}
	
	public void creaGrafo(Business b) {
		this.graph = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.graph, this.getAllReviewsByBusiness(b));
		
		for(Arco a : dao.getArchi(idRMap, b)) {
			Graphs.addEdgeWithVertices(this.graph, a.getR1(), a.getR2(), a.getWeight());
		}
		
		System.out.println(this.getVertici());
		System.out.println(this.getArchi());
	}
	
	public String getVertici() {
		return "#Vertici: " + this.graph.vertexSet().size();
	}
	
	public String getArchi() {
		return "#Archi: " + this.graph.edgeSet().size();
	}
	
	public List<Review> getMaxReviews(){
		List<Review> result = new LinkedList<>();
		
		for(Review r : this.graph.vertexSet()) {
			if(this.graph.inDegreeOf(r) > max)
				max = this.graph.inDegreeOf(r);
		}
		
		for(Review r : this.graph.vertexSet()) {
			if(this.graph.inDegreeOf(r) == max)
				result.add(r);
		}
		
		return result;
	}
	
	public int getMax() {
		return this.max;
	}
}
