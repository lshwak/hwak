package com.hwak.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;
import com.hwak.model.PageVO;
import com.hwak.service.BoardService;

@Controller

public class BoardController {
	@Resource
	private String uploadPath;
	@Autowired
	private BoardService bservice;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/* Event */
	@RequestMapping(value="event", method=RequestMethod.GET)
	public String eventGET(Criteria cri, Model model) throws Exception{
		logger.info("BoardContorller event");
		int total = bservice.boardCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword = "+cri.getKeyword());
		logger.info("pv = "+pv.getStartPage());
		logger.info("total = "+total);
		model.addAttribute("event", bservice.boardEventPaging(cri));
		logger.info("event="+bservice.boardEventPaging(cri));
		model.addAttribute("page", pv);
		return "board/event";
	}
	
	/* 행사 등록하기 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registGet() throws Exception {
		logger.info("BoardController registGET ...");
		return "board/write";
	}
	/* 행사 등록처리 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registPost(BoardVO board) throws Exception {
		logger.info("regist post ... "+board);
		logger.info("파일첨부 ... "+board.getFilename());
		bservice.boardWrite(board);
		return "redirect:event";
	}
	/* 행사 상세내용 */
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detailGet(@RequestParam int eno,Model model) throws Exception {
		logger.info("detail get ... "+eno);
		model.addAttribute("detail", bservice.boardDetail(eno));
		logger.info("detail detailList ... "+bservice.boardDetail(eno));
		
		bservice.boardCnt(eno);	// 조회수 증가
		
		List getAttachList = new ArrayList();
		getAttachList = bservice.getAttach(eno);
		logger.info("getAttachList="+getAttachList);
		model.addAttribute("getAttachList",getAttachList);
		
		return "board/detail";
	}
	/*행사수정*/
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGet(@RequestParam int eno,Model model) throws Exception {
		logger.info("modify get ... "+eno);
		model.addAttribute("modify", bservice.boardDetail(eno));
		
		// 저장된 포스터 가져오기.
		List getAttachList = new ArrayList();
		getAttachList = bservice.getAttach(eno);
		logger.info("getAttachList="+getAttachList);
		model.addAttribute("getAttachList",getAttachList);
		
		return "board/modify";
	}
	/*행사수정 처리*/
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(@RequestParam int eno,BoardVO board) throws Exception {
		logger.info("modify post"+board);
		bservice.boardModify(board);
		logger.info("파일첨부 ... "+board.getFilename());
		
		return "redirect:detail?eno="+board.getEno();
	}
	/*행사 삭제*/
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteGet(BoardVO board) throws Exception {
		logger.info("게시번호 eno = "+board.getEno());
		bservice.boardDelete(board);
		return "redirect:event";
	}
}






















