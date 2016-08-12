package com.graminmart.app.service;

import java.util.List;

import com.graminmart.app.domain.inventory.Category;
import com.graminmart.app.domain.inventory.Item;
import com.graminmart.app.domain.inventory.ItemPrice;
import com.graminmart.app.domain.inventory.ItemType;
import com.graminmart.app.domain.inventory.ItemUnit;
import com.graminmart.app.domain.inventory.Packaging;
import com.graminmart.app.exception.CustomUniqueKeyViolationException;
import com.graminmart.app.exception.NotExistException;

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
