package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tab1_cstmr")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer cid;
	@Column(name="name")
	private String cname;
	@Column(name="address")
	private String caddr;
	@Column(name="gen")
	private Character cgender;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddr() {
		return caddr;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public Character getCgender() {
		return cgender;
	}

	public void setCgender(Character cgender) {
		this.cgender = cgender;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddr=" + caddr + ", cgender=" + cgender + "]";
	}

}
