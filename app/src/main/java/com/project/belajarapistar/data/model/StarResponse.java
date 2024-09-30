package com.project.belajarapistar.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StarResponse extends ArrayList<StarItem> {

	private ArrayList<StarItem> star;


	public ArrayList<StarItem> getStar(){
		return star;
	}
}