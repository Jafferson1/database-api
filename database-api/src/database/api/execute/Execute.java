package database.api.execute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.api.config.Manager;
import database.api.interfaces.IResources;

public class Execute {

	static Logger logger = LoggerFactory.getLogger(Execute.class);

	public static int make(Object[] o, String query) throws SQLException, ClassCastException {
		int id = 0;
		try (Connection connection = Manager.getConn();
				PreparedStatement statement = connection.prepareStatement(query)) {
			int i = 0;
			int s = o.length;
			for (i = 0; i < s; i++) {
				if (o[i] instanceof Integer) {
					statement.setInt(i + 1, (int) o[i]);
				} else if (o[i] instanceof Long) {
					statement.setLong(i + 1, (long) o[i]);
				} else if (o[i] instanceof Double) {
					statement.setDouble(i + 1, (double) o[i]);
				} else if (o[i] instanceof String) {
					statement.setString(i + 1, (String) o[i]);
				} else if (o[i] instanceof Boolean) {
					statement.setBoolean(i + 1, (Boolean) o[i]);
				}
			}
			id = statement.executeUpdate();
			logger.info("Number of rows affected => " + id);
			if (id == 0) {
				throw new SQLException("Error... No rows affected!");
			}
		} catch (SQLException e) {
			throw new SQLException("Error compile sql statement -> " + e);
		} catch (ClassCastException e) {
			throw new ClassCastException("Error casting object value -> " + e);
		} finally {
			o = null;
			query = null;
		}
		return id;
	}

	public static void fetch(IResources in, Object[] o, String query) throws SQLException, ClassCastException {
		ResultSet rs = null;
		try (Connection connection = Manager.getConn();
				PreparedStatement statement = connection.prepareStatement(query)) {
			int i = 0;
			int s = o.length;
			for (i = 0; i < s; i++) {
				if (o[i] instanceof Integer) {
					statement.setInt(i + 1, (int) o[i]);
				} else if (o[i] instanceof Long) {
					statement.setLong(i + 1, (long) o[i]);
				} else if (o[i] instanceof Double) {
					statement.setDouble(i + 1, (double) o[i]);
				} else if (o[i] instanceof String) {
					statement.setString(i + 1, (String) o[i]);
				} else if (o[i] instanceof Boolean) {
					statement.setBoolean(i + 1, (Boolean) o[i]);
				}
			}
			rs = statement.executeQuery();
			in.bind(rs);
		} catch (SQLException e) {
			throw new SQLException("Error compile sql statement -> " + e);
		} catch (ClassCastException e) {
			throw new ClassCastException("Error casting object value -> " + e);
		} finally {
			o = null;
			query = null;
		}
	}
	
	public static void fetchList(IResources in, Object[] o, String query) throws SQLException, ClassCastException {
		ResultSet rs = null;
		try (Connection connection = Manager.getConn();
				PreparedStatement statement = connection.prepareStatement(query)) {
			int i = 0;
			int s = o.length;
			for (i = 0; i < s; i++) {
				if (o[i] instanceof Integer) {
					statement.setInt(i + 1, (int) o[i]);
				} else if (o[i] instanceof Long) {
					statement.setLong(i + 1, (long) o[i]);
				} else if (o[i] instanceof Double) {
					statement.setDouble(i + 1, (double) o[i]);
				} else if (o[i] instanceof String) {
					statement.setString(i + 1, (String) o[i]);
				} else if (o[i] instanceof Boolean) {
					statement.setBoolean(i + 1, (Boolean) o[i]);
				}
			}
			rs = statement.executeQuery();
			in.bindList(rs);
		} catch (SQLException e) {
			throw new SQLException("Error compile sql statement -> " + e);
		} catch (ClassCastException e) {
			throw new ClassCastException("Error casting object value -> " + e);
		} finally {
			o = null;
			query = null;
		}
	}

}
