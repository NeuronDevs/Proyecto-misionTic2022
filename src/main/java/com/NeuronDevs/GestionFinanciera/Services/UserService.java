package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Profile;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Repositories.ProfileRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;


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
        new_user.getProfile().setUser_id(user_id);
        user.setUser(new_user.getEmail(),new_user.getProfile(),new_user.getRole(),new_user.getEnterprise());
        return  userRepository.save(user);
    }


    public User newUser(User user) {
        Profile profile= new Profile();
        profile.setProfile(user.getId(),user,user.getCreatedAt());
        user.setProfile(profile);
        this.userRepository.save(user);
        this.profileRepository.save(profile);
        return user;
    }


    public String DeleteUser(Long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(
                () -> new Exception("Usuario no existe")
        );

        this.profileRepository.deleteById(id);
        this.userRepository.deleteById(id);

        return "Eliminado correctamente";
    }
}
