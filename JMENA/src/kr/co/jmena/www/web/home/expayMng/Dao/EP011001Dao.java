package kr.co.jmena.www.web.home.expayMng.Dao;

import java.util.List;

import kr.co.jmena.www.web.home.expayMng.Vo.EP011001VO;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EP011001Dao extends SqlMapClientDaoSupport {

	protected final Logger logger = Logger.getLogger(getClass());
	
	private final String NAME_SPACE = "EP011001.";

	/**
	 * 시스템 메뉴
	 * @return
	 * @throws DataAccessException
	 */
	public List<EP011001VO> selectListEnaInsaMst() throws DataAccessException {
		List<EP011001VO> lst = null;
		
		//lst = getSqlMapClientTemplate().queryForList(NAME_SPACE + "selectListEnaInsaMst");
		
		return lst;
	}
	
}
