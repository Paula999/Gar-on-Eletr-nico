package projeto.pi.lanchonete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import projeto.pi.lanchonete.models.Administrador;
import projeto.pi.lanchonete.repositories.AdmRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private AdmRepository admRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 Administrador administrador = admRepository.findByEmail(username);
	   
	  if(administrador == null) {
		  throw new UsernameNotFoundException("administrador não encontrado");  
	  }
	 
		return administrador;
	}

}
