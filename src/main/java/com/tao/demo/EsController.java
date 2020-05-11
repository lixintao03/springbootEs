package com.tao.demo;

import org.apache.lucene.queryparser.xml.ParserException;
import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.apache.lucene.search.Query;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.geo.GeoDistance;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.GeoDistanceSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Element;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EsController {

    private  ElasticsearchOperations elasticsearchOperations;

   // private ElasticsearchTemplate elasticsearchTemplate;

    /*public EsController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }*/
    public EsController(ElasticsearchTemplate elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }


    @RequestMapping("/esRestTest")
    @ResponseBody
    public String saveRest(@RequestBody Person person) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId().toString())
                .withObject(person)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery);
        return documentId;
    }
    @RequestMapping("/esTCPTest")
    @ResponseBody
    public String saveTcp(@RequestBody Person person) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId().toString())
                .withObject(person)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery);
        return documentId;
    }

    @RequestMapping("/saveFriends")
    @ResponseBody
    public String saveFriends(@RequestBody Friends friends) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(friends.getUserId().toString())
                .withObject(friends)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery);
        return documentId;
    }

    @RequestMapping("/saveFriendsBatch")
    @ResponseBody
    public String saveFriendsBatch(@RequestBody List<Friends> friends) {
        List<IndexQuery> list = new ArrayList<>();
        for (Friends f : friends){
            IndexQuery indexQuery = new IndexQueryBuilder()
                    .withId(f.getUserId().toString())
                    .withObject(f)
                    .build();
            list.add(indexQuery);
        }
        elasticsearchOperations.bulkIndex(list);
        return "ok";
    }
    @RequestMapping("/queryByBox")
    @ResponseBody
    public Object queryByBox(@RequestBody GeoPoint point) {
        GeoDistanceQueryBuilder builder = QueryBuilders.geoDistanceQuery("geo")
                                                        .point(point)
                                                        .distance(7, DistanceUnit.KILOMETERS)
                                                        .geoDistance(GeoDistance.ARC);
        /*GeoDistanceSortBuilder sortBuilder =
                SortBuilders.geoDistanceSort("geo").points(point)
                        .unit(DistanceUnit.METERS)
                        .order(SortOrder.ASC);//排序方式*/
        //构造查询条件
        NativeSearchQueryBuilder nativeSearchQueryBuilder =
                new NativeSearchQueryBuilder()
                        .withFilter(builder);
        List<Friends> list = elasticsearchOperations.queryForList(nativeSearchQueryBuilder.build(),Friends.class);
        return list;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/shouji")
    @ResponseBody
    public Object getPhoneList(){
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                /*.withIndices("goods").withTypes("phone")*/
                .withQuery(QueryBuilders.matchAllQuery()).build();
        List<GoodsList> list = elasticsearchOperations.queryForList(searchQuery,GoodsList.class);

        return list;
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/searchList")
    @ResponseBody
    public Object searchList(HttpServletRequest req){
        String searchVal = req.getParameter("searchVal");
        System.out.println("获取到查询参数："+searchVal);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("goodsName",searchVal)).build();
        List<GoodsList> list = elasticsearchOperations.queryForList(searchQuery,GoodsList.class);

        return list;
    }
}
