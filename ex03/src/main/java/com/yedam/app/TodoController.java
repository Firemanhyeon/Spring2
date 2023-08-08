package com.yedam.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
	//등록
	@PostMapping("")
	public ResponseEntity<Todo> insert(Todo vo) {
		ResponseEntity<Todo> result =null;
		if(vo.getTitle()==null) {
			result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	//수정
	@RequestMapping(value="/{no}" , method = RequestMethod.PUT)
	public Todo update( @PathVariable Integer no,@RequestBody Todo vo) {
		vo.setNo(no);
		
		return vo;
	}
	
	//삭제
	@DeleteMapping("/{no}")
	public Integer delete(@PathVariable Integer no ) {
		return no;
		
	}
	//단건조회
	@GetMapping("/{no}")
	public Todo select(@PathVariable("no")Integer no ) {//변수명과 pathvariable 이름 같으면 variable 이름 생략가능
		Todo todo = Todo.builder()
					.no(no)
					.title("제목")
					.complete("내용")
					.build();
		return todo;	
		
	}
	
	//전체조회
	
}
