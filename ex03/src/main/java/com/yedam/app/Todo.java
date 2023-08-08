package com.yedam.app;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Todo {

	


		private Integer no;
		private String title;
		private String complete;
		private Date regdt;

}
