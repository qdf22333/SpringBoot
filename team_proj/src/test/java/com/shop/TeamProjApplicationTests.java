package com.shop;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;

@SpringBootTest
class TeamProjApplicationTests {

	@Autowired
	ItemRepository itemRepository;
	
	@Test
	@DisplayName("상품 저장 테스트")
	public void createItemTest() {
		Item item = new Item();
		
		item.setItemName("프로젝트명");
		item.setItemTargetPrice(100000);
		item.setItemPrice(10000);
		item.setItemDetail("프로젝트 상세 설명입니다.");
		item.setItemStatus(ItemSellStatus.SELL);		
		item.setItemStartDate(LocalDateTime.now());
		item.setItemEndDate(LocalDateTime.now());
		Item savedItem = itemRepository.save(item);
		System.out.println(savedItem.toString());
		
		
	}
	
	
	@Test
	@DisplayName("상품 저장 테스트2")
	public void createItemTest2() {
		Item item = new Item();
		
		item.setItemName("프로젝트명 입니다.");
		item.setItemTargetPrice(1000);
		item.setItemPrice(500);
		item.setItemDetail("프로젝트 상세 설명입");
		item.setItemStatus(ItemSellStatus.SELL);		
		item.setItemStartDate(LocalDateTime.now());
		item.setItemEndDate(LocalDateTime.now());
		Item savedItem = itemRepository.save(item);
		System.out.println(savedItem.toString());
		
		
	}
}
