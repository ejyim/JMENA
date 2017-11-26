package kr.co.jmena.www.web.home.personMng.Ctr;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jmena.www.web.home.personMng.Biz.HR012001Biz;
import kr.co.jmena.www.web.home.personMng.Vo.HR012001VO;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HR012001Ctr {
	
	@Resource(name = "HR012001Biz")
	private HR012001Biz HR012001Biz;
	
	public HR012001Ctr() {}
	
	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * @name 입사자현황 화면
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/HR012001.do")
	public ModelAndView HR012001(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return new ModelAndView("home/personMng/HR012001");
	}
	

	/**
	 * @name 인사관리 화면 - 인사관리 그리드
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/selectListHR012001.do")
	public ModelAndView selectListHR012001(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HR012001VO vo = new HR012001VO();
		HR012001VO vo1 = new HR012001VO();
		HR012001VO vo2 = new HR012001VO();
		
		vo.setS_JOINDATE_FR(request.getParameter("S_JOINDATE_FR"));
		vo.setS_JOINDATE_TO(request.getParameter("S_JOINDATE_TO"));
		vo.setS_BRANCHCODE(request.getParameter("S_BRANCHCODE"));
		vo.setS_DEPTCODE(request.getParameter("S_DEPTCODE"));
		vo.setS_KNAME(request.getParameter("S_KNAME"));
		vo.setS_JUMINID(request.getParameter("S_JUMINID"));
		
		JSONArray jCell = new JSONArray();
		JSONObject json = new JSONObject();

		if(!(request.getParameter("S_JOINDATE_FR").equals("") && 
				request.getParameter("S_JOINDATE_TO").equals("") && 
				request.getParameter("S_BRANCHCODE").equals("") && 
				request.getParameter("S_DEPTCODE").equals("") && 
				request.getParameter("S_KNAME").equals("") && 
				request.getParameter("S_JUMINID").equals(""))){
		
			List<HR012001VO> lst = HR012001Biz.selectListHR012001(vo);
			
			System.out.println("******************************************");
			System.out.println("size()==>"+lst.size());
			
			
			for (int i = 0; i < lst.size(); i++) {
				JSONObject obj = new JSONObject();
				
				System.out.println("******************************************");
				System.out.println("lst.get(i).getINSACODE()==>"+lst.get(i).getINSACODE());
				vo1.setINSACODE(lst.get(i).getINSACODE());
				
				List<HR012001VO> lst2 = HR012001Biz.selectListHR012001_2(vo1);
				if(lst2.size() > 0){
					for (int j = 0; j < lst.size(); j++) {
						if(j == 0){
							obj.put("BRANCHCODE",lst.get(i).getBRANCHCODE());
							obj.put("BRANCHNAME",lst.get(i).getBRANCHNAME());
							obj.put("DEPTCODE",lst.get(i).getDEPTCODE());
							obj.put("DEPTNAME",lst.get(i).getDEPTNAME());
							obj.put("GRADE",lst.get(i).getGRADE());
							obj.put("DUTY",lst.get(i).getDUTY());
							obj.put("EMPLOYGUBUN",lst.get(i).getEMPLOYGUBUN());
							obj.put("INSACODE",lst.get(i).getINSACODE());
							obj.put("KNAME",lst.get(i).getKNAME());
							obj.put("RECONAME",lst.get(i).getRECONAME());
							obj.put("JOINDATE",lst.get(i).getJOINDATE());
							obj.put("REMARK",lst.get(i).getREMARK());
						}else{
							obj.put("BRANCHCODE","");
							obj.put("BRANCHNAME","");
							obj.put("DEPTCODE","");
							obj.put("DEPTNAME","");
							obj.put("GRADE","");
							obj.put("DUTY","");
							obj.put("EMPLOYGUBUN","");
							obj.put("INSACODE","");
							obj.put("KNAME","");
							obj.put("RECONAME","");
							obj.put("JOINDATE","");
							obj.put("REMARK","");
							
						}
						obj.put("O_BRANCHNAME",lst2.get(j).getO_BRANCHNAME());
						obj.put("O_JOINDATE",lst2.get(j).getO_JOINDATE());
						obj.put("O_RETIREDATE",lst2.get(j).getO_RETIREDATE());
						obj.put("O_EMPLOYGUBUN",lst2.get(j).getO_EMPLOYGUBUN());
						
						vo2.setINSACODE(lst.get(i).getINSACODE());
						vo2.setO_JOINDATE(lst2.get(j).getO_JOINDATE());
						vo2.setO_RETIREDATE(lst2.get(j).getO_RETIREDATE());
						System.out.println("******************************************");
						System.out.println("lst.get(i).getINSACODE()==>"+lst.get(i).getINSACODE());
						System.out.println("lst2.get(j).getO_JOINDATE()==>"+lst2.get(j).getO_JOINDATE());
						System.out.println("lst2.get(j).getO_RETIREDATE()==>"+lst2.get(j).getO_RETIREDATE());
						
						List<HR012001VO> lst3 = HR012001Biz.selectListHR012001_3(vo2);
						if(lst3.size() > 0){
							
							obj.put("O_SELLAMT",lst3.get(0).getO_SELLAMT());
							
						}else{
							obj.put("O_SELLAMT","");
						}
						
						jCell.add(obj);
					}
				}else{
					obj.put("BRANCHCODE",lst.get(i).getBRANCHCODE());
					obj.put("BRANCHNAME",lst.get(i).getBRANCHNAME());
					obj.put("DEPTCODE",lst.get(i).getDEPTCODE());
					obj.put("DEPTNAME",lst.get(i).getDEPTNAME());
					obj.put("GRADE",lst.get(i).getGRADE());
					obj.put("DUTY",lst.get(i).getDUTY());
					obj.put("EMPLOYGUBUN",lst.get(i).getEMPLOYGUBUN());
					obj.put("INSACODE",lst.get(i).getINSACODE());
					obj.put("KNAME",lst.get(i).getKNAME());
					obj.put("RECONAME",lst.get(i).getRECONAME());
					obj.put("JOINDATE",lst.get(i).getJOINDATE());
					obj.put("REMARK",lst.get(i).getREMARK());
	
					obj.put("O_BRANCHNAME","");
					obj.put("O_JOINDATE","");
					obj.put("O_RETIREDATE","");
					obj.put("O_EMPLOYGUBUN","");
					obj.put("O_SELLAMT","");
					
					jCell.add(obj);
				}
				
			}
		}
		json.put("rows", jCell);
		
		logger.debug("[selectListSysMst]" + json);
		
		return new ModelAndView("jsonView", json);
	}
	
}
