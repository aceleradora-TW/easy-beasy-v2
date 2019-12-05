//package com.thoughtworks.aceleradora.service;
//
//import com.thoughtworks.aceleradora.auth.dominio.Usuario;
//import com.thoughtworks.aceleradora.domain.Administrator;
//import com.thoughtworks.aceleradora.repository.AdministratorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//
//import static org.graalvm.compiler.options.OptionType.User;
//
//
//@Service
//public class UserDetailsImpl implements  UserDetailsService{
//    @Autowired
//    private AdministratorRepository administratorRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) {
//        Administrator administrator = administratorRepository.findByUsername(username);
//
//        return new User(administrator.getUsername(), administrator.getPassword(), new HashSet<>());
//    }
//}
//}
