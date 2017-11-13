package com.skilldistillery.wine.controllers;

import javax.validation.constraints.NotNull;

/**
 * Form with an ID field.
 * @author chrisgehrke
 *
 */

public class WineIdForm {
	@NotNull
	private Integer id;
	public WineIdForm() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
