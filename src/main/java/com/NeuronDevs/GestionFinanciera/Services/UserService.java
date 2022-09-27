package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.*;
import com.NeuronDevs.GestionFinanciera.Repositories.EnterpriseRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.ProfileRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;
    private final EnterpriseRepository enterpriseRepository;


    public List<User> getUsers(){
        return this.userRepository.findAll(); // select * from user
    }

    public Optional<User> getUser(Long id) throws Exception {
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new Exception("Usuario no existe")
        );
        return Optional.ofNullable(user);
    }

    public List<Profile> getProfiles() {
        return this.profileRepository.findAll();
    }

    public User updateUser(User new_user, Long user_id) throws Exception {
        User user = userRepository.findById(user_id).orElseThrow(
                () -> new Exception("Usuario no existe")
        );
        new_user.setCreatedAt(user.getCreatedAt());
        new_user.setProfile(user.getProfile());
        new_user.setImage(user.getImage());
        LocalDate now = LocalDate.now();
        new_user.getProfile().setUpdateAt(now);
        return  this.userRepository.save(new_user);
    }


    public User newUser(User user,Long id_e) throws Exception {
        Profile profile= new Profile();
        profile.setProfile(user.getId(),user,user.getCreatedAt());
        user.setProfile(profile);

        Enterprise enterprise = this.enterpriseRepository.findById(id_e).orElseThrow(
                () -> new Exception("Empresa no existe")
        );
        user.setEnterprise(enterprise);

        this.userRepository.save(user);
        this.profileRepository.save(profile);
        return user;
    }
    public User newUser2(User user) throws Exception {
        Profile profile= new Profile(user,user.getCreatedAt());
        user.setProfile(profile);
        LocalDate now = LocalDate.now();
        user.setCreatedAt(now);
        this.userRepository.save(user);
        this.profileRepository.save(profile);
        return user;
    }


    public String DeleteUser(Long id) throws Exception {
        boolean user = this.userRepository.existsById(id);
        if(user){
            this.profileRepository.deleteById(id);
            this.userRepository.deleteById(id);
        }else {
            return "Usuario no encontrada";
        }

        return "usuario eliminado";
    }


    public User getOrCreateUser(Map<String,Object> userData){

        User us = this.userRepository.findByEmail((String)userData.get("email"));
        if (us == null){
            String name = (String)userData.get("given_name");
            String email = (String)userData.get("email");
            String picture = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");

            LocalDate now = LocalDate.now();

            User usuario = new User(name,email,picture,auth0Id,now);
            User user = this.userRepository.save(usuario);
//            User user = this.userRepository.findByEmail(email);


            Profile profile= new Profile(user,now);
            this.profileRepository.save(profile);

            return user;
        }
        return us;
    }
}
