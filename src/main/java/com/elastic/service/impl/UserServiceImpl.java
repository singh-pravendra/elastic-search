package com.elastic.service.impl;

import com.elastic.beans.User;
import com.elastic.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestHighLevelClient client;

    private final ObjectMapper mapper = new ObjectMapper();
    private static final String INDEX = "users";

    @Override
    public String add(User user) throws IOException {
        IndexRequest request = new IndexRequest(INDEX)
                .id(user.getId())
                .source(mapper.writeValueAsString(user), XContentType.JSON);
        IndexResponse response = client.index(request, org.elasticsearch.client.RequestOptions.DEFAULT);
        return response.getId();
    }

    public User fetch(String id) throws IOException {
        GetRequest request = new GetRequest(INDEX, id);
        GetResponse response = client.get(request, org.elasticsearch.client.RequestOptions.DEFAULT);
        if (response.isExists()) {
            return mapper.readValue(response.getSourceAsString(), User.class);
        }
        return null;
    }

    public void delete(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(INDEX, id);
        client.delete(request, org.elasticsearch.client.RequestOptions.DEFAULT);
    }
}
