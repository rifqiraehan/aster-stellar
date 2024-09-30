package com.project.belajarapistar.data.model;

import com.google.gson.annotations.SerializedName;

public class StarItem{
	@SerializedName("right_ascension")
	private String rightAscension;

	@SerializedName("declination")
	private String declination;

	@SerializedName("constellation")
	private String constellation;

	@SerializedName("absolute_magnitude")
	private String absoluteMagnitude;

	@SerializedName("name")
	private String name;

	@SerializedName("apparent_magnitude")
	private String apparentMagnitude;

	@SerializedName("spectral_class")
	private String spectralClass;

	@SerializedName("distance_light_year")
	private String distanceLightYear;

	public String getRightAscension(){
		return rightAscension;
	}

	public String getDeclination(){
		return declination;
	}

	public String getConstellation(){
		return constellation;
	}

	public String getAbsoluteMagnitude(){
		return absoluteMagnitude;
	}

	public String getName(){
		return name;
	}

	public String getApparentMagnitude(){
		return apparentMagnitude;
	}

	public String getSpectralClass(){
		return spectralClass;
	}

	public String getDistanceLightYear(){
		return distanceLightYear;
	}
}
