package com.graminmart.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graminmart.app.dao.inventory.CategoryDao;
import com.graminmart.app.dao.inventory.ItemDao;
import com.graminmart.app.dao.inventory.ItemPriceDao;
import com.graminmart.app.dao.inventory.ItemTypeDao;
import com.graminmart.app.dao.inventory.ItemUnitDao;
import com.graminmart.app.dao.inventory.PackagingDao;
import com.graminmart.app.domain.inventory.Category;
import com.graminmart.app.domain.inventory.Item;
import com.graminmart.app.domain.inventory.ItemPrice;
import com.graminmart.app.domain.inventory.ItemType;
import com.graminmart.app.domain.inventory.ItemUnit;
import com.graminmart.app.domain.inventory.Packaging;
import com.graminmart.app.exception.CustomUniqueKeyViolationException;
import com.graminmart.app.exception.NotExistException;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ItemTypeDao itemTypeDao;
	
	@Autowired
	private ItemUnitDao itemUnitDao;
	
	@Autowired
	private PackagingDao packagingDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ItemPriceDao itemPriceDao;

	/************************** Category service ***************************/
	public Category addCategory(Category category) throws CustomUniqueKeyViolationException {
		// check if code is already exists
		if(categoryDao.findByCode(category.getCode()) != null)
			throw new CustomUniqueKeyViolationException("Category code already exists");
		return categoryDao.save(category);
	}
	
	public void updateCategory(Category category) throws NotExistException, CustomUniqueKeyViolationException {
		// check if this category exists
		if(categoryDao.findById(category.getCategoryId()) != null)
			throw new NotExistException("This category doesn't exists");
		Category findByCode = categoryDao.findByCode(category.getCode());
		if(findByCode != null) {
			if(findByCode.getCategoryId() != category.getCategoryId())
				throw new CustomUniqueKeyViolationException("Category code already exists");
		}
		categoryDao.update(category);
	}

	/************************** ItemType service ***************************/
	public ItemType addItemType(ItemType itemType) throws CustomUniqueKeyViolationException {
		// check if code is already exists
		if(itemTypeDao.findByCode(itemType.getCode()) != null)
			throw new CustomUniqueKeyViolationException("ItemType code already exists");
		return itemTypeDao.save(itemType);
	}
	
	public void updateItemType(ItemType itemType) throws NotExistException, CustomUniqueKeyViolationException {
		// check if this Item Type exists
		if(itemTypeDao.findById(itemType.getTypeId()) != null)
			throw new NotExistException("This Item Type doesn't exists");
		ItemType findByCode = itemTypeDao.findByCode(itemType.getCode());
		if(findByCode != null) {
			if(findByCode.getTypeId() != itemType.getTypeId())
				throw new CustomUniqueKeyViolationException("Item Type code already exists");
		}
		itemTypeDao.update(itemType);
	}

	/************************** ItemUnit service ***************************/
	public ItemUnit addItemUnit(ItemUnit itemUnit) throws CustomUniqueKeyViolationException {
		// check if code is already exists
		if(itemUnitDao.findByCode(itemUnit.getCode()) != null)
			throw new CustomUniqueKeyViolationException("Unit code already exists");
		return itemUnitDao.save(itemUnit);
	}
	
	public void updateItemUnit(ItemUnit itemUnit) throws NotExistException, CustomUniqueKeyViolationException {
		// check if this Item Unit exists
		if(itemUnitDao.findById(itemUnit.getUnitId()) != null)
			throw new NotExistException("This Item Type doesn't exists");
		ItemUnit findByCode = itemUnitDao.findByCode(itemUnit.getCode());
		if(findByCode != null) {
			if(findByCode.getUnitId() != itemUnit.getUnitId())
				throw new CustomUniqueKeyViolationException("Unit code already exists");
		}
		itemUnitDao.update(itemUnit);
	}

	/************************** Packaging service ***************************/
	public Packaging addPackaging(Packaging packaging) throws CustomUniqueKeyViolationException {
		return packagingDao.save(packaging);
	}
	
	public void updatePackaging(Packaging packaging) throws NotExistException, CustomUniqueKeyViolationException {
		// check if this Item Unit exists
		if(packagingDao.findById(packaging.getPackagingId()) != null)
			throw new NotExistException("This Packaging doesn't exists");
		packagingDao.update(packaging);
	}
	
	public boolean enablePackaging(int packagingId, int modifiedBy) throws NotExistException {
		// check if this Item Unit exists
		if(packagingDao.findById(packagingId) != null)
			throw new NotExistException("This Packaging doesn't exists");
		return packagingDao.enablePackaging(packagingId, modifiedBy);
	}
	
	public boolean disablePackaging(int packagingId, int modifiedBy) throws NotExistException {
		// check if this Item Unit exists
		if(packagingDao.findById(packagingId) != null)
			throw new NotExistException("This Packaging doesn't exists");
		return packagingDao.disablePackaging(packagingId, modifiedBy);
	}

	/************************** Item service ***************************/
	public Item addItem(Item item) throws CustomUniqueKeyViolationException {
		// check if code is already exists
		if(itemDao.findByCode(item.getCode()) != null)
			throw new CustomUniqueKeyViolationException("Item code already exists");
		return itemDao.save(item);
	}
	
	public void updateItem(Item item) throws NotExistException, CustomUniqueKeyViolationException {
		// check if this Item Unit exists
		if(itemDao.findById(item.getItemId()) != null)
			throw new NotExistException("This Item doesn't exists");
		itemDao.update(item);
	}
	
	public Item ItemFindByCode(String code) {
		return itemDao.findByCode(code);
	}
	
	public int ItemCountByTypeId(ItemType itemType) {
		return itemDao.countByTypeId(itemType);
	}

	/************************** ItemPrice service ***************************/
	public ItemPrice addItemPrice(ItemPrice itemPrice) throws CustomUniqueKeyViolationException {
		return itemPriceDao.save(itemPrice);
	}
	
	public void removeItemPriceNotInList(int itemId, List<Integer> packagingIds) {
		itemPriceDao.removeNotInList(itemId, packagingIds);
	}
	
	public ItemPrice ItemPriceFindById(int itemId, int packagingId) {
		return itemPriceDao.FindById(itemId, packagingId);
	}

}
