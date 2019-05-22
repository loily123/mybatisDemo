package mybatisDemo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Admin;
import mapper.AdminMapper;

public class AdminTest {
	private static SqlSessionFactory factory;
	static {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		factory = builder.build(AdminTest.class.getClassLoader().getResourceAsStream("sqlMapConfig.xml"));
	}

	@Test
	public void queryAll() {
		SqlSession session = factory.openSession();
		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
		List<Admin> admins = adminMapper.queryAll();
		System.out.println(admins.size());
		for (Admin admin : admins) {
			System.out.println(admin);
		}
	}

	@Test
	public void addAdmin() {
		SqlSession session = factory.openSession();
		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
		Admin admin = new Admin();
		admin.setId(2);
		admin.setUserName("≤‚ ‘");
		admin.setPassword("a∞°bb");
		adminMapper.addAdmin(admin);
		session.commit();
	}

	@Test
	public void deleteAdmin() {
		SqlSession session = factory.openSession();
		AdminMapper adminMapper = session.getMapper(AdminMapper.class);
		adminMapper.deleteAdmin(2);
		session.commit();
	}
}
