package kr.co.jmena.www.web.home.saleMng.Ctr;

import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jmena.www.web.home.saleMng.Biz.SA012012Biz;
import kr.co.jmena.www.web.home.saleMng.Vo.SA012012VO;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SA012012Ctr {
	
	@Resource(name = "SA012012Biz")
	private SA012012Biz SA012012Biz;

	protected final Logger logger = Logger.getLogger(getClass());
	
	public SA012012Ctr() {}
	
	/**
	 * @name 등기현황
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/SA012012.do")
	public ModelAndView SA012012(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("home/saleMng/SA012012");
	}
	
	/**
	 * @name 등기현황 : 조회
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/home/selectListSA012012.do")
	public ModelAndView selectListSA012012(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SA012012VO vo = new SA012012VO();
		
		String S_DEPOSITDATE_FR = request.getParameter("S_DEPOSITDATE_FR");
		String S_DEPOSITDATE_TO = request.getParameter("S_DEPOSITDATE_TO");		
		String S_SALEGUBUN = request.getParameter("S_SALEGUBUN");
		String S_REGYN = request.getParameter("S_REGYN");
		
		vo.setS_DEPOSITDATE_FR(S_DEPOSITDATE_FR);
		vo.setS_DEPOSITDATE_TO(S_DEPOSITDATE_TO);
		vo.setS_SALEGUBUN(S_SALEGUBUN);
		vo.setS_REGYN(S_REGYN);
		
		JSONArray jCell = new JSONArray();
		JSONObject json = new JSONObject();
		
		List<SA012012VO> lst = SA012012Biz.selectListSA012012(vo);
		
		for(int i = 0; i < lst.size(); i++) {
			JSONObject obj = new JSONObject();
			
			obj.put("SALEID", lst.get(i).getSALEID());			
			obj.put("SALEGUBUNNAME", lst.get(i).getSALEGUBUNNAME());
			obj.put("KNAME", lst.get(i).getKNAME());
			obj.put("MNGRNAME", lst.get(i).getMNGRNAME());
			obj.put("CONNAME", lst.get(i).getCONNAME());
			obj.put("SALEDATE", lst.get(i).getSALEDATE());
			obj.put("FULLADDRESS", lst.get(i).getCITYNAME() +" "+ lst.get(i).getBOROUGHNAME() +" "+ lst.get(i).getADDRESS());
			obj.put("CONM2", lst.get(i).getCONM2());
			obj.put("CONPY", lst.get(i).getCONPY());
			obj.put("SALEDANGA", lst.get(i).getSALEDANGA());
			obj.put("SELLAMT", lst.get(i).getSELLAMT());
			obj.put("REGNAME", lst.get(i).getREGNAME());
			obj.put("REGDATE", lst.get(i).getREGDATE());
			
			jCell.add(obj);
		}
		
		json.put("rows", jCell);
		
		logger.debug("[selectListSA012012]" + json);
		
		return new ModelAndView("jsonView", json);
	}	
}
