package kr.co.jmena.www.web.home.personMng.Dao;

import java.util.List;

import kr.co.jmena.www.web.home.personMng.Vo.HR011001VO;
import kr.co.jmena.www.web.home.systemMng.Vo.SY021001VO;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HR011001Dao extends SqlMapClientDaoSupport {

	protected final Logger logger = Logger.getLogger(getClass());
	
	private final String NAME_SPACE = "HR011001.";

	/**
	 * 시스템 메뉴
	 * @return
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public List<HR011001VO> selectListEnaInsaMst(HR011001VO vo) throws DataAccessException {
		List<HR011001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaInsaMst", vo);
		
		return lst;
	}	
	
	
	public int updateEnaInsaMst(HR011001VO vo) throws DataAccessException {
		int updateCnt = 0;
		
		updateCnt = getSqlMapClientTemplate().update(NAME_SPACE + "updateEnaInsaMst", vo);
		
		return updateCnt;
	}
	
	public int insertEnaInsaMst(HR011001VO vo) throws DataAccessException {
		int insertCnt = 0;
		
		insertCnt = getSqlMapClientTemplate().update(NAME_SPACE + "insertEnaInsaMst", vo);
		
		return insertCnt;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<HR011001VO> selectListEnaAppointItem(HR011001VO vo) throws DataAccessException {
		List<HR011001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaAppointItem", vo);
		
		return lst;
	}	
	
	@SuppressWarnings("unchecked")
	public List<HR011001VO> selectListEnaTexPayerItem(HR011001VO vo) throws DataAccessException {
		List<HR011001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaTexPayerItem", vo);
		
		return lst;
	}	
		
}
