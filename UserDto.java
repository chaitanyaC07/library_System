package library.Dto;

import java.util.Date;

public class UserDto {
	
	
    private int userId; 
	
	private String branch; 
	private String section; 
	private String semester; 

	private String yearAdm; 
	private String role; 
	private String password;
	
	private String authId;
    private String authPassword;
    
    
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int userId, String branch, String section, String semester, String yearAdm, String role,
			String password, String authId, String authPassword) {
		super();
		this.userId = userId;
		this.branch = branch;
		this.section = section;
		this.semester = semester;
		this.yearAdm = yearAdm;
		this.role = role;
		this.password = password;
		this.authId = authId;
		this.authPassword = authPassword;
	
	
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
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthPassword() {
		return authPassword;
	}
	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}
	
	
	
	
	
	
	
	

}
