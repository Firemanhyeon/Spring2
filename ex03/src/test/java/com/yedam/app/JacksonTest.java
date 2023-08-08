package com.yedam.app;

import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;
@Log4j
public class JacksonTest {
 
	@Test
	public void writeTest() throws JsonProcessingException {
		//VO(object) => String(json형식)
		ObjectMapper om = new ObjectMapper();
		BoardVO vo = new BoardVO();
		vo.setBno(2L);
		vo.setTitle("test2");
		vo.setContent("내용무");
		vo.setRegdate(new Date());
		
		String result = om.writeValueAsString(vo);
		log.info(result);
	}
	@Test
	public void readTest() throws JsonMappingException, JsonProcessingException {
		String jsonstr = "{\"bno\":2,\"title\":\"test2\",\"content\":\"내용무\",\"writer\":null,\"regdate\":\"2023-08-08\"}";
		ObjectMapper om = new ObjectMapper();
		BoardVO vo =om.readValue(jsonstr, BoardVO.class);
		
		log.info(vo);
	}
}
