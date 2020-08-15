package database.api.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResources {

	void bind(ResultSet rs) throws SQLException;
	void bindList(ResultSet rs) throws SQLException;

}
