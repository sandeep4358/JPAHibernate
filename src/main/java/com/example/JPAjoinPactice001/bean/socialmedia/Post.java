package com.example.JPAjoinPactice001.bean.socialmedia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCompleted;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Post")
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PostComment> comments = new ArrayList<>();

	// Constructors, getters and setters removed for brevity
	@Column(name = "published_on")
	private java.sql.Timestamp publishedOn;
	
	///below method is important for bidirecational realation ship for more details chekc the INTERVIEW.XML hIBERNATE021
	public void addComments(PostComment comment) {
		comments.add(comment);
		comment.setPost(this);
	}
	
	public void removeComments(PostComment comment) {
		comments.remove(comment);
		comment.setPost(null);
	}
}