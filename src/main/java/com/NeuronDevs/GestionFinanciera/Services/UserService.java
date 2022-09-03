package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Profile;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Repositories.ProfileRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public UserService(UserRepository userRepository, ProfileRepository profileRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(Long id){
        return this.userRepository.findById(id);
    }


    public User newUser(User user) {
        Profile profile= new Profile();
        profile.setUser(user);
        profile.setUser_id(user.getId());
        profile.setCreatedAt(user.getCreatedAt());
        user.setProfile(profile);
        this.userRepository.save(user);
        this.profileRepository.save(profile);
        return user;
    }
    public List<Profile> getProfiles() {
        return this.profileRepository.findAll();
    }

    public String DeleteUser(Long id) {
        if(this.userRepository.existsById(id)){
            this.profileRepository.deleteById(id);
            this.userRepository.deleteById(id);
        }else{
           return "No se ha podido eliminar";
        }
        return "Eliminado correctamente";
    }
}
