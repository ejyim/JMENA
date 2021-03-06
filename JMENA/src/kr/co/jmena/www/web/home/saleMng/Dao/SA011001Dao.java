package kr.co.jmena.www.web.home.saleMng.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.jmena.www.web.home.buyingMng.Vo.MM011001VO;
import kr.co.jmena.www.web.home.saleMng.Vo.SA011001VO;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SA011001Dao extends SqlMapClientDaoSupport {

	protected final Logger logger = Logger.getLogger(getClass());
	
	private final String NAME_SPACE = "SA011001.";

	public int selectDataSaleHistoryTb004(SA011001VO vo) throws DataAccessException {
		int cnt = (int)getSqlMapClientTemplate().queryForObject(NAME_SPACE + "selectDataSaleHistoryTb004", vo);

		return cnt;
	}
	
	public List<SA011001VO> selectListEanSaleMst(SA011001VO vo) throws DataAccessException {
		List<SA011001VO> lst = null;	
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEanSaleMst", vo);
		
		return lst;
	}
	
	public boolean insertDataSaleMst(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		String SALEID = (String) getSqlMapClientTemplate().insert(NAME_SPACE + "insertDataSaleMst", vo);
		
		vo.setSALEID(SALEID);
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "insertDataSaleDtl", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean updateDataSaleMst(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		int cnt = 0;
		
		if ((int)getSqlMapClientTemplate().update(NAME_SPACE + "updateDataSaleMst", vo) > 0) {
			cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "updateDataSaleDtl", vo);
		}
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public int selectAllSaleHistoryTb(SA011001VO vo) throws DataAccessException {
		int cnt = (int)getSqlMapClientTemplate().queryForObject(NAME_SPACE + "selectAllSaleHistoryTb", vo);

		return cnt;
	}
	
	public boolean deleteAllSaleHistoryTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteAllSaleHistoryTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public int selectAllJointnameTb(SA011001VO vo) throws DataAccessException {
		int cnt = (int)getSqlMapClientTemplate().queryForObject(NAME_SPACE + "selectAllJointnameTb", vo);

		return cnt;
	}
	
	public boolean deleteAllJointnameTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteAllJointnameTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public int selectAllIpgumScheduleTb(SA011001VO vo) throws DataAccessException {
		int cnt = (int)getSqlMapClientTemplate().queryForObject(NAME_SPACE + "selectAllIpgumScheduleTb", vo);

		return cnt;
	}
	
	public boolean deleteAllIpgumScheduleTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteAllIpgumScheduleTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean deleteDataSaleDtl(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteDataSaleDtl", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean deleteDataSaleMst(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteDataSaleMst", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public List<SA011001VO> selectListEnaIpgumScheduleTb(SA011001VO vo) throws DataAccessException {
		List<SA011001VO> lst = null;	
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaIpgumScheduleTb", vo);
		
		return lst;
	}
	
	public boolean insertDataEnaIpgumScheduleTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "insertDataEnaIpgumScheduleTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean updateDataEnaIpgumScheduleTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "updateDataEnaIpgumScheduleTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean deleteDataEnaIpgumScheduleTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteDataEnaIpgumScheduleTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public List<SA011001VO> selectListEnaJointNameTb(SA011001VO vo) throws DataAccessException {
		List<SA011001VO> lst = null;	
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaJointNameTb", vo);
		
		return lst;
	}
	
	public boolean updateDataJoint(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "updateDataJoint", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean insertDataEnaJointNameTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "insertDataEnaJointNameTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean updateDataEnaJointNameTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "updateDataEnaJointNameTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean deleteDataEnaJointNameTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteDataEnaJointNameTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public List<SA011001VO> selectListEnaSaleHistoryTb(SA011001VO vo) throws DataAccessException {
		List<SA011001VO> lst = null;	
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaSaleHistoryTb", vo);
		
		return lst;
	}
	
	public boolean insertDataEnaSaleHistoryTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "insertDataEnaSaleHistoryTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean updateDataEnaSaleHistoryTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().update(NAME_SPACE + "updateDataEnaSaleHistoryTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public boolean deleteDataEnaSaleHistoryTb(SA011001VO vo) throws DataAccessException {
		boolean chkFlag = false;
		
		int cnt = (int)getSqlMapClientTemplate().delete(NAME_SPACE + "deleteDataEnaSaleHistoryTb", vo);
		
		if (cnt > 0) chkFlag = true;
		return chkFlag;
	}
	
	public List<SA011001VO> selectListEanSaleMstPopup(SA011001VO vo) throws DataAccessException {
		List<SA011001VO> lst = null;	
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEanSaleMstPopup", vo);
		
		return lst;
	}
	
	public List<MM011001VO> selectListEnaBuyMstPopup(MM011001VO vo) throws DataAccessException {
		List<MM011001VO> lst = null;	
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaBuyMstPopup", vo);
		
		return lst;
	}
	
	public List<SA011001VO> selectHRInsamstBranchCode(SA011001VO vo) throws DataAccessException {
		List<SA011001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectHRInsamstBranchCode", vo);
		
		return lst;
	}
	
}