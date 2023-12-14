package com.spring.gta.inform.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.HtmlUtils;

import com.spring.gta.inform.service.InformService;
import com.spring.gta.inform.vo.InformVO;
import com.spring.gta.inform.vo.SearchVO;

@Controller
public class informController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InformService informservice;

	// 6. 게시글 목록 화면으로 이동
	@RequestMapping("/inform")
	public String inform(Model model, HttpSession session) {
		if(session.getAttribute("login")!=null) {
		return "inform/inform";
		}else {
			return "redirect:/";
		}
	}
	//게시글 가져오기
	@ResponseBody
    @RequestMapping("/inform/data")
    public List<InformVO> getInformListAsync() {
        List<InformVO> informList = informservice.getInformList();
        return informList;
    }

	// 6.1 게시글 작성 화면으로 이동
	@RequestMapping("/inform/write")
	public String informWrite( HttpSession session) {
		if(session.getAttribute("login") == null) {
			return "redirect:/";
		}

		return "inform/write";
	}

	// 6.1.0.1 게시글 작성 처리
	@PostMapping("/inform/write.do")
	public String informWriteDo(InformVO info, HttpSession session) throws Exception {
		String content1 = HtmlUtils.htmlEscape(info.getiContents());
	    String title1 = HtmlUtils.htmlEscape(info.getiTitle());
		String loggedInUserId = (String) session.getAttribute("login");
	    
		info.setbId(loggedInUserId);
		info.setiContents(content1);
		info.setiTitle(title1);
		
		informservice.writeInform(info);
		return "redirect:/inform";
	}

	// 6.2 게시글 상세 화면으로 이동
	@RequestMapping("/inform/detail")
	public String informDetail(Model model, int iNum, RedirectAttributes redirectAttributes) throws Exception {

		InformVO informVO = informservice.getInform(iNum);

		model.addAttribute("inform", informVO);
		 redirectAttributes.addFlashAttribute("showAlert", false);
		return "inform/detail";
	}

	// 6.2.1 게시글 수정 화면으로 이동
	@RequestMapping("/inform/rewrite")
	public String informRewrite(Model model, int iNum, RedirectAttributes redirectAttributes) throws Exception {
		InformVO informVO = informservice.getInform(iNum);

		model.addAttribute("inform", informVO);
		return "inform/rewrite";

	}



	// 6.2.1.1 게시글 수정 처리
	@PostMapping("/inform/rewrite.do")
	public String informRewriteDo(InformVO inform, Model model, int iNum, String password, String button,
			RedirectAttributes redirectAttributes) throws Exception {
		InformVO informVO = informservice.getInform(iNum);
		// 로그 추가
		logger.debug("iNum: {}", iNum);
		logger.debug("password: {}", password);
		logger.debug("informVO.getiPwd(): {}", informVO.getiPwd());
		if (button.equals("rewrite")) {
			// 비밀번호 일치 여부 로그
			if (informVO.getiPwd().equals(password)) {
				String content1 = HtmlUtils.htmlEscape(inform.getiContents());
			    String title1 = HtmlUtils.htmlEscape(inform.getiTitle());
			    inform.setiContents(content1);
			    inform.setiTitle(title1);
				logger.debug("수정 완료");
				informservice.rewriteinform(inform);
				return "redirect:/inform";
			} else {
				redirectAttributes.addFlashAttribute("errorMsg", "비밀번호가 옳바르지 않습니다.");
				 redirectAttributes.addFlashAttribute("showAlert", true);
				return "redirect:/inform/detail?iNum=" + iNum;
			}
		} else {
			// 비밀번호 일치 여부
			if (informVO.getiPwd().equals(password)) {
				informservice.deleteInform(informVO);
				return "redirect:/inform";
			} else {
				// 비밀번호 불일치 시 에러 메시지와 함께 상세 화면으로 리다이렉트
				redirectAttributes.addFlashAttribute("errorMsg", "비밀번호가 옳바르지 않습니다.");
				 redirectAttributes.addFlashAttribute("showAlert", true);
				return "redirect:/inform/detail?iNum=" + iNum;
			}
		}

	}

	// 6.0.0.1 게시글 검색
	@ResponseBody
	@RequestMapping("/inform/search")
	public List<InformVO> informSearchAsync(@RequestParam("category") String category,
			@RequestParam("keyword") String keyword) 
	{
		SearchVO searchVO = new SearchVO();
		searchVO.setCategory(category);
		searchVO.setKeyword(keyword);

		List<InformVO> informList = informservice.searchInformList(searchVO);

		return informList;
	}
}
