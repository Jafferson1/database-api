package object.handler.custom;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.api.execute.Execute;
import object.handler.objects.User;
import object.handler.sqlbuild.UserSqlBuild;

public class UserCustom {

	static Logger logger = LoggerFactory.getLogger(UserCustom.class);
	private static UserSqlBuild usb = UserSqlBuild.getInstace();
	private static UserCustom instance;

	public static UserCustom getInstace() {
		if (instance == null) {
			instance = new UserCustom();
		}
		return instance;
	}

	public int save(User user) throws Exception {
		int rows_affected = 0;
		String query = usb.insert();
		Object[] params = { user.getFirstname(), user.getSurname(), user.getEmail(), user.getPhone(),
				user.getUsername(), user.getPassword() };
		try {
			rows_affected = Execute.make(params, query);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error while saving user");
		}
		return rows_affected;
	}

	public User getById(long id) throws Exception {
		String query = usb.getById();
		Object[] params = { id };
		User user = new User();
		try {
			Execute.fetch(user, params, query);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error fetching user");
		}
		return user;
	}
}
