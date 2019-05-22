package mapper;

import java.util.List;
import java.util.Map;

import entity.Admin;

public interface AdminMapper {
	List<Admin> queryAll();

	void addAdmin(Admin admin);

	void deleteAdmin(int id);
}
