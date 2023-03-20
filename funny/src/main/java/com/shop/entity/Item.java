package com.shop.entity;

import java.time.LocalDateTime;

import com.shop.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Table(name="item")
@Getter
@Setter
@ToString
@Entity
public class Item {
	
	@Id
	@Column(name="item_idx")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idxitem;		//상품idx
	
	@Column(nullable = false, length = 50)
	private String itemName;	//상품명
	
	@Column(name="price", nullable=false)
	private int itemTargetPrice;	//목표금액
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;		//상품설명
	
	@Column(name="price, nullable=false")
	private int itemPrice;		//판매금액
	
	@Column(nullable=false)
	private LocalDateTime itemEndDate; 	//마감날짜
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemStatus;	//상품상태 
	

}
