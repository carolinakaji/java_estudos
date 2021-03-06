package composicao_stringBuilder.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private Date moment;
	private String title;
	private String content;
	private int likes;
	
	private List<Comment> comments = new ArrayList<>();

	public Post() {}
	
	public Post(Date moment, String title, String content, int likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	/* REMOVER! EM VEZ DE USAR, CRIAR MÉTODO PARA ADD COMENTÁRIO E REMOVER COMENTÁRIO
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	*/
	
	public void addComments(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComments(Comment comment) {
		comments.remove(comment);
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes + " Likes - " + moment + "\n");
		sb.append(content + "\n");
		sb.append("Comments:\n");
		for(Comment c : comments) {
			sb.append(c.getText() + "\n");
		}
		
		return sb.toString();
	}
	
	
}
