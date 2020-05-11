package com.tao.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
public class MusicController {
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	@RequestMapping("/getMusicList")
	@ResponseBody
	public Object getMusicList(HttpServletRequest request) {
		String keywords = request.getParameter("keywords");
		List<Music> retList = new ArrayList<>();
		//获取与名称匹配的music的hash的key
		Set<String> HashKeySet = redisTemplate.keys(keywords+"*");
		System.out.println("模糊匹配到的数据为："+HashKeySet);
		//List<String> musicList = redisTemplate.opsForList().range("musicList:001", 0,-1);
//		Object[] params = {"name","img","url"};
//		List<Object> list = Arrays.asList(params);
		for(String key : HashKeySet) {
			if(key.contains(":")) {
				continue;
			}
			System.out.println("开始查询指定key:"+key+"对应的值！");
			key = redisTemplate.opsForValue().get(key);
			System.out.println("查询到对应的值:"+key);
			Music music = new Music();
			Map<Object,Object> result = redisTemplate.opsForHash().entries(key);
			System.out.println(result);
			music = JSON.parseObject(JSON.toJSONString(result), Music.class);
			//获取音乐的评论列表
			if(music.getCommentList() != null && music.getCommentList() != "") {
				List<String> commentList = redisTemplate.opsForList().range(music.getCommentList(), 0,-1);
				List<Comment> comments = new ArrayList<Comment>();
				for(String commentKey : commentList) {
					Map<Object,Object> commentMap = redisTemplate.opsForHash().entries(commentKey);
					System.out.println("获取评论列表:"+commentMap);
					Comment comment = JSON.parseObject(JSON.toJSONString(commentMap), Comment.class);
					//获取评论中的用户信息
					Map<Object,Object> userMap = redisTemplate.opsForHash().entries("user:"+comment.getUserId().substring(1));
					User user = JSON.parseObject(JSON.toJSONString(userMap), User.class);
					comment.setHeadIconUrl(user.getHeadIconUrl());
					comments.add(comment);
				}
				music.setComments(comments);
			}
			retList.add(music);
		}
		System.out.println(retList);
		return retList;
	}

}
