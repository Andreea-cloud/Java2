package server.service;

import library.dto.UserDTO;
import library.service.UserService;
import server.model.User;
import server.repository.UserRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;

public class UserServiceImplement extends UnicastRemoteObject implements UserService {

    private UserRepository userRepository;

    public UserServiceImplement() throws RemoteException {
        userRepository = new UserRepository();
    }

    @Override
    public int login(UserDTO userDTO) throws RemoteException {
        Optional<User> userOptional = userRepository
                .findByUsername(userDTO.getUsername());
        return userOptional
                .filter(user -> user.getPassword().equals(userDTO.getPassword()))
                .map(User::getId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int register(UserDTO userDTO) throws RemoteException {
        Optional<User> userOptional = userRepository
                .findByUsername(userDTO.getUsername());

        if(userOptional.isEmpty()){
            return userRepository.create(userDTO).getId();
        }else {
            throw new IllegalArgumentException();
        }
    }
}
