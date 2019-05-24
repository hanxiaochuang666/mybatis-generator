package com.hanchuang.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {

	public static void generator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

		myBatisGenerator.generate(null);
		
	}

	public static void main(String[] args)
			throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
		generator();
		System.out.println("----------------- 执行成功！ ----------------------");
	}


//	public static void main(String[] args){
//
//		String aaStr = "ORD_TEMP_CREDIT_LIMIT@@ORD_TAX_PAYER_ATTR@@ORD_TAX_PAYER@@ORD_SPECIAL_REQMT_IND@@ORD_SPECIAL_LIST@@ORD_SERVICE_REQMT_IND@@ORD_SERVICE_GRADE@@ORD_ROUTE_INFO@@ORD_PROD_RES_INST_REL@@ORD_PROD_INST_STATE@@ORD_PROD_INST_REL@@ORD_PROD_INST_PAYMODE@@ORD_PROD_INST_CONTACT@@ORD_PROD_INST_ATTR@@ORD_PROD_INST_ACC_NUM@@ORD_PROD_INST_ACCT_REL@@ORD_PROD_INST@@ORD_PAY_TRANS_INST_DETAIL@@ORD_PAYMENT_PLAN@@ORD_PARTY_ROLE@@ORD_PARTY_REL@@ORD_PARTY_ORG@@ORD_PARTY_IND@@ORD_PARTY_CERT@@ORD_PARTY_ATTR@@ORD_PARTY@@ORD_OFFER_RES_INST_REL@@ORD_OFFER_PROD_INST_REL@@ORD_OFFER_OBJ_INST_REL@@ORD_OFFER_INST_REL@@ORD_OFFER_INST_FEE_INFO@@ORD_OFFER_INST_FEE_ATTR@@ORD_OFFER_INST_ATTR@@ORD_OFFER_INST_ASSURE@@ORD_OFFER_INST@@ORD_MKT_RES_INST_STORE@@ORD_MKT_RES_INST_ATTR@@ORD_MKT_RES_INST@@ORD_GROUP_PAY_TRANS_INST@@ORD_GROUP_PAY_LIMIT@@ORD_EXT_ACCT@@ORD_DEV_STAFF_INFO@@ORD_CUST_CONTACT_INFO_REL@@ORD_CUST_ATTR@@ORD_CUSTOMER@@ORD_CREDIT_LIMIT@@ORD_CREDIT@@ORD_CONTACTS_INFO_ATTR@@ORD_CONTACTS_INFO@@ORD_CERT_INFO_SYS_REL@@ORD_CERT_INFO@@ORD_ACC_NBR_ATTR@@ORD_ACCOUNT@@ORDER_MODIFY@@ORDER_ITEM_REL@@ORDER_ITEM_MODIFY@@ORDER_ITEM_ATTR@@ORDER_CONTACT_INFO@@ORDER_BALANCE@@ORDER_ITEM@@ORDER_HANDLER@@ORDER_ATTR@@CUST_ORDER_LOGISTICS@@CUSTOMER_ORDER";
//
//		String[] aaAray = aaStr.split("@@");
//		if(null!=aaAray&&aaAray.length>0){
//			StringBuffer sb = new StringBuffer();
//			for(int a = 0;a<aaAray.length;a++){
//				String tableName = aaAray[a];
//				sb.append("<table tableName=\""+tableName+"\" enableSelectByExample=\"true\""+"\n");
//				sb.append("  enableDeleteByExample=\"true\" enableCountByExample=\"true\""+"\n");
//				sb.append("  enableUpdateByExample=\"true\" selectByExampleQueryId=\"false\">"+"\n");
//				sb.append("  <property name=\"ignoreQualifiersAtRuntime\" value=\"false\" />"+"\n");
//				sb.append("  <property name=\"useActualColumnNames\" value=\"false\" />"+"\n");
//				sb.append("</table>"+"\n");
//			}
//			System.out.println("测试表配置===\n"+sb.toString());
//		}
//	}

}
