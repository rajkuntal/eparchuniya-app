package com.eparchuniya.app.service;

import java.util.List;

import com.eparchuniya.app.domain.inventory.Category;
import com.eparchuniya.app.domain.inventory.Item;
import com.eparchuniya.app.domain.inventory.ItemPrice;
import com.eparchuniya.app.domain.inventory.ItemType;
import com.eparchuniya.app.domain.inventory.ItemUnit;
import com.eparchuniya.app.domain.inventory.Packaging;
import com.eparchuniya.app.exception.CustomUniqueKeyViolationException;
import com.eparchuniya.app.exception.NotExistException;

public interface InventoryService {
	
	/************************** Category service ***************************/
	Category addCategory(Category category) throws CustomUniqueKeyViolationException;
	void updateCategory(Category category) throws NotExistException, CustomUniqueKeyViolationException;
	
	/************************** ItemType service ***************************/
	ItemType addItemType(ItemType itemType) throws CustomUniqueKeyViolationException;
	void updateItemType(ItemType itemType) throws NotExistException, CustomUniqueKeyViolationException;
	
	/************************** ItemType service ***************************/
	ItemUnit addItemUnit(ItemUnit itemUnit) throws CustomUniqueKeyViolationException;
	void updateItemUnit(ItemUnit itemUnit) throws NotExistException, CustomUniqueKeyViolationException;
	
	
	/************************** Packaging service ***************************/
	Packaging addPackaging(Packaging packaging) throws CustomUniqueKeyViolationException;
	void updatePackaging(Packaging packaging) throws NotExistException, CustomUniqueKeyViolationException;
	boolean enablePackaging(int packagingId, int modifiedBy) throws NotExistException;
	boolean disablePackaging(int packagingId, int modifiedBy) throws NotExistException;
	
	/************************** Item service ***************************/
	Item addItem(Item item) throws CustomUniqueKeyViolationException;
	void updateItem(Item item) throws NotExistException, CustomUniqueKeyViolationException;
	Item ItemFindByCode(String code);
	int ItemCountByTypeId(ItemType itemType);
	
	
	/************************** ItemPrice service ***************************/
	ItemPrice addItemPrice(ItemPrice itemPrice) throws CustomUniqueKeyViolationException;
	void removeItemPriceNotInList(int itemId, List<Integer> packagingIds);
	ItemPrice ItemPriceFindById(int itemId, int packagingId); 

}
