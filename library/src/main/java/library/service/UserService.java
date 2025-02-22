package library.service;

import library.dto.UserDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    int login(UserDTO userDTO) throws RemoteException;
    int register(UserDTO userDTO) throws RemoteException;
}
