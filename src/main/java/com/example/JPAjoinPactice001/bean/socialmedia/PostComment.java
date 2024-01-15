package com.example.JPAjoinPactice001.bean.socialmedia;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity(name = "PostComment")
@Table(name = "post_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostComment {
 
    @Id
    @GeneratedValue
    private Long id;
 
    private String review;
    
	@JoinColumn(name = "fk_post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((post == null) ? 0 : post.hashCode());
//		result = prime * result + ((review == null) ? 0 : review.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		PostComment other = (PostComment) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (post == null) {
//			if (other.post != null)
//				return false;
//		} else if (!post.equals(other.post))
//			return false;
//		if (review == null) {
//			if (other.review != null)
//				return false;
//		} else if (!review.equals(other.review))
//			return false;
//		return true;
//	}
 
   
}
