package com.poc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dto.CartResponseDTO;
import com.poc.dto.RequestDTO;
import com.poc.dto.ResponseDTO;
import com.poc.entity.Cart;
import com.poc.entity.CartItems;
import com.poc.entity.Product;
import com.poc.mapper.CartMapper;
import com.poc.util.CartServiceValidator;

@Service
public class CartService {

	@Autowired
	CartMapper cartMapper;
	
	@Autowired
	CartServiceValidator validator;
	
	public Cart insertCart(Cart cart) {
		cartMapper.create(cart);
		return cartMapper.getCart(cart);

	}

//	public List<Cart> getList(Cart cart) {
//		return cartMapper.getList(cart);
//	}
	
	public Object deleteItem(Integer cartId, RequestDTO request) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			System.out.println(request.toString());
			cartMapper.deleteCartItems(cartId, request.getProduct_id());
			responseDTO.setMessage("Successfully Deleted!");
			return responseDTO;
		}catch (Exception e) {
			responseDTO.setMessage("Something went wrong! " + e.getLocalizedMessage());
			return responseDTO;
		}
	}

	public ResponseDTO deleteCart(Integer cartId) {
			ResponseDTO responseDTO = new ResponseDTO();
		
		try {
			if(cartMapper.deleteAllItems(cartId)<=0) {
				throw new Exception("Something went wrong!");
			}else {
				responseDTO.setMessage("Successfully Deleted!");
				return responseDTO;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			responseDTO.setMessage("Something went wrong!");
			return responseDTO;
		}
	}
	
	public Object viewMyCart(Integer id, String ownerEmail) {
		List<CartItems> list = new ArrayList<>();
		try {
			cartMapper.getMyCart(id, ownerEmail).forEach(cart ->{
				list.add(new CartItems(
						cart.getCartItemId(),
						cart.getCartId(),
						cart.getOwnerEmail(),
						cart.getProduct_id(),
						cart.getProduct_name(),
						cart.getPrice(),
						cart.getOrder_qty(),
						cart.getOrder_subtotal()));
			});
			return list;
		}catch (Exception e) {
			ResponseDTO dto = new ResponseDTO();
			dto.setMessage("Something went wrong!");
			return dto;
		}
	}
	
//	public Cart editCart(Cart cart) {
//			try {
//				Cart existingCart = CartMapper.getCart(cart.getCartId(), cartId);
//				existingCart.setOwnerFName(cart.getOwnerFName());
//				existingCart.setOwnerLName(cart.getOwnerLName());
//				existingCart.setOwnerEmail(cart.getOwnerEmail());
//				return CartMapper.getCart(cart);
//			} catch (Exception e) {
//				return null;
//			}
//		}
//}
	
	public Object addToCart(Integer id, RequestDTO request) {
		Product product = new Product();
		CartItems item = new CartItems();
		ResponseDTO response = new ResponseDTO();
		try {
			System.out.println("validation");
			validator.checkCartExistence(id, request);
			System.out.println("cart exist!");
			validator.checkProductExistence(request.getProduct_id());
			System.out.println("product exist!");
			product =cartMapper.getProduct(request.getProduct_id());
			System.out.println(product.toString());
			
			item.setCartId(id);
			item.setOwnerEmail(request.getOwnerEmail());
			item.setProduct_id(request.getProduct_id());
			item.setProduct_name(product.getProduct_name());
			item.setPrice(product.getPrice());
			item.setOrder_qty(request.getOrder_qty());
			item.setOrder_subtotal(product.getPrice() * request.getOrder_qty());
			
			System.out.println(item.toString());
			cartMapper.addToCart(item);
			response.setMessage("Successfully Added!");
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			response.setMessage(e.getLocalizedMessage());
			return response;
		}
	}
}
