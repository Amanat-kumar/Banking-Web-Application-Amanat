package dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customers {

	@Id
	@SequenceGenerator(initialValue = 112233, allocationSize = 1, sequenceName = "customerId", name = "customerId")
	@GeneratedValue(generator = "customerId")
	int cId;

	@Column(nullable = false, unique = false)
	String cName;

	@Column(unique = true, nullable = false)
	long cPhone;

	@Column(unique = true, nullable = false)
	String cEmail;

	@Column(nullable = false)
	String cPwd;

	@Column(nullable = false)
	String cGender;

	@Column(nullable = false)
	Date cDob;

	@OneToMany
	List<BankAccounts> bankAccountList;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public long getcPhone() {
		return cPhone;
	}

	public void setcPhone(long cPhone) {
		this.cPhone = cPhone;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPwd() {
		return cPwd;
	}

	public void setcPwd(String cPwd) {
		this.cPwd = cPwd;
	}

	public String getcGender() {
		return cGender;
	}

	public void setcGender(String cGender) {
		this.cGender = cGender;
	}

	public Date getcDob() {
		return cDob;
	}

	public void setcDob(Date cDob) {
		this.cDob = cDob;
	}

	public List<BankAccounts> getBankAccountList() {
		return bankAccountList;
	}

	public void setBankAccountList(List<BankAccounts> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}
	

}
