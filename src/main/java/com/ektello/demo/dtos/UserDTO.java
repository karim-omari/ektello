package com.ektello.demo.dtos;

import com.ektello.demo.entities.User;

public class UserDTO {

	 public String firstName;
	 public String lastName;
	 public String address1;
	 public String address2;
	 public String city;
	 public String state;
	 public String zip;
	 public String country;
	 public String date;
	 
	 public UserDTO() {}
	 public UserDTO(User user) {
			this.address1 = user.getAddress1();
			this.address2 = user.getAddress2();
			this.city = user.getCity();
			this.country = user.getCountry();
			this.firstName =user.getFirstName();
			this.lastName = user.getLastName();
			this.state = user.getState();
			this.zip = user.getZip();
			this.date = user.getDate().toString();
		}
	 public void Validate() {
		 if (firstName == null || firstName == "")
			 throw new RuntimeException("first name is required");
		 if (lastName == null || lastName == "")
			 throw new RuntimeException("last name is required");
		 if (state == null || state == "")
			 throw new RuntimeException("state is required");
		 if (address1 == null || address1 == "")
			 throw new RuntimeException("address1 is required");
		 
		 if (city == null || city == "")
			 throw new RuntimeException("city is required");
		 if (country == null || country == "")
			 throw new RuntimeException("country is required");
		 if (zip == null || zip == "")
			 throw new RuntimeException("zip is required");
		 if (zip.length()!=5 && zip.length() != 9)
			 throw new RuntimeException("zip is wrong");
	 }
	
}
