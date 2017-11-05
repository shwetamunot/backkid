package niit.com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table
public class User implements Serializable{
//	private static final long serialVersionUID=1L;
			@Id
			int useId;
		 String email;
	     String name;
		int phno;
	    String password;
		String username;
	     public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	     
	      public int getUseId() {
				return useId;
			}
			public void setUseId(int useId) {
				this.useId = useId;
			}
		public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}

			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getRole() {
				return role;
			}
			public void setRole(String role) {
				this.role = role;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
		
	        public int getPhno() {
				return phno;
			}
			public void setPhno(int phno) {
				this.phno = phno;
			}

		 String address;	
	     String role;
	     String country;
	       
}
