package object.handler.sqlbuild;

import object.handler.entities.User;

public class UserSqlBuild {

	private static UserSqlBuild instance;
	private static String user = User.class.getSimpleName().toLowerCase();

	public static UserSqlBuild getInstace() {
		if (instance == null) {
			instance = new UserSqlBuild();
		}
		return instance;
	}

	public String insert() {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ");
		sb.append(user);
		sb.append(" (firstname, surname, email, phone, username, password) ");
		sb.append("values (?, ?, ?, ?, ?, ?); ");
		return sb.toString();
	}

	public String update() {
		StringBuilder sb = new StringBuilder();
		sb.append("update ");
		sb.append(user);
		sb.append(" set firstname = ?, surname = ?, email = ?, phone = ?, username = ?");
		sb.append("where id = ? ");
		return sb.toString();
	}

	public String delete() {
		StringBuilder sb = new StringBuilder();
		sb.append("delete from ");
		sb.append(user);
		sb.append(" where id = ? ");
		return sb.toString();
	}

	public String getById() {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");
		sb.append(user);
		sb.append(" where id = ?");
		return sb.toString();
	}

	public String getAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ");
		sb.append(user);
		return sb.toString();
	}

}
