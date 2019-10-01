package fr.clement.entities;

import javafx.beans.property.SimpleStringProperty;

public class RecetteBean {
	private SimpleStringProperty receipeName;
	private SimpleStringProperty receipeDecr;
	
	public RecetteBean(String nom, String descr) {
		this.receipeName=new SimpleStringProperty(nom);
		this.receipeDecr=new SimpleStringProperty(descr);
	}

	public String getReceipeName() {
		return receipeName.get();
	}

	public String getReceipeDecr() {
		return receipeDecr.get();
	}
	public void setReceipeName(String receipeName) {
		this.receipeName.set(receipeName);
	}

	public void setReceipeDecr(String receipeDecr) {
		this.receipeDecr.set(receipeDecr);
	}
	
}
