package servlet;

import java.util.Date;

public class Review {
	private Integer reviewId;
	private Integer userId;
	private Integer recipeId;
	private Date reviewdate;
	private String recipeReview;
	private String firstname;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Date getReviewdate() {
		return reviewdate;
	}
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	public String getRecipeReview() {
		return recipeReview;
	}
	public void setRecipeReview(String recipeReview) {
		this.recipeReview = recipeReview;
	}
	
	

}
