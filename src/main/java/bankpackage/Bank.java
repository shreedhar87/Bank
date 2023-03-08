package bankpackage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	
	private int id;
	private int numemployee;
	private String bankname;
	private String bankloc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumemployee() {

		return numemployee;
	}

	public void setNumemployee(int numemployee) {
		this.numemployee = numemployee;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankloc() {
		return bankloc;
	}

	public void setBankloc(String bankloc) {
		this.bankloc = bankloc;
	}

}
