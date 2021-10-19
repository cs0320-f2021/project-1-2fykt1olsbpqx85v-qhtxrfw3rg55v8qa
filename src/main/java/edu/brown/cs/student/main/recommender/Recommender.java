package edu.brown.cs.student.main.recommender;

import java.util.List;

public interface Recommender<T extends Item> {

  public void loadData();

  public List<T> getTopKRecommendations(T item, int k);
}