package com.codingdojo.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			
			@NotNull (message="Please provide a name")
			 @Size(min = 3, max = 200, message="Please provide valid name between 3-200 characters")
			 private String name;
			 
			@NotNull (message="Please provide amount")
			@Min(value=1, message="Must have an amount of greater than 1")
			private Integer rating;
			 
			 
			 @NotNull (message="Please provide vendor")
		    @Size(min = 3, max = 40)
		    private String artist;

		 
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
			 
			 
		public Song() {
			
		}
		
		 @PrePersist
		    protected void onCreate() {
		    	this.createdAt=new Date();
		    }
		    
		    @PreUpdate
		    protected void onUpdate() {
		    	this.updatedAt=new Date();
		    }

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Integer getRating() {
				return rating;
			}

			public void setRating(Integer rating) {
				this.rating = rating;
			}

			public String getArtist() {
				return artist;
			}

			public void setArtist(String artist) {
				this.artist = artist;
			}

			public Date getCreatedAt() {
				return createdAt;
			}

			public void setCreatedAt(Date createdAt) {
				this.createdAt = createdAt;
			}

			public Date getUpdatedAt() {
				return updatedAt;
			}

			public void setUpdatedAt(Date updatedAt) {
				this.updatedAt = updatedAt;
			}
		    
		    
}