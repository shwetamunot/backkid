package niit.com.model;

import javax.persistence.Entity
;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product {
	@Id
int proId;
String proName,proDesc;
int stock,price,cId,sId;
@Transient
MultipartFile pimge;

public MultipartFile getPimge() {
	return pimge;
}
public void setPimge(MultipartFile pimge) {
	this.pimge = pimge;
}
public int getsId() {
	return sId;
}
public void setsId(int sId) {
	this.sId = sId;
}
public int getProId() {
	return proId;
}
public void setProId(int proId) {
	this.proId = proId;
}
public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public String getProDesc() {
	return proDesc;
}
public void setProDesc(String proDesc) {
	this.proDesc = proDesc;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getcId() {
	return cId;
}
public void setcId(int cId) {
	this.cId = cId;
}

}
