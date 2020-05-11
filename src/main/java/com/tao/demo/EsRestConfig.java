package com.tao.demo;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * rest方式访问es，所以端口是9200
 *
 * **/
//@Configuration
public class EsRestConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration configuration = ClientConfiguration.localhost();
        RestHighLevelClient client = RestClients.create(configuration).rest();
        return client;
    }
    @Bean
    @Override
    public EntityMapper entityMapper() {
        ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(elasticsearchMappingContext(),
                new DefaultConversionService());
        entityMapper.setConversions(elasticsearchCustomConversions());
        return entityMapper;
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/shouji")
    @ResponseBody
    public Object getPhoneList(){

        Map<String,Object> map = new HashMap<>();
        map.put("img","static/img/shouji/1.jpg");
        map.put("goodsName","中兴4G学生老年智能手机");
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);

        return list;
    }
}
