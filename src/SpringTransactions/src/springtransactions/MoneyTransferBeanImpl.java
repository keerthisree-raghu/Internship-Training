package springtransactions;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class MoneyTransferBeanImpl implements MoneyTransferBean {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void credit(int accountId, int amount) throws Exception {
		// datasource.getConnection().setAutoCommit(false);
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		Integer oldAmount = jdbc.queryForObject("select amount from accounts where accountId = ?",
				new Object[] { accountId }, Integer.class);
		int newAmount = oldAmount + amount;

		NamedParameterJdbcTemplate njdbc = new NamedParameterJdbcTemplate(dataSource);

		MapSqlParameterSource mps = new MapSqlParameterSource();
		mps.addValue("amt", newAmount);
		mps.addValue("id", accountId);
		njdbc.update("update accounts set amount=:amt where accountId=:id", mps);
	}

	@Override
	public void debit(int accountId, int amount) throws Exception {
		// dataSource.getConnection().setAutoCommit(false);
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		Integer oldAmount = jdbc.queryForObject("select amount from accounts where accountId=?",
				new Object[] { accountId }, Integer.class);
		if (oldAmount < amount) {
			throw new InsufficientBalanceException("The user does not have enough balance...");
			// throw new RuntimeException();
		}
		int newAmount = oldAmount - amount;
		NamedParameterJdbcTemplate njdbc = new NamedParameterJdbcTemplate(dataSource);

		MapSqlParameterSource mps = new MapSqlParameterSource();
		mps.addValue("amt", newAmount);
		mps.addValue("id", accountId);
		njdbc.update("update accounts set amount=:amt where accountId=:id", mps);

	}
}
