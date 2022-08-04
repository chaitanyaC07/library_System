package library.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;


@Entity
@Table(name = "User")
@Component
public class User  {
	
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId; 
	
	private String branch; 
	private String section; 
	private String semester; 
	
//	@Temporal(TemporalType.TIMESTAMP)
	private String yearAdm; 
	private String role; 
	private String password;
	
//	@OneToOne
//	private User user; 
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getYearAdm() {
		return yearAdm;
	}

	public void setYearAdm(String yearAdm) {
		this.yearAdm = yearAdm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userId, String branch, String section, String semester, String yearAdm, String role,
			String password) {
		super();
		this.userId = userId;
		this.branch = branch;
		this.section = section;
		this.semester = semester;
		this.yearAdm = yearAdm;
		this.role = role;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", branch=" + branch + ", section=" + section + ", semester=" + semester
				+ ", yearAdm=" + yearAdm + ", role=" + role + ", password=" + "****" + "]";
	}


	
	

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	} 
	
	
	
	
	
	

}
