package object.handler.test;

import object.handler.custom.UserCustom;
import object.handler.objects.User;

public class Main {

	public static void main(String[] args) throws Exception {
		UserCustom uc = UserCustom.getInstace();
//      User user = new User();
//		user.setFirstname("jafferson");
//		user.setSurname("alves");
//		user.setEmail("jafferson@gmail.com");
//		user.setPhone("83981686507");
//		user.setUsername("jafferson1");
//		user.setPassword("secret");
//		int id = uc.save(user);

//		if (id > 0)
//			System.out.println("saved!");
		User user = uc.getById(1);
		System.out.println("--> " + user.getFirstname());
	}
}
