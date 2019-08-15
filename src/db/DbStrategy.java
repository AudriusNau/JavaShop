package db;

import jxl.read.biff.BiffException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DbStrategy<E> {
	void load() ;
	void save();
	List<String[]> getItems();
	void setItems(List<String[]> items);


}
