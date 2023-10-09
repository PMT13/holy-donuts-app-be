package net.yorksolutions.teamproject.dto;

import net.yorksolutions.teamproject.models.Category;

import java.util.Set;

public class NewProductRequestDTO {

    public String name;
    public String description;
    public String imgUrl;
    public Double price;
    public Double sale;
    public Set<Category> category;
    public boolean discontinued;

    public Double discount;
}
