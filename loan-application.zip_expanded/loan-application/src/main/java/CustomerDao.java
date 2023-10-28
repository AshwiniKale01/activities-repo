import org.springframework.data.jpa.repository.Query;

import com.npci.loanapplication.beans.Customer;

public interface CustomerDao {
	
	@Query("select c from Profile c  where c.emailid =?1")
	public Customer findByEmailId(String emailid);

}
