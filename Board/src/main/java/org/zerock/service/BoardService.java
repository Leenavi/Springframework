package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dto.BoardVO;
import org.zerock.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository repository;
	
	public List<BoardVO> boardList() {
		
		List<BoardVO> list = repository.getAllBoards();
		
		return list;
	}
}
