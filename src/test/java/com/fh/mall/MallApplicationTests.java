package com.fh.mall;

import com.fh.mall.utils.GetUploadPath;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
class MallApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private Environment environment;

	@Autowired
	private GetUploadPath getUploadPath;


	@Test
	void contextLoads() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println("获取连接------------");
		System.out.println("默认的数据源是------------" + dataSource.getClass());
		System.out.println(connection != null);
		connection.close();
	}

	@Test
	public void getPathTest(){
//		String property = environment.getProperty("upload.path");
//		System.out.println(property);
//		getUploadPath.setUploadPath("fff");
		String uploadPath = getUploadPath.getUploadPath();
		System.out.println(uploadPath);
	}

}
