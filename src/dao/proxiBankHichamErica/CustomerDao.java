package dao.proxiBankHichamErica;

import java.util.List;

public interface CustomerDao {
	public int createCustomer(Client c) throws MybusinessException;

	public int deleteCustomer(Client c) throws MybusinessException;

	public Conseiller findConseillerById(int id);

	public Client findCustomer(Client c);

	public int modifyCustomer(Client c) throws MybusinessException;

	public List<Client> findAllPerson();

}
