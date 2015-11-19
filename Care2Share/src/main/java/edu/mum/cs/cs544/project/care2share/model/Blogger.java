package edu.mum.cs.cs544.project.care2share.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Blogger {

	@Id
	@Column(name = "BLOGGER_ID")
	private long id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "BIO")
	private String bio;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "blogger")
	private List<Post> postsList;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USERNAME")
	private Users user;
	@Transient
	private String fullName;

	public Blogger() {

	}

	public Blogger(String firstName, String lastName, String email, String phone, String bio, List<Post> postsList,
			Users user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.bio = bio;
		this.postsList = postsList;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Post> getPostsList() {
		return postsList;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setPostsList(List<Post> postsList) {
		this.postsList = postsList;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

}
