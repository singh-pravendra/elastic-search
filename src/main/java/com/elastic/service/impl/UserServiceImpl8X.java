//package com.elastic.service.impl;
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.elasticsearch.core.GetRequest;
//import co.elastic.clients.elasticsearch.core.IndexRequest;
//import co.elastic.clients.elasticsearch.core.DeleteRequest;
//import co.elastic.clients.elasticsearch.core.IndexResponse;
//import co.elastic.clients.elasticsearch.core.GetResponse;
//import com.elastic.beans.User;
//import com.elastic.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class UserServiceImpl8X implements UserService {
//
//    private static final String INDEX = "users8x";
//
//    @Autowired
//    private ElasticsearchClient client;
//
//    @Override
//    public String add(User user) throws IOException {
//        IndexRequest<User> request = IndexRequest.of(i -> i
//                .index(INDEX)
//                .id(user.getId())
//                .document(user));
//        IndexResponse response = client.index(request);
//        return response.id();
//    }
//
//    @Override
//    public User fetch(String id) throws IOException {
//        GetRequest request = GetRequest.of(g -> g.index(INDEX).id(id));
//        GetResponse<User> response = client.get(request, User.class);
//        return response.found() ? response.source() : null;
//    }
//
//    @Override
//    public void delete(String id) throws IOException {
//        DeleteRequest request = DeleteRequest.of(d -> d.index(INDEX).id(id));
//        client.delete(request);
//    }
//}
