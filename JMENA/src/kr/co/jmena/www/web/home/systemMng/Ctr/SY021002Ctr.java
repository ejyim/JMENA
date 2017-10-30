package kr.co.jmena.www.web.home.systemMng.Ctr;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jmena.www.web.home.systemMng.Biz.SY021002Biz;
import kr.co.jmena.www.web.home.systemMng.Vo.SY021002VO;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SY021002Ctr {
	
	@Resource(name = "SY021002Biz")
	private SY021002Biz SY021002Biz;
	
	protected final Logger logger = Logger.getLogger(getClass());
	
	public SY021002Ctr() {}
	
	/**
	 * @name 지사및부서관리 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/SY021002.do")
	public ModelAndView SY021002(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("home/systemMng/SY021002");
	}

	/**
	 * @name 지사및부서관리 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/selectListEnaBranchMst.do")
	public ModelAndView selectListEnaBranchMst(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SY021002VO vo = new SY021002VO();
		
		vo.setBRANCHNAME(request.getParameter("BRANCHNAME"));
		vo.setBRANCHCODE(request.getParameter("BRANCHCODE"));
		
		List<SY021002VO> lst = SY021002Biz.selectListEnaBranchMst(vo);
		
		JSONArray jCell = new JSONArray();
		JSONObject json = new JSONObject();
		
		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = new JSONObject();
			
			//jData.put("id", i+1);
			obj.put("BRANCHCODE", lst.get(i).getBRANCHCODE());
			obj.put("BRANCHNAME", lst.get(i).getBRANCHNAME());
			obj.put("USEYN", lst.get(i).getUSEYN());
			jCell.add(obj);
		}
		
		json.put("records", lst.size());
		json.put("rows", jCell);
		
		logger.debug("[selectListSysMst]" + json);
		
		return new ModelAndView("jsonView", json);
	}

	/**
	 * @name 지사및부서관리 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/selectListEnaDeptMst.do")
	public ModelAndView selectListEnaDeptMst(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SY021002VO vo = new SY021002VO();
		
		vo.setBRANCHCODE(request.getParameter("BRANCHCODE"));
		
		List<SY021002VO> lst = SY021002Biz.selectListEnaDeptMst(vo);
		
		JSONArray jCell = new JSONArray();
		JSONObject json = new JSONObject();
		
		for (int i = 0; i < lst.size(); i++) {
			JSONObject obj = new JSONObject();

			obj.put("DEPTCODE", lst.get(i).getDEPTCODE());
			obj.put("DEPTNAME", lst.get(i).getDEPTNAME());
			obj.put("DEPTGUBUN", lst.get(i).getDEPTGUBUN());
			obj.put("SORTKEY", lst.get(i).getSORTKEY());
			obj.put("USEYN", lst.get(i).getUSEYN());
			obj.put("REMARK", lst.get(i).getREMARK());
			
			jCell.add(obj);
		}
		
		json.put("records", lst.size());
		json.put("rows", jCell);
		
		logger.debug("[selectListSysMst]" + json);
		
		return new ModelAndView("jsonView", json);
	}

	/**
	 * @name 지사및부서관리 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/saveEnaBranchMst.do")
	public ModelAndView saveEnaBranchMst(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SY021002VO vo = new SY021002VO();
		
		System.out.println("BRANCHCODE==>"+request.getParameter("RS_BRANCHCODE"));
		System.out.println("BRANCHNAME==>"+request.getParameter("RS_BRANCHNAME"));
		System.out.println("USEYN==>"+request.getParameter("RS_USEYN"));
		
		vo.setBRANCHCODE(request.getParameter("RS_BRANCHCODE"));
		vo.setBRANCHNAME(request.getParameter("RS_BRANCHNAME"));
		vo.setUSEYN(request.getParameter("RS_USEYN"));
		
		int updateCnt = 0;
		int insertCnt = 0;

		List<SY021002VO> lst = SY021002Biz.selectListEnaBranchMst(vo);
		System.out.println("lst.size()==>"+lst.size());
		
		JSONArray jCell = new JSONArray();
		JSONObject json = new JSONObject();
		
		if(lst.size() > 0){
			updateCnt = SY021002Biz.updateEnaBranchMst(vo);
			
			
			JSONObject obj = new JSONObject();
			if(updateCnt > 0){
				obj.put("MSG", "success");
			}else{
				obj.put("MSG", "error");
			}
			jCell.add(obj);
			json.put("rows", jCell);
			
		}else{
			insertCnt = SY021002Biz.insertEnaBranchMst(vo);
			
			JSONObject obj = new JSONObject();
			obj.put("insertCnt", insertCnt);
			json.put("rows", jCell);
			if(insertCnt > 0){
				obj.put("MSG", "success");
			}else{
				obj.put("MSG", "error");
			}
			jCell.add(obj);
			json.put("rows", jCell);
		}
		
		System.out.println("updateCnt==>"+updateCnt);
		System.out.println("insertCnt==>"+insertCnt);
		
		System.out.println("json==>"+json);
		
		return new ModelAndView("jsonView", json);	
	}

	/**
	 * @name 지사및부서관리 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/saveEnaDeptMst.do")
	public ModelAndView saveEnaDeptMst(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SY021002VO vo = new SY021002VO();
		
		System.out.println(request.getParameter("DEPTCODE"));
		System.out.println(request.getParameter("DEPTNAME"));
		System.out.println(request.getParameter("BRANCHCODE"));
		System.out.println(request.getParameter("DEPTGUBUN"));
		System.out.println(request.getParameter("SORTKEY"));
		System.out.println(request.getParameter("USEYN"));
		System.out.println(request.getParameter("REMARK"));
		
		vo.setDEPTCODE(request.getParameter("DEPTCODE"));
		vo.setDEPTNAME(request.getParameter("DEPTNAME"));
		vo.setBRANCHCODE(request.getParameter("BRANCHCODE"));
		vo.setDEPTGUBUN(request.getParameter("DEPTGUBUN"));
		vo.setSORTKEY(request.getParameter("SORTKEY"));
		vo.setUSEYN(request.getParameter("USEYN"));
		vo.setREMARK(request.getParameter("REMARK"));
		
		int insertCnt = 0;

		List<SY021002VO> lst = SY021002Biz.chkEnaDeptMst(vo);
		System.out.println("lst.size()==>"+lst.size());
		
		JSONArray jCell = new JSONArray();
		JSONObject json = new JSONObject();
		JSONObject obj = new JSONObject();
		
		if(lst.size() > 0){
			obj.put("MSGCODE", "0000");
			obj.put("MSG", "error");
			jCell.add(obj);
			json.put("rows", jCell);
		}else{
			insertCnt = SY021002Biz.saveEnaDeptMst(vo);
			
			obj.put("insertCnt", insertCnt);
			json.put("rows", jCell);
			if(insertCnt > 0){
				obj.put("MSG", "success");
			}else{
				obj.put("MSG", "error");
			}
			jCell.add(obj);
			json.put("rows", jCell);
		}
		
		System.out.println("insertCnt==>"+insertCnt);
		
		System.out.println("json==>"+json);
		
		return new ModelAndView("jsonView", json);	
	}
	
}
