package com.skilldistillery.wine.data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Wine {
    private int id;
    @Size(min=2, max=100, message="Pick a name between 2 and 100 characters.")
    private String name;
    @Min(value = 0, message="Minimum bottle size is 0.")
    @Max(value= 1000, message ="Max bottle size is 1000.")
    private double bottlesize;
    private double abv;
    private double price;
    private String imageName;
    

    public Wine(int id, String name, double bottlesize, double abv, double price, String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.bottlesize = bottlesize;
		this.abv = abv;
		this.price = price;
		this.imageName = imageName;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Wine(int id, String name, double bottlesize, double abv, double price) {
		super();
		this.id = id;
		this.name = name;
		this.bottlesize = bottlesize;
		this.abv = abv;
		this.price = price;
	}

	public Wine() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Wine other = (Wine) obj;
        if (id != other.id)
            return false;
        return true;
    }

   

    @Override
	public String toString() {
		return "Wine [id=" + id + ", name=" + name + ", bottlesize=" + bottlesize + ", abv=" + abv + ", price=" + price
				+ "]";
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


	public double getBottlesize() {
		return bottlesize;
	}

	public void setBottlesize(double bottlesize) {
		this.bottlesize = bottlesize;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

}