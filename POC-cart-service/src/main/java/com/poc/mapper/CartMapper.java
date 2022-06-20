package com.poc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.poc.dto.RequestDTO;
import com.poc.entity.Cart;
import com.poc.entity.CartItems;
import com.poc.entity.Product;

@Mapper
public interface CartMapper {
	
	
	@Insert("insert into carts(cartId, ownerFName, ownerLName, ownerEmail) "
			+ "values(#{cartId},#{ownerFName}, #{ownerLName}, #{ownerEmail})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "cartId", before = false, resultType = Integer.class)
	int create(Cart cart);

	@Select("select * from carts where ownerFName=#{ownerFName} and ownerLName=#{ownerLName}")
	Cart getCart(Cart cart);
	
	@Select("select * from cartItems where cartId=#{cartId} and ownerEmail=#{ownerEmail}")
	List<CartItems> getMyCart(Integer cartId, String ownerEmail);
	
//	@Select("select count(*) from carts where cartId=#{cartId}")
//	int checkCartExistence(Integer cartId);
	
	@Update("update carts set ownerFName=#{ownerFName}, ownerLName=#{ownerLName} where cartId=#{cartId}")
	int updateCart(Cart cart);
	
	@Delete("delete from cartItems where cartId=#{cartId} AND product_id=#{product_id}")
	int deleteCartItems(Integer cartId, Integer product_id);
	
	@Delete("delete from cartItems where cartId=#{cartId}")
	int deleteAllItems(int cartId);
	
//	@Select("select * from carts")
//	List<Cart> getList(Cart cart);
	
	@Select("select count(*) from products where product_id=#{product_id}")
	int checkProductExistence(Integer product_id);
	
	@Select("select count(*) from carts where cartId=#{cartId} and ownerEmail=#{ownerEmail}")
	int checkCartExistence(Integer cartId, String ownerEmail);
	
	@Insert("insert into cartitems(cartItemId, cartId, ownerEmail, product_id, product_name, price, order_qty, order_subtotal) "
			+ " values(#{cartItemId}, #{cartId}, #{ownerEmail}, #{product_id}, #{product_name}, #{price}, #{order_qty}, #{order_subtotal})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "cartItemId", before = false, resultType = Integer.class)
	int addToCart(CartItems items);
	
	@Select("select * from products where product_id=#{product_id}")
	Product getProduct(Integer product_id);
}