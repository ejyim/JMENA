package kr.co.jmena.www.web.home.saleMng.Dao;

import java.util.List;

import kr.co.jmena.www.web.home.saleMng.Vo.SA012001VO;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SA012001Dao extends SqlMapClientDaoSupport {

	protected final Logger logger = Logger.getLogger(getClass());
	
	private final String NAME_SPACE = "SA012001.";

	/**
	 * 시스템 메뉴
	 * @return
	 * @throws DataAccessException
	 */
	public List<SA012001VO> selectListSA012001_1(SA012001VO vo) throws DataAccessException {
		List<SA012001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListSA012001_1", vo);
		
		return lst;
	}

	public List<SA012001VO> selectListSA012001_2(SA012001VO vo) throws DataAccessException {
		List<SA012001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListSA012001_2", vo);
		
		return lst;
	}

	public List<SA012001VO> selectListSA012001_3(SA012001VO vo) throws DataAccessException {
		List<SA012001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListSA012001_3", vo);
		
		return lst;
	}

	public List<SA012001VO> selectListSA012001_4(SA012001VO vo) throws DataAccessException {
		List<SA012001VO> lst = null;
		
		lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListSA012001_4", vo);
		
		return lst;
	}
	
}
