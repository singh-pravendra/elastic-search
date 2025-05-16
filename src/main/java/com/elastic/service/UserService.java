package com.elastic.service;

import com.elastic.beans.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UserService {

    String add(User user) throws IOException;

    User fetch(String id) throws IOException;

    void delete(String id) throws IOException;

}
