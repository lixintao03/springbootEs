package com.tao.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MongoController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping("/mongo/getDataList")
    @ResponseBody
    public Object getMessage(HttpServletRequest request,String name){
        name = request.getParameter("name");
        WeiBo weibo = new WeiBo();
        Query userQuery = new Query(Criteria.where("screen_name").is(name));
        UserInfo user = mongoTemplate.findOne(userQuery,UserInfo.class);
        if(user == null){
            return null;
        }
        weibo.setUserInfo(user);
        String userId = user.getUser_id();
        Query cardQuery = new Query(Criteria.where("user_id").is(userId));
        List<CardInfo> cardList = mongoTemplate.find(cardQuery,CardInfo.class);
        System.out.println("获取用户："+name+"id为"+userId+",获取"+cardList.size()+"条微博！");
        for(CardInfo card : cardList){
            String bId = card.getBid();
            if(card.getPic_num() > 0){
                Query picQuery = new Query(Criteria.where("bid").is(bId));
                List<PicInfo> pics = mongoTemplate.find(picQuery,PicInfo.class);
                System.out.println("bid："+bId+",获取图片个数："+pics.size());
                card.setPics(pics);
            }
            if(card.getComments_count() > 0L){
                String mId = card.getMid();
                Query commentQuery = new Query(Criteria.where("card_id").is(mId));
                List<Comments> commentsList = mongoTemplate.find(commentQuery,Comments.class);
                for(Comments com : commentsList){
                    String comment_id = com.getComment_id();
                    Query subCommentQuery = new Query(Criteria.where("rootidstr").is(comment_id).and("comment_id").ne(comment_id));
                    List<Comments> subCommentsList = mongoTemplate.find(subCommentQuery,Comments.class);
                    com.setSubComments(subCommentsList);
                }
                card.setComments(commentsList);
            }
        }
        weibo.setCards(cardList);
        return weibo;
    }
}
