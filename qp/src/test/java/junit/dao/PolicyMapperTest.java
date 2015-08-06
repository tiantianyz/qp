package junit.dao;

import junit.TestParent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by roger.zhang on 14-8-29.
 */
public class PolicyMapperTest extends TestParent {

    private static final Logger logger = LoggerFactory.getLogger(PolicyMapperTest.class);
 /*   @Autowired
    private PolicyMapper policyMapper;

    @Test
    public void testInsertPolicy() throws Exception {
        Policy policy = getInsertRecord();
        int insertFlag = policyMapper.insert(policy);
        logger.info("insert policy insertFlag={}",insertFlag);
    }
    private Policy getInsertRecord() {
        Policy policyBean = new Policy();
        policyBean.setFlightcode("CZ");
        policyBean.setOfficeno("PEK110");
        policyBean.setStartdateTicket("2014-07-03");
        policyBean.setEnfdateTicket("2014-07-03");
        policyBean.setStartdate("2014-07-03");
        policyBean.setEnddate("2014-07-03");
        policyBean.setDpt("CAN");
        policyBean.setArr("PEK/CTU/CKG");
        policyBean.setCabin("Y/Y1/T/W/T1/H/M/G/S/L/Q/E");
        policyBean.setReturnpoint(new BigDecimal("3.5"));
        short numLimit = new Integer(1).shortValue();
        byte productTypeByte = new Integer(1).byteValue();
        policyBean.setProducttype(productTypeByte);
        policyBean.setNote("");
        policyBean.setAutoticket(true);
        policyBean.setSwitchpnr(false);
        policyBean.setCodeAuth(true);
        policyBean.setFlightnumlimit(numLimit);
        policyBean.setStatus(new Integer(3).shortValue());
        policyBean.setFlighttype(new Integer(0).shortValue());
        //todo
        policyBean.setSavestatus(new Integer(1).shortValue());
        Random random= new Random();
        policyBean.setFriendlyid(""+random.nextInt());
        policyBean.setSupplierid("4e7376bb-82a0-4fee-a22f-37f3766b4fac");
        return policyBean;
    }

    @Test
    public void testUpdatePolicy() throws Exception {
        Policy policy = getUpdateRecord();
        int insertFlag = policyMapper.updateByPrimaryKeySelective(policy);
        logger.info("insert policy insertFlag={}",insertFlag);
    }
    private Policy getUpdateRecord() {
        Policy policyBean = new Policy();
        policyBean.setId(new Long(1));
        policyBean.setFlightcode("ww");
        policyBean.setOfficeno("PEK110");
        policyBean.setStartdateTicket("2014-07-03");
        policyBean.setEnfdateTicket("2014-07-03");
        policyBean.setStartdate("2014-07-03");
        policyBean.setEnddate("2014-07-03");
        policyBean.setDpt("CAN");
        policyBean.setArr("PEK/CTU/CKG");
        policyBean.setCabin("Y/Y1/T/W/T1/H/M/G/S/L/Q/E");
        policyBean.setReturnpoint(new BigDecimal("3.5"));
        short numLimit = new Integer(1).shortValue();
        byte productTypeByte = new Integer(1).byteValue();
        policyBean.setProducttype(productTypeByte);
        policyBean.setNote("");
        policyBean.setAutoticket(true);
        policyBean.setSwitchpnr(false);
        policyBean.setFlightnumlimit(numLimit);
        policyBean.setStatus(new Integer(3).shortValue());
        policyBean.setFlighttype(new Integer(0).shortValue());
        //todo
//        policyBean.setSavestatus(new Integer(1).shortValue());
//        policyBean.setFriendlyid("");
        policyBean.setSupplierid("4e7376bb-82a0-4fee-a22f-37f3766b4fac");
        return policyBean;
    }
    @Test
    public void testLookPolicy() throws Exception {
        long id = new Long(1);
        String supplierid = "4e7376bb-82a0-4fee-a22f-37f3766b4fac";
        Policy policy = policyMapper.selectBySupplerId(supplierid,id);
        logger.info("insert policy policy={}",policy);
    }
    @Test
    public void testgenB2BFriendlyIdUniq() throws Exception {

        String friendlyId =  PolicyUtil.genB2BFriendlyIdUniq(GlobalConstants.getAtomicInteger());
        System.out.println("insert policy friendlyId={}" + friendlyId);
    }
    @Test
    public void testQueryRankPolicyList() throws Exception {
        long id = new Long(1);
        String supplierid = "4e7376bb-82a0-4fee-a22f-37f3766b4fac";
        Policy qb = getQueryRankPolicy();
        List<Policy> policyList = null;
		int totalCount = 0;
		policyList = policyMapper.selectRankPolicyList(qb);
		totalCount = policyMapper.selectRankPolicyCount(qb);
        logger.info("policyRankList baitour policyList={},totalCount={}", policyList.size(), totalCount);
        for (int i = 0; i < policyList.size(); i++) {
        	Policy policy = policyList.get(i);
        	logger.info("policyRankList baitour policy={}", policy);
		}
    }
	private Policy getQueryRankPolicy() {
		Policy qb = new Policy();
			qb.setFlightcode("CA");
			qb.setDpt("CAN");
			qb.setArr("PEK");
			//航班类型：0 单程 1 往返 2 单程以及往返
			qb.setFlighttype(new Short("1"));
			//票证类型：2 B2B,1 BSP
			qb.setProductType(new Byte("1"));
			qb.setFlightcondition(""); 
			qb.setCabin("Y");
			qb.setStartdateTicket("");
			qb.setEnfdateTicket("");
			qb.setStatus(new Short("2"));
		if(baitourAgent != null) {
			//供应商id
			qb.setSupplierid(baitourAgent.getAgentID());
			//状态：1删除 2挂起 3有效 4失效
			qb.setStatus(new Integer(3).shortValue()); //供应商只能查询有效状态
		} else {
			//为运维人员查询, 不查询删除状态
			qb.setExceptStatus(new Short("1"));
		}
			//为运维人员查询, 不查询删除状态
			qb.setExceptStatus(new Short("1"));
		logger.info("policyRankList baitour PolicyBean={}", qb);
		return qb;
	}*/
	
}