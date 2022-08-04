package library.Service;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.Dto.UserDto;
import library.Dto.userConverter;
import library.entities.User;
import library.entities.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthService authService;
	@Autowired
	private userConverter userConverter;
	
	public UserService(UserRepository userRepository  , userConverter userConverter) {
		
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}
	
	// add User
	public  User addUser(UserDto userDto) {
		
		
	User user	= userConverter.dtoToEntity(userDto);
	
	String role = authService.authenticate(userDto.getAuthId(), userDto.getAuthPassword());
	
	if(role != null && role.equalsIgnoreCase("admin")) {
	
		return userRepository.save(user);
	}else {
		throw new RuntimeException("not allow");
	}

	}
	
// updateUser
	
	@Transactional
	public User updateUser(int id,  UserDto userDto ) {
		
		System.out.println(id);
		System.out.println(userDto);
		
		User user = userConverter.dtoToEntity(userDto);
		
		String role = authService.authenticate(userDto.getAuthId() , userDto.getAuthPassword());
		
		
		
		if(role != null && role.equalsIgnoreCase("admin")) {
			
		
		 user = userRepository.findById(id)
				.orElseThrow(()-> new IllegalStateException("student with id" + id + "does not exists"));
		
		if(userDto.getBranch() != null && 
				userDto.getBranch().length()>0 
				) {
			
			user.setBranch(userDto.getBranch());
		}
		if(userDto.getSection() != null &&
				userDto.getSection().length()>0 
				) {
			
			user.setSection(userDto.getSection());
		}
		if(userDto.getSemester() != null &&
				userDto.getSemester().length()>0 
				) {
			
			user.setSemester(userDto.getSemester());
		}
		return userRepository.save(user); 
		
		}
		else {
		throw new RuntimeException("not allow");	
		}
		
		
	}
	// delete User

	public User removeUser(Integer id , UserDto userDto ) {
		
		User user = userConverter.dtoToEntity(userDto);
		
		String role = authService.authenticate(userDto.getAuthId(), userDto.getAuthPassword());
		
		if(role != null && role.equalsIgnoreCase("admin")) {
		boolean exists = userRepository.existsById(id);
		
		if(!exists) {
			throw new IllegalStateException("User with id "+ id+ "does not exists");
		}
		 userRepository.deleteById(id);
		 return user;
		}
		else {
			throw new RuntimeException("not allow");
		}
		
	}
	

}
