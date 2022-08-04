package library.Dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.entities.User;

@Component
public class userConverter {
	
	
	@Autowired
	public User user; 
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	public userConverter(User user) {
		super();
		this.user = user;
	}


	public static UserDto entityToDto(User user) {
		
		UserDto userDto = new UserDto();
		
		userDto.setUserId(user.getUserId());
		userDto.setBranch(user.getBranch());
		userDto.setSection(user.getSection());
		userDto.setSemester(user.getSemester());
		userDto.setYearAdm(user.getYearAdm());
		userDto.setRole(user.getRole());
		userDto.setPassword(user.getPassword());
		
		
		userDto.setAuthId("1");
		userDto.setAuthPassword("1234");
		
		
		return userDto;
	}
	public List<UserDto> entityToDto(List<User> user){
		
		return user.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
		
		
	}
	

	
	public  User dtoToEntity(UserDto userDto) {
		
		user.setUserId(userDto.getUserId());
		user.setBranch(userDto.getBranch());
		user.setSection(userDto.getSection());
		user.setSemester(userDto.getSemester());
		user.setYearAdm(userDto.getYearAdm());
		user.setRole(userDto.getRole());
		user.setPassword(userDto.getPassword());
		
		
		return user;
		
		
	}
	public List<User> dtoToEntity(List<UserDto> userDto){
		
		return userDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	
	}
	
	
	
}
