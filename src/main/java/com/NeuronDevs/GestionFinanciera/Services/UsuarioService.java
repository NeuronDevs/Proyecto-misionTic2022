package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.Profile;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Entities.Usuario;
import com.NeuronDevs.GestionFinanciera.Repositories.EnterpriseRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.ProfileRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public List<Usuario> getUsers(){
        return this.usuarioRepository.findAll(); // select * from user
    }

    public Usuario getOrCreateUser(Map<String,Object> userData){

        Usuario us = usuarioRepository.findByEmail((String) userData.get("email"));
        if (us == null){
            String name = (String)userData.get("given_name");
            String email = (String)userData.get("email");
            String picture = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");
            Usuario usuario = new Usuario(name,email,picture,auth0Id);
            return this.usuarioRepository.save(usuario);
        }
        return us;
    }


    public Optional<Usuario> getUser(Long id) throws Exception {
        Usuario user = this.usuarioRepository.findById(id).orElseThrow(
                () -> new Exception("Usuario no existe")
        );
        return Optional.ofNullable(user);
    }


    public Usuario updateUser(Usuario new_user, Long user_id) throws Exception {
        Usuario user = usuarioRepository.findById(user_id).orElseThrow(
                () -> new Exception("Usuario no existe")
        );
        return  this.usuarioRepository.save(new_user);
    }


    public Usuario newUser(Usuario user) throws Exception {
        return this.usuarioRepository.save(user);
    }

    public String DeleteUser(Long id) throws Exception {
        boolean user = this.usuarioRepository.existsById(id);
        if(user){
            this.usuarioRepository.deleteById(id);
        }else {
            return "Usuario no encontrada";
        }
        return "usuario eliminado";
    }
}
