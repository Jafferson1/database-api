package object.handler.test;

import java.util.List;

import object.handler.custom.UserCustom;
import object.handler.entities.User;

public class Main {

	public static void main(String[] args) throws Exception {

		UserCustom uc = UserCustom.getInstace();

		User user = new User();
		user.setFirstname("jafferson");
		user.setSurname("alves");
		user.setEmail("jaffersonaraujo@gmail.com");
		user.setPhone("981686507");
		user.setUsername("jafferson1");
		user.setPassword("secret");

		int id = uc.save(user);
		if (id > 0)
			System.out.println("saved!");

		user = uc.getById(1);
		System.out.println("--> " + user.getFirstname());

		List<User> u = uc.getAll();
		for (int i = 0; i < u.size(); i++) {
			System.out.println("--> " + u.get(i).getFirstname());
		}

		user.setId(1);
		id = uc.change(user);
		if (id > 0)
			System.out.println("changed!");

		id = uc.remove(1);
		if (id > 0)
			System.out.println("removed!");
	}
}
