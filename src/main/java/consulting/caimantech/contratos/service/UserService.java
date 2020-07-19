package consulting.caimantech.contratos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import consulting.caimantech.contratos.model.Usuario;
import consulting.caimantech.contratos.repo.IUsuarioRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usr = repo.findByNombre(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		if (usr.getId() == 1){
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		
		UserDetails userDet = new User(usr.getNombre(), usr.getClave(), roles);
		
		return userDet;
	}

}
